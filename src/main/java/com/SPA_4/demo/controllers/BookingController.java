package com.SPA_4.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.SPA_4.demo.Database.BookingDB;
import com.SPA_4.demo.models.BookingDTO;
import com.SPA_4.demo.repositories.BookingRepository;
import com.SPA_4.demo.services.BookingService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

}
