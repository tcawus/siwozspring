package org.siwoz.service;

import java.util.Collection;

import javax.annotation.Resource;

import org.siwoz.dao.model.Person;
import org.siwoz.dao.repos.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("personService")
@Transactional
public class PersonService implements IService<Person> {

	@Resource(name="personRepository")
	PersonRepository personRepository;
	
	@Override
	public Collection<Person> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getById(long id) {
		return personRepository.getById(id);
	}

	@Override
	public int add(Person object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Person object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
