package dao;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.siwoz.dao.configuration.DataInitializer;
import org.siwoz.dao.configuration.PersistenceConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class,
		DataInitializer.class })
public class RepositoryTest {

	// @Autowired
	// PersonRepository userRepository;
	// long userId;
	// final String EXAMPLE_NAME = "qwertyuiop";

	// @Before
	// public void insertBeforeTest() {
	// Person user = new Person();
	// user.setName(EXAMPLE_NAME);
	// userId = userRepository.add(user);
	// }

	@Test
	public void updateTest() {
		// System.out.println(userRepository.getAll().size());
		// Person person = userRepository.getById(userId);
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
