<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee Form</title>
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
      <h4>Employee Data Form</h4>
      <form class="form-horizontal" role="form" name="AddEmployeeForm" method="POST" action="mainController">
      	<input type="hidden" name="command" value="add_employee" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		
		
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="name">Name:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="address">Address:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="address" name="address" placeholder="Enter address">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="phone">Phone:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="phone" name="phone" placeholder="Enter phone">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="passport">Passport:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="passport" name="passport" placeholder="Enter passport">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="credit_card">Credit card:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="credit_card" name="credit_card" placeholder="Enter credit card">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="resume">Resume:</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="6" id="resume" name="resume" placeholder="Enter resume"></textarea>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="specialization">Specialization:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="specialization" name="specialization" placeholder="Enter specialization">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="salary">Salary:</label>
		    <div class="col-sm-9">
		      <input type="number" class="form-control" id="salary" name="salary" placeholder="Enter salary">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="recruitment_date">Recruitment date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="recruitment_date" name="recruitment_date" placeholder="Enter recruitment date">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="contract_expiration_date">Contract expiration date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="contract_expiration_date" name="contract_expiration_date" placeholder="Enter contract expiration date">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="id_roles">Status:</label>
		    <div class="col-sm-9">
		      <select class="form-control" id="id_roles" name="id_roles">
	        	<c:forEach var="employeerole" items="${rolesList}">
	        	  <option value="${employeerole.id}">${employeerole.role}</option>
	        	</c:forEach>
	          </select>			
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="login">Login:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="login" name="login" placeholder="Enter login">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="pwd">Password:</label>
		    <div class="col-sm-9"> 
		      <input type="password" class="form-control" id="pwd" name="password" placeholder="Enter password">
		    </div>    
		  </div>
		 
		  <div class="form-group"> 
		    <div class="col-sm-offset-3 col-sm-9">
		      <button type="submit" class="btn btn-default">Add Employee</button>
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
        <p>${errorUpdateEmployeeDataMessage}</p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Project Made By Sytau</p>
</footer>

<!--  
	<h4>Employee Data Form</h4>
	
	<form name="AddEmployeeForm" method="POST" action="mainController">
		<input type="hidden" name="command" value="add_employee" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<table>
			<tr><td>Name</td>
	        	<td><input type="text" size="30" name="name"></td></tr>
	        <tr><td>Address</td>
	        	<td><input type="text" size="30" name="address"></td></tr>	
			<tr><td>Phone</td>
	        	<td><input type="text" size="30" name="phone"></td></tr>
			<tr><td>Passport</td>
	        	<td><input type="text" size="30" name="passport"></td></tr>
			<tr><td>Credit card</td>
	        	<td><input type="text" size="30" name="credit_card"></td></tr>
	        <tr><td>Resume</td>
	        	<td><textarea rows="10" cols="50" name="resume"></textarea></td></tr>	
			<tr><td>Specialization</td>
	        	<td><input type="text" size="30" name="specialization"></td></tr>
	        <tr><td>Status</td>
	        	<td><select name="id_roles">
	        		<c:forEach var="employeerole" items="${rolesList}">
	        			<option value="${employeerole.id}">${employeerole.role}</option>
	        		</c:forEach>
	        	</select></td></tr>	
	        <tr><td>Salary</td>
	        	<td><input type="text" size="30" name="salary"></td></tr>
	        <tr><td>Recruitment date</td>
	        	<td><input type="text" size="30" name="recruitment_date"></td></tr>
	        <tr><td>Contract expiration date</td>
	        	<td><input type="text" size="30" name="contract_expiration_date"></td></tr>
	        
			<tr><td>Login</td>
	        	<td><input type="text" size="30" name="login"></td></tr>
			<tr><td>Password</td>
	        	<td><input type="password" size="30" name="password"></td></tr>
			<tr><td><input type="submit" name="button" value="Update"></td></tr>
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