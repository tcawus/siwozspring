package org.siwoz.dao.repos;

import java.util.Collection;

import org.hibernate.Query;
import org.siwoz.dao.model.VisitDescription;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@Repository("visitDescriptionRepository")
public class VisitDescriptionRepository extends
		AbstractRepository<VisitDescription> {

	@Override
	public Collection<VisitDescription> getAll() {
		Query query = getSession().createQuery("from VisitDescription");
		return Lists.newArrayList(Iterables.filter(query.list(),
				VisitDescription.class));
	}

	@Override
	public VisitDescription getById(long id) {
		return (VisitDescription) getSession().get(VisitDescription.class, id);
	}

}
