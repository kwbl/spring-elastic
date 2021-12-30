package com.explore.springelastic.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Document(indexName = "explore-elastic")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Car {
	
	@Id
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonInclude(value = Include.NON_EMPTY )
	private List<String> additionalFeatures;

	private boolean available;
	private String brand;
	
	private String color;
	
	@JsonUnwrapped
	private Engine engine;
	
	@Field(type = FieldType.Date, format = DateFormat.date)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "US/Eastern")
	private LocalDate firstReleaseDate;
	
	private int price;
	
	private List<Tire> tires;
	
	private String type;
	
	@JsonInclude(value = Include.NON_EMPTY )
	private String secretFeature;

	public String getSecretFeature() {
		return secretFeature;
	}

	public void setSecretFeature(String secretFeature) {
		this.secretFeature = secretFeature;
	}

	public Car() {
		
	}

	public Car(String brand, String color, String type) {
		super();
		this.brand = brand;
		this.color = color;
		this.type = type;
	}

	public List<String> getAdditionalFeatures() {
		return additionalFeatures;
	}

	public String getBrand() {
		return brand;
	}
	
	public String getColor() {
		return color;
	}

	public Engine getEngine() {
		return engine;
	}

	public LocalDate getFirstReleaseDate() {
		return firstReleaseDate;
	}

	public int getPrice() {
		return price;
	}

	public List<Tire> getTires() {
		return tires;
	}

	public String getType() {
		return type;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAdditionalFeatures(List<String> additionalFeatures) {
		this.additionalFeatures = additionalFeatures;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public void setFirstReleaseDate(LocalDate firstReleaseDate) {
		this.firstReleaseDate = firstReleaseDate;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setTires(List<Tire> tires) {
		this.tires = tires;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Car [additionalFeatures=" + additionalFeatures + ", available=" + available + ", brand=" + brand
				+ ", color=" + color + ", engine=" + engine + ", firstReleaseDate=" + firstReleaseDate + ", price="
				+ price + ", tires=" + tires + ", type=" + type + ", secretFeature=" + secretFeature + "]";
	}

}
