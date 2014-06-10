package org.siwoz.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.siwoz.model.forms.employee.PatientIdFormBean;
import org.siwoz.model.forms.employee.PatientRecordFormBean;
import org.siwoz.service.general.HistoricalVisitService;
import org.siwoz.service.general.PatientService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Resource(name = "messageSource")
	MessageSource messageSource;

	@Resource(name = "historicalVisitService")
	HistoricalVisitService historicalVisitService;

	@Resource(name = "patientService")
	PatientService patientService;

	Map<String, String> cachedMap;

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

	@RequestMapping(value = "/unsubscribe", method = RequestMethod.GET)
	public String patientUnsubscribeForm(Model model) throws IOException {
		cachedMap = patientService.getAllSubscribedMap();
		model.addAttribute("patients", cachedMap);
		model.addAttribute("patientRecord", new PatientIdFormBean());
		return "employee/unsubscribe";
	}

	@RequestMapping(value = "/unsubscribe", method = RequestMethod.POST)
	public ModelAndView patientUnsubscribeSubmit(
			@Valid PatientIdFormBean patientIdFormBean, Model model)
			throws IOException {
		cachedMap.remove(patientIdFormBean.getId());
		patientService.unsubscribePatient(patientIdFormBean.getId());
		ModelAndView mav = new ModelAndView("employee/unsubscribe", "result",
				messageSource.getMessage("patientUnsubscribed", null, null));
		mav.addObject("patients", cachedMap);
		mav.addObject("patientRecord", new PatientIdFormBean());
		return mav;
	}
}
