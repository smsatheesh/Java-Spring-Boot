package net.java.sms.entity;

import jakarta.persistence.*;

@Entity
@Table(name="teachers")
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@Column(name="email")
	private String email;
	
	@Column(name="department", nullable=false)
	private String department;

	public Teacher() {
		super();
	}
	
	public Teacher(long id, String firstName, String lastName, String email, String department) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getDepartment() {
		return department;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
