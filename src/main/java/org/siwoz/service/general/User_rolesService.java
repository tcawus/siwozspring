package org.siwoz.service.general;

import java.util.List;

import javax.annotation.Resource;

import org.siwoz.dao.model.Patient;
import org.siwoz.dao.model.Patient2Company;
import org.siwoz.dao.model.User_roles;
import org.siwoz.dao.model.Users;
import org.siwoz.dao.repos.Patient2CompanyRepository;
import org.siwoz.dao.repos.PatientRepository;
import org.siwoz.dao.repos.User_rolesRepository;
import org.siwoz.dao.repos.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service("user_rolesService")
@Transactional
public class User_rolesService {

	@Resource(name = "user_rolesRepository")
	User_rolesRepository user_rolesRepository;

	@Resource(name = "usersRepository")
	UsersRepository usersRepository;

	@Resource(name = "patientRepository")
	PatientRepository patientRepository;

	@Resource(name = "patient2CompanyRepository")
	Patient2CompanyRepository patient2CompanyRepository;

	public void activate(Users user, User_roles object) {
		// TODO Auto-generated method stub
		List<User_roles> user_roles = Lists.newArrayList();
		boolean isFound = false;
		for (User_roles user_role : user_roles) {
			if (user.getUsername().equals(user_role.getUsername())) {
				isFound = true;
				break;
			}
		}
		if (!isFound) {
			Patient patient = new Patient();
			patient.setIdUser(user);
			Patient patientAfterSaving = patientRepository.add(patient);
			Patient2Company patient2Company = new Patient2Company();
			patient2Company.setIdPatient(patientAfterSaving);
			patient2CompanyRepository.add(patient2Company);
			user_rolesRepository.add(object);
		}
		//usersRepository.update(user);
	}
}
