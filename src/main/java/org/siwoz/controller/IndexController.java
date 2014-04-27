package org.siwoz.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Resource;

import org.siwoz.dao.model.Person;
import org.siwoz.service.IService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@Resource(name = "personService")
	IService<Person> personService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) throws IOException {
		Person person = new Person();
		person.setName("Jan");
		person.setSurname("Nowak");
		person.setPass("haslo");
		person.setPesel("234566543");
		model.addAttribute("persons", Arrays.asList(person));
		return "index";
	}
}
