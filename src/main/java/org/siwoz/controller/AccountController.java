package org.siwoz.controller;


import java.io.IOException;
import java.security.Principal;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.siwoz.dao.model.Users;
import org.siwoz.dao.repos.User_rolesRepository;
import org.siwoz.model.forms.account.AccountEditBean;
import org.siwoz.service.account.AccountPropertiesService;
import org.siwoz.service.account.ActiveFormBean;
import org.siwoz.service.general.User_rolesService;
import org.siwoz.service.general.UsersService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

	@Resource(name = "accountPropertiesService")
	AccountPropertiesService accountPropertiesService;

	@Resource(name = "messageSource")
	MessageSource messageSource;
	
	@Resource(name = "usersService")
	UsersService usersService;
	
	@Resource(name = "user_rolesService")
	User_rolesService user_rolesService;

	private AccountEditBean cachedAccountBean;
	private Users currentUser;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editAccount(Model model, Principal principal)
			throws IOException {
		currentUser = usersService.getByEmail(principal.getName());
		cachedAccountBean = accountPropertiesService
				.getCurrentProperties(principal.getName());
		model.addAttribute("accountBean", cachedAccountBean);
		return "account/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView registerFormSubmitted(
			@Valid AccountEditBean accountEditBean, BindingResult bindingResult)
			throws IOException {
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			accountEditBean.clearPasswords();
			mav.addObject("accountBean", cachedAccountBean);
			mav.addObject("editResult",
					messageSource.getMessage("passesNotEqual", null, null));
			return mav;
		}
		accountPropertiesService.updateProperties(currentUser, accountEditBean);
		return new ModelAndView("register", "editResult",
				accountPropertiesService.getUpdateResult());
	}

	@RequestMapping(value = "/active", method = RequestMethod.GET)
	public String usersChooser(Model model) throws IOException {
		model.addAttribute("name", usersService.getAll());
		model.addAttribute("role", user_rolesService.getAll());
		model.addAttribute("activeRecord", new ActiveFormBean());
		return "account/active";
	}

	@RequestMapping(value = "/active", method = RequestMethod.POST)
	public String activeAccount(ActiveFormBean formBean, Model model)
			throws IOException {
		model.addAttribute("name", usersService.getAll());
		model.addAttribute("role", user_rolesService.getAll());
		model.addAttribute("activeRecord", new ActiveFormBean());
		return "account/active";
	}

	@RequestMapping(value = "/edit/delete", method = RequestMethod.POST)
	public String deleteAccount(Model model) throws IOException {
		accountPropertiesService.deleteAccount(currentUser);
		return "index";
	}
}
