<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
            @media all {
                body
                {
                    text-align:center;
                }
                table
                {
                	text-align:center;
                }
               }
        </style>
<meta charset="UTF-8">
<title>SpringBoot web mvc demo</title>
</head>
<body>
<div> <h1>Enter Your Details</h1><br>
<form action="addStudent">
Name:<input type="text" name="name" id=""
	pattern="[A-Za-z]*" title="Characters Only" required><br>

Marks: <input type="text" name="marks" id=""
pattern="[0-9]{1,3}" title="Chraracters only" required><br>
<input type="submit" ><br>

</form>

<form action="studentlist">
<h1>To print student list</h1>
<input type="text" name="id" pattern="[0-9]{1,3}" title="Enter a valid id" required>
<input type="submit">
</form>

</div>
<%-- welcome ${obj.name} , ${obj.language} --%>
</body>
</html>