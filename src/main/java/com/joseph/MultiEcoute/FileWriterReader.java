package com.joseph.MultiEcoute;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReader {

    public void WriteIntoFile(Member client) {
        try {
            FileWriter myWriter = new FileWriter("src\\\\main\\resources\\Database.txt", true);
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
        } catch (IOException e) {
            System.out.println("something is wrong with writing boat.txt");
            e.printStackTrace();
        }

    }
}
