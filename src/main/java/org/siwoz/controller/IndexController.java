package org.siwoz.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.siwoz.model.MyUserType;
import org.siwoz.model.forms.auth.UserParameters;
import org.siwoz.model.forms.register.RegisterBean;
import org.siwoz.service.index.AccountManagerService;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@Resource(name = "accountManagerService")
	AccountManagerService accountManagerService;

	@Resource(name = "messageSource")
	MessageSource messageSource;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) throws IOException {
		model.addAttribute("userParameters", new UserParameters());
		model.addAttribute("title", "Spring Security Hello World");
		model.addAttribute("message", "This is user page!");
		return "index";
	}

	// @RequestMapping(value = "/", method = RequestMethod.POST)
	// public String loginFormSubmitted(@Valid UserParameters userParameters,
	// BindingResult bindingResult) throws IOException {
	// // tu jest potrzebna walidacja?
	// return "index";
	// }

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerIndex(Model model) throws IOException {
		model.addAttribute("userType", MyUserType.toMap());
		model.addAttribute("registerBean", new RegisterBean());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerFormSubmitted(@Valid RegisterBean registerBean,
			BindingResult bindingResult) throws IOException {
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			registerBean.clearPasswords();
			mav.addObject("userType", MyUserType.toMap());
			mav.addObject("registerBean", registerBean);
			mav.addObject("registrationResult",
					messageSource.getMessage("passesNotEqual", null, null));
			return mav;
		}
		accountManagerService.checkIfUserExistsUN(registerBean.getUsername());
		accountManagerService.register(registerBean);
		return new ModelAndView("register", "registrationResult",
				accountManagerService.getRegistrationResult());
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}
}
