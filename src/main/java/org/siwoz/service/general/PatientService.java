package org.siwoz.service.general;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.siwoz.dao.model.Patient;
import org.siwoz.dao.repos.PatientRepository;
import org.siwoz.dao.repos.UsersRepository;
import org.siwoz.filter.IFilter;
import org.siwoz.filter.SubscribedPatientsFilter;
import org.siwoz.filter.UnsubscribedPatientsFilter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("patientService")
@Transactional
public class PatientService implements IService<Patient> {

	@Resource(name = "patientRepository")
	PatientRepository patientRepository;

	@Resource(name = "usersRepository")
	UsersRepository usersRepository;

	@Override
	public Collection<Patient> getAll() {
		return patientRepository.getAll();
	}

	@Override
	public Patient getById(long id) {
		return patientRepository.getById(id);
	}

	@Override
	public Patient add(Patient object) {
		return patientRepository.add(object);
	}

	@Override
	public void update(Patient object) {
		patientRepository.update(object);
	}

	@Override
	public void delete(Patient object) {
		patientRepository.delete(object);
	}

	public Map<String, String> getAllSubscribedMap() {
		return getPatientsAsMapWithFilter(new SubscribedPatientsFilter());
	}

	public Map<String, String> getAllUnsubscribedMap() {
		return getPatientsAsMapWithFilter(new UnsubscribedPatientsFilter());
	}

	private Map<String, String> getPatientsAsMapWithFilter(
			IFilter<Patient> filter) {
		Map<String, String> map = new HashMap<String, String>();
		List<Patient> patients = patientRepository.getAll();
		for (Patient patient : filter.doFilter(patients)) {
			map.put(String.valueOf(patient.getIdUser().getId()), patient
					.getIdUser().getName()
					+ " "
					+ patient.getIdUser().getSurname());
		}
		return map;
	}

	public void unsubscribePatient(String id) {
		usersRepository.unsubscribePatient(Long.parseLong(id));
	}
}
