package com.springboot.arithmeticExpression.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.arithmeticExpression.models.ArithmeticExpression;
import com.springboot.arithmeticExpression.repositories.ArithmeticExpressionRepository;
import com.springboot.arithmeticExpression.services.HistoryService;

@Service
public class HistoryServiceImpl implements HistoryService{

	@Autowired
	ArithmeticExpressionRepository arithmeticExpressionRepository;
	
	@Override
	public Iterable<ArithmeticExpression> listExpressions() {
		return arithmeticExpressionRepository.findAll();
	}

}
