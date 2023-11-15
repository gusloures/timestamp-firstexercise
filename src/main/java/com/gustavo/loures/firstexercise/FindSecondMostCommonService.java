package com.gustavo.loures.firstexercise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindSecondMostCommonService {

    public int findSecondMostCommon(int[] nums) {
        // Count the frequency of numbers in the vector
        Map<Integer, Long> frequencyMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        // Find the most common number
        Map.Entry<Integer, Long> mostCommonEntry = frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);


        // Find the second most common number
        Map.Entry<Integer, Long> secondMostCommonEntry = frequencyMap.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(mostCommonEntry.getKey()))
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        // If there is only one number or no second number, return that first number
        // Or if there is no number return -1
        // Or if there is no second number because the first and the second are equal, return the first
        if (mostCommonEntry == null || frequencyMap.size() <= 1 || secondMostCommonEntry == null) {
            return mostCommonEntry != null ? mostCommonEntry.getKey() : -1;
        } else if (mostCommonEntry.getValue().equals(secondMostCommonEntry.getValue())) {
            return mostCommonEntry.getKey();
        }

        // Returns the second most common
        return secondMostCommonEntry.getKey();
    }

}
