package com.joseph.MultiEcoute;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ClientsList implements ClientDatabase {

    private List<Client> clientList = new ArrayList<Client>();

    Iterator<Client> itr = clientList.iterator();


    @Override
    public boolean addNewClient(Client newClient) {
        return clientList.add(newClient);
    }

    @Override
    public Client findClient(int id) {
        for (Client cl : clientList) {
            if (cl.id == id) return cl;
        }
        return null;
    }

    @Override
    public boolean removeClient(Client client) {
        return clientList.remove(client);
    }

    @Override
    public boolean writeIntoFile(Client client) {
        try {
            FileWriter myWriter = new FileWriter("src\\main\\resources\\ClientDataFile.txt", true);
            myWriter.write(
            client.id + ";" +
                client.name_first + ";" +
                client.name_last + ";" +
                client.telephone + ";" +
                client.dob + ";" +
                client.gender + ";" +
                client.balance + "\n"
            );
            myWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("something is wrong with file writing");
            e.printStackTrace();
            return false;
        }
    }


/**
    @Override
    public void readFromFile() {
        try {
            File myObj = new File("src\\main\\resources\\ClientDataFile.txt");
            Scanner myReader = new Scanner(myObj);
            System.out.println("\nDatabase content for Clients:");
            while (myReader.hasNextLine()) {
                String data1 = myReader.nextLine();
                String array1[]= data1.split(";");

                field1 = array1[0];
                field2 = Integer.parseInt(array1[1]);
                field3 = Integer.parseInt(array1[2]);
                Boat tempBoat = new Boat(field1, field2, field3);
                boats.add(tempBoat);


            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("something is wrong with reading boat.txt");
            e.printStackTrace();
        }

        for(int i = 0; i < boats.size(); i++) {
            System.out.println(boats.get(i).toString());
        }
**/

} //end of class:ClientsList


