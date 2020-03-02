package io.novelis.demo.dto;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.novelis.demo.entity.Collaborator;


public class CollaboratorDTO {
	
	//@JsonProperty(value="Id")
	private int id;
	
	@NotNull(message = "Name cannot be null.")
	@Pattern(
		    regexp = "/^[a-z ,.'-]+$/i", 
		    message = "Enter a valid name."
		    ) 
	private String firstName;
	
	@NotNull(message = "Name cannot be null.")
	@Pattern(
		    regexp = "/^[a-z ,.'-]+$/i", 
		    message = "Enter a valid name."
		    ) 
	private String lastName;
	
	@Email(message="Enter a valid email.")
    @NotBlank
	private String email;
	
	@NotNull()
	@Past(message = "Date input is invalid for a birth date.")
	private Date dateOfBirth;
	
	@NotNull()
	@Size(min = 1, max = 10, message = "Civility is either M. or MM. .")
	private String civility;
	
	public CollaboratorDTO() {
		
	}
	
	
	
	public CollaboratorDTO(String firstName, String lastName, String email, Date dateOfBirth, String civility) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

	public static CollaboratorDTO build(Collaborator collaborator) {
        return new CollaboratorDTO(collaborator.getFirstName(), collaborator.getLastName(),
        		collaborator.getEmail(), collaborator.getDateOfBirth(), collaborator.getCivility());
    }

}






