package com.joseph.MultiEcoute;

import java.util.List;
import java.util.Scanner;


public class UserPanel {
    //variables
    Scanner input = new Scanner(System.in);

    //methods
    public userChoice requestUserOption(){
        System.out.println("Please, select one of these actions");
        System.out.println("  1. Add a new client to database");
        System.out.println("  2. Find a client by his/her ID from database");
        System.out.println("  3. Remove a client by his/her ID from current session");
        System.out.println("  4. List all of the clients from database");
        System.out.println("  5. Copy database into a new file");
        System.out.println("  0. Exit from this user panel");
        int choiceNumber = input.nextInt();
        switch (choiceNumber) {
            case 1 -> {return userChoice.CREATE;}
            case 2 -> {return userChoice.FIND;}
            case 3 -> {return userChoice.REMOVE;}
            case 4 -> {return userChoice.LIST;}
            case 5 -> {return userChoice.COPY;}
            case 0 -> {return userChoice.EXIT;}
            default -> {
                System.out.println("Please enter an valid option number including 1, 2, 3 and 4\n");
                return userChoice.NONE;}
        }
    }

    public Client getNewClientToCreate(){
        System.out.print("Please enter id for new client: ");
        int id = input.nextInt();

        System.out.print("Please enter client first name: ");
        String fname = input.next();

        System.out.print("Please enter client last name: ");
        String lname = input.next();

        System.out.print("Please enter client telephone: ");
        String phone = input.next();

        Client newClient = new Client(id,fname,lname,phone,"2000-01-01", "M",0);
        return newClient;
    }

    public int getClientIdToSearch(){
        System.out.print("\nPlease enter client id to start searching: ");
        int id = input.nextInt();
        return id;
    }

    public void showClient(Client clnt) {
        System.out.println(
            "\n-------------------------------------"+
            "\nid: " + clnt.id +
            "\nfirst name: " + clnt.name_first +
            "\nlast name: " + clnt.name_last +
            "\ntelephone: " + clnt.telephone +
            "\nDOB: " + clnt.dob +
            "\ngender: " + clnt.gender +
            "\nbalance: " + clnt.balance +
            "\n-------------------------------------"
        );
    }

    public int getClientIdToRemove(){
        System.out.print("\nPlease enter client id to remove the client from the list: ");
        int id = input.nextInt();
        return id;
    }

    public void showDatabaseClientList(List<Client> list){
        System.out.println("List of all the clients in the database");
        for (Client client: list
             ) {
            showClient(client);
        }
    }

    public String getNewFilePath(){
        System.out.println("Please enter a full path including file name for new copy of database. example: src\\main\\resources\\Database.txt");
        String newFilePath = input.next();
        return newFilePath;
    }
    public void successfulMessage(){
        System.out.println("Your request has been processed successfully\n");
    }

    public void failureMessage(){
        System.out.println("Sorry! your request process has been failed\n");
    }

    public void exitMessage(){
        System.out.println("Good luck and see you next time :)");
    }



}


