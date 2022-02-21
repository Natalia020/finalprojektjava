package com.example.projektjava.Controller;

import com.example.projektjava.model.Reservation;
import com.example.projektjava.model.ReserveForm;
import com.example.projektjava.model.User;
import com.example.projektjava.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class PublicController<principal> {

    @GetMapping("/logged")
    public String currentUsername(Authentication authentication) {
        String user = authentication.getName();
        return "account";
    }

    @GetMapping("/")
    public String redirectToLoginPage() {
        return "redirect:/login";
    }

}
