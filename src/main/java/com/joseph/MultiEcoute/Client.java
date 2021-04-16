package com.joseph.MultiEcoute;

import java.sql.Date;

public class Client {
    // attribs:
    int id;
    String name_first;
    String name_last;
    String telephone;
    String dob;
    char gender;
    float balance;

    public Client(int id, String name_first, String name_last, String telephone, String dob, char gender, float balance) {
        this.id = id;
        this.name_first = name_first;
        this.name_last = name_last;
        this.telephone = telephone;
        this.dob = dob;
        this.gender = gender;
        this.balance = balance;
    }

}