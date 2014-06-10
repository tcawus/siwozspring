package org.siwoz.dao.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Visit")
public class Visit {

	@Id
	@GeneratedValue
	private long id;

	@Column
	Date visitDate;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Patient2Company.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "idPatient2Company", updatable = true, insertable = true)
	private Patient2Company idPatient2Company;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = VisitDescription.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "idDescription", updatable = true, insertable = true)
	private VisitDescription idDescription;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "idEmployee", updatable = true, insertable = true)
	private Employee idEmployee;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Patient2Company getIdPatient2Company() {
		return idPatient2Company;
	}

	public void setIdPatient2Company(Patient2Company idPatient2Company) {
		this.idPatient2Company = idPatient2Company;
	}

	public Employee getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Employee idEmployee) {
		this.idEmployee = idEmployee;
	}

	public VisitDescription getIdDescription() {
		return idDescription;
	}

	public void setIdDescription(VisitDescription idDescription) {
		this.idDescription = idDescription;
	}

}
