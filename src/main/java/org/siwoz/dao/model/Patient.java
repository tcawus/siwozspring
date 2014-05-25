package org.siwoz.dao.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Patient")
public class Patient {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Users.class)
	@JoinColumn(name = "idUser", updatable = true, insertable = true)
	private Users idUser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Users getIdUser() {
		return idUser;
	}

	public void setIdUser(Users idUser) {
		this.idUser = idUser;
	}
}
