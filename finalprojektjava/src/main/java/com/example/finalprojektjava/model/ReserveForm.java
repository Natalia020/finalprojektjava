package com.example.projektjava.model;


import java.time.LocalDate;
import java.util.Date;

public class ReserveForm {
    private String userName;
    private String firstName;
    private String lastName;
    private String service;
    private String date;
    public ReserveForm(){
        super();
    }

    public ReserveForm(String userName, String firstName, String lastName, String service, String date){
        super();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.service = service;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
