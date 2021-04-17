package com.joseph.MultiEcoute;

import java.util.List;
import java.util.Scanner;


public class UserPanel {
    //variables
    Scanner input = new Scanner(System.in);

    //methods
    public userChoice userMenu() {
        System.out.println("Please, select one of these actions");
        System.out.println("  1. Add a new member");
        System.out.println("  2. Find a member");
        System.out.println("  3. Remove a member");
        System.out.println("  4. List members");
        System.out.println("  5. Backup database");
        System.out.println("  0. Exit from menu");
        int choiceNumber = input.nextInt();
        switch (choiceNumber) {
            case 1 -> {
                return userChoice.ADD;
            }
            case 2 -> {
                return userChoice.FIND;
            }
            case 3 -> {
                return userChoice.REMOVE;
            }
            case 4 -> {
                return userChoice.LIST;
            }
            case 5 -> {
                return userChoice.BACKUP;
            }
            case 0 -> {
                return userChoice.EXIT;
            }
            default -> {
                System.out.println("Please enter an valid option number including 0, 1, 2, 3, 4 and 5\n");
                return userChoice.NONE;
            }
        }
    }

    public String getFilePath() {
        System.out.println("Please enter a full path including file name for new copy of database. Example: src\\main\\resources\\Database.txt");
        String path = input.next();
        return path;
    }


    public Member getNewMember() {
        System.out.print("Please enter id for new member: ");
        int id = input.nextInt();
        input.nextLine(); //to consume left-over line after nextInt

        System.out.print("Please enter member first name: ");
        String fname = input.nextLine();

        System.out.print("Please enter member last name: ");
        String lname = input.nextLine();

        Member member = new Member(id, fname, lname, "(438) 654-7898", fname + "." + lname + "@gmail.com", "2000-01-01", "6500 Forest Hill", 0);
        return newClient;
    }

    public int getIdToSearch() {
        System.out.print("\nPlease enter client id: ");
        int id = input.nextInt();
        return id;
    }

    public void showMember(Member mmbr) {
        System.out.println(
                "\n-------------------------------------" +
                "\nid: " + mmbr.id +
                "\nfirst name: " + mmbr.name_first +
                "\nlast name: " + mmbr.name_last +
                "\nphone: " + mmbr.phone +
                "\nemail: " + mmbr.email +
                "\nDOB: " + mmbr.dob +
                "\naddress: " + mmbr.address +
                "\nbalance: " + mmbr.balance +
                "\n-------------------------------------"
        );
    }

    public void exitMessage() {
        System.out.println("Thank you and Good luck :)");
    }

}


