package dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.siwoz.dao.configuration.DataInitializer;
import org.siwoz.dao.configuration.PersistenceConfig;
import org.siwoz.dao.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class,
		DataInitializer.class })
public class RepositoryTest {

	@Autowired
	UserRepository userRepository;

	@Test
	public void selectTest() {
		if (userRepository == null)
			System.out.println("null");
		boolean notEmpty = userRepository.getAll().size() > 0 ? true : false;
		assertTrue(notEmpty);
	}
}
