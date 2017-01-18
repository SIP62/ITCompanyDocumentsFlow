<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recruit form</title>
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
      <h4>Project proposal form</h4>
      <form class="form-horizontal" role="form" name="RecruitForm" method="POST" action="mainController">
      	<input type="hidden" name="command" value="add_recruit" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="name">Name:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="name" name="name" value="${user}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="phone">Phone:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="phone" name="phone" placeholder="Enter phone">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="email">e-Mail:</label>
		    <div class="col-sm-9">
		      <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="specialization">Specialization:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="specialization" name="specialization" placeholder="Enter specialization">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="resume">Resume:</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="6" id="resume" name="resume" placeholder="Enter resume"></textarea>
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
        <p>${errorRecruitMessage}</p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Project Made By Sytau</p>
</footer>
<!--  
	<h4>Recruit form</h4>
	<form name="RecruitForm" method="POST" action="mainController">
		<input type="hidden" name="command" value="add_recruit" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<table>
			<tr><td>Name</td>
	        	<td><input type="text" size="30" name="name" value="${user}"></td></tr>
			<tr><td>Phone</td>
	        	<td><input type="text" size="30" name="phone"></td></tr>
			<tr><td>e-Mail</td>
	        	<td><input type="text" size="30" name="email"></td></tr>
			<tr><td>Specialization</td>
	        	<td><input type="text" size="70" name="specialization"></td></tr>
			<tr><td>Resume</td>
	        	<td><textarea rows="10" cols="50" name="resume"></textarea></td></tr>
			
			<tr><td><input type="submit" name="button" value="Send"></td></tr>
    </table>
    <br/>
    	${errorRecruitMessage}
	</form>
	<br>
	<form name="ReturnToPage" method="GET" action="mainController">
		<input type="hidden" name="command" value="return_to_page" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<input type="submit" value="Return"/>
	</form>
-->	
</body>
</html>