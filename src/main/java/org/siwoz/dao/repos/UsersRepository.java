package org.siwoz.dao.repos;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.siwoz.dao.model.Users;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@Repository("usersRepository")
public class UsersRepository extends AbstractRepository<Users> {

	@Override
	public Collection<Users> getAll() {
		Query query = getSession().createQuery("from Users");
		return Lists.newArrayList(Iterables.filter(query.list(), Users.class));
	}

	public Collection<Users> getAllDisabled() {
		Query query = getSession()
				.createQuery("from Users where enabled=false");
		return Lists.newArrayList(Iterables.filter(query.list(), Users.class));
	}

	@Override
	public Users getById(long id) {
		return (Users) getSession().get(Users.class, id);
	}

	public Users getByEmail(String email) {
		Query query = getSession().createQuery(
				"from Users where username='" + email + "'");
		List<?> queryResult = query.list();
		if (queryResult.size() == 0)
			return null;
		return Lists.newArrayList(Iterables.filter(queryResult, Users.class))
				.get(0);
	}

	public Users getByUsername(String username) {
		Query query = getSession().createQuery(
				"from Users where username='" + username + "'");
		List<?> queryResult = query.list();
		if (queryResult.size() == 0)
			return null;
		return Lists.newArrayList(Iterables.filter(queryResult, Users.class))
				.get(0);
	}

	public void unsubscribePatient(long id) {
		Users users = (Users) getSession().get(Users.class, id);
		users.setEnabled(false);
		update(users);
	}
}
