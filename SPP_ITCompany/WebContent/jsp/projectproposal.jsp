<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project Proposal</title>
</head>
<body>
	<h4>Project proposal</h4>
	<table border="1">
		<tr><th>Project Name</th><td>${project_proposal.name}</td></tr>
		<tr><th>Contact Name</th><td>${project_proposal.contactName}</td></tr>
		<tr><th>Phone</th><td>${project_proposal.phone}</td></tr>
		<tr><th>e-Mail</th><td>${project_proposal.email}</td></tr>
		<tr><th>Status</th><td>${project_proposal.status}</td></tr>
		<tr><th>Project description</th><td>${project_proposal.description}</td></tr>
		<tr><th>Require Specification</th><td>${project_proposal.requirementSpecification}</td></tr>
		<tr><th>Term</th><td>${project_proposal.term}</td></tr>	
	</table>
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