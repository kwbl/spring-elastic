package com.explore.springelastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.explore.springelastic.entity.Car;

@Repository
public interface CarElasticRepository extends ElasticsearchRepository<Car, String>{

}
