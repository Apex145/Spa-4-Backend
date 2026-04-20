package com.SPA_4.demo.repositories;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.SPA_4.demo.Database.BookingDB;

@Repository
public interface BookingRepository extends MongoRepository<BookingDB, String>{
    
}
