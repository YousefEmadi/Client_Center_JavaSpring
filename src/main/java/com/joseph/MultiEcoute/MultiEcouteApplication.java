package com.joseph.MultiEcoute;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;


@SpringBootApplication
public class MultiEcouteApplication {

    public static void main(String[] args) {
//        SpringApplication.run(MultiEcouteApplication.class, args);

        UserPanel userPanel = new UserPanel();
        Controller controller = new Controller();
        ClientsList clientsList = new ClientsList();


        while (true) {
            controller.mainController();
        }

    }
}
