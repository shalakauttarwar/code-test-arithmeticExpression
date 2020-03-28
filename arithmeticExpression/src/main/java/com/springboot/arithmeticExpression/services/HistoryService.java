package com.springboot.arithmeticExpression.services;

import com.springboot.arithmeticExpression.models.ArithmeticExpression;

public interface HistoryService {

	public Iterable<ArithmeticExpression> listExpressions();
}
