package org.siwoz.dao.repos;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.siwoz.dao.model.Person;
import org.springframework.stereotype.Repository;

@Repository("personRepository")
public class PersonRepository extends AbstractRepository<Person> {

	@Override
	public Collection<Person> getAll() {
		return null;
		// return session.createCriteria(Person.class).list();
	}

	@Override
	public Person getById(long id) {
		// Session session = sessionFactory.openSession();
		// Query query = session.createQuery("FROM Person WHERE id=" + id);
		// Iterator<?> iterator = query.iterate();
		// if (iterator.hasNext())
		// return (Person) iterator.next();
		// return hibernateTemplate.load(Person.class, id);
		return null;
	}

	@Override
	public long add(Person object) {
		System.out.println(object.toString());
		hibernateTemplate.persist(object);
		hibernateTemplate.flush();
		return object.getId();
	}

	@Override
	public void update(Person object) {
		hibernateTemplate.update(object);
	}

	@Override
	public boolean update(long id, List<String> properties, List<Object> values) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(long id) {
		hibernateTemplate.delete(hibernateTemplate.load(Person.class, id));
	}
}
