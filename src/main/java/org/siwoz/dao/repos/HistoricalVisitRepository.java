package org.siwoz.dao.repos;

import java.util.Collection;

import org.hibernate.Query;
import org.siwoz.dao.model.HistoricalVisit;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@Repository("historicalVisitRepository")
public class HistoricalVisitRepository extends
		AbstractRepository<HistoricalVisit> {

	@Override
	public Collection<HistoricalVisit> getAll() {
		Query query = getSession().createQuery("from HistoricalVisit");
		return Lists.newArrayList(Iterables.filter(query.list(),
				HistoricalVisit.class));
	}

	@Override
	public HistoricalVisit getById(long id) {
		return (HistoricalVisit) getSession().get(HistoricalVisit.class, id);
	}

}
