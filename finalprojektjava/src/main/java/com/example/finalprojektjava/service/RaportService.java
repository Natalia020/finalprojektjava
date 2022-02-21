package com.example.projektjava.service;

import com.example.projektjava.model.Raport;
import com.example.projektjava.model.Reservation;
import com.example.projektjava.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RaportService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<Raport> getAllRaports() {
        List<Reservation> reservations = reservationRepository.findAll();

        return reservations
                .stream()
                .map(reservation -> new Raport(reservation.getFirstName(), reservation.getLastName(), reservation.getService(), reservation.getDate()))
                .collect(Collectors.toList());
    }
}
