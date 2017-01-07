package pl.polsl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RatesController {
	
	@RequestMapping(value = "/rates")
	public String home(){
		return "rates";
	}

}
