<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
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
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">IT Company</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="mainController?command=logout">Home</a></li>
        <li><a href="mainController?command=employee_form&id_users=${user_id}&user_id=${user_id}&user=${user}&role=${role}">Private Data</a></li>
        <li><a href="mainController?command=employee_list&user_id=${user_id}&user=${user}&role=${role}">Employee list</a></li>
        <li><a href="mainController?command=add_employee_form&user_id=${user_id}&user=${user}&role=${role}">Add Employee</a></li>
        <li><a href="mainController?command=client_list&user_id=${user_id}&user=${user}&role=${role}">Client list</a></li>
        <li><a href="mainController?command=add_client_form&user_id=${user_id}&user=${user}&role=${role}">Add Client</a></li>
        <li><a href="mainController?command=users_list&user_id=${user_id}&user=${user}&role=${role}">User list</a></li>
        
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
		<c:if test="${!empty employeeList}">
		  <h5>Employee List</h5>
			<c:forEach var="employee" items="${employeeList}">
				<li><a href="mainController?command=employee_data&id_users=${employee.users.id}&user_id=${user_id}&user=${user}&role=${role}">${employee.users.name} - ${employee.users.roles.role}</a></li>
			</c:forEach>
		</c:if>
		<c:if test="${!empty employee}">
    		<li><a href="mainController?command=employee_form&id_users=${employee.users.id}&user_id=${user_id}&user=${user}&role=${role}">Change</a></li>
			<li class="dropdown">
    		  <a class="dropdown-toggle" data-toggle="dropdown" href="#">Export<span class="caret"></span></a>
    		  <ul class="dropdown-menu">
      			<li><a href="mainController?command=employee_data&output_file=${'excel'}&id_users=${employee.users.id}&user_id=${user_id}&user=${user}&role=${role}">Export in Excel</a></li>
      			<li><a href="mainController?command=employee_data&output_file=${'pdf'}&id_users=${employee.users.id}&user_id=${user_id}&user=${user}&role=${role}">Export in PDF</a></li>
      			<li><a href="mainController?command=employee_data&output_file=${'csv'}&id_users=${employee.users.id}&user_id=${user_id}&user=${user}&role=${role}">Export in CSV</a></li> 
    		  </ul>
  			</li>
		</c:if>
		<c:if test="${!empty clientList}">
			<h5>Client List</h5>
			<c:forEach var="client" items="${clientList}">
				<li><a href="mainController?command=client_data&id_users=${client.users.id}&user_id=${user_id}&user=${user}&role=${role}">${client.users.name}</a></li>
			</c:forEach>
		</c:if>
		<c:if test="${!empty client}">
    		<li><a href="mainController?command=client_form&id_users=${client.users.id}&user_id=${user_id}&user=${user}&role=${role}">Change</a></li>
    		<li class="dropdown">
    		  <a class="dropdown-toggle" data-toggle="dropdown" href="#">Export<span class="caret"></span></a>
    		  <ul class="dropdown-menu">
    			<li><a href="mainController?command=client_data&output_file=${'excel'}&id_users=${client.users.id}&user_id=${user_id}&user=${user}&role=${role}">Export in Excel</a></li>
			  	<li><a href="mainController?command=client_data&output_file=${'pdf'}&id_users=${client.users.id}&user_id=${user_id}&user=${user}&role=${role}">Export in PDF</a></li>
			  	<li><a href="mainController?command=client_data&output_file=${'csv'}&id_users=${client.users.id}&user_id=${user_id}&user=${user}&role=${role}">Export in CSV</a></li>
			  </ul>
		</c:if>
		<c:if test="${!empty userList}">
			<li class="dropdown">
    		  <a class="dropdown-toggle" data-toggle="dropdown" href="#">Export<span class="caret"></span></a>
    		  <ul class="dropdown-menu">
				<li><a href="mainController?command=users_list&output_file=${'excel'}&user_id=${user_id}&user=${user}&role=${role}">Export in Excel</a></li>
	  		  	<li><a href="mainController?command=users_list&output_file=${'pdf'}&user_id=${user_id}&user=${user}&role=${role}">Export in PDF</a></li>
	  		  	<li><a href="mainController?command=users_list&output_file=${'csv'}&user_id=${user_id}&user=${user}&role=${role}">Export in CSV</a></li>
	  		  </ul>
	  	</c:if>
	  </ul>
    </div>
    <div class="col-sm-6 text-left"> 
      <h3>Data</h3>
		<c:if test="${!empty employee}">
			<table  class="table table-bordered">
				<tr><th>Name</th><td>${employee.users.name}</td></tr>
		        <tr><th>Address</th><td>${employee.address}</td></tr>	
				<tr><th>Phone</th><td>${employee.phone}</td></tr>
				<tr><th>Passport</th><td>${employee.passport}</td></tr>
				<tr><th>Credit card</th><td>${employee.creditCard}</td></tr>
		        <tr><th>Resume</th><td>${employee.resume}</td></tr>	
				<tr><th>Specialization</th><td>${employee.specialization}</td></tr>
		        <tr><th>Salary</th><td>${employee.salary}</td></tr>
		        <tr><th>Recruitment date</th><td>${employee.recruitmentDate}</td></tr>
		        <tr><th>Contract expiration date</th><td>${employee.contractExpirationDate}</td></tr>
		        <tr><th>Status</th><td>${employee.users.roles.role}</td></tr>
    		</table>
		</c:if>
		<c:if test="${!empty client}">
			<table class="table table-bordered">
				<tr><th>Name</th><td>${client.users.name}</td></tr>
		        <tr><th>Payment Credentials</th><td>${client.paymentCredentials}</td></tr>	
				<tr><th>Phone</th><td>${client.phone}</td></tr>
				<tr><th>e-Mail</th><td>${client.email}</td></tr>
				<tr><th>Address</th><td>${client.address}</td></tr>
				<tr><th>Discount</th><td>${client.discount}</td></tr>
    		</table>
		</c:if>
		<c:if test="${!empty userList}">
		  <table class="table table-bordered">
			<tr><th>ID</th><th>User</th><th>Status</th><th>&nbsp;</th></tr>
			<c:forEach var="user_el" items="${userList}">
				<tr><td>${user_el.id}</td>
				<td>${user_el.name}</td>
				<td>${user_el.roles.role}</td>
				<td>
				<c:if test="${user_el.roles.role eq 'guest'}">
					<a href="mainController?command=delete_user&userid=${user_el.id}&user_id=${user_id}&user=${user}&role=${role}">Delete</a>
				</c:if></td></tr><br>
			</c:forEach>
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
        <p>${updatePrivateDataMessage}</p>
        <br/>
		<p>${updateEmployeeDataMessage}</p>
		<br/>
		<p>${addEmployeeMessage}</p>
		<br/>
		<p>${updateClientDataMessage}</p>
		<br/>
		<p>${addClientMessage}</p>
		<br/>
		<p>${clientOutputMessage}</p>
 		<br/>
		<p>${employeeOutputMessage}</p>
		<br/>
		<p>${userOutputMessage}</p>	
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
	
	<form name="EmployeeData" method="GET" action="mainController">
		<input type="hidden" name="command" value="employee_form" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="id_users" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<input type="submit" value="Private Data"/>
		<br/>
		${updatePrivateDataMessage}
		<br/>
	</form>
	<br>
	<form name="EmployeeList" method="GET" action="mainController">
			<input type="hidden" name="command" value="employee_list" />
			<input type="hidden" name="user_id" value="${user_id}" />
			<input type="hidden" name="user" value="${user}" />
			<input type="hidden" name="role" value="${role}" />
			<input type="submit" value="Employee list"/>
		</form>
		<br>
		<c:if test="${!empty employeeList}">
			<table>
			<tr><th>Employee</th><th>Status</th></tr>
			<c:forEach var="employee" items="${employeeList}">
				<tr><td><a href="mainController?command=employee_data&id_users=${employee.users.id}&user_id=${user_id}&user=${user}&role=${role}">${employee.users.name}</a></td>
					<td>${employee.users.roles.role}</td></tr> <br>
			</c:forEach>
			</table>
		</c:if>
		<c:if test="${!empty employee}">
			<table border="1" >
				<tr><th>Name</th><td>${employee.users.name}</td></tr>
		        <tr><th>Address</th><td>${employee.address}</td></tr>	
				<tr><th>Phone</th><td>${employee.phone}</td></tr>
				<tr><th>Passport</th><td>${employee.passport}</td></tr>
				<tr><th>Credit card</th><td>${employee.creditCard}</td></tr>
		        <tr><th>Resume</th><td>${employee.resume}</td></tr>	
				<tr><th>Specialization</th><td>${employee.specialization}</td></tr>
		        <tr><th>Salary</th><td>${employee.salary}</td></tr>
		        <tr><th>Recruitment date</th><td>${employee.recruitmentDate}</td></tr>
		        <tr><th>Contract expiration date</th><td>${employee.contractExpirationDate}</td></tr>
		        <tr><th>Status</th><td>${employee.users.roles.role}</td></tr>
    		</table>
    		<a href="mainController?command=employee_form&id_users=${employee.users.id}
						&user_id=${user_id}&user=${user}&role=${role}">Change</a>
		</c:if>
		<br/>
		${updateEmployeeDataMessage}
		<br/>
	<br>
	<form name="AddEmployee" method="GET" action="mainController">
		<input type="hidden" name="command" value="add_employee_form" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<input type="submit" value="Add Employee"/>
		<br/>
		${addEmployeeMessage}
		<br/>
	</form>
	<br>
		
	<form name="ClientList" method="GET" action="mainController">
			<input type="hidden" name="command" value="client_list" />
			<input type="hidden" name="user_id" value="${user_id}" />
			<input type="hidden" name="user" value="${user}" />
			<input type="hidden" name="role" value="${role}" />
			<input type="submit" value="Client list"/>
	</form>
		<br>
		
		<c:if test="${!empty clientList}">
			<table>
			<tr><th>Client</th></tr>
			<c:forEach var="client" items="${clientList}">
				<tr><td><a href="mainController?command=client_data&id_users=${client.users.id}
						&user_id=${user_id}&user=${user}&role=${role}">${client.users.name}</a></td></tr> <br>
			</c:forEach>
			</table>
		</c:if>
		
		<c:if test="${!empty client}">
			<table border="1" >
				<tr><th>Name</th><td>${client.users.name}</td></tr>
		        <tr><th>Payment Credentials</th><td>${client.paymentCredentials}</td></tr>	
				<tr><th>Phone</th><td>${client.phone}</td></tr>
				<tr><th>e-Mail</th><td>${client.email}</td></tr>
				<tr><th>Discount</th><td>${client.discount}</td></tr>
		        <tr><th>Login</th><td>${client.users.login}</td></tr>	
				<tr><th>Password</th><td>${client.users.password}</td></tr>
		        <tr><th>Address</th><td>${client.address}</td></tr>
    		</table>
    		<a href="mainController?command=client_form&id_users=${client.users.id}
						&user_id=${user_id}&user=${user}&role=${role}">Change</a>
		</c:if>
		<br/>
		<p>${updateClientDataMessage}</p>
		<br>
	<form name="AddClient" method="GET" action="mainController">
		<input type="hidden" name="command" value="add_client_form" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<input type="submit" value="Add Client"/>
		<br/>
		${addClientMessage}
		<br/>
	</form>
	<br>
		
	<form name="UserList" method="GET" action="mainController">
			<input type="hidden" name="command" value="users_list" />
			<input type="hidden" name="user_id" value="${user_id}" />
			<input type="hidden" name="user" value="${user}" />
			<input type="hidden" name="role" value="${role}" />
			<input type="submit" value="User list"/>
	</form>
		<br>
		
		<c:if test="${!empty userList}">
			<table>
			<tr><th>ID</th><th>User</th><th>Status</th><th>&nbsp;</th></tr>
			<c:forEach var="user_el" items="${userList}">
				<tr><td>${user_el.id}</td>
				<td>${user_el.name}</td>
				<td>${user_el.roles.role}</td>
				<td>
				<c:if test="${user_el.roles.role eq 'guest'}">
					<a href="mainController?command=delete_user&userid=${user_el.id}&user_id=${user_id}&user=${user}&role=${role}">Delete</a>
				</c:if></td></tr><br>
			</c:forEach>
		</table>
		</c:if>	
-->		
</body>
</html>