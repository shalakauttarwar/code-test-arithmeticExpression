package com.springboot.arithmeticExpression.services;

import com.springboot.arithmeticExpression.models.ArithmeticExpression;

public interface ArithmeticService {

	void saveExpression(ArithmeticExpression arithmeticExpression);
	ArithmeticExpression createDefaultArithmeticExpression() ;
	
	int evaluateExpression(String expression);
}
