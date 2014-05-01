package dao;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.siwoz.dao.model.Person;
import org.siwoz.service.IService;

public class PersonServiceTest extends DaoTestScheme<Person> {

	@Resource(name = "personService")
	IService<Person> personService;

	@Before
	public void insertObjectBeforeTest() {
		Person person = new Person();
		person.setName("MyNameIs");
		person.setPass("45678976543ergmjy65yd");
		person.setPesel("1234567890");
		person.setRegisterDate(new Date());
		personService.add(person);
		setService();
		setObjectToUpdate(person);
		setInsertedId(person.getId());
	}

	@Override
	protected void setService() {
		service = personService;
	}

	@Override
	protected void setInsertedId(long id) {
		insertedId = id;
	}

	@Override
	protected void setObjectToUpdate(Object object) {
		((Person) object).setName("MyNameIs2");
		objectToUpdate = object;
	}
}
