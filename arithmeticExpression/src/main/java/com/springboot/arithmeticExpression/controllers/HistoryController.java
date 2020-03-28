package com.springboot.arithmeticExpression.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.arithmeticExpression.models.ArithmeticExpression;
import com.springboot.arithmeticExpression.services.HistoryService;

@Controller
@RequestMapping(value = "/history")
public class HistoryController {

	@Autowired
	HistoryService historyService;
	
	
	@GetMapping
	public String showHistory(Model model) {
		
		Iterable<ArithmeticExpression> expressionsList = historyService.listExpressions();
		model.addAttribute("expressionsList", expressionsList);

		return "history";
	}
}
