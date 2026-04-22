package com.SPA_4.demo.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.SPA_4.demo.Database.BookingDB;

@Repository
public interface BookingRepository extends MongoRepository<BookingDB, String> {

    List<BookingDB> findByDate(String date);

}
