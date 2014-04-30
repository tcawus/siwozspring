package org.siwoz.dao.repos;

import java.util.Collection;

import org.hibernate.Query;
import org.siwoz.dao.model.Person;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@Repository("personRepository")
public class PersonRepository extends AbstractRepository<Person> {

	@Override
	public Collection<Person> getAll() {
		Query query = getSession().createQuery("from Person");
		return Lists.newArrayList(Iterables.filter(query.list(), Person.class));
	}

	@Override
	public Person getById(long id) {
		return (Person) getSession().get(Person.class, id);
	}
}
