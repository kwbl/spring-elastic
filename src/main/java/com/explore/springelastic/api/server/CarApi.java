package com.explore.springelastic.api.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.explore.springelastic.entity.Car;
import com.explore.springelastic.service.CarService;

@RequestMapping(value = "/api/car/v1")
@RestController
public class CarApi {
	@Autowired
	private CarService carService;
	
	@GetMapping(value = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
	public Car random() {
		return carService.generateCar();
	}
}
