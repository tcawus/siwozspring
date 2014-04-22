package org.siwoz.dao.repos;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRepository<T> {

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session session;

	public AbstractRepository() {
		session = sessionFactory.getCurrentSession();
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

	/**
	 * Add specified object.
	 * 
	 * @param id
	 * @return
	 */
	public abstract boolean add(T object);

	/**
	 * Updates object with specified ID.
	 * 
	 * @param id
	 * @return
	 */
	public abstract boolean update(long id, T object);

	/**
	 * Updates specified ID with specified properties with given values.
	 * 
	 * @param id
	 * @return
	 */
	public abstract boolean update(long id, List<String> properties,
			List<Object> values);

	/**
	 * Deletes object with selected ID.
	 * 
	 * @param id
	 * @return
	 */
	public abstract boolean delete(long id);
}
