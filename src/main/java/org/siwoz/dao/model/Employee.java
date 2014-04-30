package org.siwoz.dao.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = EmployeeStatus.class)
	@JoinColumn(name = "idEmployeeStatus", updatable = true, insertable = true)
	private Address idEmployeeStatus;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Person.class)
	@JoinColumn(name = "idPerson", updatable = true, insertable = true)
	private Person idPerson;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Company.class)
	@JoinColumn(name = "idCompany", updatable = true, insertable = true)
	private Person idCompany;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getIdEmployeeStatus() {
		return idEmployeeStatus;
	}

	public void setIdEmployeeStatus(Address idEmployeeStatus) {
		this.idEmployeeStatus = idEmployeeStatus;
	}

	public Person getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Person idPerson) {
		this.idPerson = idPerson;
	}

	public Person getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Person idCompany) {
		this.idCompany = idCompany;
	}

}
