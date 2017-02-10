package com.prueba.beans;

import java.sql.Date;

public class Document {
	private String id;
	private String type;
	private User user;
    private Date enter_date;
    private Date exit_date;
    private String status;
    private String commentary;
    
    
	public Document(String id, String type, Date enter_date, Date exit_date,
			String status, String commentary, User user) {
		this.id = id;
		this.type = type;
		this.enter_date = enter_date;
		this.exit_date = exit_date;
		this.status = status;
		this.commentary = commentary;
		this.user = user;
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getEnter_date() {
		return enter_date;
	}
	public void setEnter_date(Date enter_date) {
		this.enter_date = enter_date;
	}
	public Date getExit_date() {
		return exit_date;
	}
	public void setExit_date(Date exit_date) {
		this.exit_date = exit_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCommentary() {
		return commentary;
	}
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
