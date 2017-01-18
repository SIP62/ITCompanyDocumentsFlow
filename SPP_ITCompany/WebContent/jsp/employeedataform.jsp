<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Data Form</title>
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
      <form class="form-horizontal" role="form" name="EmployeeDataForm" method="POST" action="mainController">
      	<input type="hidden" name="command" value="update_employee_data" />
		<input type="hidden" name="employee_id" value="${employee.id}" />
		<input type="hidden" name="id_users" value="${employee.users.id}" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		
		<c:choose>
		<c:when test="${role eq 'admin'}">
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="name">Name:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="name" name="name" value="${employee.users.name}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="address">Address:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="address" name="address" value="${employee.address}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="phone">Phone:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="phone" name="phone" value="${employee.phone}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="passport">Passport:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="passport" name="passport" value="${employee.passport}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="credit_card">Credit card:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="credit_card" name="credit_card" value="${employee.creditCard}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="resume">Resume:</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="6" id="resume" name="resume">${employee.resume}</textarea>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="specialization">Specialization:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="specialization" name="specialization" value="${employee.specialization}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="salary">Salary:</label>
		    <div class="col-sm-9">
		      <input type="number" class="form-control" id="salary" name="salary" value="${employee.salary}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="recruitment_date">Recruitment date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="recruitment_date" name="recruitment_date" value="${employee.recruitmentDate}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="contract_expiration_date">Contract expiration date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="contract_expiration_date" name="contract_expiration_date" value="${employee.contractExpirationDate}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="id_roles">Status:</label>
		    <div class="col-sm-9">
		      <select class="form-control" id="id_roles" name="id_roles">
	        	<c:forEach var="employeerole" items="${rolesList}">
	        	  <c:choose>
	        		<c:when test="${employeerole.role eq employee.users.roles.role}">
	        		  <option value="${employeerole.id}" selected>${employeerole.role}</option>
	        		</c:when>
	        	  	<c:otherwise>
	        		  <option value="${employeerole.id}">${employeerole.role}</option>
	        	  	</c:otherwise>
	        	  </c:choose>
	        	</c:forEach>
	          </select>			
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="login">Login:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="login" name="login" value="${employee.users.login}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="pwd">Password:</label>
		    <div class="col-sm-9"> 
		      <input type="password" class="form-control" id="pwd" name="password" value="${employee.users.password}">
		    </div>    
		  </div>
		  </c:when>
		  <c:when test="${role eq 'project_manager' or role eq 'HR'}">
			<c:if test="${role ne employee.users.roles.role}">
				<input type="hidden" name="login" value="${employee.users.login}" />\
				<input type="hidden" name="password" value="${employee.users.password}" />
				<input type="hidden" name="passport" value="${employee.passport}" />
				<input type="hidden" name="credit_card" value="${employee.creditCard}" />
			</c:if>
			<div class="form-group">
		    <label class="control-label col-sm-3" for="name">Name:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="name" name="name" value="${employee.users.name}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="address">Address:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="address" name="address" value="${employee.address}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="phone">Phone:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="phone" name="phone" value="${employee.phone}" readonly>
		    </div>
		  </div>
		  <c:if test="${role eq employee.users.roles.role}">	
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="passport">Passport:</label>
			    <div class="col-sm-9">
			      <input type="text" class="form-control" id="passport" name="passport" value="${employee.passport}">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="credit_card">Credit card:</label>
			    <div class="col-sm-9">
			      <input type="text" class="form-control" id="credit_card" name="credit_card" value="${employee.creditCard}" readonly>
			    </div>
			  </div>
		  </c:if>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="resume">Resume:</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="6" id="resume" name="resume" readonly>${employee.resume}</textarea>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="specialization">Specialization:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="specialization" name="specialization" value="${employee.specialization}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="salary">Salary:</label>
		    <div class="col-sm-9">
		      <input type="number" class="form-control" id="salary" name="salary" value="${employee.salary}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="recruitment_date">Recruitment date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="recruitment_date" name="recruitment_date" value="${employee.recruitmentDate}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="contract_expiration_date">Contract expiration date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="contract_expiration_date" name="contract_expiration_date" value="${employee.contractExpirationDate}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="id_roles">Status:</label>
		    <div class="col-sm-9">
		      <select class="form-control" id="id_roles" name="id_roles">
	        	<c:forEach var="employeerole" items="${rolesList}">
	        	  <c:choose>
	        		<c:when test="${employeerole.role eq employee.users.roles.role}">
	        		  <option value="${employeerole.id}" selected>${employeerole.role}</option>
	        		</c:when>
	        	  	<c:otherwise>
	        		  <option value="${employeerole.id}">${employeerole.role}</option>
	        	  	</c:otherwise>
	        	  </c:choose>
	        	</c:forEach>
	          </select>			
		    </div>
		  </div>
		  <c:if test="${role eq employee.users.roles.role}">
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="login">Login:</label>
			    <div class="col-sm-9">
			      <input type="text" class="form-control" id="login" name="login" value="${employee.users.login}">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="pwd">Password:</label>
			    <div class="col-sm-9"> 
			      <input type="password" class="form-control" id="pwd" name="password" value="${employee.users.password}">
			    </div>    
			  </div>
		  </c:if>		
		  </c:when>
		  <c:otherwise>
			<input type="hidden" name="id_roles" value="${employee.users.roles.id}" />
			<div class="form-group">
		    <label class="control-label col-sm-3" for="name">Name:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="name" name="name" value="${employee.users.name}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="address">Address:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="address" name="address" value="${employee.address}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="phone">Phone:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="phone" name="phone" value="${employee.phone}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="passport">Passport:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="passport" name="passport" value="${employee.passport}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="credit_card">Credit card:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="credit_card" name="credit_card" value="${employee.creditCard}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="resume">Resume:</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="6" id="resume" name="resume">${employee.resume}</textarea>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="specialization">Specialization:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="specialization" name="specialization" value="${employee.specialization}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="salary">Salary:</label>
		    <div class="col-sm-9">
		      <input type="number" class="form-control" id="salary" name="salary" value="${employee.salary}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="recruitment_date">Recruitment date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="recruitment_date" name="recruitment_date" value="${employee.recruitmentDate}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="contract_expiration_date">Contract expiration date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="contract_expiration_date" name="contract_expiration_date" value="${employee.contractExpirationDate}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="id_roles">Status:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="id_roles" name="id_roles" value="${employee.users.roles.role}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="login">Login:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="login" name="login" value="${employee.users.login}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="pwd">Password:</label>
		    <div class="col-sm-9"> 
		      <input type="password" class="form-control" id="pwd" name="password" value="${employee.users.password}">
		    </div>    
		  </div>
		  </c:otherwise>		
		</c:choose>
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
	
	<form name="EmployeeDataForm" method="POST" action="mainController">
		<input type="hidden" name="command" value="update_employee_data" />
		<input type="hidden" name="employee_id" value="${employee.id}" />
		<input type="hidden" name="id_users" value="${employee.users.id}" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		<c:choose>
			<c:when test="${role eq 'admin'}">
				<table>
			
					<tr><td>Name</td>
	        			<td><input type="text" size="30" name="name" 
	        			value="${employee.users.name}"></td></tr>
	        		<tr><td>Address</td>
	        			<td><input type="text" size="30" name="address" 
	        			value="${employee.address}"></td></tr>	
					<tr><td>Phone</td>
	        			<td><input type="text" size="30" name="phone" 
	        			value="${employee.phone}"></td></tr>
					<tr><td>Passport</td>
	        			<td><input type="text" size="30" name="passport" 
	        			value="${employee.passport}"></td></tr>
					<tr><td>Credit card</td>
	        			<td><input type="text" size="30" name="credit_card" 
	        			value="${employee.creditCard}"></td></tr>
	        		<tr><td>Resume</td>
	        			<td><textarea rows="10" cols="50" 
	        			name="resume">${employee.resume}</textarea></td></tr>	
					<tr><td>Specialization</td>
	        			<td><input type="text" size="30" name="specialization" 
	        			value="${employee.specialization}"></td></tr>
	        		<tr><td>Salary</td>
	        			<td><input type="text" size="30" name="salary" 
	        			value="${employee.salary}"></td></tr>
	        		<tr><td>Recruitment date</td>
	        			<td><input type="text" size="30" name="recruitment_date" 
	        			value="${employee.recruitmentDate}"></td></tr>
	        		<tr><td>Contract expiration date</td>
	        			<td><input type="text" size="30" name="contract_expiration_date" 
	        			value="${employee.contractExpirationDate}"></td></tr>
	        		<tr><td>Status</td>
	        			<td><select name="id_roles">
	        				<c:forEach var="employeerole" items="${rolesList}">
	        					<c:choose>
	        						<c:when test="${employeerole.role 
	        								eq employee.users.roles.role}">
	        							<option value="${employeerole.id}" selected>
	        								${employeerole.role}</option>
	        						</c:when>
	        						<c:otherwise>
	        							<option value="${employeerole.id}">
	        								${employeerole.role}</option>
	        						</c:otherwise>
	        					</c:choose>
	        				</c:forEach>
	        			</select></td></tr>
	        		<tr><td>Login</td>
	        			<td><input type="text" size="30" name="login" 
	        			value="${employee.users.login}"></td></tr>
					<tr><td>Password</td>
	        			<td><input type="password" size="30" name="password"
	        			value="${employee.users.password}"></td></tr> 
	        		</table>	
				</c:when>
				<c:when test="${role eq 'project_manager' or role eq 'HR'}">
					<c:if test="${role ne employee.users.roles.role}">
						<input type="hidden" name="login" value="${employee.users.login}" />\
						<input type="hidden" name="password" value="${employee.users.password}" />
						<input type="hidden" name="passport" value="${employee.passport}" />
							<input type="hidden" name="credit_card" value="${employee.creditCard}" />
					</c:if>
				
				<table>
			
					<tr><td>Name</td>
	        			<td><input type="text" size="30" name="name" 
	        			value="${employee.users.name}" readonly></td></tr>
	        		<tr><td>Address</td>
	        			<td><input type="text" size="30" name="address" 
	        			value="${employee.address}" readonly></td></tr>	
					<tr><td>Phone</td>
	        			<td><input type="text" size="30" name="phone" 
	        			value="${employee.phone}" readonly></td></tr>
	        		<c:if test="${role eq employee.users.roles.role}">	
	        			<tr><td>Passport</td>
	        				<td><input type="text" size="30" name="passport" 
	        				value="${employee.passport}"></td></tr>
						<tr><td>Credit card</td>
	        				<td><input type="text" size="30" name="credit_card" 
	        				value="${employee.creditCard}" readonly></td></tr>	
	        		</c:if>	
	        		<tr><td>Resume</td>
	        			<td><textarea rows="10" cols="50" name="resume" 
	        			readonly>${employee.resume}</textarea></td></tr>	
					<tr><td>Specialization</td>
	        			<td><input type="text" size="30" name="specialization" 
	        			value="${employee.specialization}"></td></tr>
	        		<tr><td>Salary</td>
	        			<td><input type="text" size="30" name="salary" 
	        			value="${employee.salary}" readonly></td></tr>
	        		<tr><td>Recruitment date</td>
	        			<td><input type="text" size="30" name="recruitment_date" 
	        			value="${employee.recruitmentDate}" readonly></td></tr>
	        		<tr><td>Contract expiration date</td>
	        			<td><input type="text" size="30" name="contract_expiration_date" 
	        			value="${employee.contractExpirationDate}" readonly></td></tr>
	        		<tr><td>Status</td>
	        			<td><select name="id_roles">
	        				<c:forEach var="employeerole" items="${rolesList}">
	        					<c:choose>
	        						<c:when test="${employeerole.role 
	        								eq employee.users.roles.role}">
	        							<option value="${employeerole.id}" selected>
	        								${employeerole.role}</option>
	        						</c:when>
	        						<c:otherwise>
	        							<option value="${employeerole.id}">
	        								${employeerole.role}</option>
	        						</c:otherwise>
	        					</c:choose>
	        				</c:forEach>
	        			</select></td></tr>
	        		<c:if test="${role eq employee.users.roles.role}">	
	        			<tr><td>Login</td>
	        				<td><input type="text" size="30" name="login" 
	        				value="${employee.users.login}"></td></tr>
						<tr><td>Password</td>
	        				<td><input type="password" size="30" name="password"
	        				value="${employee.users.password}"></td></tr> 
	        		</c:if>	
	        		</table>	
				</c:when>
				<c:otherwise>
					<input type="hidden" name="id_roles" value="${employee.users.roles.id}" />
					<table>
			
					<tr><td>Name</td>
	        			<td><input type="text" size="30" name="name" 
	        			value="${employee.users.name}" readonly></td></tr>
	        		<tr><td>Address</td>
	        			<td><input type="text" size="30" name="address" 
	        			value="${employee.address}"></td></tr>	
					<tr><td>Phone</td>
	        			<td><input type="text" size="30" name="phone" 
	        			value="${employee.phone}"></td></tr>
					<tr><td>Passport</td>
	        			<td><input type="text" size="30" name="passport" 
	        			value="${employee.passport}"></td></tr>
					<tr><td>Credit card</td>
	        			<td><input type="text" size="30" name="credit_card" 
	        			value="${employee.creditCard}" readonly></td></tr>
	        		<tr><td>Resume</td>
	        			<td><textarea rows="10" cols="50" 
	        			name="resume">${employee.resume}</textarea></td></tr>	
					<tr><td>Specialization</td>
	        			<td><input type="text" size="30" name="specialization" 
	        			value="${employee.specialization}" readonly></td></tr>
	        		<tr><td>Salary</td>
	        			<td><input type="text" size="30" name="salary" 
	        			value="${employee.salary}" readonly></td></tr>
	        		<tr><td>Recruitment date</td>
	        			<td><input type="text" size="30" name="recruitment_date" 
	        			value="${employee.recruitmentDate}" readonly></td></tr>
	        		<tr><td>Contract expiration date</td>
	        			<td><input type="text" size="30" name="contract_expiration_date" 
	        			value="${employee.contractExpirationDate}" readonly></td></tr>
	        		<tr><td>Status</td><td>${employee.users.roles.role}</td></tr>
	        		<tr><td>Login</td>
	        			<td><input type="text" size="30" name="login" 
	        			value="${employee.users.login}"></td></tr>
					<tr><td>Password</td>
	        			<td><input type="password" size="30" name="password"
	        			value="${employee.users.password}"></td></tr> 
	        		</table>	
	        	</c:otherwise>
	        </c:choose>
			<input type="submit" name="button" value="Update">
			<br/>
    	${errorUpdateEmployeeDataMessage}
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