package org.siwoz.service.account;

import javax.annotation.Resource;

import org.siwoz.dao.model.Users;
import org.siwoz.dao.repos.UsersRepository;
import org.siwoz.model.forms.account.AccountEditBean;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountPropertiesService")
@Transactional
public class AccountPropertiesService {

	@Resource(name = "usersRepository")
	UsersRepository usersRepository;

	@Resource(name = "messageSource")
	MessageSource messageSource;

	String updateResult;

	public AccountEditBean getCurrentProperties(String username) {
		Users currentUser = usersRepository.getByEmail(username);
		AccountEditBean accountEditBean = new AccountEditBean();
		accountEditBean.setName(currentUser.getName());
		accountEditBean.setSurname(currentUser.getSurname());
		if (currentUser.getPesel() != null)
			accountEditBean.setPesel(currentUser.getPesel());
		return accountEditBean;
	}

	public void deleteAccount(Users user) {
		usersRepository.delete(user);
	}

	public void updateProperties(Users user, AccountEditBean accountEditBean) {
		// TODO Auto-generated method stub
		user.setName(accountEditBean.getName());
		user.setSurname(accountEditBean.getSurname());
		if (accountEditBean.getPesel() != null)
			user.setPesel(accountEditBean.getPesel());
		usersRepository.update(user);
		updateResult = messageSource.getMessage("updateAccountSuccess", null,
				null);
	}

	public String getUpdateResult() {
		return updateResult;
	}

	public Users getUserByEmail(String username) {
		return usersRepository.getByEmail(username);
	}
}
