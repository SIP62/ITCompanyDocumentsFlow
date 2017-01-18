package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.entities.Info;
import by.bsuir.spp.entities.Project;

public class ProjectInfoDAO {
	Connection connection;
	Statement stmt;
	
	Employee employee = null;
	Project project = null;
	List<Info> infoList = new ArrayList<Info>();
	
	public ProjectInfoDAO() {}
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public List<Info> viewProjectInfo(String projectId) {
		String projectInfoQuery = "select info.*, users.name, project.name "
				+ "from ((project inner join info "
				+ "on project.id = info.id_project) "
				+ "inner join employee on employee.id = info.author_id) "
				+ "inner join users on users.id = employee.id_users "
				+ "where project.id like '" + projectId + "'";
		Info info = null;
		
		
		try{
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(projectInfoQuery);
			while (rs.next()) {
				info = new Info();
				info.setId(rs.getInt("info.id"));
				info.setName(rs.getString("info.name"));
				info.setDate(rs.getDate("info.date"));
				info.setDescription(rs.getString("info.description"));
				info.getEmployee().setId(rs.getInt("info.author_id"));
				info.getEmployee().getUsers().setName(rs.getString("users.name"));
				info.getProject().setId(rs.getInt("info.id_project"));
				info.getProject().setName(rs.getString("project.name"));
				
				infoList.add(info);
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
		return infoList;
	}

}
