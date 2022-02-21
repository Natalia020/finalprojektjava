package com.example.projektjava.Controller;

import com.example.projektjava.model.Raport;
import com.example.projektjava.service.RaportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@RequestMapping("/admin")
@Controller
public class AdminController {

  @RequestMapping("/admin")
  @PreAuthorize("hasAuthority('admin:read')")
  public String showAccount() {
    return "admin";
  }

  @GetMapping(path = "/mainpage")
  @PreAuthorize("hasAuthority('admin:read')")
  public String redirectToAccount() {
    return "account";
  }


}
