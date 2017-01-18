<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project info</title>
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
      <h4>Add Information for Project ${projectname}</h4>
      <form class="form-horizontal" role="form" name="ProjectInfoForm" method="POST" action="mainController">
      	<input type="hidden" name="command" value="add_project_info" />
		<input type="hidden" name="projectid" value="${projectid}" />
		<input type="hidden" name="projectname" value="${projectname}" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="name">Info Name:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="name" name="name" placeholder="Enter info name">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="date">Date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="date" name="date" placeholder="Enter date">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="description">Info description:</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="6" id="description" name="description" placeholder="Enter date"></textarea>
		    </div>
		  </div>
		  <div class="form-group">
      		<label class="control-label col-sm-3" for="author_id">Author:</label>
      		<div class="col-sm-9">
      		  <select class="form-control" id="author_id" name="author_id">
				<c:forEach var="employee" items="${employeeList}">
	        		<option value="${employee.id}">${employee.users.name} ${employee.users.roles.role}</option>
	        	</c:forEach>
	          </select>
      		</div>
    	  </div>
		  <div class="form-group"> 
		    <div class="col-sm-offset-3 col-sm-9">
		      <button type="submit" class="btn btn-default">Send</button>
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
        <p></p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Project Made By Sytau</p>
</footer>

<!--  
	<h4>Add Information for Project ${projectname}</h4>
	<form name="ProjectInfoForm" method="POST" action="mainController">
		<input type="hidden" name="command" value="add_project_info" />
		<input type="hidden" name="projectid" value="${projectid}" />
		<input type="hidden" name="projectname" value="${projectname}" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<table>
			<tr><th>Info Name</th>
	        	<td><input type="text" name="name"></td></tr>
	        <tr><th>Date</th>
	        	<td><input type="text" name="date"></td></tr>	
	        <tr><th>Info description</th>
	        	<td><textarea rows="3" cols="30" name="description"></textarea></td></tr>
			<tr><th>Author</th>
				<td><select name="author_id">
					<c:forEach var="employee" items="${employeeList}">
	        			<option value="${employee.id}">${employee.users.name} ${employee.users.roles.role}</option>
	        		</c:forEach>
	        	</select></td></tr>
	        <tr><td><input type="submit" name="button" value="Send"></td></tr>	
    	</table>
	</form>
	<br>
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