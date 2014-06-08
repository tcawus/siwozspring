package org.siwoz.service.calendar;

import java.util.List;

import javax.annotation.Resource;

import org.siwoz.dao.model.Visit;
import org.siwoz.dao.repos.VisitRepository;
import org.siwoz.filter.VisitForPatientFilter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gdata.data.DateTime;

@Service("calendarService")
@Transactional
public class MyCalendarService {

	@Resource(name = "calendarManager")
	CalendarManager calendarManager;

	@Resource(name = "visitRepository")
	VisitRepository visitRepository;

	public void putMyEvents(int userId) {
		calendarManager.clearEvents();
		List<Visit> allVisits = visitRepository.getAll();
		List<Visit> myVisits = new VisitForPatientFilter(userId)
				.doFilter(allVisits);
		for (Visit visit : myVisits) {
			DateTime startTime = new DateTime(visit.getVisitDate());
			DateTime endTime = new DateTime(
					visit.getVisitDate().getTime() + 1000 * 60 * 60);
			calendarManager.insertEvent(visit.getIdDescription()
					.getDescription(), visit.getIdDescription()
					.getDescription(), startTime, endTime);
		}
	}
}