package by.bsuir.spp.entities;

import java.util.Date;
import java.util.List;


public class Employee {
	private int id;
	private String address;
	private String phone;
	private String passport;
	private String creditCard;
	private String resume;
	private float salary;
	private Date recruitmentDate;
	private Date contractExpirationDate;
	private List<Project> currentProjects;
	private List<Project> projects;
	private String specialization;
	private Users users;
	private Roles roles;
	
	public Employee() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Date getRecruitmentDate() {
		return recruitmentDate;
	}
	public void setRecruitmentDate(Date recruitmentDate) {
		this.recruitmentDate = recruitmentDate;
	}
	public Date getContractExpirationDate() {
		return contractExpirationDate;
	}
	public void setContractExpirationDate(Date contractExpirationDate) {
		this.contractExpirationDate = contractExpirationDate;
	}
	public List<Project> getCurrentProjects() {
		return currentProjects;
	}
	public void setCurrentProjects(List<Project> currentProjects) {
		this.currentProjects = currentProjects;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Roles getRoles() {
		if (roles == null) roles = new Roles();
		return roles;
	}
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	public Users getUsers() {
		if (users == null) users = new Users();
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	
	
}
