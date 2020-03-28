package com.springboot.arithmeticExpression.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.springboot.arithmeticExpression.services.impl.ArithmeticServiceImpl;

public class ArithmeticServiceTest {
	
	private ArithmeticService arithmeticService;
	
	@BeforeEach
	void setup() {
		arithmeticService = new ArithmeticServiceImpl();
	}
	
	@Test
	void test_withExpression_evaluateExpression() {

		//given
		String expression = "(2+4)*5";
		
		//when
		int solution = arithmeticService.evaluateExpression(expression);
		
		//then
		assertEquals(solution, 30);
	}
	
	@Test
	void test_performance_evaluateExpression() {

		//given
		String expression = "(2+4)*5";
		
		//when
		Executable executable = () -> arithmeticService.evaluateExpression(expression);

		//then
		assertTimeout(Duration.ofNanos(10), executable);
	}
	
	@Test
	void test_withBlank_evaluateExpression() {

		//given
		String expression = " ";
		
		//when
		int solution = arithmeticService.evaluateExpression(expression);
		
		//then
		assertEquals(solution, 0);
	}
	
	@Test
	void test_throwException_evaluateExpression() {
	
		//given
		String expression = "(2+7)/0";
		
		//when
		Executable executable = () -> arithmeticService.evaluateExpression(expression);
		
		//then
		assertThrows(UnsupportedOperationException.class, executable);
	}
}
