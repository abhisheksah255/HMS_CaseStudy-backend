package com.abhisheksah.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abhisheksah.model.Reservation;

public interface ReservationRepository extends MongoRepository<Reservation, Integer> {

}
