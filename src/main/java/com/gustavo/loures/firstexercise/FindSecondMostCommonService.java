package com.gustavo.loures.firstexercise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindSecondMostCommonService {

    public int findSecondMostCommon(int[] nums) {
        // Count the frequency of numbers in the vector using TreeMap for ordered keys
        Map<Integer, Long> frequencyMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, TreeMap::new, Collectors.counting()));

        //If there is no number return -1 or if there is only one number, return that first number
        if (frequencyMap.isEmpty()) {
            return -1;
        } else if (frequencyMap.size() == 1) {
            return nums[0];
        }

        // Collect the two most common numbers
        List<Map.Entry<Integer, Long>> mostCommonEntries = frequencyMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(2)
                .toList();

        //If the second number has equal frequency to the first number, return the first most common number.
        if (mostCommonEntries.get(0).getValue().equals(mostCommonEntries.get(1).getValue())) {
            return mostCommonEntries.get(0).getKey();
        }

        // Return the second most common number
        return mostCommonEntries.get(1).getKey();
    }

}
