package io.novelis.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;


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
	private String first_name;
	
	
	@Column(name="last_name") 
	private String last_name;
	
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_number")
	private String phone_number;

	@Column(name="birth_date")
	private Date birth_date;
	
	
	@Column(name="civility")
	private String civility;
	
	
	public Collaborator() {
		
	}

	

	public Collaborator(String first_name, String lastName, String civility, Date dateOfBirth, String email, String phoneNumber) {
		this.first_name = first_name;
		this.last_name = lastName;
		this.civility = civility;
		this.birth_date = dateOfBirth;
		this.email = email;
		this.phone_number = phoneNumber;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return first_name;
	}



	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}


	public String getLastName() {
		return last_name;
	}



	public void setLastName(String lastName) {
		this.last_name = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getphone_number() {
		return phone_number;
	}



	public void setphone_number(String phoneNumber) {
		this.phone_number = phoneNumber;
	}



	public Date getDateOfBirth() {
		return birth_date;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.birth_date = dateOfBirth;
	}



	public String getCivility() {
		return civility;
	}



	public void setCivility(String civility) {
		this.civility = civility;
	}
	


	
	 

}
