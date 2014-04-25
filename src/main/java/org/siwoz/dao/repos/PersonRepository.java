package org.siwoz.dao.repos;

import java.util.Collection;
import java.util.List;

import org.siwoz.dao.model.Person;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public class PersonRepository extends AbstractRepository<Person> {

	@Override
	public Collection<Person> getAll() {
		return null;
	}

	@Override
	public Person getById(long id) {
		return hibernateTemplate.load(Person.class, id);
	}

	@Override
	public long add(Person object) {
		System.out.println(object.toString());
		hibernateTemplate.persist(object);
		hibernateTemplate.flush();
		return object.getId();
	}

	@Override
	public boolean update(long id, Person object) {
		// TODO Auto-generated method stub
		return false;
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
