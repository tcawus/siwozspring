package org.siwoz.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.siwoz.model.forms.employee.PatientRecordFormBean;
import org.siwoz.service.general.HistoricalVisitService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Resource(name = "messageSource")
	MessageSource messageSource;

	@Resource(name = "historicalVisitService")
	HistoricalVisitService historicalVisitService;

	@RequestMapping(value = "/records", method = RequestMethod.GET)
	public String patientsChooser(Model model) throws IOException {
		historicalVisitService.getAllPatientsForCompanyAndEmployee(1, 1);
		model.addAttribute("name", historicalVisitService.getCachedListAsMap());
		model.addAttribute("patientRecord", new PatientRecordFormBean());
		return "employee/records";
	}

	@RequestMapping(value = "/records", method = RequestMethod.POST)
	public String patientRecord(PatientRecordFormBean formBean, Model model)
			throws IOException {
		model.addAttribute("name", historicalVisitService.getCachedListAsMap());
		model.addAttribute("patientRecord", new PatientRecordFormBean());
		model.addAttribute("records", historicalVisitService
				.getPatientsVisitDataForCompanyAndEmployee(formBean));
		return "employee/records";
	}
}
