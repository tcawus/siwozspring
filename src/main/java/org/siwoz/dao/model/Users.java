package org.siwoz.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users implements Serializable {
	private static final long serialVersionUID = 4424034325142121584L;

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String name;

	@Column
	private String surname;

	@Column
	private String username;

	@Column
	private String password;

	@Column
	private String pesel;

	@Column
	private Date registerDate;

	@Column
	private boolean enabled;

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date date) {
		this.registerDate = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
