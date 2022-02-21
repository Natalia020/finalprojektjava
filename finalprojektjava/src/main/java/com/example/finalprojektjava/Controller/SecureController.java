package com.example.projektjava.Controller;

import com.example.projektjava.model.Reservation;
import com.example.projektjava.model.ReserveForm;
import com.example.projektjava.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

//@RestController
//@RequestMapping("/secure")
@Controller
public class SecureController {
    @Autowired
    private ReservationRepository reservationRepository;

  @RequestMapping("/account")
  @PreAuthorize("hasAuthority('user:read')")
  public String showAccount() {
    return "account";
  }

    @GetMapping(path = "/pricelist")
    @PreAuthorize("hasAuthority('user:read')")
    public String redirectToPriceList() {
        return "pricelist";
    }

    @GetMapping(path = "/returntoaccount")
    @PreAuthorize("hasAuthority('user:read')")
    public String redirectToAccount() {
        return "account";
    }

    @GetMapping(path = "/reserve")
    @PreAuthorize("hasAuthority('user:read')")
    public String getReserveForm() {
        return "reserve";
    }

    @PostMapping(path = "/reserve")
    @PreAuthorize("hasAuthority('user:read')")
    public String submitReserveForm(ReserveForm reserveForm) {
        Reservation reservation = null;
        if(null != reserveForm){
            reservation = new Reservation(reserveForm.getUserName(), reserveForm.getFirstName(), reserveForm.getLastName(), reserveForm.getService(), reserveForm.getDate());
        }
        reservationRepository.save(reservation);
        return "reserve-success";
    }









}
