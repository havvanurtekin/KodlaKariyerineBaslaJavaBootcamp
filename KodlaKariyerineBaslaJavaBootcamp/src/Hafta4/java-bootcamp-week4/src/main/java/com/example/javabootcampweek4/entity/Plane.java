package com.example.javabootcampweek4.entity;

import com.example.javabootcampweek4.service.PassengerService;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table
public abstract class Plane {
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

    public abstract int remainderCapacity(int personCount);

    public abstract boolean isItFull();

    public abstract double takeTicket(int personCount);

    public abstract int lastDayCalculation(LocalDate ticketPurchaseDate);

    public abstract void removePassenger(int passengerId);




}
