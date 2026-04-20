package com.SPA_4.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SPA_4.demo.Database.BookingDB;
import com.SPA_4.demo.models.BookingDTO;
import com.SPA_4.demo.repositories.BookingRepository;

@Service
public class BookingService {

private BookingRepository bookingRepository;


public BookingService(BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
}


public BookingDB createBooking(BookingDB bookingDB) {

    return bookingRepository.insert(bookingDB);
}

public List<BookingDB> getAllBookings() {
    return bookingRepository.findAll();
}

}
