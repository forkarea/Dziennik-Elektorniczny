package pl.polsl.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.polsl.domain.User;
import pl.polsl.service.UserVerification;

@Controller
public class ContactController {
	
	@Autowired
	UserVerification userVerification;

	@RequestMapping(value = "/contact")
	public ModelAndView contact(){
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
