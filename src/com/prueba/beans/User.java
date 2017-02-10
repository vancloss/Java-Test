package com.prueba.beans;

import java.sql.Date;

public class User {

	private String id;
	private String firstname;
    private String password;
    private String mail;
    private String codeidentification;
    private String status;
    private Date expiration_date;
    
    
    public User() {
    }
 
    public User(String id) {
        this.id = id;
    }
 
    public User(String id, String firstname, String password, String status) {
        this.firstname = firstname;
        this.password = password;
        this.status = status;
        this.id = id;
    }
    
    public User(String id, String firstname, String password, String mail, String codeidentifcation, String status, Date expiration_date ) {
        this.firstname = firstname;
        this.password = password;
        this.mail = mail;
        this.codeidentification = codeidentification;
        this.status = status;
        this.expiration_date = expiration_date;
        this.id = id;
    }
    
    
	public User(String firstname, String password, String mail,
			String codeidentification, String status,
			Date expiration_date) {
        this.firstname = firstname;
        this.password = password;
        this.mail = mail;
        this.codeidentification = codeidentification;
        this.status = status;
        this.expiration_date = expiration_date;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCodeidentification() {
		return codeidentification;
	}
	public void setCodeidentification(String codeidentification) {
		this.codeidentification = codeidentification;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	
	
	
}
