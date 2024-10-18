<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Users</title>

<style type="text/css">
table {
	margin: auto;
	font-size: 30px;
	border-collapse: collapse;
}

#add {
	
	margin-left: 1120px;
	margin-bottom: 10px;
}
</style>
</head>
<body>

	<h1 id="msg">${msg }</h1>
	<h1>All Users</h1>
	<form id="form-1" action="search">
	<input type="text" name="sq" placeholder="Type Here to Search">
	<button type="submit">Search</button>
	</form>

	<a href="createpage" id="add"><button>Create User</button></a>

	<table id="table-1" border="5" cellpadding="10" cellspacing="10">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Password</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="u" items="${users }">

				<tr>
					<td>${u.getId() }</td>
					<td>${u.getName() }</td>
					<td>${u.getEmail() }</td>
					<td>${u.getPhone() }</td>
					<td>${u.getPassword() }</td>
					<td><a href="updatepage?id=${u.getId() }"><input type="submit" value="Update" id="button-1" /></a></td>
					<td><a href="delete?id=${u.getId() }"><input type="submit"
							value="Delete" id="button-1" /></a></td>
				</tr>

			</c:forEach>

		</tbody>
	</table>

	<script type="text/javascript">
	
	const msgELe=document.getElementById("msg")
	
	setTimeout(()=>{
		msgEle.style.display="none";
		},3000);
	
	
	</script>

</body>
</html>