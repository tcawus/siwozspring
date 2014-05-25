DROP TABLE IF EXISTS `Visit`;
DROP TABLE IF EXISTS `HistoricalVisit`;
DROP TABLE IF EXISTS `Employee`;
DROP TABLE IF EXISTS `Patient2Company`;
DROP TABLE IF EXISTS `Company`;
DROP TABLE IF EXISTS `Patient`;
DROP TABLE IF EXISTS `User_roles`;
DROP TABLE IF EXISTS `Users`;
DROP TABLE IF EXISTS `EmployeeStatus`;
DROP TABLE IF EXISTS `Address`;

CREATE TABLE Users (
	id INT AUTO_INCREMENT,
	name VARCHAR(64),
	surname VARCHAR(128),
	email VARCHAR(128),
	username VARCHAR(128) not null,
	password VARCHAR(256),
	pesel CHAR(11),
	registerDate TIMESTAMP,
	enabled TINYINT NOT NULL DEFAULT 1 ,
	PRIMARY KEY(id)
) DEFAULT CHARSET=utf8;

CREATE TABLE User_roles (
  user_role_id INT(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  ROLE VARCHAR(45) NOT NULL,
  user_id INT,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (ROLE,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (user_id) REFERENCES users (id)
  ) DEFAULT CHARSET=utf8;

CREATE TABLE Address (
	id INT AUTO_INCREMENT,
	city varchar(64),
	street varchar(64),
	PRIMARY KEY(id)
) DEFAULT CHARSET=utf8;


CREATE TABLE Patient (
	id INT AUTO_INCREMENT,
	idUser INT,
	FOREIGN KEY(idUser) REFERENCES Users(id),
	PRIMARY KEY(id)
)  DEFAULT CHARSET=utf8;

CREATE TABLE EmployeeStatus (
	id INT AUTO_INCREMENT,
	statusName varchar(32),
	PRIMARY KEY(id)
)  DEFAULT CHARSET=utf8;

CREATE TABLE Company (
	id INT AUTO_INCREMENT,
	name varchar(128),
	description varchar(512),
	idAddress INT,
	founder INT,
	FOREIGN KEY(idAddress) REFERENCES Address(id),
	FOREIGN KEY(founder) REFERENCES Users(id),
	PRIMARY KEY(id)
)  DEFAULT CHARSET=utf8;

CREATE TABLE Employee (
	id INT AUTO_INCREMENT,
	idEmployeeStatus INT,
	idUser INT,
	idCompany INT,
	FOREIGN KEY(idEmployeeStatus) REFERENCES EmployeeStatus(id),
	FOREIGN KEY(idUser) REFERENCES Users(id),
	FOREIGN KEY(idCompany) REFERENCES Company(id),
	PRIMARY KEY(id)
)  DEFAULT CHARSET=utf8;


CREATE TABLE Patient2Company (
	id INT AUTO_INCREMENT,
	idPatient INT,
	idCompany INT,
	FOREIGN KEY(idPatient) REFERENCES Patient(id),
	FOREIGN KEY(idCompany) REFERENCES Company(id),
	PRIMARY KEY(id)
)  DEFAULT CHARSET=utf8;

CREATE TABLE Visit (
	id INT AUTO_INCREMENT,
	visitDate TIMESTAMP,
	idPatient2Company INT,
	idEmployee INT,
	FOREIGN KEY(idPatient2Company) REFERENCES Patient2Company(id),
	FOREIGN KEY(idEmployee) REFERENCES Employee(id),
	PRIMARY KEY(id)
)  DEFAULT CHARSET=utf8;

CREATE TABLE HistoricalVisit (
	id INT AUTO_INCREMENT,
	visitDate TIMESTAMP,
	idPatient2Company INT,
	idEmployee INT,
	FOREIGN KEY(idPatient2Company) REFERENCES Patient2Company(id),
	FOREIGN KEY(idEmployee) REFERENCES Employee(id),
	PRIMARY KEY(id)
)  DEFAULT CHARSET=utf8;