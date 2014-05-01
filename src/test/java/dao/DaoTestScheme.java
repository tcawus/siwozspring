package dao;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.siwoz.config.MvcConfiguration;
import org.siwoz.dao.configuration.DataInitializer;
import org.siwoz.dao.configuration.PersistenceConfig;
import org.siwoz.service.IService;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { PersistenceConfig.class,
		DataInitializer.class, MvcConfiguration.class })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class DaoTestScheme<T> {

	protected long insertedId;
	protected IService<T> service;
	protected Object objectToUpdate;

	@Before
	public abstract void insertObjectBeforeTest();
	
	protected abstract void setService();

	protected abstract void setObjectToUpdate(Object object);
	
	protected abstract void setInsertedId(long id);

	@Test
	public void selectAllTest() {
		Collection<?> collection = service.getAll();
		Assert.notNull(collection);
		Assert.notEmpty(collection);
	}

	@Test
	public void selectByIdTest() {
		Assert.notNull(service.getById(insertedId));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void updateTest() {
		service.update((T) objectToUpdate);
	}
}
