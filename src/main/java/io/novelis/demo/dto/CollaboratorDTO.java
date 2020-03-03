package io.novelis.demo.dto;

import java.sql.Date;

import javax.persistence.Column;
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
	private String first_name;

	@NotNull(message = "Name cannot be null.")
	@Pattern(
		    regexp = "/^[a-z ,.'-]+$/i", 
		    message = "Enter a valid name."
		    ) 
	private String last_name;
	
	@NotNull()
	@Pattern(
		    regexp = "(^0[0-9]{8}$|^00[0-9]{11,13}$)", 
		    message = "Enter a valid phone number."
		    ) 
	@Column(name="phone_number")
	private String phone_number;
	
	@Email(message="Enter a valid email.")
    @NotBlank
	private String email;
	
	@NotNull()
	@Past(message = "Date input is invalid for a birth date.")
	private Date birth_date;
	
	@NotNull()
	@Size(min = 1, max = 10, message = "Civility is either M. or MM. .")
	private String civility;
	
	public CollaboratorDTO() {
		
	}
	
	
	
	public CollaboratorDTO(int id,String first_name, String lastName, String civility, Date dateOfBirth, String email, String phone_number) {
		this.id=id;
		this.first_name = first_name;
		this.last_name = lastName;
		this.email = email;
		this.birth_date = dateOfBirth;
		this.civility = civility;
		this.phone_number = phone_number;
		
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
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

	public static CollaboratorDTO build(Collaborator collaborator) {
        return new CollaboratorDTO(collaborator.getId(), collaborator.getFirstName(), collaborator.getLastName(), collaborator.getCivility(), collaborator.getDateOfBirth(),
        		collaborator.getEmail(), collaborator.getphone_number());
    }

}






