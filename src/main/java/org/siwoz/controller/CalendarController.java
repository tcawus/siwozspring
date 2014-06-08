package org.siwoz.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.siwoz.service.calendar.MyCalendarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/calendar")
public class CalendarController {

	 @Resource(name = "calendarService")
	 MyCalendarService calendarService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String myCalendarIndex(Model model) throws IOException {
		// model.addAttribute("events", personService.getMyEvents());
		return "calendar/index";
	}

	@RequestMapping(value = "/redirect", method = RequestMethod.POST)
	public ModelAndView calendarRedirect(Model model) throws IOException {
		calendarService.putMyEvents(1);
		return new ModelAndView(
				"redirect:https://www.google.com/calendar/embed?src=siwoz2014%40gmail.com&ctz=Europe/Warsaw");
	}
}
