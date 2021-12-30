package com.explore.springelastic.common;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.explore.springelastic.entity.Car;
import com.explore.springelastic.repository.CarElasticRepository;
import com.explore.springelastic.service.CarService;

@Component
public class CarElasticDataSource {
	private static final Logger LOG = LoggerFactory.getLogger(CarElasticDataSource.class);
	
	@Autowired
	private CarElasticRepository carRepository;
	
	@Autowired
	@Qualifier("randomCarService")
	private CarService carService;
	
	@Autowired
	@Qualifier("webClientElasticsearch")
	private WebClient webClient;
	
	@EventListener(ApplicationReadyEvent.class)
	public void populateData() {
		var response = webClient.delete().uri("/explore-elastic").retrieve().bodyToMono(String.class).block();
		LOG.info("Delete response: {}", response);
		
		var cars = new ArrayList<Car>();
		for (int i = 0; i < 10_000; i++) {
			cars.add(carService.generateCar());
		}
		
		carRepository.saveAll(cars);
		
		LOG.info("Saved {} cars", carRepository.count());
	}

}
