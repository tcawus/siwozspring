package org.siwoz.service;

import java.util.Collection;

import javax.annotation.Resource;

import org.siwoz.dao.model.Employee;
import org.siwoz.dao.repos.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeService")
@Transactional
public class EmployeeService implements IService<Employee> {

	@Resource(name = "employeeRepository")
	EmployeeRepository employeeRepository;

	@Override
	public Collection<Employee> getAll() {
		return employeeRepository.getAll();
	}

	@Override
	public Employee getById(long id) {
		return employeeRepository.getById(id);
	}

	@Override
	public Employee add(Employee object) {
		return employeeRepository.add(object);
	}

	@Override
	public void update(Employee object) {
		employeeRepository.update(object);
	}

	@Override
	public void delete(Employee object) {
		employeeRepository.delete(object);
	}
}
