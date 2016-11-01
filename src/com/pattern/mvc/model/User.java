package com.pattern.mvc.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private Long idUser;
	private String nameUser;
	public User(Long idUser, String nameUser) {
		super();
		this.idUser = idUser;
		this.nameUser = nameUser;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	
	

}
