package com.example.javabootcampweek4.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table
public class Passenger {
    @Id
    @Column(name = "passenger_ıd", nullable = false)
    private Long passengerId;

    @Column(name = "age")
    int age;

    @Column(name = "suitcase_weight")
    double suitcaseWeight;

    @Column(name = "gender")
    String gender;

    @Column(name = "seat_no")
    int seatNo;

    @Column(name = "date")
    LocalDate date;

    @Column(name = "isBusiness")
    boolean isBusiness;
}
