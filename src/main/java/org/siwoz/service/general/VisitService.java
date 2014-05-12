package org.siwoz.service.general;

import java.util.Collection;

import javax.annotation.Resource;

import org.siwoz.dao.model.Visit;
import org.siwoz.dao.repos.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("visitService")
@Transactional
public class VisitService implements IService<Visit> {

	@Resource(name = "visitRepository")
	VisitRepository visitRepository;

	@Override
	public Collection<Visit> getAll() {
		return visitRepository.getAll();
	}

	@Override
	public Visit getById(long id) {
		return visitRepository.getById(id);
	}

	@Override
	public Visit add(Visit object) {
		return visitRepository.add(object);
	}

	@Override
	public void update(Visit object) {
		visitRepository.update(object);
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
	}
}
