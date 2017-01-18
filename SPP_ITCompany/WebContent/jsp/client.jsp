<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client</title>
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
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">IT Company</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="mainController?command=logout">Home</a></li>
        <li><a href="mainController?command=client_form&id_users=${user_id}&user_id=${user_id}&user=${user}&role=${role}">Private Data</a></li>
        <li><a href="mainController?command=project_proposal_form&user_id=${user_id}&user=${user}&role=${role}">Project proposal</a></li>
        <li><a href="mainController?command=projects_list&user_id=${user_id}&user=${user}&role=${role}">Projects list</a></li>
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
		<c:if test="${!empty projectsList}">
			<c:forEach var="project" items="${projectsList}">
				<li><a href="mainController?command=project_form&projectid=${project.id}&user_id=${user_id}&user=${user}&role=${role}">${project.name}</a></li>
			</c:forEach>
		  </c:if>
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
        <p>${updatePrivateDataMessage}</p>
        <br/>
		<p>${addProjectProposalMessage}</p>
		<br/>
		<p>${updateProjectDataMessage}</p>
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
	<form name="ProjectProposalForm" method="GET" action="mainController">
		<input type="hidden" name="command" value="project_proposal_form" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<input type="submit" value="Project proposal"/>
		<br/>
		${addProjectProposalMessage}
		<br/>
	</form>
	<br>
	<form name="ClientData" method="GET" action="mainController">
		<input type="hidden" name="command" value="client_form" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="id_users" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<input type="submit" value="Update Client Data"/>
		<br/>
		${updatePrivateDataMessage}
		<br/>
	</form>

	<br>
	<form name="ProjectsList" method="GET" action="mainController">
		<input type="hidden" name="command" value="projects_list" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<input type="submit" value="Projects list"/>
	</form>
	<br>
	<c:forEach var="project" items="${projectsList}">
		<a href="mainController?command=project_form&projectid=${project.id}&user_id=${user_id}&user=${user}&role=${role}">${project.name}</a><br>
	</c:forEach>
	<br/>
	<p>${updateProjectDataMessage}</p>
 	<br/>
--> 	
</body>
</html>