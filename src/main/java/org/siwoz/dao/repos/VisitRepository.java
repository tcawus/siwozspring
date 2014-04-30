package org.siwoz.dao.repos;

import java.util.Collection;

import org.hibernate.Query;
import org.siwoz.dao.model.Visit;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@Repository("visitRepository")
public class VisitRepository extends AbstractRepository<Visit> {

	@Override
	public Collection<Visit> getAll() {
		Query query = getSession().createQuery("from Visit");
		return Lists.newArrayList(Iterables.filter(query.list(), Visit.class));
	}

	@Override
	public Visit getById(long id) {
		return (Visit) getSession().get(Visit.class, id);
	}

}
