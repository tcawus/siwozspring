package org.siwoz.service.general;

import java.util.Collection;

import javax.annotation.Resource;

import org.siwoz.dao.model.User_roles;
import org.siwoz.dao.repos.User_rolesRepository;
import org.siwoz.dao.repos.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("user_rolesService")
@Transactional
public class User_rolesService implements IService<User_roles> {
	
	@Resource(name = "user_rolesRepository")
	User_rolesRepository user_rolesRepository;

	@Override
	public Collection<User_roles> getAll() {
		// TODO Auto-generated method stub
		return user_rolesRepository.getAll();
	}

	@Override
	public User_roles getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User_roles add(User_roles object) {
		// TODO Auto-generated method stub
		return user_rolesRepository.add(object);
	}

	@Override
	public void update(User_roles object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User_roles object) {
		// TODO Auto-generated method stub

	}

}
