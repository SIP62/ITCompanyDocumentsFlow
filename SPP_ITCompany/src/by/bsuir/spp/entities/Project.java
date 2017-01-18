package by.bsuir.spp.entities;

import java.util.Date;
import java.util.List;


public class Project {
	private int id;
	private float cost;
	private String requirementSpecification;
	private Date startDate;
	private Date finishDate;
	private float progress;
	private String name;
	private String description;
	private Client client;
	private List<Employee> employees;
	private List<Info> info;
	private List<String> keywords;
	
	public Project() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getRequirementSpecification() {
		return requirementSpecification;
	}
	public void setRequirementSpecification(String requirementSpecification) {
		this.requirementSpecification = requirementSpecification;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public float getProgress() {
		return progress;
	}
	public void setProgress(float progress) {
		this.progress = progress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Client getClient() {
		if (client == null) client = new Client();
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public List<Info> getInfo() {
		return info;
	}
	public void setInfo(List<Info> info) {
		this.info = info;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	
}
