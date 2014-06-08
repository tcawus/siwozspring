package org.siwoz.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_roles")
public class User_roles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long user_role_id;

	@Column
	private String username;

	@Column
	private String role;

	public long getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(long user_role_id) {
		this.user_role_id = user_role_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
