package by.bsuir.spp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.bsuir.spp.entities.ProjectProposal;

public class ProjectProposalRecorder {

	public void insertProjectProposal(PreparedStatement ps,
			ProjectProposal projectProposal) {
		try {
			ps.setString(1, projectProposal.getName());
			ps.setString(2, projectProposal.getContactName());
			ps.setString(3, projectProposal.getPhone());
			ps.setString(4, projectProposal.getEmail());
			ps.setString(5, projectProposal.getStatus());
			ps.setString(6, projectProposal.getDescription());
			ps.setString(7, projectProposal.getRequirementSpecification());
			ps.setString(8, projectProposal.getTerm());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Record to db is failed");
			e.printStackTrace();
		}
	}

}
