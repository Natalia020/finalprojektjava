package com.example.projektjava.Controller;

import com.example.projektjava.model.Raport;
import com.example.projektjava.service.RaportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class RaportController {
    @Autowired
    RaportService raportService;

    @RequestMapping("/raport")
    @PreAuthorize("hasAuthority('admin:read')")
    public String home2(Model model) {

        model.addAttribute("reservations", raportService.getAllRaports());

        return"reservations";
    }
}
