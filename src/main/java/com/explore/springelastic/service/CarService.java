package com.explore.springelastic.service;

import java.util.List;

import com.explore.springelastic.entity.Car;

public interface CarService {
	List<String> BRANDS = List.of("Toyota", "Honda", "Ford");
	
	List<String> COLORS = List.of("Red", "Black", "White");
	
	List<String> TYPES = List.of("SUV", "Sedan", "MPV");
	
	List<String> ADDITIONAL_FEATURES = List.of("GPS", "Alarm", "Sunroof", "Media player", "Leather seats");
	
	Car generateCar();
	
}
