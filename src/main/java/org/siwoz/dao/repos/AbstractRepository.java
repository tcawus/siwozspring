package org.siwoz.dao.repos;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class AbstractRepository<T> {

	@Autowired
	protected HibernateTemplate hibernateTemplate;
	
	@Autowired
	public SessionFactory sessionFactory;

	protected Session session;
	
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
	public abstract long add(T object);

	/**
	 * Updates object with specified ID.
	 * 
	 * @param id
	 * @return
	 */
	public abstract void update(T object);

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
	public abstract void delete(long id);
}
