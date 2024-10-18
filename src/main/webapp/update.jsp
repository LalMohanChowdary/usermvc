<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
</head>
<body>
	<h1>Update Page</h1>
	<form id="form-1" action="update">
		<input name="id" type="number" value="${user.getId() }" readonly="readonly"><br><br>
		<input name="name"  type="text" value="${user.getName() }"><br><br>
		<input name="email" type="text" value="${user.getEmail() }"><br><br>
		<input name="phone" type="tel" value="${user.getPhone() }"><br><br>
		<input name="password" type="text" value="${user.getPassword() }"><br><br>
		
		<input type="submit" value="Update" id="button-1" />
	</form>
</body>
</html>