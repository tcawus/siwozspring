package org.siwoz.filter;

import java.util.Collection;
import java.util.List;

import org.siwoz.dao.model.HistoricalVisit;

import com.google.common.collect.Lists;

public class PatientsForHistoricalVisitFilter implements
		IFilter<HistoricalVisit> {

	int idEmployee, idCompany;

	public PatientsForHistoricalVisitFilter(int idEmployee, int idCompany) {
		this.idEmployee = idEmployee;
		this.idCompany = idCompany;
	}

	@Override
	public List<HistoricalVisit> doFilter(Collection<HistoricalVisit> input) {
		List<HistoricalVisit> result = Lists.newArrayList();
		for (HistoricalVisit historicalVisit : input) {
			if (historicalVisit.getIdEmployee().getId() == idEmployee) {
				if (historicalVisit.getIdPatient2Company().getIdCompany()
						.getId() == idCompany) {
					result.add(historicalVisit);
				}
			}
		}
		return result;
	}
}
