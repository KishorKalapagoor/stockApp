package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class responsible for bootstrapping spring-boot configuration.
 * @author kishor kalapagoor
 */
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
	 System.getProperties().put( "server.port", 9090);
    SpringApplication.run(Application.class, args);
  }

}
