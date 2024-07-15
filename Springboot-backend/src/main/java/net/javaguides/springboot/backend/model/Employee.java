package net.javaguides.springboot.backend.model;

import jakarta.persistence.*;

@Entity
@Table( name="employees" )
public class Employee {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private long id;
	
	@Column( name="first_name", nullable=true )
	private String firstName;
	
	@Column( name="last_name", nullable=true )
	private String lastName;
	
	@Column( name="email", nullable=true )
	private String email;
	
	public Employee() {
		super();
	}
	
	public Employee(long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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
	
}
