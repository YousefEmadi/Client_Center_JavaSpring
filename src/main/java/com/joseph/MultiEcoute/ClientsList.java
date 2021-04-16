package com.joseph.MultiEcoute;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientsList implements ClientDatabase {

    private List<Client> clientList = new ArrayList<Client>();


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



    @Override
    public List<Client> readFromDatabaseFile() {
        try {
            File myObj = new File("src\\main\\resources\\ClientDataFile.txt");
            Scanner myReader = new Scanner(myObj);
            System.out.println("\nDatabase content for Clients:");

            // create a temporary Arraylist to hold client objects will be created by output stream from file
            List<Client> tempClientList = new ArrayList<Client>();
            while (myReader.hasNextLine()) {

                // temporary Array from raw file data to create client objects
                String rawData = myReader.nextLine();
                String[] tempArray = rawData.split(";");

                int id = Integer.parseInt(tempArray[0]);
                String fname = tempArray[1];
                String lname = tempArray[2];
                String phone = tempArray[3];
                String dob = tempArray[4];
                String gender = tempArray[5];
                double balance = Double.parseDouble(tempArray[6]);
                Client clientToTempList = new Client(id,fname,lname,phone,dob, gender, balance);
                tempClientList.add(clientToTempList);

            }
            myReader.close();
            return tempClientList;
        } catch (FileNotFoundException e) {
            System.out.println("something is wrong with reading boat.txt");
            e.printStackTrace();
        }

        return null;
    }


} //end of class:ClientsList


