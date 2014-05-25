package org.siwoz.model.forms.employee;

import java.util.Date;

public class PatientVisitDataBean {

	String fullName, description;
	Date visitDate;

	public PatientVisitDataBean(String fullName, String description,
			Date visitDate) {
		this.fullName = fullName;
		this.description = description;
		this.visitDate = visitDate;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	@Override
	public String toString() {
		return "PatientVisitDataBean [fullName=" + fullName + ", description="
				+ description + ", visitDate=" + visitDate + "]";
	}
}
