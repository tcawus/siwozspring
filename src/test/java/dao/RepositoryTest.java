package dao;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.siwoz.dao.configuration.DataInitializer;
import org.siwoz.dao.configuration.PersistenceConfig;
import org.siwoz.dao.model.Person;
import org.siwoz.dao.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class,
		DataInitializer.class })
public class RepositoryTest {

	@Autowired
	PersonRepository userRepository;
	long userId;
	final String EXAMPLE_NAME = "qwertyuiop";

	@Before
	public void insertBeforeTest() {
		Person user = new Person();
		user.setName(EXAMPLE_NAME);
		userId = userRepository.add(user);
	}

	@Test
	public void simpleSelectTest() {
//		boolean nameAlright = userRepository.getById(userId).getName()
//				.equals(EXAMPLE_NAME);
//		assertTrue(nameAlright);
	}

	@After
	public void deletionAfterTest() {
//		userRepository.delete(userId);
	}
}
