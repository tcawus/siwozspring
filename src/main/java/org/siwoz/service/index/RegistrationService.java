package org.siwoz.service.index;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.siwoz.dao.model.Person;
import org.siwoz.dao.repos.PersonRepository;
import org.siwoz.model.forms.register.RegisterBean;
import org.siwoz.util.Converter;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("registrationService")
@Transactional
public class RegistrationService {

	@Resource(name = "personRepository")
	PersonRepository personRepository;

	@Resource(name = "messageSource")
	MessageSource messageSource;

	boolean userAlreadyExists;
	boolean problemsWithRegister;

	public void checkIfUserExists(String email) {
		if (personRepository.getByEmail(email) != null)
			userAlreadyExists = true;
	}

	public void register(RegisterBean registerBean) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(registerBean.getPass().getBytes());

			Person person = new Person();
			person.setName(registerBean.getName());
			person.setSurname(registerBean.getSurname());
			person.setEmail(registerBean.getEmail());
			person.setPass(Converter.hashToString(messageDigest.digest()));
			personRepository.add(person);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			problemsWithRegister = true;
		}
	}

	public String getRegistrationResult() {
		if (userAlreadyExists)
			return messageSource.getMessage("userExists", null, null);
		if (problemsWithRegister)
			return messageSource.getMessage("registrationFailed", null, null);
		return messageSource.getMessage("registrationSuccess", null, null);
	}
}
