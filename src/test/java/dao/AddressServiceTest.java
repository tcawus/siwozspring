package dao;

import javax.annotation.Resource;

import org.siwoz.dao.model.Address;
import org.siwoz.service.IService;

public class AddressServiceTest extends DaoTestScheme<Address> {

	@Resource(name = "addressService")
	IService<Address> addressService;

	@Override
	public void insertObjectBeforeTest() {
		Address address = new Address();
		address.setCity("Poznan");
		address.setStreet("Warszawska");
		addressService.add(address);

		address.setStreet("Winogrady");
		setObjectToUpdate(address);
		setService();
		setInsertedId(address.getId());
	}

	@Override
	protected void setService() {
		service = addressService;
	}

	@Override
	protected void setObjectToUpdate(Object object) {
		objectToUpdate = object;
	}

	@Override
	protected void setInsertedId(long id) {
		insertedId = id;
	}

}
