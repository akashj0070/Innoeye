<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<style>
            @media all {
                body
                {
                    text-align:center;
                }
               
            }
        </style>
<meta charset="UTF-8">
<title>Students</title>
</head>
<body>
	
	<h3>Students List</h3>
	
	<table border="1" cellpadding="2" cellspacing="2" style="border:1px solid black;margin-left:auto;margin-right:auto;">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Marks</th>
		</tr>
		<c:forEach var="studentlist" items="${studentModel}">
			<tr>
				<td>${studentModel.id }</td>
				<td>${studentModel.name }</td>
				<td>${studentModel.marks }</td>
			</tr>
		</c:forEach>
	</table>
	<form action="/"> 
	<h4>Go back to home page- </h4>
<input type="Submit" value="Back" style="text-align:center;">
</form>
</body>
</html>