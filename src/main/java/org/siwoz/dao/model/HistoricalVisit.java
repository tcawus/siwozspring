package org.siwoz.dao.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HistoricalVisit")
public class HistoricalVisit {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	Date visitDate;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Patient2Company.class)
	@JoinColumn(name = "idPatient2Company", updatable = true, insertable = true)
	private Patient2Company idPatient2Company;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Employee.class)
	@JoinColumn(name = "idEmployee", updatable = true, insertable = true)
	private Employee idEmployee;
	
}
