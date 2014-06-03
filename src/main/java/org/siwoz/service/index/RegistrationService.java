package org.siwoz.service.index;

import javax.annotation.Resource;

import org.siwoz.dao.model.Users;
import org.siwoz.dao.repos.UsersRepository;
import org.siwoz.model.forms.register.RegisterBean;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("registerService")
@Transactional
public class RegistrationService {

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
		try {
			Users user = new Users();
			user.setName(registerBean.getName());
			user.setSurname(registerBean.getSurname());
			user.setUsername(registerBean.getUsername());
			user.setPesel(registerBean.getPesel());
			user.setPassword(BCrypt.hashpw(registerBean.getPassword(),
					BCrypt.gensalt()));
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
