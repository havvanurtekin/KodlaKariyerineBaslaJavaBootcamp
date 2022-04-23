package com.example.javabootcampweek4.repository;

import com.example.javabootcampweek4.entity.Plane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends CrudRepository<Plane, Integer> {
}
