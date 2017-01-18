<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Employee</title>
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
        <c:if test="${role ne 'HR'}">
          <span class="icon-bar"></span>
        </c:if>
        <c:if test="${role eq 'project_manager' || role eq 'HR'}">
          <span class="icon-bar"></span>
        </c:if>
        <c:if test="${role eq 'HR'}">
          <span class="icon-bar"></span>
        </c:if>
        <c:if test="${role eq 'client_manager'}">
          <span class="icon-bar"></span>
        </c:if>                      
      </button>
      <a class="navbar-brand" href="#">IT Company</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="mainController?command=logout">Home</a></li>
        <li><a href="mainController?command=employee_form&id_users=${user_id}&user_id=${user_id}&user=${user}&role=${role}">Private Data</a></li>
        <c:if test="${role ne 'HR'}">
          <li><a href="mainController?command=projects_list&user_id=${user_id}&user=${user}&role=${role}">Projects list</a></li>
        </c:if>
        <c:if test="${role eq 'project_manager' || role eq 'HR'}">			
          <li><a href="mainController?command=employee_list&user_id=${user_id}&user=${user}&role=${role}">Employee list</a></li>
        </c:if>
        <c:if test="${role eq 'HR'}">			
          <li><a href="mainController?command=project_proposal_list&user_id=${user_id}&user=${user}&role=${role}">Project proposal list</a></li>
        </c:if>
        <c:if test="${role eq 'client_manager'}">			
          <li><a href="mainController?command=client_list&user_id=${user_id}&user=${user}&role=${role}">Client list</a></li>
        </c:if>										
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
        <c:if test="${role ne 'HR'}">
		  <c:if test="${!empty projectsList}">
			<c:forEach var="project" items="${projectsList}">
				<li><a href="mainController?command=project_data&projectid=${project.id}&user_id=${user_id}&user=${user}&role=${role}">${project.name}</a></li>
			</c:forEach>
		  </c:if>
		  <c:if test="${!empty project}">
    		<li><a href="mainController?command=client_employees&clientid=${project.client.id}&clientname=${project.client.users.name}&user_id=${user_id}&user=${user}&role=${role}">See contacts of Client ${project.client.users.name}</a></li>
    		<li><a href="mainController?command=project_info&projectid=${project.id}&projectname=${project.name}&user_id=${user_id}&user=${user}&role=${role}">See Project ${project.name} info</a></li>
    		<li><a href="mainController?command=project_form&projectid=${project.id}&user_id=${user_id}&user=${user}&role=${role}">Change Project</a></li>
		  </c:if>
		  <c:if test="${!empty infoList}">
		    <li><a href="mainController?command=project_info_form&projectid=${projectid}&projectname=${projectname}&user_id=${user_id}&user=${user}&role=${role}">Add info in Project ${projectname}</a></li>
		  </c:if>
	    </c:if>
	  
	  
	  <c:if test="${role eq 'project_manager' || role eq 'HR'}">
		<c:if test="${!empty employeeList}">
		  <h5>Employee List</h5>
			<c:forEach var="employee" items="${employeeList}">
				<li><a href="mainController?command=employee_data&id_users=${employee.users.id}&user_id=${user_id}&user=${user}&role=${role}">${employee.users.name} - ${employee.users.roles.role}</a></li>
			</c:forEach>
		</c:if>
		<c:if test="${!empty employee && role eq 'project_manager'}">
    		<li><a href="mainController?command=employee_form&id_users=${employee.users.id}&user_id=${user_id}&user=${user}&role=${role}">Change</a></li>
		</c:if>
	  </c:if>
	  <c:if test="${role eq 'HR'}">
		<c:forEach var="project_proposal" items="${projectProposalList}">
			<li><a href="mainController?command=project_proposal_view&projectProposalid=${project_proposal.id}&user_id=${user_id}&user=${user}&role=${role}">${project_proposal.name}</a></li>
		</c:forEach>
	  </c:if>
	  <c:if test="${role eq 'client_manager'}">
		<c:if test="${!empty clientList}">
			<h5>Client List</h5>
			<c:forEach var="client" items="${clientList}">
				<li><a href="mainController?command=client_data&id_users=${client.users.id}&user_id=${user_id}&user=${user}&role=${role}">${client.users.name}</a></li>
			</c:forEach>
		</c:if>
		<c:if test="${!empty client}">
    		<li><a href="mainController?command=client_form&id_users=${client.users.id}&user_id=${user_id}&user=${user}&role=${role}">Change</a></li>
		</c:if>
	  </c:if>
	  </ul>
    </div>
    <div class="col-sm-6 text-left"> 
      <h3>Data</h3>
      <c:if test="${role ne 'HR'}">
        <c:if test="${!empty project}">
			<table  class="table table-bordered">
				<tr><th>Project Name</th><td>${project.name}</td></tr>
		        <tr><th>Project description</th><td>${project.description}</td></tr>	
				<tr><th>Requirements Specification</th>
					<td>${project.requirementSpecification}</td></tr>
				<tr><th>Cost</th><td>${project.cost}</td></tr>
				<tr><th>Start Date</th><td>${project.startDate}</td></tr>
		        <tr><th>Finish Date</th><td>${project.finishDate}</td></tr>	
				<tr><th>Progress</th><td>${project.progress}</td></tr>
				<tr><th>Client Name</th><td>${project.client.users.name}</td></tr>
				<tr><th>Executants</th>
					<td>
					<c:forEach var="executant" items="${project.employees}">
						${executant.users.name} ${executant.users.roles.role}<br>
					</c:forEach>
					</td></tr>
    		</table>
    	</c:if>
    	<c:if test="${!empty clientEmployeeList}">
			<table  class="table table-bordered">
			  <tr>
				<th>Name</th>
				<th>Phone</th>
				<th>e-Mail</th>
				<th>Skype</th>
				<th>Status</th>
			  </tr>
		        <c:forEach var="clientEmployee" items="${clientEmployeeList}">
			      <tr>
					<td>${clientEmployee.name}</td>
					<td>${clientEmployee.phone}</td>
					<td>${clientEmployee.email}</td>
					<td>${clientEmployee.skype}</td>
					<td>${clientEmployee.status}</td>
				  </tr>
				</c:forEach>
    		</table>
    	</c:if>
    	<c:if test="${!empty infoList}">
		  	<table  class="table table-bordered">
				<tr>
				<th>Project</th>
				<th>Info Name</th>
				<th>Date</th>
				<th>Info description</th>
				<th>Author</th>
				</tr>
				<c:forEach var="info" items="${infoList}">
					<tr>
					<td>${info.project.name}</td>
					<td>${info.name}</td>
					<td>${info.date}</td>
					<td>${info.description}</td>
					<td>${info.employee.users.name}</td>
					</tr>
				</c:forEach>
    		</table>
    	</c:if>		
      </c:if>
      <c:if test="${role eq 'project_manager' || role eq 'HR'}">
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
	  </c:if>
	  
	  <c:if test="${role eq 'HR'}">
		<c:if test="${!empty project_proposal}">
			<table  class="table table-bordered">
				<tr><th>Project Name</th><td>${project_proposal.name}</td></tr>
				<tr><th>Contact Name</th><td>${project_proposal.contactName}</td></tr>
				<tr><th>Phone</th><td>${project_proposal.phone}</td></tr>
				<tr><th>e-Mail</th><td>${project_proposal.email}</td></tr>
				<tr><th>Status</th><td>${project_proposal.status}</td></tr>
				<tr><th>Project description</th><td>${project_proposal.description}</td></tr>
				<tr><th>Require Specification</th><td>${project_proposal.requirementSpecification}</td></tr>
				<tr><th>Term</th><td>${project_proposal.term}</td></tr>	
			</table>
		</c:if>
	  </c:if>
	  
	  <c:if test="${role eq 'client_manager'}">
		<c:if test="${!empty client}">
			<table  class="table table-bordered">
				<tr><th>Name</th><td>${client.users.name}</td></tr>
		        <tr><th>Payment Credentials</th><td>${client.paymentCredentials}</td></tr>	
				<tr><th>Phone</th><td>${client.phone}</td></tr>
				<tr><th>e-Mail</th><td>${client.email}</td></tr>
				<tr><th>Address</th><td>${client.address}</td></tr>
				<tr><th>Discount</th><td>${client.discount}</td></tr>
    		</table>
		</c:if>
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
		<p>${updateProjectDataMessage}</p>
		<br/>
		<p>${updateEmployeeDataMessage}</p>
		<br/>
		<p>${updateClientDataMessage}</p>
 			
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
	
	
	<c:if test="${role ne 'HR'}">
		<form name="ProjectsList" method="GET" action="mainController">
			<input type="hidden" name="command" value="projects_list" />
			<input type="hidden" name="user_id" value="${user_id}" />
			<input type="hidden" name="user" value="${user}" />
			<input type="hidden" name="role" value="${role}" />
			<input type="submit" value="Projects list"/>
		</form>
		<br>
		<c:if test="${!empty projectsList}">
			<c:forEach var="project" items="${projectsList}">
				<a href="mainController?command=project_data&projectid=${project.id}
					&user_id=${user_id}&user=${user}&role=${role}">${project.name}</a><br>
			</c:forEach>
		</c:if>
		<c:if test="${!empty project}">
			<table border="1" >
				<tr><th>Project Name</th><td>${project.name}</td></tr>
		        <tr><th>Project description</th><td>${project.description}</td></tr>	
				<tr><th>Requirements Specification</th>
					<td>${project.requirementSpecification}</td></tr>
				<tr><th>Cost</th><td>${project.cost}</td></tr>
				<tr><th>Start Date</th><td>${project.startDate}</td></tr>
		        <tr><th>Finish Date</th><td>${project.finishDate}</td></tr>	
				<tr><th>Progress</th><td>${project.progress}</td></tr>
				<tr><th>Client Name</th><td>${project.client.users.name}</td></tr>
				<tr><th>Executants</th>
					<td>
					<c:forEach var="executant" items="${project.employees}">
						${executant.users.name} ${executant.users.roles.role}<br>
					</c:forEach>
					</td></tr>
    		</table>
    		
    		<a href="mainController?command=client_employees&clientid=${project.client.id}&clientname=${project.client.users.name}&user_id=${user_id}&user=${user}&role=${role}">See contacts of Client ${project.client.users.name}</a><br>
    		<a href="mainController?command=project_info&projectid=${project.id}&projectname=${project.name}&user_id=${user_id}&user=${user}&role=${role}">See Project ${project.name} info</a><br>
    		<a href="mainController?command=project_form&projectid=${project.id}&user_id=${user_id}&user=${user}&role=${role}">Change Project</a><br>
					
		</c:if>
		<br/>
		<p>${updateProjectDataMessage}</p>
 		<br/>
		<br>
	</c:if>
	<c:if test="${role eq 'project_manager'}">
		<form name="EmployeeList" method="GET" action="mainController">
			<input type="hidden" name="command" value="employee_list" />
			<input type="hidden" name="user_id" value="${user_id}" />
			<input type="hidden" name="user" value="${user}" />
			<input type="hidden" name="role" value="${role}" />
			<input type="submit" value="Employee list"/>
		</form>
		<br>
		<c:if test="${!empty employeeList}">
			<table border="1" >
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
    		<a href="mainController?command=employee_form&id_users=${employee.users.id}&user_id=${user_id}&user=${user}&role=${role}">Change</a>
		</c:if>
		<br/>
		${updateEmployeeDataMessage}
		<br/>
	</c:if>
	<c:if test="${role eq 'HR'}">
		<form name="ProjectProposalList" method="GET" action="mainController">
			<input type="hidden" name="command" value="project_proposal_list" />
			<input type="hidden" name="user_id" value="${user_id}" />
			<input type="hidden" name="user" value="${user}" />
			<input type="hidden" name="role" value="${role}" />
			<input type="submit" value="Project proposal list"/>
		</form>
		<br>
		<c:forEach var="project_proposal" items="${projectProposalList}">
			<a href="mainController?command=project_proposal_view&projectProposalid=${project_proposal.id}&user_id=${user_id}&user=${user}&role=${role}">${project_proposal.name}</a><br>
		</c:forEach>
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
				<tr><td><a href="mainController?command=employee_data&id_users=${employee.users.id}
						&user_id=${user_id}&user=${user}&role=${role}">${employee.users.name}</a></td>
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
    		
		</c:if>

	<br>
		
	</c:if>
	<br>
	<c:if test="${role eq 'client_manager'}">	
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
				<tr><td><a href="mainController?command=client_data&id_users=${client.users.id}&user_id=${user_id}&user=${user}&role=${role}">${client.users.name}</a></td></tr> <br>
			</c:forEach>
			</table>
		</c:if>
		
		<c:if test="${!empty client}">
			<table border="1" >
				<tr><th>Name</th><td>${client.users.name}</td></tr>
		        <tr><th>Payment Credentials</th><td>${client.paymentCredentials}</td></tr>	
				<tr><th>Phone</th><td>${client.phone}</td></tr>
				<tr><th>e-Mail</th><td>${client.email}</td></tr>
				<tr><th>Address</th><td>${client.address}</td></tr>
				<tr><th>Discount</th><td>${client.discount}</td></tr>
    		</table>
    		<a href="mainController?command=client_form&id_users=${client.users.id}&user_id=${user_id}&user=${user}&role=${role}">Change</a>
			<br/>
			<p>${updateClientDataMessage}</p>
 			<br/>
		</c:if>
	</c:if>	
	
-->	
	
</body>
</html>