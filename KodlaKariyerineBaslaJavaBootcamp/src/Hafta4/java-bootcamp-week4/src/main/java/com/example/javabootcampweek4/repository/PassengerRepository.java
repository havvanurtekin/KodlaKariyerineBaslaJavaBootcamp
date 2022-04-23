package com.example.javabootcampweek4.repository;

import com.example.javabootcampweek4.entity.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Integer> {
}
