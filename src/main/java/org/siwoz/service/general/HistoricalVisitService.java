package org.siwoz.service.general;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.siwoz.dao.model.HistoricalVisit;
import org.siwoz.dao.model.Patient;
import org.siwoz.dao.model.Users;
import org.siwoz.dao.repos.HistoricalVisitRepository;
import org.siwoz.filter.HistoricalVisitsForPatientFilter;
import org.siwoz.filter.IFilter;
import org.siwoz.filter.PatientDataForHistoricalVisitFilter;
import org.siwoz.filter.PatientsForHistoricalVisitFilter;
import org.siwoz.model.forms.employee.PatientRecordFormBean;
import org.siwoz.model.forms.employee.PatientVisitDataBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service("historicalVisitService")
@Transactional
public class HistoricalVisitService implements IService<HistoricalVisit> {

	@Resource(name = "historicalVisitRepository")
	HistoricalVisitRepository historicalVisitRepository;

	List<HistoricalVisit> cachedList;

	public void getAllPatientsForCompanyAndEmployee(int companyId,
			int employeeId) {
		PatientsForHistoricalVisitFilter filter = new PatientsForHistoricalVisitFilter(
				companyId, employeeId);
		List<HistoricalVisit> filteredResult = filter
				.doFilter(historicalVisitRepository
						.getAllPatientsForCompanyAndEmployee(companyId,
								employeeId));
		cachedList = filteredResult;
	}

	public List<PatientVisitDataBean> getPatientsVisitDataForCompanyAndEmployee(
			PatientRecordFormBean formBean) {
		if (cachedList != null) {
			PatientDataForHistoricalVisitFilter filter = new PatientDataForHistoricalVisitFilter(
					formBean.getName());
			return constructPatientVisitDataBeans(filter.doFilter(cachedList));
		}
		return null;
	}

	public Map<String, String> getCachedListAsMap() {
		Map<String, String> patients = new LinkedHashMap<String, String>();
		for (HistoricalVisit historicalVisit : cachedList) {
			Patient patient = historicalVisit.getIdPatient2Company()
					.getIdPatient();
			String fullName = patient.getIdUser().getName() + " "
					+ patient.getIdUser().getSurname();
			patients.put(fullName, fullName);
		}
		return patients;
	}

	public List<PatientVisitDataBean> getVisitsForUser(String email) {
		List<HistoricalVisit> historicalVisits = historicalVisitRepository
				.getAll();
		IFilter<HistoricalVisit> historicalVisitFilter = new HistoricalVisitsForPatientFilter(
				email);
		return constructPatientVisitDataBeans(historicalVisitFilter
				.doFilter(historicalVisits));
	}

	private List<PatientVisitDataBean> constructPatientVisitDataBeans(
			Collection<HistoricalVisit> historicalVisits) {
		List<PatientVisitDataBean> visitDataList = Lists.newArrayList();
		for (HistoricalVisit visit : historicalVisits) {
			Users currentUser = visit.getIdPatient2Company().getIdPatient()
					.getIdUser();
			PatientVisitDataBean patientVisitDataBean = new PatientVisitDataBean(
					currentUser.getName() + " " + currentUser.getSurname(),
					visit.getIdDescription().getDescription(),
					visit.getVisitDate());
			visitDataList.add(patientVisitDataBean);
		}
		return visitDataList;
	}

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

	public List<HistoricalVisit> getCachedList() {
		return new ArrayList<HistoricalVisit>(cachedList);
	}
}
