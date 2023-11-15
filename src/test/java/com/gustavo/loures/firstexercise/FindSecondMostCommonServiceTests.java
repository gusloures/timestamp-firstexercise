package com.gustavo.loures.firstexercise;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FindSecondMostCommonServiceTests {
	@Autowired
	private FindSecondMostCommonService findSecondMostCommonService;

	@Test
	public void testFindSecondMostCommonExample1() {
		int[] vetor1 = {0, 1, 2, 5, 7, 4, 2, 9, 1, 2};
		int expectedResult1 = 1;

		int result1 = findSecondMostCommonService.findSecondMostCommon(vetor1);
		assertEquals(expectedResult1, result1);
	}

	@Test
	public void testFindSecondMostCommonExample2() {
		int[] vetor2 = {0, 1, 2, 5, 7, 4, 2, 9, 1};
		int expectedResult2 = 1;

		int result2 = findSecondMostCommonService.findSecondMostCommon(vetor2);
		assertEquals(expectedResult2, result2);
	}

	@Test
	public void testFindSecondMostCommonEmptyArray() {
		int[] emptyArray = {};
		int expectedResult = -1;

		int result = findSecondMostCommonService.findSecondMostCommon(emptyArray);
		assertEquals(expectedResult, result);
	}

	@Test
	public void testFindSecondMostCommonOneElementArray() {
		int[] oneElementArray = {5};
		int expectedResult = 5;

		int result = findSecondMostCommonService.findSecondMostCommon(oneElementArray);
		assertEquals(expectedResult, result);
	}

	@Test
	public void testFindSecondMostCommonSameFrequency() {
		int[] sameFrequencyArray = {0, 3, 2, 5, 7, 4, 2, 9, 3, 5, 7, 4};
		int expectedResult = 2;

		int result = findSecondMostCommonService.findSecondMostCommon(sameFrequencyArray);
		assertEquals(expectedResult, result);
	}

	@Test
	public void testFindSecondMostCommonAllEqualNumbers() {
		int[] allEqualNumbers = {3, 3, 3, 3, 3};
		int expectedResult = 3;

		int result = findSecondMostCommonService.findSecondMostCommon(allEqualNumbers);
		assertEquals(expectedResult, result);
	}

	@Test
	public void testFindSecondMostCommonNoSecondCommon() {
		int[] noSecondCommon = {0, 1, 2, 2, 1, 0};
		int expectedResult = 0;

		int result = findSecondMostCommonService.findSecondMostCommon(noSecondCommon);
		assertEquals(expectedResult, result);
	}
}