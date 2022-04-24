package com.example.javabootcampweek5.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

//passenger tablosu entity classı
@Data
@Entity
@Table
public class Passenger {
    //features - columns
    @Id
    @Column(name = "passenger_ıd", nullable = false)
    private Integer passengerId;

    @Column(name = "age")
    int age;

    @Column(name = "suitcase_weight")
    double suitcaseWeight;

    @Column(name = "gender")
    String gender;

    @Column(name = "seat_no")
    int seatNo;

    @Column(name = "flight_date")
    LocalDate flightDate;

    @Column(name = "ticket_purchase_date")
    LocalDate ticketPurchaseDate;

    @Column(name = "is_business")
    boolean isBusiness;
}
