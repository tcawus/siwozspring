package org.siwoz.service.general;

import java.util.Collection;

import javax.annotation.Resource;

import org.siwoz.dao.model.Address;
import org.siwoz.dao.repos.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("addressService")
@Transactional
public class AddressService implements IService<Address> {

	@Resource(name = "addressRepository")
	AddressRepository addressRepository;

	@Override
	public Collection<Address> getAll() {
		return addressRepository.getAll();
	}

	@Override
	public Address getById(long id) {
		return addressRepository.getById(id);
	}

	@Override
	public Address add(Address object) {
		return addressRepository.add(object);
	}

	@Override
	public void update(Address object) {
		addressRepository.update(object);
	}

	@Override
	public void delete(Address object) {
		addressRepository.delete(object);
	}

}
