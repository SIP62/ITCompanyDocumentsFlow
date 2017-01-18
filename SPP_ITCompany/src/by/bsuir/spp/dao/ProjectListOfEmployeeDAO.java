package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.Project;

public class ProjectListOfEmployeeDAO {
	Connection connection;
	Statement stmt;
	
	public ProjectListOfEmployeeDAO() {}
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public List<Project> viewProjectsList(String userId) {
		String projectsListQuery = "select project.id, project.name "
				+ "from ((users inner join employee "
				+ "on users.id = employee.id_users) "
				+ "inner join project_employee "
				+ "on employee.id = project_employee.id_employee) "
				+ "inner join project on project.id = project_employee.id_project "
				+ "where users.id like '" + userId + "'";
		List<Project> projectsList = new ArrayList<Project>();
		Project prj = null;
		try{
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(projectsListQuery);
			while (rs.next()) {
				prj = new Project();
				prj.setId(rs.getInt("project.id"));
				prj.setName(rs.getString("project.name"));
				projectsList.add(prj);
				
			}
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
		return projectsList;
	}

}
