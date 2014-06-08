package org.siwoz.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.siwoz.model.forms.calendar.NewVisitBean;
import org.siwoz.service.calendar.MyCalendarService;
import org.siwoz.service.general.PatientService;
import org.siwoz.service.general.VisitService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/calendar")
public class CalendarController {

	@Resource(name = "calendarService")
	MyCalendarService calendarService;

	@Resource(name = "visitService")
	VisitService visitService;

	@Resource(name = "patientService")
	PatientService patientService;

	@Resource(name = "messageSource")
	MessageSource messageSource;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView myCalendarIndex(Model model) throws IOException {
		calendarService.getMyEvents(3);
		return new ModelAndView(
				"redirect:https://www.google.com/calendar/embed?src=siwoz2014%40gmail.com&ctz=Europe/Warsaw");
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addNewVisit(Model model) throws IOException {
		model.addAttribute("patients", patientService.getAllAsMap());
		model.addAttribute("newVisitBean", new NewVisitBean());
		return "calendar/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView submitVisit(@Valid NewVisitBean newVisitBean,
			BindingResult bindingResult) throws IOException {
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("patients", patientService.getAllAsMap());
			mav.addObject("newVisitBean", newVisitBean);
			return mav;
		}
		visitService.add(newVisitBean, newVisitBean.getPatients());
		ModelAndView mav = new ModelAndView("calendar/add", "result",
				messageSource.getMessage("visitAdded", null, null));
		mav.addObject("newVisitBean", new NewVisitBean());
		return mav;
	}
}
