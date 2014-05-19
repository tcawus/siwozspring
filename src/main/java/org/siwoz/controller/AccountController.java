package org.siwoz.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.siwoz.service.index.AccountManagerService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

	@Resource(name = "accountManagerService")
	AccountManagerService accountManagerService;

	@Resource(name = "messageSource")
	MessageSource messageSource;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editAccount(Model model) throws IOException {
		// add accountBean which is registerBean
		return "account/edit";
	}

//	@RequestMapping(value = "/edit", method = RequestMethod.POST)
//	public ModelAndView submitEditAccount(@Valid RegisterBean registerBean,
//			BindingResult bindingResult) throws IOException {
//		if (bindingResult.hasErrors()) {
//			ModelAndView mav = new ModelAndView();
//			registerBean.clearPasswords();
//			mav.addObject("userType", MyUserType.toMap());
//			mav.addObject("accountBean", registerBean);
//			mav.addObject("registrationResult",
//					messageSource.getMessage("passesNotEqual", null, null));
//			return mav;
//		}
//		accountManagerService.checkIfUserExists(registerBean.getEmail());
//		accountManagerService.register(registerBean);
//		return new ModelAndView("register", "registrationResult",
//				accountManagerService.getRegistrationResult());
//	}

	@RequestMapping(value = "/edit/delete", method = RequestMethod.POST)
	public String deleteAccount(Model model) throws IOException {
		System.out.println("a");
		// accountManagerService.deleteAccount();
		return "index";
	}
}
