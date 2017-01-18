package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.ProjectProposal;

public class ProjectProposalDataDAO {
	
	Connection connection;
	Statement stmt;
	
	public ProjectProposalDataDAO() {}
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public ProjectProposal viewProjectProposalData(String projectProposalId) {
		String projectProposalDataQuery = "select * from project_proposal where id like '" + projectProposalId + "'";
		ProjectProposal projectProposal = null;
		
		try{
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(projectProposalDataQuery);
			while (rs.next()) {
				projectProposal = new ProjectProposal();
				projectProposal.setId(rs.getInt("id"));
				projectProposal.setName(rs.getString("name"));
				projectProposal.setContactName(rs.getString("contact_name"));
				projectProposal.setPhone(rs.getString("phone"));
				projectProposal.setEmail(rs.getString("email"));
				projectProposal.setStatus(rs.getString("status"));
				projectProposal.setDescription(rs.getString("description"));
				projectProposal.setRequirementSpecification(rs.getString("requirement_specification"));
				projectProposal.setTerm(rs.getString("term"));
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
		return projectProposal;
	}

}
