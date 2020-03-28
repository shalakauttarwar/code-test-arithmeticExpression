package com.springboot.arithmeticExpression.services.impl;

import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.arithmeticExpression.models.ArithmeticExpression;
import com.springboot.arithmeticExpression.repositories.ArithmeticExpressionRepository;
import com.springboot.arithmeticExpression.services.ArithmeticService;

@Service
public class ArithmeticServiceImpl implements ArithmeticService{

	@Autowired
	ArithmeticExpressionRepository arithmeticExpressionRepository;
	
	@Override
	public void saveExpression(ArithmeticExpression arithmeticExpression) {
		arithmeticExpressionRepository.save(arithmeticExpression);
	}

	@Override
	public ArithmeticExpression createDefaultArithmeticExpression() {
		return new ArithmeticExpression();
	}

	public int evaluateExpression(String expression) {
		
		if(expression.length() == 1 && expression.equals(" "))
			return 0;
		
		Stack<Integer> numStack = new Stack<Integer>();
		Stack<Character> opStack = new Stack<Character>();

        expression.chars()
        		.mapToObj(c -> (char) c)
        		.forEach(c -> {
        	if(c >= '0' && c <= '9') {
        		
        		numStack.push(Integer.parseInt(String.valueOf(c)));				
			}
			else if(c == '(') {

				opStack.push(c);
			}
			else if(c == ')') {
				
				while(opStack.peek() != '(')
					numStack.push(operate(opStack.pop(), numStack.pop(), numStack.pop()));
				opStack.pop();
			}
			else if (c == '+' || c == '-' || 
					c == '*' || c == '/') {
				 while (!opStack.empty() && hasPrecedenceHigher(c, opStack.peek())) 
					 numStack.push(operate(opStack.pop(), numStack.pop(), numStack.pop())); 
	  
				 opStack.push(c); 
			}
        
        });
        
		while (!opStack.empty()) 
			numStack.push(operate(opStack.pop(), numStack.pop(), numStack.pop())); 

		return numStack.pop();
	}
	
	// Returns true if 'op2' has higher or same precedence as 'op1', 
    // otherwise returns false. 
    private boolean hasPrecedenceHigher(char op1, char op2) 
    { 
        if (op2 == '(' || op2 == ')') 
            return false; 
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
            return false; 
        else
            return true; 
    } 
    
	private int operate(char op, int b, int a) 
    { 

        switch (op) 
        { 
        case '+': 
            return a + b; 
        case '-': 
            return a - b; 
        case '*': 
            return a * b; 
        case '/': 
            if (b == 0) 
                throw new
                UnsupportedOperationException("Cannot divide by zero"); 
            return a / b; 
        } 
        return 0; 
    }
}
