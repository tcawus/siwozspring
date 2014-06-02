package org.siwoz.service.index;

import java.security.MessageDigest;

import javax.annotation.Resource;

import org.siwoz.dao.model.Users;
import org.siwoz.dao.repos.UsersRepository;
import org.siwoz.model.forms.register.RegisterBean;
import org.siwoz.util.Converter;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountManagerService")
@Transactional
public class AccountManagerService {

	@Resource(name = "usersRepository")
	UsersRepository usersRepository;

	@Resource(name = "messageSource")
	MessageSource messageSource;

	boolean userAlreadyExists;
	boolean problemsWithRegister;

	public void checkIfUserExists(String email) {
		if (usersRepository.getByEmail(email) != null)
			userAlreadyExists = true;
	}

	public void checkIfUserExistsUN(String username) {
		if (usersRepository.getByUsername(username) != null)
			userAlreadyExists = true;
	}

	public void register(RegisterBean registerBean) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(registerBean.getPassword().getBytes());

			Users user = new Users();
			user.setName(registerBean.getUsername());
			user.setSurname(registerBean.getSurname());
			user.setUsername(registerBean.getEmail());
			user.setPassword(Converter.hashToString(messageDigest.digest()));
			usersRepository.add(user);
		} catch (Exception e) {
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
