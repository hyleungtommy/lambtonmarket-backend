package ca.lambtoncollege.JavaEEProject.model;

import lombok.Getter;

@Getter
public class PageCounter {
	
	private int pageCount;
	public void increment() {
		pageCount ++;
	}

}