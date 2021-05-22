package com.hardik.springboot.app.jpa;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class UserCommandLineRunner implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);
	
	
	@Autowired
	private UserRepository H_repo;
	
	@Override
	public void run(String... args) throws Exception {
		

		H_repo.save(new User("Ranga", "Admin"));
        H_repo.save(new User("Ravi", "User"));
        H_repo.save(new User("Satish", "Admin"));
        H_repo.save(new User("Raghu", "User"));
		
        for(User us : H_repo.findAll()) {
        	log.info(us.toString());
        }
        
		System.out.println("UserCommandLineRunner");
		
	}
	

}
