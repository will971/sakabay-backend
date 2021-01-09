package com.mowil.ats.model.beans;

import java.io.Serializable;
import java.util.Date;

public class CompteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4304293903738538413L;
	private Long id;
	private String mail;
	private String username;
	private String password;
	private Date dateOfBirth;
	private boolean status;

	public CompteBean(String mail, String username, String password, Date dateOfBirth) {
		super();
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
	}

	public CompteBean(Long id, String mail, String username, String password, Date dateOfBirth, boolean status) {
		super();
		this.id = id;
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.status = status;
	}

	public CompteBean(String mail, String username, String password, Date dateOfBirth, boolean status) {
		super();
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
