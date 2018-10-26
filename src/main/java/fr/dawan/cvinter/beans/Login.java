package fr.dawan.cvinter.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login implements Serializable {

	@Id
	private long id;
	
	private String email;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
