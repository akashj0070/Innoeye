<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringBoot web mvc demo</title>
</head>
<body>
<div> <h1>Enter Your Details</h1><br>
<form action="contact" method="POSt">
<table>
<tr> 
<td>Name:<td> <input type="character" name="name" id="" required>
<tr>
<td>Language: <td><input type="character" name="language" id="" required>
<tr>
<tr><td><td><input type="submit" value="Enter" name="Submit"><br>
</table>
</form>

</div>
<%-- welcome ${obj.name} , ${obj.language} --%>
</body>
</html>