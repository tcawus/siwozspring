package dao;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.siwoz.config.MvcConfiguration;
import org.siwoz.dao.configuration.DataInitializer;
import org.siwoz.dao.configuration.PersistenceConfig;
import org.siwoz.dao.model.Person;
import org.siwoz.dao.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { PersistenceConfig.class,
		DataInitializer.class, MvcConfiguration.class })
public class RepositoryTest {

	 @Autowired
	 PersonRepository personRepository;
	 long userId;
	 final String EXAMPLE_NAME = "qwertyuiop";

	// @Before
	// public void insertBeforeTest() {
	// Person user = new Person();
	// user.setName(EXAMPLE_NAME);
	// userId = userRepository.add(user);
	// }

	@Test
	public void updateTest() {
		// System.out.println(personRepository.getAll().size());
		 Person person = personRepository.getById(userId);
		// person.setPass("123242543");
		// userRepository.update(person);
	}

	@Test
	public void simpleSelectTest() {
		// boolean nameAlright = userRepository.getById(userId).getName()
		// .equals(EXAMPLE_NAME);
		// assertTrue(nameAlright);
	}

	@After
	public void deletionAfterTest() {
		// userRepository.delete(userId);
	}
}
