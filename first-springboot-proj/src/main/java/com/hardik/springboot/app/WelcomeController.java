package com.hardik.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardik.springboot.app.service.WelcomeService;


@RestController
@ComponentScan("com.hardik.springboot.app")
public class WelcomeController {
	
	@Autowired
	private WelcomeService service;
	
			@RequestMapping("/welcome")
			public String welcome() {
				
				return service.retrieveWelcomeMessage();
			}
			
}

