<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client Employee</title>
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
      <h3>Data</h3>
      <form class="form-horizontal" role="form" name="ClientEmployeeForm" method="POST" action="mainController">
      	<input type="hidden" name="command" value="add_client_employee" />
		<input type="hidden" name="clientid" value="${clientid}" />
		<input type="hidden" name="clientname" value="${clientname}" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="name">Name:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="phone">Phone:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="phone" name="phone" placeholder="Enter phone">
		    </div>
		  </div>
		  <div class="form-group">
      		<label class="control-label col-sm-2" for="email">Email:</label>
      		<div class="col-sm-10">
        	  <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
      		</div>
    	  </div>
    	  <div class="form-group">
		    <label class="control-label col-sm-2" for="skype">Skype:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="skype" name="skype" placeholder="Enter skype">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="status">Status:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="status" name="status" placeholder="Enter status">
		    </div>
		  </div>
		  <div class="form-group"> 
		    <div class="col-sm-offset-2 col-sm-10">
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
	<h4>Add Client Employee for Project ${projectname}</h4>
	<form name="ClientEmployeeForm" method="POST" action="mainController">
		<input type="hidden" name="command" value="add_client_employee" />
		<input type="hidden" name="clientid" value="${clientid}" />
		<input type="hidden" name="clientname" value="${clientname}" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<table>
			<tr><th>Name</th>
	        	<td><input type="text" name="name"></td></tr>
	        <tr><th>Phone</th>
	        	<td><input type="text" name="phone"></td></tr>	
	        <tr><th>e-Mail</th>
	        	<td><input type="text" name="email"></td></tr>
			<tr><th>Skype</th>
				<td><input type="text" name="skype"></td></tr>
			<tr><th>Status</th>
				<td><input type="text" name="status"></td></tr>	
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