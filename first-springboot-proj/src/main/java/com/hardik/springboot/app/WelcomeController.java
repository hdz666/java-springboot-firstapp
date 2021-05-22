package com.hardik.springboot.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardik.springboot.app.configuration.BasicConfiguration;
import com.hardik.springboot.app.service.WelcomeService;


@RestController
@ComponentScan("com.hardik.springboot.app")
public class WelcomeController {
	
	@Autowired
	private WelcomeService service;
	
	@Autowired
	private BasicConfiguration basicConfig;
			@RequestMapping("/welcome")
			public String welcome() {
				
				return service.retrieveWelcomeMessage();
			}
			
			@RequestMapping("/dynamic-config")
			public Map dynamicConfig() {
				Map sad = new HashMap();
				sad.put("message",basicConfig.getMessage());
				sad.put("number", basicConfig.getNumber());
				sad.put("value", basicConfig.isValue());
				return sad;
						}
			
}

