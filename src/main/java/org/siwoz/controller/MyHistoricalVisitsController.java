package org.siwoz.controller;

import java.io.IOException;
import java.security.Principal;

import javax.annotation.Resource;

import org.siwoz.service.general.HistoricalVisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/visits")
public class MyHistoricalVisitsController {

	@Resource(name = "historicalVisitService")
	HistoricalVisitService historicalVisitService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String patientRecord(Model model, Principal principal)
			throws IOException {
		model.addAttribute("records",
				historicalVisitService.getVisitsForUser(principal.getName()));
		return "visits/index";
	}

}
