package org.siwoz.filter;

import java.util.Collection;
import java.util.List;

import org.siwoz.dao.model.Visit;

import com.google.common.collect.Lists;

public class VisitForPatientFilter implements IFilter<Visit> {

	int userId;

	public VisitForPatientFilter(int userId) {
		this.userId = userId;
	}

	@Override
	public List<Visit> doFilter(Collection<Visit> input) {
		List<Visit> resultList = Lists.newArrayList();
		for (Visit visit : input) {
			if (visit.getIdPatient2Company().getIdPatient().getIdUser().getId() == userId) {
				resultList.add(visit);
			}
		}
		return resultList;
	}

}
