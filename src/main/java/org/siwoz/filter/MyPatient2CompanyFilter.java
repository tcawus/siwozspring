package org.siwoz.filter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.siwoz.dao.model.Patient2Company;

public class MyPatient2CompanyFilter implements IFilter<Patient2Company> {

	int userId;

	public MyPatient2CompanyFilter(int userId) {
		this.userId = userId;
	}

	@Override
	public List<Patient2Company> doFilter(Collection<Patient2Company> input) {
		for (Patient2Company patient2Company : input) {
			if (patient2Company.getIdPatient().getIdUser().getId() == userId)
				return Arrays.asList(patient2Company);
		}
		return null;
	}

}
