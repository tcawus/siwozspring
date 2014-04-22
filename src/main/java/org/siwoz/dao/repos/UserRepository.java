package org.siwoz.dao.repos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.siwoz.dao.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends AbstractRepository<User> {

	@Override
	public Collection<User> getAll() {
		Query query = session.createQuery("FROM User");
		List<User> result = new ArrayList<User>();
		for (Iterator<?> iterator = query.iterate(); iterator.hasNext();) {
			result.add((User) iterator.next());
		}
		return result;
	}

	@Override
	public User getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(User object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(long id, User object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(long id, List<String> properties, List<Object> values) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}
}
