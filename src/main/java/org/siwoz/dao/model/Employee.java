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

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = EmployeeStatus.class)
	@JoinColumn(name = "idEmployeeStatus", updatable = true, insertable = true)
	private EmployeeStatus idEmployeeStatus;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Users.class)
	@JoinColumn(name = "idUser", updatable = true, insertable = true)
	private Users idUser;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Company.class)
	@JoinColumn(name = "idCompany", updatable = true, insertable = true)
	private Company idCompany;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EmployeeStatus getIdEmployeeStatus() {
		return idEmployeeStatus;
	}

	public Users getIdUser() {
		return idUser;
	}

	public void setIdUser(Users idUser) {
		this.idUser = idUser;
	}

	public void setIdEmployeeStatus(EmployeeStatus idEmployeeStatus) {
		this.idEmployeeStatus = idEmployeeStatus;
	}


	public Company getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Company idCompany) {
		this.idCompany = idCompany;
	}

}
