package com.gustavo.loures.firstexercise;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
@Slf4j
public class FirstexerciseApplication implements CommandLineRunner {

    private final FindSecondMostCommonService findSecondMostCommonService;

    public FirstexerciseApplication(FindSecondMostCommonService findSecondMostCommonService) {
        this.findSecondMostCommonService = findSecondMostCommonService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FirstexerciseApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        log.info("Enter the numbers of the array separated by space:");
        String input = scanner.nextLine();

        String[] numbers = input.split(" ");

        int[] vector = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = findSecondMostCommonService.findSecondMostCommon(vector);
        log.info("The second most common number is: " + result);
    }
}