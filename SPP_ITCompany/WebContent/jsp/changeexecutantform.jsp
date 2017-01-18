<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Executants List</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="css/user.css">
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>           
      </button>
      <a class="navbar-brand" href="#">IT Company</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="mainController?command=logout">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="mainController?command=logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h3>Menu</h3>
      <ul class="nav nav-pills nav-stacked" style="background-color:#aaa">
		<li><a href="mainController?command=return_to_page&user_id=${user_id}&user=${user}&role=${role}">Return</a></li>
	  </ul>
    </div>
    <div class="col-sm-6 text-left"> 
      <h4>Executants for Project ${project.name}</h4>
      <table class="table table-bordered">
        <thead><tr><th>ID</th><th>Employee</th><th>Status</th></tr></thead>
        <tbody>
      	  <c:forEach var="executant" items="${project.employees}">
      		<tr><td>${executant.id}</td>
				<td>${executant.users.name}</td>
				<td>${executant.users.roles.role}</td>
			</tr>
		  </c:forEach>
		</tbody>  
	  </table>
	  <c:if test="${!empty employeeList}">
	    <h4>Change Executants for Project ${project.name}</h4>
		<table class="table table-bordered">
		  <thead><tr><th>ID</th><th>Employee</th><th>Status</th><th>&nbsp;</th></tr></thead>
		  <tbody>
			<c:forEach var="employee" items="${employeeList}">
				<c:if test="${employee.users.roles.role eq 'programmer' or  employee.users.roles.role eq 'team_leader'}">
				<tr><td>${employee.id}</td>
					<td>${employee.users.name}</td>
					<td>${employee.users.roles.role}</td>
				<td>
				<c:set var="isExecutant" value="false" scope="page"/>
				<c:forEach var="executant" items="${project.employees}">
					<c:if test="${employee.id eq executant.id}">
						<c:set var="isExecutant" value="true" scope="page"/>
					</c:if>
				</c:forEach>
					<c:choose>
						<c:when test="${isExecutant eq 'true'}">
							<a href="mainController?command=delete_executant&employeeid=${employee.id}&projectid=${project.id}&user_id=${user_id}&user=${user}&role=${role}">Remove from executants</a>
						</c:when>
						<c:otherwise>
							<a href="mainController?command=add_executant&employeeid=${employee.id}&projectid=${project.id}&user_id=${user_id}&user=${user}&role=${role}">Add to Executants</a>
						</c:otherwise>
					</c:choose>
				</td></tr><br>
				</c:if>
			</c:forEach>
		  </tbody>
		</table>
	</c:if>
	
    </div>
    <div class="col-sm-3 sidenav">
      <div class="well">
        <h3>Welcome</h3>
	    <hr/>
        <p>${user} ${role}, hello!</p>
      </div>
      <div class="well">
        <p></p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Project Made By Sytau</p>
</footer>

<!--  
	<h3>Change Executants for Project ${project.name}</h3>
	
	<c:forEach var="executant" items="${project.employees}">
			${executant.id} ${executant.users.name} ${executant.users.roles.role}<br>
	</c:forEach>
	
	<c:if test="${!empty employeeList}">
		<table>
			<tr><th>ID</th><th>Employee</th><th>Status</th><th>&nbsp;</th></tr>
			<c:forEach var="employee" items="${employeeList}">
				<c:if test="${employee.users.roles.role eq 'programmer' or  employee.users.roles.role eq 'team_leader'}">
				<tr><td>${employee.id}</td>
					<td>${employee.users.name}</td>
					<td>${employee.users.roles.role}</td>
				<td>
				<c:set var="isExecutant" value="false" scope="page"/>
				<c:forEach var="executant" items="${project.employees}">
					<c:if test="${employee.id eq executant.id}">
						<c:set var="isExecutant" value="true" scope="page"/>
					</c:if>
				</c:forEach>
					<c:choose>
						<c:when test="${isExecutant eq 'true'}">
							<a href="mainController?command=delete_executant&employeeid=${employee.id}&projectid=${project.id}&user_id=${user_id}&user=${user}&role=${role}">Remove from executants</a>
						</c:when>
						<c:otherwise>
							<a href="mainController?command=add_executant&employeeid=${employee.id}&projectid=${project.id}&user_id=${user_id}&user=${user}&role=${role}">Add to Executants</a>
						</c:otherwise>
					</c:choose>
				</td></tr><br>
				</c:if>
			</c:forEach>
		</table>
	</c:if><br>
	
	<form name="ReturnToPage" method="GET" action="mainController">
		<input type="hidden" name="command" value="return_to_page" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<input type="submit" value="Return"/>
	</form>
-->	
</body>
</html>