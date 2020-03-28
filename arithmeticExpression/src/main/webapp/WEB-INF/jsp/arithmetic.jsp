<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="WEB-INF/dateTag.tld" prefix="dt" %>  

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Evaluate Arithmetic Expression!</title>
</head>

<style>
body {
	background-color: powderblue;
	text-align: center;	
}

h1 {
  	color: blue;
  	font-family: Garamond;
 }
 
 a{
	font-family: cursive; 
	font-size: 16px; 
	font-weight: bold;
 }
 
 p{
	font-size: 16px; 
	text-align: right;	
 }
 
</style>

<body>
	<h1>Arithmetic Expression Evaluation</h1>
	<p>Today: <dt:today /></p>
    <h3 font-family="courier">Enter expression to evaluate</h3>

    <table align="center">

	    <form:form method="post" modelAttribute="arithmeticExpression">
    	<tr>
			<td>Input : </td>
			<td><form:input path="expression" /> </td>
			<td><input type="submit" value="Evaluate"/><td>
		</tr>
		</form:form>
		
		<tr /><tr /><tr />
		<tr>
			<td>Output : </td>
			<td><c:out value="${arithmeticExpression.solution}"/></td>
		</tr>
		
	</table>
	
	<br><br><a href="/history">History of Evaluation</a>
</body>
</html>