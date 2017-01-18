<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client Employees</title>
</head>
<body>
	<h4>Employees of Client ${clientname}</h4>
	<table border="1">
		<tr>
			
			<th>Name</th>
			<th>Phone</th>
			<th>e-Mail</th>
			<th>Skype</th>
			<th>Status</th>
			
		</tr>
		<c:forEach var="clientEmployee" items="${clientEmployeeList}">
			<tr>
				<td>${clientEmployee.name}</td>
				<td>${clientEmployee.phone}</td>
				<td>${clientEmployee.email}</td>
				<td>${clientEmployee.skype}</td>
				<td>${clientEmployee.status}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
		<a href="mainController?command=client_employee_form&clientid=${clientid}&clientname=${clientname}&user_id=${user_id}&user=${user}&role=${role}">Add employee of Client ${clientname}</a><br>
	<br>
	<form name="ReturnToPage" method="GET" action="mainController">
		<input type="hidden" name="command" value="return_to_page" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<input type="submit" value="Return"/>
	</form>
</body>
</html>