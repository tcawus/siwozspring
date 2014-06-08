package org.siwoz.service.general;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

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

	Collection<Users> usersList;

	public Collection<Users> getAllDisabled() {
		return usersRepository.getAllDisabled();
	}

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

	public Users getByEmail(String name) {
		return usersRepository.getByEmail(name);
	}

	public Users getByUsername(String username) {
		return usersRepository.getByUsername(username);
	}

	public Map<Long, String> getCachedListAsMap() {
		usersList = this.getAllDisabled();
		Map<Long, String> usersMap = new LinkedHashMap<Long, String>();
		for (Users user : usersList) {
			usersMap.put(user.getId(), user.getUsername());
		}
		return usersMap;
	}
}
