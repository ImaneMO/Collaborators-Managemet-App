package io.novelis.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="collaborators")
public class Collaborator implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	
	@Column(name="last_name") 
	private String lastName;
	
	
	@Column(name="email")
	private String email;
	
	@NotNull()
	@Pattern(
		    regexp = "(\\+212|0)([ \\-_/]*)(\\d[ \\-_/]*){9}", 
		    message = "Enter a valid phone number."
		    ) 
	@Column(name="phone_number")
	private String phoneNumber;
	
	 
	@Column(name="birth_date")
	private Date dateOfBirth;
	
	
	@Column(name="civility")
	private String civility;
	
	
	public Collaborator() {
		
	}

	

	public Collaborator(String firstName, String lastName, String email, String phoneNumber, Date dateOfBirth,
			String civility) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.civility = civility;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getphoneNumber() {
		return phoneNumber;
	}



	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public Date getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getCivility() {
		return civility;
	}



	public void setCivility(String civility) {
		this.civility = civility;
	}
	


	
	 

}
