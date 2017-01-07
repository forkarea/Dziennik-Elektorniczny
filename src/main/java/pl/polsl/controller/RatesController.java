package pl.polsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.polsl.domain.Rates;
import pl.polsl.service.UserRates;

@Controller
public class RatesController {
	
	@Autowired
	UserRates userRatesService;
	
	@RequestMapping(value = "/rates")
	public String home(ModelMap model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		List<Rates> userRates = userRatesService.getUserRates(userName);
		model.addAttribute("userrates", userRates);
		
		return "rates";
	}

}
