package com.example.javabootcampweek6.repository;

import com.example.javabootcampweek6.entity.Plane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//plane repository - connect entity to service by plane id
@Repository
public interface PlaneRepository extends CrudRepository<Plane, Integer> {
}
