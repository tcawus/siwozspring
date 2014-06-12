package org.siwoz.service.calendar;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.siwoz.dao.model.Users;
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

	public void getMyEvents(long userId) {
		calendarManager.clearEvents();
		Collection<Visit> allVisits = visitRepository.getAll();
		List<Visit> myVisits = new VisitForPatientFilter(userId)
				.doFilter(allVisits);
		for (Visit visit : myVisits) {
			DateTime startTime = new DateTime(visit.getVisitDate().getTime());
			DateTime endTime = new DateTime(
					visit.getVisitDate().getTime() + 1000 * 60 * 60);
			calendarManager.insertEvent("Wizyta", visit.getIdDescription()
					.getDescription(), startTime, endTime);
		}
	}

	public void getAllEvents() {
		calendarManager.clearEvents();
		Collection<Visit> allVisits = visitRepository.getAll();
		for (Visit visit : allVisits) {
			DateTime startTime = new DateTime(visit.getVisitDate().getTime());
			DateTime endTime = new DateTime(
					visit.getVisitDate().getTime() + 1000 * 60 * 60);
			Users currentUser = visit.getIdPatient2Company().getIdPatient()
					.getIdUser();
			calendarManager.insertEvent("Wizyta " + currentUser.getName() + " "
					+ currentUser.getSurname(), visit.getIdDescription()
					.getDescription(), startTime, endTime);
		}
	}
}
