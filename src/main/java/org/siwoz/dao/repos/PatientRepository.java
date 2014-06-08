package org.siwoz.dao.repos;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.siwoz.dao.model.Patient;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@Repository("patientRepository")
public class PatientRepository extends AbstractRepository<Patient> {

	@Override
	public List<Patient> getAll() {
		Query query = getSession().createQuery("from Patient");
		return Lists
				.newArrayList(Iterables.filter(query.list(), Patient.class));
	}

	@Override
	public Patient getById(long id) {
		return (Patient) getSession().get(Patient.class, id);
	}

}
