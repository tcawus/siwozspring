package org.siwoz.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.siwoz.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/calendar")
public class CalendarController {

//	@Resource(name = "personService")
//	PersonService personService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String myCalendarIndex(Model model) throws IOException {
		//model.addAttribute("events", personService.getMyEvents());
		return "calendar";
	}
}
