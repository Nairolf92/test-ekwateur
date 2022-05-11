package com.example.testekwateur;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.testekwateur.model.Offer;

@SpringBootApplication
public class TestEkwateurApplication implements CommandLineRunner{
	
    private static Logger LOG = LoggerFactory
    	      .getLogger(TestEkwateurApplication.class);

	public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(TestEkwateurApplication.class, args);
        LOG.info("APPLICATION FINISHED");
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		ArrayList<Offer> offerList = new ArrayList<Offer>();
		return args -> {
			offerList = restTemplate.getForObject(
					"https://601025826c21e10017050013.mockapi.io/ekwatest/offerList", Offer.class);
			LOG.info(offerList.toString());
		};
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
