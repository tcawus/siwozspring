package org.siwoz.dao.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class DataInitializer {

	@Value("classpath:db/data/db-schema.sql")
	private Resource schemaScript;

	@Value("classpath:db/data/db-employeestatus-data.sql")
	private Resource employeeStatusDataScript;

	@Value("classpath:db/data/db-employee-data.sql")
	private Resource employeeDataScript;

	@Value("classpath:db/data/db-patient-data.sql")
	private Resource patientDataScript;

	@Value("classpath:db/data/db-person-data.sql")
	private Resource userDataScript;

	@Value("classpath:db/data/db-company-data.sql")
	private Resource companyDataScript;

	@Value("classpath:db/data/db-address-data.sql")
	private Resource addressDataScript;

	@Value("classpath:db/data/db-visit-data.sql")
	private Resource visitDataScript;

	@Value("classpath:db/data/db-historicalvisit-data.sql")
	private Resource historicalVisitDataScript;

	@Value("classpath:db/data/db-patient2company-data.sql")
	private Resource patient2CompanyDataScript;

	@Autowired
	DataSource restDataSource;

	@Bean
	public DataSourceInitializer dataSourceInitializer(
			final DataSource dataSource) {
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(restDataSource);
		initializer.setDatabasePopulator(databasePopulator());
		return initializer;
	}

	private DatabasePopulator databasePopulator() {
		final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(schemaScript);
		populator.addScript(employeeStatusDataScript);
		populator.addScript(employeeDataScript);
		populator.addScript(userDataScript);
		populator.addScript(patientDataScript);
		populator.addScript(companyDataScript);
		populator.addScript(addressDataScript);
		populator.addScript(patient2CompanyDataScript);
		populator.addScript(visitDataScript);
		populator.addScript(historicalVisitDataScript);
		return populator;
	}
}
