package org.siwoz.dao.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Patient2Company")
public class Patient2Company {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Patient.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "idPatient", updatable = true, insertable = true)
	private Patient idPatient;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Company.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "idCompany", updatable = true, insertable = true)
	private Company idCompany;

	public Long getId() {
		return id;
	}

	public Patient getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Patient idPatient) {
		this.idPatient = idPatient;
	}

	public Company getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Company idCompany) {
		this.idCompany = idCompany;
	}

	public void setId(long id) {
		this.id = id;
	}

}
