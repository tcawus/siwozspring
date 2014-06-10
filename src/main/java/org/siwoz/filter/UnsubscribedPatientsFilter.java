package org.siwoz.filter;

import java.util.Collection;
import java.util.List;

import org.siwoz.dao.model.Patient;

import com.google.common.collect.Lists;

public class UnsubscribedPatientsFilter implements IFilter<Patient> {

	@Override
	public List<Patient> doFilter(Collection<Patient> input) {
		List<Patient> result = Lists.newArrayList();
		for (Patient patient : input) {
			if (!patient.getIdUser().isEnabled()) {
				result.add(patient);
			}
		}
		return result;
	}
}
