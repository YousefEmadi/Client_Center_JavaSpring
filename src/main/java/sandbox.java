

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;


class Boat {

    //1. fields
    private String ownerName;
    private int size;
    private int depth;


    //2. Constructors
    public Boat(String ownerName, int size, int depth) {

        this.ownerName = ownerName;
        this.size = size;
        this.depth = depth;
    }

    public Boat() {

    }


    //3.Setters and Getters
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Boat {ownerName=" + ownerName + ", size=" + size + ", depth=" + depth + "}";
    }


}

class BoatInputData {

    public static void main(String[] args) {

        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        ArrayList<Boat> boats;
        boats = new ArrayList<Boat>();
        String field1;
        int field2, field3;


/**
        try {
            FileWriter myWriter = new FileWriter("src\\main\\resources\\boat.txt", true);
            System.out.println("what is owner name?");
            myWriter.write(input.nextLine()+";");

            System.out.println("what is the size of the boat?");
            myWriter.write(input.nextInt()+";");

            System.out.println("what is the depth of the boat?");
            myWriter.write(input.nextInt()+"\n");
            myWriter.close();


            System.out.println("Writing in the boat.txt has been completed.");
        } catch (IOException e) {
            System.out.println("something is wrong with writing boat.txt");
            e.printStackTrace();
        }
**/

        try {
            File myObj = new File("src\\main\\resources\\boat.txt");
            Scanner myReader = new Scanner(myObj);
            System.out.println("\nDatabase content of boats:");
            while (myReader.hasNextLine()) {
                String data1 = myReader.nextLine();
                System.out.println(data1);
                String array1[]= data1.split(";");
                String name = array1[0];
                int size = Integer.parseInt(array1[1])+100;
                double depth = Float.parseFloat(array1[2])+1.50;

                System.out.println("name"+name);
                System.out.println("size"+size);
                System.out.println("depth"+depth);
                System.out.println(array1.length);
                System.out.println(array1[0]);
                System.out.println(array1[1]);
                System.out.println(array1[2]);

                /*


                field1 = array1[0];
                field2 = Integer.parseInt(array1[1]);
                field3 = Integer.parseInt(array1[2]);
                Boat tempBoat = new Boat(field1, field2, field3);
                boats.add(tempBoat);
*/

            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("something is wrong with reading boat.txt");
            e.printStackTrace();
        }

        /*

        for(int i = 0; i < boats.size(); i++) {
            System.out.println(boats.get(i).toString());
        }

         */

    }

}



