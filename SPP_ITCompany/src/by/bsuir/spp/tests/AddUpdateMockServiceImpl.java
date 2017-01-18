package by.bsuir.spp.tests;

import by.bsuir.spp.entities.Client;
import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.entities.Info;
import by.bsuir.spp.entities.Project;
import by.bsuir.spp.entities.ProjectProposal;
import by.bsuir.spp.entities.Recruit;
import by.bsuir.spp.entities.Users;

public class AddUpdateMockServiceImpl {
	private IAddUpdateMockService iAddUpdateMockService;
	public void setIRequestService(IAddUpdateMockService iAddUpdateMockService){
		this.iAddUpdateMockService = iAddUpdateMockService;
	}
	public boolean addClientInDB(Client client) {
		return iAddUpdateMockService.addClientInDB(client);
	}
	public boolean addEmployeeInDB(Employee employee) {
		return iAddUpdateMockService.addEmployeeInDB(employee);
	}
	public boolean insertExecutantInProject(String projectId, String employeeId) {
		return iAddUpdateMockService.insertExecutantInProject(projectId, employeeId);
	}
	public boolean insertProjectInfo(Info info) {
		return iAddUpdateMockService.insertProjectInfo(info);
	}
	public boolean addProjectProposalToDB(ProjectProposal projectProposal) {
		return iAddUpdateMockService.addProjectProposalToDB(projectProposal);
	}
	public boolean addRecruitToDB(Recruit recruit) {
		return iAddUpdateMockService.addRecruitToDB(recruit);
	}
	public boolean addUserToDB(Users user) {
		return iAddUpdateMockService.addUserToDB(user);
	}
	public boolean updateClientInDB(Client client) {
		return iAddUpdateMockService.updateClientInDB(client);
	}
	public boolean updateEmployeeInDB(Employee employee) {
		return iAddUpdateMockService.updateEmployeeInDB(employee);
	}
	public boolean updateProjectInDB(Project project) {
		return iAddUpdateMockService.updateProjectInDB(project);
	}
}
