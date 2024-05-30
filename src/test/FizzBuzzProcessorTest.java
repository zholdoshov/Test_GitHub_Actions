package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FizzBuzzProcessorTest {
	@Test
	public void FizzBuzz_NormalCaseNumbers_expectEchoOfNumber() {
		
		FizzBuzzProcessor fb = new FizzBuzzProcessor();
		
		String result;
		int input = 1;
		result = fb.convert(input);
		System.out.format("  fb.convert(%d) = %s\n",input,result);
		input = 2;
		result = FizzBuzzProcessor.convert(input);
		System.out.format("  fb.convert(%d) = %s\n",input,result);

		Assertions.assertEquals("1", FizzBuzzProcessor.convert(1));
		Assertions.assertEquals("2", FizzBuzzProcessor.convert(2));
	}

	@Test
	public void FizzBuzz_3_expectFizz() {
		String result = FizzBuzzProcessor.convert(3);
		String expected_result = "Fizz";
		Assertions.assertEquals(expected_result, result);
	}

	@Test
	public void FizzBuzz_5_expectBuzz() {
		String result = FizzBuzzProcessor.convert(5);
		String expected_result = "Buzz";
		Assertions.assertEquals(expected_result, result);
	}

	@Test
	public void FizzBuzz_15_expectFizzBuzz() {
		String result = FizzBuzzProcessor.convert(15);
		String expected_result = "FizzBuzz";
		Assertions.assertEquals(expected_result, result);
	}

	@Test
	public void FizzBuzz_NullPoint_Test() {
		FizzBuzzProcessor.main();
	}

	@ParameterizedTest
	@CsvSource({
			"-4",
			"-10",
			"0",
	})
	void convert_expectedException(int value) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			FizzBuzzProcessor.convert(value);
		});
	}

	@ParameterizedTest(name = "FizzBuzz_{0}_expect_{1}")
	@CsvSource({
			"2, 2",
			"4, 4",
			"14, 14",
			"16, 16",
			"3, Fizz",
			"9, Fizz",
			"12, Fizz",
			"5, Buzz",
			"10, Buzz",
			"20, Buzz",
			"15, FizzBuzz",
			"30, FizzBuzz",
			"45, FizzBuzz",
	})
	public void FizzBuzz_parameterized_test(int inValue, String expectedResult) {
		String actualResult = FizzBuzzProcessor.convert(inValue);
		Assertions.assertEquals(expectedResult, actualResult);
	}
}