package ca.lambtoncollege.JavaEEProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.lambtoncollege.JavaEEProject.model.PageCounter;

@Controller
public class WelcomeController {
	
	@Autowired
	private PageCounter pageCount;
	
	@GetMapping("/")
	public String welcome(Model model) {
		model.addAttribute("pageCount",pageCount.getPageCount());
		pageCount.increment();
		return "welcome";
	}
	
	
}
