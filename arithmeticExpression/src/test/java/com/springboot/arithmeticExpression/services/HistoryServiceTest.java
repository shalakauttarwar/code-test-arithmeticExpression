package com.springboot.arithmeticExpression.services;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot.arithmeticExpression.repositories.ArithmeticExpressionRepository;
import com.springboot.arithmeticExpression.services.impl.HistoryServiceImpl;

@ExtendWith(MockitoExtension.class)
class HistoryServiceTest {

	@Mock
	ArithmeticExpressionRepository arithmeticExpressionRepository;
	
	@InjectMocks
	HistoryServiceImpl historyService;
	
	
	@Test
	void test_listExpressions() {
		historyService.listExpressions();
		
		verify(arithmeticExpressionRepository).findAll();
	}

}
