package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.ProjectProposal;

public class ProjectProposalListDAO {
	Connection connection;
	Statement stmt;
	
	public ProjectProposalListDAO() {}
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public List<ProjectProposal> viewProjectProposalList() {
		String projectProposalListQuery = "select project_proposal.id, project_proposal.name from project_proposal";
		List<ProjectProposal> projectProposalList = new ArrayList<ProjectProposal>();
		ProjectProposal prj = null;
		try{
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(projectProposalListQuery);
			while (rs.next()) {
				prj = new ProjectProposal();
				prj.setId(rs.getInt("project_proposal.id"));
				prj.setName(rs.getString("project_proposal.name"));
				projectProposalList.add(prj);
				
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
		return projectProposalList;
	}

}
