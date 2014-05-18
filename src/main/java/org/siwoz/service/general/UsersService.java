package org.siwoz.service.general;

import java.util.Collection;

import javax.annotation.Resource;

import org.siwoz.dao.model.Users;
import org.siwoz.dao.repos.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usersService")
@Transactional
public class UsersService implements IService<Users> {

	@Resource(name = "usersRepository")
	UsersRepository usersRepository;

	@Override
	public Collection<Users> getAll() {
		return usersRepository.getAll();
	}

	@Override
	public Users getById(long id) {
		return usersRepository.getById(id);
	}

	@Override
	public Users add(Users object) {
		return usersRepository.add(object);
	}

	@Override
	public void update(Users object) {
		usersRepository.update(object);
	}

	@Override
	public void delete(Users object) {
		usersRepository.delete(object);
	}
}
