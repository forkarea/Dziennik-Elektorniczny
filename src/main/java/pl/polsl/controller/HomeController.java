package pl.polsl.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.polsl.domain.Role;
import pl.polsl.domain.User;
import pl.polsl.service.UserVerification;

@Controller
public class HomeController {
	
	@Autowired
	UserVerification userVerification;

	@RequestMapping(value = "/")
	public ModelAndView home(){
		ModelAndView model = new ModelAndView("contact") ;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		Optional<User> user = userVerification.getUserByLogin(userName);
		String rolePerLogin = userVerification.getRolePerLogin(userName);
		model.addObject("user", user.get());
		model.addObject("role", rolePerLogin);
		return model;
	}

}
