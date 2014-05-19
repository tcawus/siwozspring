package org.siwoz.service.index;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

	public void register(RegisterBean registerBean) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(registerBean.getPass().getBytes());

			Users user = new Users();
			user.setName(registerBean.getName());
			user.setSurname(registerBean.getSurname());
			user.setEmail(registerBean.getEmail());
			user.setPass(Converter.hashToString(messageDigest.digest()));
			usersRepository.add(user);
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
