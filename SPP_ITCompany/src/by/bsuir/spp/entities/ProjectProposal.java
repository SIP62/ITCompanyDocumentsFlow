package by.bsuir.spp.entities;

public class ProjectProposal {
	
	private int id;
	private String name;
	private String contactName;
	private String phone;
	private String email;
	private String status;
	private String description;
	private String requirementSpecification;
	private String term;
	
	public ProjectProposal() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequirementSpecification() {
		return requirementSpecification;
	}

	public void setRequirementSpecification(String requirementSpecification) {
		this.requirementSpecification = requirementSpecification;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
	
	
	
}
