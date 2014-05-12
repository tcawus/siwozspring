package org.siwoz.service.general;

import java.util.Collection;

import javax.annotation.Resource;

import org.siwoz.dao.model.Company;
import org.siwoz.dao.repos.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("companyService")
@Transactional
public class CompanyService implements IService<Company> {

	@Resource(name = "companyRepository")
	CompanyRepository companyRepository;

	@Override
	public Collection<Company> getAll() {
		return companyRepository.getAll();
	}

	@Override
	public Company getById(long id) {
		return companyRepository.getById(id);
	}

	@Override
	public Company add(Company object) {
		return companyRepository.add(object);
	}

	@Override
	public void update(Company object) {
		companyRepository.update(object);
	}

	@Override
	public void delete(Company object) {
		companyRepository.delete(object);
	}

}
