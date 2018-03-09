package org.proxima.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import java.util.Date;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date dateofbirth;

	@Email(message = "error.email.email")
	@NotNull(message = "error.email.null")
	@NotEmpty(message = "error.email.empty")
	@Length(max = 50, message = "error.email.length")
	private String email;

	@NotNull(message = "error.firstname.null")
	@NotEmpty(message = "error.firstname.empty")
	@Length(max = 50, message = "error.firstname.length")
	private String firstname;

	private String imgpath;

	@NotNull(message = "error.lastname.null")
	@NotEmpty(message = "error.lastname.empty")
	@Length(max = 50, message = "error.lastname.length")
	private String lastname;

	@NotNull(message = "error.password.null")
	@NotEmpty(message = "error.password.empty")
	@Length(max = 11, message = "error.password.length")
	private String password;

	@Temporal(TemporalType.DATE)
	private Date regdate;

	private int role;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getImgpath() {
		return this.imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getRole() {
		return this.role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}