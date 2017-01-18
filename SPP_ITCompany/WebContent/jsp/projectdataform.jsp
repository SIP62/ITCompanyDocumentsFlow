<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project</title>
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
        <c:if test="${role eq 'project_manager'}">
      	  <li><a href="mainController?command=change_executants_form&user_id=${user_id}&user=${user}&role=${role}&projectid=${project.id}">ChangeExecutants</a></li>
		</c:if>
		<li><a href="mainController?command=return_to_page&user_id=${user_id}&user=${user}&role=${role}">Return</a></li>
	  </ul>
    </div>
    <div class="col-sm-6 text-left"> 
      <h4>Project ${project.name}</h4>
      <form class="form-horizontal" role="form" name="ProjectForm" method="POST" action="mainController">
      	<input type="hidden" name="command" value="update_project" />
		<input type="hidden" name="id_project" value="${project.id}" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />

		  <div class="form-group">
		    <label class="control-label col-sm-3" for="name">Name:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="name" name="name" value="${project.name}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="description">Project description:</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="6" id="description" name="description">${project.description}</textarea>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="requirements_specification">Requirements Specification:</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="6" id="requirements_specification" name="requirements_specification">${project.requirementSpecification}</textarea>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="cost">Cost:</label>
		    <div class="col-sm-9">
		      <input type="number" class="form-control" id="cost" name="cost" value="${project.cost}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="start_date">Start Date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="start_date" name="start_date" value="${project.startDate}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="finish_date">Finish Date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="finish_date" name="finish_date" value="${project.finishDate}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="progress">Progress:</label>
		    <div class="col-sm-9">
		      <input type="number" class="form-control" id="progress" name="progress" value="${project.progress}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="client_name">Client Name:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="client_name" name="client_name" value="${project.client.users.name}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="executant">Executants:</label>
		    
		    <div class="col-sm-9">
		    <c:forEach var="executant" items="${project.employees}">
		      <input type="text" class="form-control" id="executant" name="executant" value="${executant.users.name} ${executant.users.roles.role}" readonly>
		    </c:forEach>
		    </div>
		    
		  </div>
		  <div class="form-group"> 
		    <div class="col-sm-offset-3 col-sm-9">
		      <button type="submit" class="btn btn-default">Update</button>
		    </div>
		  </div>
		  
	  </form>
    </div>
    <div class="col-sm-3 sidenav">
      <div class="well">
        <h3>Welcome</h3>
	    <hr/>
        <p>${user} ${role}, hello!</p>
      </div>
      <div class="well">
        <p>${errorUpdateProjectDataMessage}</p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Project Made By Sytau</p>
</footer>

<!--  
	<h4>Project ${project.name}</h4>
	<form name="ProjectForm" method="POST" action="mainController">
		<input type="hidden" name="command" value="update_project" />
		<input type="hidden" name="id_project" value="${project.id}" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<table>
			<tr><th>Project Name</th>
	        	<td><input type="text" size="50" name="name" value="${project.name}"></td></tr>
	        <tr><th>Project description</th>
	        	<td><textarea rows="10" cols="50" name="description">${project.description}</textarea></td></tr>
	        <tr><th>Requirements Specification</th>
	        	<td><textarea rows="10" cols="50" name="requirements_specification">${project.requirementSpecification}</textarea></td></tr>	
	        <tr><th>Cost</th>
	        	<td><input type="text" name="cost" value="${project.cost}"></td></tr>
			<tr><th>Start Date</th>
	        	<td><input type="text" name="start_date" value="${project.startDate}"></td></tr>
	        <tr><th>Finish Date</th>
	        	<td><input type="text" name="finish_date" value="${project.finishDate}"></td></tr>
	        <tr><th>Progress</th>
	        	<td><input type="text" name="progress" value="${project.progress}"></td></tr>
	        <tr><th>Client Name</th><td>${project.client.users.name}</td></tr>
				<tr><th>Executants</th>
					<td>
					<c:forEach var="executant" items="${project.employees}">
						${executant.users.name} ${executant.users.roles.role}<br>
					</c:forEach>
					</td></tr>
	        <tr><td><input type="submit" name="button" value="Send"></td></tr>	
    	</table>
    	<br/>
    	${errorUpdateProjectDataMessage}
	</form>
	<br>
	<c:if test="${role eq 'project_manager'}">
		<form name="ChangeExecutants" method="GET" action="mainController">
			<input type="hidden" name="command" value="change_executants_form"/>
			<input type="hidden" name="user_id" value="${user_id}" />
			<input type="hidden" name="user" value="${user}"/>
			<input type="hidden" name="role" value="${role}"/>
			<input type="hidden" name="projectid" value="${project.id}"/>
			<input type="submit" value="Change Executants"/>
		</form>
		<br>
	</c:if>
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