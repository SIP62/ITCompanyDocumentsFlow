<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Guest</title>
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
		<li><a href="mainController?command=recruit_form&user=${user}&role=${role}">Recruit application</a></li>
		<li><a href="mainController?command=project_proposal_form&user=${user}&role=${role}">Project proposal</a></li>
	  </ul>
    </div>
    <div class="col-sm-6 text-left"> 
      <h3>Data</h3>
    </div>
    <div class="col-sm-3 sidenav">
      <div class="well">
        <h3>Welcome</h3>
	    <hr/>
        <p>${user} ${role}, hello!</p>
      </div>
      <div class="well">
        <p>${addRecruitMessage}</p>
        <br/>
		<p>${addProjectProposalMessage}</p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Project Made By Sytau</p>
</footer>
<!--  
	<h3>Welcome</h3>
	<hr/>
	${user} ${role}, hello!
	<hr/>
	<a href="mainController?command=logout">Logout</a>
	<hr/>
 	
 	<a href="mainController?command=recruit_form&user=${user}&role=${role}">
 		Recruit application</a>
 	<a href="mainController?command=project_proposal_form&user=${user}
 		&role=${role}">Project proposal</a>
 	<br/>
 	
 	<p>${addRecruitMessage}</p>
 	<br/>
	<p>${addProjectProposalMessage}</p>
 	<br/>
--> 	
 	
</body>
</html>