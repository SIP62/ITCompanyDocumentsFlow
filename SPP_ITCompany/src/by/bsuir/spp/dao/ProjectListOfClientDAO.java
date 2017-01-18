package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.Client;
import by.bsuir.spp.entities.Project;

public class ProjectListOfClientDAO {
	Connection connection;
	Statement stmt;
	
	public ProjectListOfClientDAO() {}
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public List<Project> viewProjectsList(String idUsers) {
		String projectsListQuery = "select project.id, project.name, users.id, users.name "
				+ "from (users inner join client "
				+ "on users.id = client.id_users) "
				+ "inner join project "
				+ "on client.id = project.id_client "
				+ "where users.id like '" + idUsers + "'";
		List<Project> projectsList = new ArrayList<Project>();
		Project prj = null;
		Client client = null;
		
		try{
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(projectsListQuery);
			while (rs.next()) {
				prj = new Project();
				client = new Client();
				prj.setId(rs.getInt("project.id"));
				prj.setName(rs.getString("project.name"));
				client.getUsers().setId(rs.getInt("users.id"));
				client.getUsers().setName(rs.getString("users.name"));
				prj.setClient(client);
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
