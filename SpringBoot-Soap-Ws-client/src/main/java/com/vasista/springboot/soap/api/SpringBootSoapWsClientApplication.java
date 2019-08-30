package com.vasista.springboot.soap.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JmsProperties.AcknowledgeMode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vasista.springboot.soap.api.client.SoapClient;

@SpringBootApplication
@RestController
public class SpringBootSoapWsClientApplication {
	
	@Autowired
	private SoapClient client;
	
	
	  @PostMapping("/getLoanStatus") public Acknowledgement
	  invokeSoapClient(CustomerRequest request) { return
	  client.getLoanStatus(request); }
	 

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapWsClientApplication.class, args);
	}

}
