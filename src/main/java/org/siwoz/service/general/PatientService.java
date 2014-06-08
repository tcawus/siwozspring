package org.siwoz.service.general;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.siwoz.dao.model.Patient;
import org.siwoz.dao.repos.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("patientService")
@Transactional
public class PatientService implements IService<Patient> {

	@Resource(name = "patientRepository")
	PatientRepository patientRepository;

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

	public Map<String, String> getAllAsMap() {
		List<Patient> allPatients = patientRepository.getAll();
		Map<String, String> patientMap = new HashMap<String, String>();
		for (Patient patient : allPatients) {
			patientMap.put(String.valueOf(patient.getIdUser().getId()), patient
					.getIdUser().getName()
					+ " "
					+ patient.getIdUser().getSurname());
		}
		return patientMap;
	}
}
