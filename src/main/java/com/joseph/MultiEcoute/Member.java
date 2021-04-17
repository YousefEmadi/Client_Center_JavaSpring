package com.joseph.MultiEcoute;

public class Member {
    // attribs:
    int id;
    String name_first;
    String name_last;
    String phone;
    String email;
    String dob;
    String address;
    double balance;


    public Member(int id, String name_first, String name_last, String phone, String email, String dob, String address, double balance) {
        this.id = id;
        this.name_first = name_first;
        this.name_last = name_last;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.balance = balance;
    }
}