package ca.lambtoncollege.JavaEEProject.Services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ca.lambtoncollege.JavaEEProject.model.MarketPost;
import ca.lambtoncollege.JavaEEProject.model.PageCounter;

@Configuration
public class PageCountConfig {
	
	@Bean
	public PageCounter pageCounter() {
		return new PageCounter();
	}
	
	@Bean
	public MarketPost marketPost() {
		return new MarketPost();
	}

}

