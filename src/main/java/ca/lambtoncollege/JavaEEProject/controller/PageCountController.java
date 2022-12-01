package ca.lambtoncollege.JavaEEProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.lambtoncollege.JavaEEProject.model.PageCounter;

@RestController
public class PageCountController {
	@Autowired
	private PageCounter pageCount;
	
	@GetMapping("/currentcount")
	public String getCurrentCount() {
		return Integer.toString(pageCount.getPageCount());
	}
}

