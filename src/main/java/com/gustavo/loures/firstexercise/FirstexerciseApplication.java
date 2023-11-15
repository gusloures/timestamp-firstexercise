package com.gustavo.loures.firstexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstexerciseApplication  implements CommandLineRunner {

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
        int[] vetor1 = {0, 1, 2, 5, 7, 4, 2, 9, 1, 2};
        int[] vetor2 = {0, 1, 2, 5, 7, 4, 2, 9, 1};
        int[] vetor3 = {3, 3, 2, 2};
        int[] vetor4 = {3, 3, 3, 3};

        System.out.println("Resultado 1: " + findSecondMostCommonService.findSecondMostCommon(vetor1));
        System.out.println("Resultado 2: " + findSecondMostCommonService.findSecondMostCommon(vetor2));
        System.out.println("Resultado 3: " + findSecondMostCommonService.findSecondMostCommon(vetor3));
        System.out.println("Resultado 4: " + findSecondMostCommonService.findSecondMostCommon(vetor4));
    }
}