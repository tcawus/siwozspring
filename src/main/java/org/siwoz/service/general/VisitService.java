package org.siwoz.service.general;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.siwoz.dao.model.Patient2Company;
import org.siwoz.dao.model.Visit;
import org.siwoz.dao.model.VisitDescription;
import org.siwoz.dao.repos.Patient2CompanyRepository;
import org.siwoz.dao.repos.UsersRepository;
import org.siwoz.dao.repos.VisitDescriptionRepository;
import org.siwoz.dao.repos.VisitRepository;
import org.siwoz.filter.MyPatient2CompanyFilter;
import org.siwoz.model.forms.calendar.NewVisitBean;
import org.siwoz.service.MailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("visitService")
@Transactional
public class VisitService implements IService<Visit> {

	@Resource(name = "visitRepository")
	VisitRepository visitRepository;

	@Resource(name = "visitDescriptionRepository")
	VisitDescriptionRepository visitDescriptionRepository;

	@Resource(name = "patient2CompanyRepository")
	Patient2CompanyRepository patient2CompanyRepository;

	@Resource(name = "usersRepository")
	UsersRepository usersRepository;

	@Resource(name = "mailSender")
	MailSender mailSender;

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

	public void add(NewVisitBean newVisitBean, int idUser) {
		VisitDescription visitDescription = new VisitDescription();
		visitDescription.setDescription(newVisitBean.getDescription());
		visitDescription = visitDescriptionRepository.add(visitDescription);

		List<Patient2Company> patient2Companies = patient2CompanyRepository
				.getAll();
		Patient2Company patient2Company = new MyPatient2CompanyFilter(idUser)
				.doFilter(patient2Companies).get(0);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Visit visit = new Visit();
		visit.setIdDescription(visitDescription);
		visit.setIdEmployee(null);
		visit.setIdPatient2Company(patient2Company);
		try {
			visit.setVisitDate(formatter.parse(newVisitBean.getFrom()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		visitRepository.add(visit);
		sendNotification(visit, idUser);
	}

	private void sendNotification(Visit visit, int idUser) {
		String email = usersRepository.getById(idUser).getUsername();
		mailSender.send(email, "Wizyta " + visit.getVisitDate(), visit
				.getIdDescription().getDescription());
	}
}
