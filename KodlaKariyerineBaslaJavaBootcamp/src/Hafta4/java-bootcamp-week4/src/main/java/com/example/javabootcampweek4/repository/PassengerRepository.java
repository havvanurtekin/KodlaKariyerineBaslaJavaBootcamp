package com.example.javabootcampweek4.repository;

import com.example.javabootcampweek4.entity.Passenger;
import com.example.javabootcampweek4.entity.Plane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Integer> {
    List<Passenger> findAllByPlane(Plane plane);
}
