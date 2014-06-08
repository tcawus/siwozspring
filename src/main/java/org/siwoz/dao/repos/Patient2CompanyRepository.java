package org.siwoz.dao.repos;

import java.util.List;

import org.hibernate.Query;
import org.siwoz.dao.model.Patient2Company;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@Repository("patient2CompanyRepository")
public class Patient2CompanyRepository extends
		AbstractRepository<Patient2Company> {

	@Override
	public List<Patient2Company> getAll() {
		Query query = getSession().createQuery("from Patient2Company");
		return Lists.newArrayList(Iterables.filter(query.list(),
				Patient2Company.class));
	}

	@Override
	public Patient2Company getById(long id) {
		return (Patient2Company) getSession().get(Patient2Company.class, id);
	}

}
