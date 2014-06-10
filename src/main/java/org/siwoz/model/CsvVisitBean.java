package org.siwoz.model;

public class CsvVisitBean {
	String visitDate;
	String name, email;

	public CsvVisitBean(String visitDate, String name, String email) {
		super();
		this.visitDate = visitDate;
		this.name = name;
		this.email = email;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
