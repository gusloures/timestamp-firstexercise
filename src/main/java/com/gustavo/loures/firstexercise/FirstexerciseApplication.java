package com.gustavo.loures.firstexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstexerciseApplication implements CommandLineRunner {

    private final FindSecondMostCommonService findSecondMostCommonService;

    @Autowired
    public FirstexerciseApplication(FindSecondMostCommonService findSecondMostCommonService) {
        this.findSecondMostCommonService = findSecondMostCommonService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FirstexerciseApplication.class, args);
    }

    @Override
    public void run(String... args) {
        int[] vector1 = {0, 1, 2, 5, 7, 4, 2, 9, 1, 2};
        int[] vector2 = {0, 1, 2, 5, 7, 4, 2, 9, 1};
        int[] vector3 = {3, 3, 2, 2};
        int[] vector4 = {3, 3, 3, 3};

        System.out.println("Result 1: " + findSecondMostCommonService.findSecondMostCommon(vector1));
        System.out.println("Result 2: " + findSecondMostCommonService.findSecondMostCommon(vector2));
        System.out.println("Result 3: " + findSecondMostCommonService.findSecondMostCommon(vector3));
        System.out.println("Result 4: " + findSecondMostCommonService.findSecondMostCommon(vector4));
    }
}