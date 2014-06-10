package org.siwoz.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Company")
public class Company {

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;

	@Column
	private String description;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Address.class)
	@JoinColumn(name = "idAddress", updatable = true, insertable = true)
	private Address idAddress;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Users.class)
	@JoinColumn(name = "founder", updatable = true, insertable = true)
	private Users founder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Address idAddress) {
		this.idAddress = idAddress;
	}

	public Users getFounder() {
		return founder;
	}

	public void setFounder(Users founder) {
		this.founder = founder;
	}

}
