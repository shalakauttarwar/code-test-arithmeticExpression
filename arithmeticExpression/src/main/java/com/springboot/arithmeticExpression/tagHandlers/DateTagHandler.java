package com.springboot.arithmeticExpression.tagHandlers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DateTagHandler extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2993804840342706666L;

	public int doStartTag() throws JspException{
		
		JspWriter out = pageContext.getOut();
		
		try {
			LocalDateTime current = LocalDateTime.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");   
			out.print(current.getDayOfWeek() +" "+current.format(format));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}

}
