package by.bsuir.spp.command.client;

import by.bsuir.spp.command.ActionCommand;
import by.bsuir.spp.command.AddClientCommand;
import by.bsuir.spp.command.AddClientEmployeeCommand;
import by.bsuir.spp.command.AddClientFormCommand;
import by.bsuir.spp.command.AddEmployeeCommand;
import by.bsuir.spp.command.AddEmployeeFormCommand;
import by.bsuir.spp.command.AddExecutantCommand;
import by.bsuir.spp.command.AddProjectInfoCommand;
import by.bsuir.spp.command.AddProjectProposalCommand;
import by.bsuir.spp.command.AddRecruitCommand;
import by.bsuir.spp.command.ChangeExecutantsFormCommand;
import by.bsuir.spp.command.ClientDataCommand;
import by.bsuir.spp.command.ClientEmployeeFormCommand;
import by.bsuir.spp.command.ClientEmployeesCommand;
import by.bsuir.spp.command.ClientFormCommand;
import by.bsuir.spp.command.ClientListCommand;
import by.bsuir.spp.command.DeleteExecutantCommand;
import by.bsuir.spp.command.DeleteUserCommand;
import by.bsuir.spp.command.EmployeeDataCommand;
import by.bsuir.spp.command.EmployeeFormCommand;
import by.bsuir.spp.command.EmployeeListCommand;
import by.bsuir.spp.command.LoginCommand;
import by.bsuir.spp.command.LogoutCommand;
import by.bsuir.spp.command.ProjectDataCommand;
import by.bsuir.spp.command.ProjectFormCommand;
import by.bsuir.spp.command.ProjectInfoCommand;
import by.bsuir.spp.command.ProjectInfoFormCommand;
import by.bsuir.spp.command.ProjectProposalFormCommand;
import by.bsuir.spp.command.ProjectProposalListCommand;
import by.bsuir.spp.command.ProjectProposalViewCommand;
import by.bsuir.spp.command.ProjectsListCommand;
import by.bsuir.spp.command.RecruitFormCommand;
import by.bsuir.spp.command.RegistrateCommand;
import by.bsuir.spp.command.RegistrationFormCommand;
import by.bsuir.spp.command.ReturnToPageCommand;
import by.bsuir.spp.command.UpdateClientDataCommand;
import by.bsuir.spp.command.UpdateEmployeeDataCommand;
import by.bsuir.spp.command.UpdateProjectCommand;
import by.bsuir.spp.command.UsersListCommand;



public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	},
	RECRUIT_FORM {
		{
			this.command = new RecruitFormCommand();
		}
	},
	ADD_RECRUIT {
		{
			this.command = new AddRecruitCommand();
		}
	},
	PROJECT_PROPOSAL_FORM {
		{
			this.command = new ProjectProposalFormCommand();
		}
	},
	PROJECT_PROPOSAL_LIST {
		{
			this.command = new ProjectProposalListCommand();
		}
	},
	PROJECT_PROPOSAL_VIEW {
		{
			this.command = new ProjectProposalViewCommand();
		}
	},
	ADD_PROJECT_PROPOSAL {
		{
			this.command = new AddProjectProposalCommand();
		}
	},
	REGISTRATION_FORM {
		{
			this.command = new RegistrationFormCommand();
		}
	},
	REGISTRATE {
		{
			this.command = new RegistrateCommand();
		}
	},
	CLIENT_LIST {
		{
			this.command = new ClientListCommand();
		}
	},
	CLIENT_DATA {
		{
			this.command = new ClientDataCommand();
		}
	},
	CLIENT_FORM {
		{
			this.command = new ClientFormCommand();
		}
	},
	ADD_CLIENT_FORM {
		{
			this.command = new AddClientFormCommand();
		}
	},
	ADD_CLIENT {
		{
			this.command = new AddClientCommand();
		}
	},
	UPDATE_CLIENT_DATA {
		{
			this.command = new UpdateClientDataCommand();
		}
	},
	PROJECTS_LIST {
		{
			this.command = new ProjectsListCommand();
		}
	},
	PROJECT_DATA {
		{
			this.command = new ProjectDataCommand();
		}
	},
	PROJECT_FORM {
		{
			this.command = new ProjectFormCommand();
		}
	},
	UPDATE_PROJECT {
		{
			this.command = new UpdateProjectCommand();
		}
	},
	EMPLOYEE_DATA {
		{
			this.command = new EmployeeDataCommand();
		}
	},
	EMPLOYEE_FORM {
		{
			this.command = new EmployeeFormCommand();
		}
	},
	ADD_EMPLOYEE_FORM {
		{
			this.command = new AddEmployeeFormCommand();
		}
	},
	ADD_EMPLOYEE {
		{
			this.command = new AddEmployeeCommand();
		}
	},
	EMPLOYEE_LIST {
		{
			this.command = new EmployeeListCommand();
		}
	},
	UPDATE_EMPLOYEE_DATA {
		{
			this.command = new UpdateEmployeeDataCommand();
		}
	},
	CHANGE_EXECUTANTS_FORM {
		{
			this.command = new ChangeExecutantsFormCommand();
		}
	},
	DELETE_EXECUTANT {
		{
			this.command = new DeleteExecutantCommand();
		}
	},
	ADD_EXECUTANT {
		{
			this.command = new AddExecutantCommand();
		}
	},
	PROJECT_INFO {
		{
			this.command = new ProjectInfoCommand();
		}
	},
	PROJECT_INFO_FORM {
		{
			this.command = new ProjectInfoFormCommand();
		}
	},
	ADD_PROJECT_INFO {
		{
			this.command = new AddProjectInfoCommand();
		}
	},
	CLIENT_EMPLOYEES {
		{
			this.command = new ClientEmployeesCommand();
		}
	},
	CLIENT_EMPLOYEE_FORM {
		{
			this.command = new ClientEmployeeFormCommand();
		}
	},
	ADD_CLIENT_EMPLOYEE {
		{
			this.command = new AddClientEmployeeCommand();
		}
	},
	USERS_LIST {
		{
			this.command = new UsersListCommand();
		}
	},
	DELETE_USER {
		{
			this.command = new DeleteUserCommand();
		}
	},
	RETURN_TO_PAGE {
		{
			this.command = new ReturnToPageCommand();
		}
	};
	
	ActionCommand command;
	public ActionCommand getCurrentCommand() {
		return command;
	}	

}
