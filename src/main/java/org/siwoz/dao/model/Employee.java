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

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class)
	@JoinColumn(name = "idUser", updatable = true, insertable = true)
	private Users idUser;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Company.class)
	@JoinColumn(name = "idCompany", updatable = true, insertable = true)
	private Users idCompany;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getIdEmployeeStatus() {
		return idEmployeeStatus;
	}

	public Users getIdUser() {
		return idUser;
	}

	public void setIdUser(Users idUser) {
		this.idUser = idUser;
	}

	public void setIdEmployeeStatus(Address idEmployeeStatus) {
		this.idEmployeeStatus = idEmployeeStatus;
	}


	public Users getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Users idCompany) {
		this.idCompany = idCompany;
	}

}
