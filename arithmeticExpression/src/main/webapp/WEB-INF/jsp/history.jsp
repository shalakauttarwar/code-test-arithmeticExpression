<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="WEB-INF/dateTag.tld" prefix="dt" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Evaluation History!</title>
</head>

<style>
body {background-color: powderblue;}

table {
  font-family: Garamond;
  font-size: 16px;
  background-color: white;
  text-align: center;
 }

h1 {
  color: blue;
  font-family: Garamond;
  text-align: center;
}
 
#thd{
	font-weight: bold;
	font-size: 18px;
	text-align: center;
}

 p{
	font-size: 16px; 
	text-align: right;	
 }
</style>

<body>
    <h1>Evaluation History</h1>
    <p>Today: <dt:today /></p><br />
    <table width="59%" border="1" align="center">
    	<thead><tr>
    		<td id="thd">Arithmetic Expression</td>
    		<td id="thd">Solution</td>
    	<tr><thead>

    	<c:forEach var="data" items="${expressionsList}">
    		<tr>
    			<td><c:out value="${data.expression}" />
    			<td><c:out value="${data.solution}" />
    		</tr>
    	</c:forEach>

	</table>
</body>
</html>