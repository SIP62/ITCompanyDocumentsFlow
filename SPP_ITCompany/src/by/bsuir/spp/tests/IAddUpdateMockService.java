package by.bsuir.spp.tests;

import by.bsuir.spp.entities.Client;
import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.entities.Info;
import by.bsuir.spp.entities.Project;
import by.bsuir.spp.entities.ProjectProposal;
import by.bsuir.spp.entities.Recruit;
import by.bsuir.spp.entities.Users;

public interface IAddUpdateMockService {
	public boolean addClientInDB(Client client);
	public boolean addEmployeeInDB(Employee employee);
	public boolean insertExecutantInProject(String projectId, String employeeId);
	public boolean insertProjectInfo(Info info);
	public boolean addProjectProposalToDB(ProjectProposal projectProposal);
	public boolean addRecruitToDB(Recruit recruit);
	public boolean addUserToDB(Users user);
	public boolean updateClientInDB(Client client);
	public boolean updateEmployeeInDB(Employee employee);
	public boolean updateProjectInDB(Project project);
}
