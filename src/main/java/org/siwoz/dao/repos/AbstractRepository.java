package org.siwoz.dao.repos;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRepository<T> {

	@Autowired
	public SessionFactory sessionFactory;

	private Session session;

	protected Session getSession() {
		if (session == null) {
			session = sessionFactory.getCurrentSession();
		}
		return session;
	}

	/**
	 * Gets all objects from DB.
	 * 
	 * @param id
	 * @return
	 */
	public abstract Collection<T> getAll();

	/**
	 * Gets object with selected ID.
	 * 
	 * @param id
	 * @return
	 */
	public abstract T getById(long id);

	public T add(T object) {
		getSession().persist(object);
		getSession().flush();
		return object;
	}

	public void update(T object) {
		getSession().update(object);
		getSession().flush();
	}

	public void delete(T object) {
		getSession().delete(object);
	}
}
