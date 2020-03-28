package com.springboot.arithmeticExpression.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.arithmeticExpression.models.ArithmeticExpression;
import com.springboot.arithmeticExpression.services.ArithmeticService;

@Controller
@RequestMapping(value = "/evaluate")
public class ArithmeticController {

	@Autowired
	ArithmeticService arithmeticService;
	
	@GetMapping
	public String showInputPage(Model model) {
		
		model.addAttribute("arithmeticExpression", arithmeticService.createDefaultArithmeticExpression());
		
		return "arithmetic";
	}
	
	@PostMapping
	public String evaluate(Model model, @ModelAttribute ArithmeticExpression arithmeticExpression) {
		
		if(arithmeticExpression.getExpression() !="") {
			
			int solution = arithmeticService.evaluateExpression(arithmeticExpression.getExpression());
			arithmeticExpression.setSolution(String.valueOf(solution));
			arithmeticService.saveExpression(arithmeticExpression);
			
			model.addAttribute("arithmeticExpression", arithmeticExpression);
		}
		return "arithmetic";
	}
}
