package org.siwoz.dao.repos;

import java.util.Collection;

import org.hibernate.Query;
import org.siwoz.dao.model.Company;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@Repository("companyRepository")
public class CompanyRepository extends AbstractRepository<Company> {

	@Override
	public Collection<Company> getAll() {
		Query query = getSession().createQuery("from Company");
		return Lists
				.newArrayList(Iterables.filter(query.list(), Company.class));
	}

	@Override
	public Company getById(long id) {
		return (Company) getSession().get(Company.class, id);
	}
}
