package by.bsuir.spp.dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.bsuir.spp.entities.Project;

public class ProjectUpdater {

	public void updateProject(PreparedStatement ps, Project project) {
		try {
			ps.setString(1, project.getName());
			ps.setString(2, project.getDescription());
			ps.setString(3, project.getRequirementSpecification());
			ps.setFloat(4, project.getCost());
			java.util.Date utilStartDate = project.getStartDate();
			java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
			ps.setDate(5, sqlStartDate);
			java.util.Date utilFinishDate = project.getFinishDate();
			java.sql.Date sqlFinishDate = new java.sql.Date(utilFinishDate.getTime());
			ps.setDate(6, sqlFinishDate);
			ps.setFloat(7, project.getProgress());
			ps.setInt(8, project.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Record to db is failed");
			e.printStackTrace();
		}
	}

}
