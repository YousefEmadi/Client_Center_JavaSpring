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

    public static final String DEFAULT_FILE_PATH = "src\\main\\resources\\Database.txt";

    @Override
    public boolean addNewClient(Client newClient) {
        return clientList.add(newClient);
    }



//    @Override
//    public Client findClientFromCurrentSession(int id) {
//        for (Client cl : clientList) {
//            if (cl.id == id) return cl;
//        }
//        return null;
//    }

    @Override
    public Client findClientFromDatabaseClientList(int id) {
        for (Client cl : retrieveDatabaseClientList()) {
            if (cl.id == id) return cl;
        }
        return null;
    }


    @Override
    public boolean removeClientFromList(Client client) {
        return clientList.remove(client);
    }


    @Override
    public boolean writeIntoDatabase(Client client, String filePath) {
        try {
            FileWriter myWriter = new FileWriter(filePath, true);
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
    public List<Client> retrieveDatabaseClientList() {
        try {
            File myObj = new File("src\\main\\resources\\Database.txt");
            Scanner myReader = new Scanner(myObj);
            System.out.println("\n-- Database interaction -- ");

            // create a temporary Arraylist to hold client objects will be created by output stream from file
            List<Client> updateClientList = new ArrayList<Client>();
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
                Client clientToMainList = new Client(id,fname,lname,phone,dob, gender, balance);
                updateClientList.add(clientToMainList);

            }
            myReader.close();
            return updateClientList;
        } catch (FileNotFoundException e) {
            System.out.println("something is wrong with reading boat.txt");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean writeListToDatabaseFile(String newfilePath, List<Client> clientList) {
        for (Client client: clientList
             ) {
            writeIntoDatabase(client, newfilePath);
        }

        return false;
    }

    public void updateDatabaseFile(){

    }

    @Override
    public void deleteDatabaseFile() {
        File myObj = new File("src\\main\\resources\\Database.txt");
        myObj.delete();
    }


} //end of class:ClientsList


