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

	public AccountEditBean getCurrentProperties(int userId) {
		Users currentUser = usersRepository.getById(userId);
		AccountEditBean accountEditBean = new AccountEditBean();
		accountEditBean.setName(currentUser.getName());
		accountEditBean.setSurname(currentUser.getSurname());
		accountEditBean.setUsername(currentUser.getUsername());
		if (currentUser.getPesel() != null)
			accountEditBean.setPesel(currentUser.getPesel());
		return accountEditBean;
	}

	public void deleteAccount(int i) {
		// usersRepository.delete(object);
	}

	public void updateProperties(int i, AccountEditBean accountEditBean) {
		// TODO Auto-generated method stub
		updateResult = messageSource.getMessage("updateAccountSuccess", null,
				null);
	}

	public String getUpdateResult() {
		return updateResult;
	}
}
