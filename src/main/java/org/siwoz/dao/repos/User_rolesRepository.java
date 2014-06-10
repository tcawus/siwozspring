package org.siwoz.dao.repos;

import java.util.Collection;

import org.hibernate.Query;
import org.siwoz.dao.model.User_roles;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@Repository("user_rolesRepository")
public class User_rolesRepository extends
		AbstractRepository<User_roles> {

	@Override
	public Collection<User_roles> getAll() {
		Query query = getSession().createQuery("from User_roles");
		return Lists.newArrayList(Iterables.filter(query.list(),
				User_roles.class));
	}

	@Override
	public User_roles getById(long id) {
		return (User_roles) getSession().get(User_roles.class, id);
	}

}
