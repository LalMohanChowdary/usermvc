<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" isELIgonred="false">
<title>Create Page</title>
</head>
<body>

	<h1>${msg }</h1>
	<h1>Create Page</h1>
	
	
	<form id="form-1" action="save">
	
	<input type="text" name="name" placeholder="enter your name"><br><br>
	<input type="email" name="email" placeholder="@gmail.com"><br><br>
	<input type="tel" name="phone" placeholder="enter your number"><br><br>
	<input type="text" name="password" placeholder="enter your password"><br><br>
		<input type="submit" value="create" id="button-1"/>
	
	</form>
	
	
	
	
	
</body>
</html>