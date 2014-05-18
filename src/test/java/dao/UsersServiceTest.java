package dao;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.siwoz.dao.model.Users;
import org.siwoz.service.general.IService;

public class UsersServiceTest extends DaoTestScheme<Users> {

	@Resource(name = "usersService")
	IService<Users> usersService;

	@Before
	public void insertObjectBeforeTest() {
		Users user = new Users();
		user.setName("MyNameIs");
		user.setPass("45678976543ergmjy65yd");
		user.setPesel("1234567890");
		user.setRegisterDate(new Date());
		usersService.add(user);
		setService();
		setObjectToUpdate(user);
		setInsertedId(user.getId());
	}

	@Override
	protected void setService() {
		service = usersService;
	}

	@Override
	protected void setInsertedId(long id) {
		insertedId = id;
	}

	@Override
	protected void setObjectToUpdate(Object object) {
		((Users) object).setName("MyNameIs2");
		objectToUpdate = object;
	}
}
