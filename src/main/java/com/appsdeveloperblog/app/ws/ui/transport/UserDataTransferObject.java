package com.appsdeveloperblog.app.ws.ui.transport;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDataTransferObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9098042807676070136L;
	//private static final long serialVersionUID = 4865903039190150223L;
	private long id;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String encryptedPassword;
	private String emailVerificationToken;
	private Boolean emailVerificationStatus=false;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



}
