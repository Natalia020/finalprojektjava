package com.example.projektjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Raport {
    public String firstName;
    public String lastName;
    public String service;
    public String date;
}
