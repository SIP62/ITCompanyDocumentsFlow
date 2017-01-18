package by.bsuir.spp.entities;

import java.util.Date;


public class Info {
	private int id;
	private Date date;
	private String name;
	private String description;
	private Project project;
	private Employee employee;
	
	public Info() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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

	public Project getProject() {
		if (project == null) project = new Project();
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Employee getEmployee() {
		if (employee == null) employee = new Employee();
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
