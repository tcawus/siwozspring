package org.siwoz.dao.repos;

import java.util.Collection;

import org.hibernate.Query;
import org.siwoz.dao.model.Address;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@Repository("addressRepository")
public class AddressRepository extends AbstractRepository<Address> {

	@Override
	public Collection<Address> getAll() {
		Query query = getSession().createQuery("from Address"); 
		return Lists
				.newArrayList(Iterables.filter(query.list(), Address.class));
	}

	@Override
	public Address getById(long id) {
		return (Address) getSession().get(Address.class, id);
	}
}
