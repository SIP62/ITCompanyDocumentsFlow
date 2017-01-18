<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project info</title>
</head>
<body>

	<h4>Information for Project ${projectname}</h4>
	<table border="1">
		<tr>
			<th>Project</th>
			<th>Info Name</th>
			<th>Date</th>
			<th>Info description</th>
			<th>Author</th>
		</tr>
		<c:forEach var="info" items="${infoList}">
			<tr>
				<td>${info.project.name}</td>
				<td>${info.name}</td>
				<td>${info.date}</td>
				<td>${info.description}</td>
				<td>${info.employee.users.name}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
		<a href="mainController?command=project_info_form&projectid=${projectid}&projectname=${projectname}&user_id=${user_id}&user=${user}&role=${role}">Add info in Project ${projectname}</a><br>
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