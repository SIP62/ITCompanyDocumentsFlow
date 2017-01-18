<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client Data Form</title>
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
      <h4>Client data form</h4>
      <form class="form-horizontal" role="form" name="ClientDataForm" method="POST" action="mainController">
      	<input type="hidden" name="command" value="update_client_data" />
		<input type="hidden" name="id_client" value="${client.id}" />
		<input type="hidden" name="id_users" value="${client.users.id}" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<input type="hidden" name="id_roles" value="${id_roles}" />
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="name">Name:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="name" name="name" value="${client.users.name}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="payment_credentials">Payment credentials:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="payment_credentials" name="payment_credentials" value="${client.paymentCredentials}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="phone">Phone:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="phone" name="phone" value="${client.phone}">
		    </div>
		  </div>
		  <div class="form-group">
      		<label class="control-label col-sm-2" for="email">Email:</label>
      		<div class="col-sm-10">
        	  <input type="email" class="form-control" id="email" name="email" value="${client.email}">
      		</div>
    	  </div>
    	  <div class="form-group">
		    <label class="control-label col-sm-2" for="address">Address:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="address" name="address" value="${client.address}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="discount">Discount:</label>
		    <div class="col-sm-10">
		      <input type="number" class="form-control" id="discount" name="discount" value="${client.discount}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="login">Login:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="login" name="login" value="${client.users.login}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="pwd">Password:</label>
		    <div class="col-sm-10"> 
		      <input type="password" class="form-control" id="pwd" name="password" value="${client.users.password}">
		    </div>
		  </div>
		  <div class="form-group"> 
		    <div class="col-sm-offset-2 col-sm-10">
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
        <p>${errorUpdateClientDataMessage}</p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Project Made By Sytau</p>
</footer>

<!--	
	<h4>Client data form</h4>
	<form name="ClientDataForm" method="POST" action="mainController">
		<input type="hidden" name="command" value="update_client_data" />
		<input type="hidden" name="id_client" value="${client.id}" />
		<input type="hidden" name="id_users" value="${client.users.id}" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<input type="hidden" name="id_roles" value="${id_roles}" />
		<table>
			<tr><td>Name</td>
	        	<td><input type="text" size="30" name="name" value="${client.users.name}"></td></tr>
	        <tr><td>Payment credentials</td>
	        	<td><input type="text" size="30" name="payment_credentials" value="${client.paymentCredentials}"></td></tr>	
			<tr><td>Phone</td>
	        	<td><input type="text" size="30" name="phone" value="${client.phone}"></td></tr>
			<tr><td>e-Mail</td>
	        	<td><input type="text" size="30" name="email" value="${client.email}"></td></tr>
			<tr><td>Address</td>
	        	<td><input type="text" size="30" name="address" value="${client.address}"></td></tr>
			<tr><td>Discount</td>
	        	<td><input type="text" size="30" name="discount" value="${client.discount}" readonly></td></tr>
			<tr><td>Login</td>
	        	<td><input type="text" size="30" name="login" value="${client.users.login}"></td></tr>
			<tr><td>Password</td>
	        	<td><input type="password" size="30" name="password" value="${client.users.password}"></td></tr>
			<tr><td><input type="submit" name="button" value="Update"></td></tr>
    </table>
    <br/>
    	${errorUpdateClientDataMessage}
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