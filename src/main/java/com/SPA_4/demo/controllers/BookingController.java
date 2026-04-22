package com.SPA_4.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.SPA_4.demo.Database.BookingDB;
import com.SPA_4.demo.models.BookingDTO;
import com.SPA_4.demo.repositories.BookingRepository;
import com.SPA_4.demo.services.BookingService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {

        this.bookingService = bookingService;
    }

    @PostMapping("/")
    public BookingDB createBooking(@RequestBody BookingDB bookingDB) {

        return bookingService.createBooking(bookingDB);
    }

    @GetMapping("/booking")
    public List<BookingDB> getMethodName() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/booking/id/{id}")
    public Optional<BookingDB> getBookingById(@PathVariable String id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping("/booking/date")
    public List<BookingDB> getBookingByDate(@RequestParam("Date") String date) {
        return bookingService.getBookingByDate(date);

    }
}
