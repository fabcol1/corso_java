package org.proxima.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userlogintoken database table.
 * 
 */
@Entity
@Table(name="userlogintoken")
@NamedQuery(name="Userlogintoken.findAll", query="SELECT u FROM Userlogintoken u")
public class Userlogintoken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String email;

	@Column(name="expiration_date")
	private String expirationDate;

	@Column(name="generated_token")
	private String generatedToken;

	public Userlogintoken() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getGeneratedToken() {
		return this.generatedToken;
	}

	public void setGeneratedToken(String generatedToken) {
		this.generatedToken = generatedToken;
	}

}