package com.example.javabootcampweek4.repository;

import com.example.javabootcampweek4.entity.Passenger;
import com.example.javabootcampweek4.entity.Plane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//passenger repository - connect entity to service by passenger id
@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Integer> {
    //plane'e göre yolcuların tamamını bulur
    List<Passenger> findAllByPlane(Plane plane);
}
