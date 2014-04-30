package org.siwoz.dao.repos;

import java.util.Collection;

import org.hibernate.Query;
import org.siwoz.dao.model.Employee;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@Repository("employeeRepository")
public class EmployeeRepository extends AbstractRepository<Employee> {

	@Override
	public Collection<Employee> getAll() {
		Query query = getSession().createQuery("from Employee");
		return Lists
				.newArrayList(Iterables.filter(query.list(), Employee.class));
	}

	@Override
	public Employee getById(long id) {
		return (Employee) getSession().get(Employee.class, id);
	}
}
