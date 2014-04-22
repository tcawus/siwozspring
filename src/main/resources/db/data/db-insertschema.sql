CREATE TABLE User (
	id bigint primary key IDENTITY,
	name VARCHAR(64),
	surname VARCHAR(128),
	password VARCHAR(256),
	pesel CHAR(11)
);

CREATE TABLE Patient (
	id bigint primary key IDENTITY,
	idUser bigint FOREIGN KEY REFERENCES User(id)
);

CREATE TABLE EmployeeStatus (
	id bigint primary key IDENTITY,
	statusName varchar(32)
);

CREATE TABLE Address (
	id bigint primary key IDENTITY,
	city varchar(64),
	street varchar(64)
);

CREATE TABLE Company (
	id bigint primary key IDENTITY,
	city varchar(128),
	street varchar(512),
	idAddress bigint FOREIGN KEY REFERENCES Address(id)
);

CREATE TABLE Employee (
	id bigint primary key IDENTITY,
	idEmployeeStatus bigint FOREIGN KEY REFERENCES EmployeeStatus(id),
	idUser bigint FOREIGN KEY REFERENCES User(id),
	idCompany bigint FOREIGN KEY REFERENCES Company(id)
);


CREATE TABLE Patient2Company (
	id bigint primary key IDENTITY,
	idPatient bigint FOREIGN KEY REFERENCES Patient(id),
	idCompany bigint FOREIGN KEY REFERENCES Company(id)
);

CREATE TABLE Visit (
	id bigint primary key IDENTITY,
	date TIMESTAMP,
	idPatient2Company bigint FOREIGN KEY REFERENCES Patient2Company(id),
	idEmployee bigint FOREIGN KEY REFERENCES Employee(id)
);

CREATE TABLE HistoricalVisit (
	id bigint primary key IDENTITY,
	date TIMESTAMP,
	idPatient2Company bigint FOREIGN KEY REFERENCES Patient2Company(id),
	idEmployee bigint FOREIGN KEY REFERENCES Employee(id)
);