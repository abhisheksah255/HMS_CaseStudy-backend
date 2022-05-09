package com.abhisheksah.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abhisheksah.model.Reservation;

@Repository
public interface ReservationRepository extends MongoRepository<Reservation, Long>{

}
