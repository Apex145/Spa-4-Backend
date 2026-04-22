package com.SPA_4.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public Optional<BookingDB> getBookingById(String id) {
        return bookingRepository.findById(id);
    }

    public List<BookingDB> getBookingByDate(String date) {
        return bookingRepository.findByDate(date);
    }

}
