package org.siwoz.service.general;

import java.util.Collection;

import javax.annotation.Resource;

import org.siwoz.dao.model.Person;
import org.siwoz.dao.repos.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("personService")
@Transactional
public class PersonService implements IService<Person> {

	@Resource(name = "personRepository")
	PersonRepository personRepository;

	@Override
	public Collection<Person> getAll() {
		return personRepository.getAll();
	}

	@Override
	public Person getById(long id) {
		return personRepository.getById(id);
	}

	@Override
	public Person add(Person object) {
		return personRepository.add(object);
	}

	@Override
	public void update(Person object) {
		personRepository.update(object);
	}

	@Override
	public void delete(Person object) {
		personRepository.delete(object);
	}
}
