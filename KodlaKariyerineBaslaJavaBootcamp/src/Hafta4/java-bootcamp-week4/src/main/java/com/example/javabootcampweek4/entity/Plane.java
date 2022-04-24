package com.example.javabootcampweek4.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

//plane table - entity
@Data
@Entity
@Table
public abstract class Plane {
    //fetaures - columns
    @Id
    @Column(name = "plane_ıd", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer planeId;

    @Column(name = "passenger_count")
    int passengerCount;

    @Column(name = "capacity")
    int capacity;

    @Column(name = "business_capacity")
    int businessCapacity;

    @Column(name = "fare")
    double fare;

    @Column(name = "flight_date")
    LocalDate flightDate;

    @Column(name = "ticket_purchase_date")
    LocalDate ticketPurchaseDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passenger_id")
    Passenger passenger;

    List<Passenger> passengers;

    //abstract methods
    public abstract int remainderCapacity(int personCount);

    public abstract boolean isItFull();

    public abstract double takeTicket(int personCount);

    public abstract int lastDayCalculation(LocalDate ticketPurchaseDate);






}
