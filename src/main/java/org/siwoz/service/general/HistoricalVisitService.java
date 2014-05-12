package org.siwoz.service.general;

import java.util.Collection;

import javax.annotation.Resource;

import org.siwoz.dao.model.HistoricalVisit;
import org.siwoz.dao.repos.HistoricalVisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("historicalVisitService")
@Transactional
public class HistoricalVisitService implements IService<HistoricalVisit> {

	@Resource(name = "historicalVisitRepository")
	HistoricalVisitRepository historicalVisitRepository;

	@Override
	public Collection<HistoricalVisit> getAll() {
		return historicalVisitRepository.getAll();
	}

	@Override
	public HistoricalVisit getById(long id) {
		return historicalVisitRepository.getById(id);
	}

	@Override
	public HistoricalVisit add(HistoricalVisit object) {
		return historicalVisitRepository.add(object);
	}

	@Override
	public void update(HistoricalVisit object) {
		historicalVisitRepository.update(object);
	}

	@Override
	public void delete(HistoricalVisit object) {
		historicalVisitRepository.delete(object);
	}

}
