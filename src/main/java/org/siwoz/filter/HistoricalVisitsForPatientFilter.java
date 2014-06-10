package org.siwoz.filter;

import java.util.Collection;
import java.util.List;

import org.siwoz.dao.model.HistoricalVisit;

import com.google.common.collect.Lists;

public class HistoricalVisitsForPatientFilter implements
		IFilter<HistoricalVisit> {

	String email;

	public HistoricalVisitsForPatientFilter(String email) {
		this.email = email;
	}

	@Override
	public Collection<HistoricalVisit> doFilter(
			Collection<HistoricalVisit> input) {
		List<HistoricalVisit> historicalVisits = Lists.newArrayList();
		for (HistoricalVisit historicalVisit : input) {
			if (historicalVisit.getIdPatient2Company().getIdPatient()
					.getIdUser().getUsername().equals(email)) {
				historicalVisits.add(historicalVisit);
			}
		}
		return historicalVisits;
	}
}
