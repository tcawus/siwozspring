package org.siwoz.service;

import java.util.Collection;

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

}
