package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.Client;
import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.entities.Project;

public class ProjectDataDAO {
	Connection connection;
	Statement stmt;
	
	Employee employee = null;
	Client client = null;
	List<Employee> employeeList = new ArrayList<Employee>();
	
	public ProjectDataDAO() {}
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public Project viewProjectData(String projectId) {
		String projectDataQuery = "select project.*, client.id, users.name "
				+ "from (project inner join client "
				+ "on client.id = project.id_client) "
				+ "inner join users "
				+ "on users.id = client.id_users "
				+ "where project.id like '" + projectId + "'";
		
		String employeeInProjectQuery = "select employee.id, users.name, roles.role "
				+ "from (((roles inner join users "
				+ "on roles.id = users.id_roles) "
				+ "inner join employee "
				+ "on users.id = employee.id_users) "
				+ "inner join project_employee "
				+ "on employee.id = project_employee.id_employee) "
				+ "inner join project "
				+ "on project.id = project_employee.id_project "
				+ "where project.id like '" + projectId + "'";
		Project project = null;
		
		
		try{
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(projectDataQuery);
			while (rs.next()) {
				project = new Project();
				project.setId(rs.getInt("id"));
				project.setName(rs.getString("name"));
				project.setDescription(rs.getString("description"));
				project.setRequirementSpecification(rs.getString("requirements_specification"));
				project.setCost(rs.getFloat("cost"));
				project.setStartDate(rs.getDate("start_date"));
				project.setFinishDate(rs.getDate("finish_date"));
				project.setProgress(rs.getFloat("progress"));
				project.getClient().setId(rs.getInt("client.id"));
				project.getClient().getUsers().setName(rs.getString("users.name"));
			}
			rs = stmt.executeQuery(employeeInProjectQuery);
			while (rs.next()) {
				employee = new Employee();
				employee.setId(rs.getInt("employee.id"));
				employee.getUsers().setName(rs.getString("users.name"));
				employee.getUsers().getRoles().setRole(rs.getString("roles.role"));
				employeeList.add(employee);
			}
			project.setEmployees(employeeList);
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally
		{
			try {
				if(stmt != null)
					stmt.close();
				if(connection != null)
					connection.close();
				} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return project;
	}

}
