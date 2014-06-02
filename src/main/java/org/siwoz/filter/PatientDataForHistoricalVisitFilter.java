package org.siwoz.filter;

import java.util.Collection;
import java.util.List;

import org.siwoz.dao.model.HistoricalVisit;
import org.siwoz.dao.model.Users;

import com.google.common.collect.Lists;

public class PatientDataForHistoricalVisitFilter implements
		IFilter<HistoricalVisit> {

	String name;

	public PatientDataForHistoricalVisitFilter(String name) {
		this.name = name;
	}

	@Override
	public List<HistoricalVisit> doFilter(Collection<HistoricalVisit> input) {
		List<HistoricalVisit> historicalVisits = Lists.newArrayList();
		for (HistoricalVisit historicalVisit : input) {
			Users user = historicalVisit.getIdPatient2Company().getIdPatient()
					.getIdUser();
			String currentName = user.getUsername() + " " + user.getSurname();
			if (currentName.equals(name)) {
				historicalVisits.add(historicalVisit);
			}
		}
		return historicalVisits;
	}
}
