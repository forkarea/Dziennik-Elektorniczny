package pl.polsl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.polsl.dao.SubjectDao;
import pl.polsl.dao.UserDao;
import pl.polsl.domain.Subject;
import pl.polsl.domain.User;
import pl.polsl.service.AddRates;
import pl.polsl.service.GetSubject;
import pl.polsl.service.GetUser;
import pl.polsl.service.UserVerification;

@Controller
public class AdminController {

	@Autowired
	GetSubject getSubject;

	@Autowired
	GetUser getUser;
	
	@Autowired
	AddRates addRates; 
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	SubjectDao subjectDao;
	
	@Autowired
	UserVerification userVerification;
	
	@RequestMapping(value = "/admin")
	public ModelAndView adminPage(ModelMap model) {

		List<Subject> subjects = getSubject.getSubject();
		List<User> users = getUser.getUsers();
		model.addAttribute("subjects", subjects);
		model.addAttribute("users", users);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		Optional<User> user = userVerification.getUserByLogin(userName);
		String rolePerLogin = userVerification.getRolePerLogin(userName);
		model.addAttribute("user", user.get());
		model.addAttribute("role", rolePerLogin);

		return new ModelAndView("admin", "model", model);
	}

	@RequestMapping(value = "/addRates")
	public ModelAndView addRatesAdminPage(ModelMap model, @RequestParam("user") String userLogin,
			@RequestParam("subject") String subjectName, @RequestParam("rate") int rate) {

		Optional<User> user = userDao.findByUsername(userLogin);
		Subject subject = subjectDao.findBySubjectName(subjectName);
		
		addRates.addRatesPerUser(user.get(), subject, rate);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		Optional<User> userAuth = userVerification.getUserByLogin(userName);
		String rolePerLogin = userVerification.getRolePerLogin(userName);
		model.addAttribute("user", userAuth.get());
		model.addAttribute("role", rolePerLogin);
		
		return new ModelAndView("admin", "model", model);
	}

}
