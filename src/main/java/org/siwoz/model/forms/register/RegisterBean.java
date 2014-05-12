package org.siwoz.model.forms.register;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.ScriptAssert;

@ScriptAssert(lang = "javascript", script = "_this.passVerify.equals(_this.pass)")
public class RegisterBean {

	@NotBlank
	@Length(min = 2, max = 20)
	private String name, surname;

	@NotBlank
	@Length(max = 40)
	@Email
	private String email;

	@NotBlank
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{7,15})")
	private String pass, passVerify;

	private String userType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPassVerify() {
		return passVerify;
	}

	public void setPassVerify(String passVerify) {
		this.passVerify = passVerify;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void clearPasswords() {
		pass = "";
		passVerify = "";
	}
}
