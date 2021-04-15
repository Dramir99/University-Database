/*
    Author: Daniel Ramirez
    Purpose: a File IO class that reads a file and can write to a txt file
 */

package university_database;

import contact_information.Address;
import contact_information.PhoneNumber;
import people.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DatabaseFileIO {
    private ArrayList<Person> populate;
    private File inFile;

    public DatabaseFileIO() {
        inFile = new File("nothing");
    }

    public DatabaseFileIO(File test) {
        inFile = test;
    }

    public DatabaseFileIO(ArrayList<Person> test) {
        populate = test;
    }

    public ArrayList<Person> readFile() {
        //set Scanner to null
        Scanner fReader = null;
        //get an array list of the people
        ArrayList<Person> people = new ArrayList<>();
        //get an array list of the phones
        ArrayList<PhoneNumber> phones = new ArrayList<>();

        //test the file
        try {
            fReader = new Scanner(inFile);
        } catch (FileNotFoundException ex) {
//            System.out.println("ERROR! the file could not be found");
        }

        //read the file
        while (fReader.hasNextLine()) {
            String nextLine = fReader.nextLine();

            String[] token = nextLine.split(",");

            //check the first token to see the object type
            for (int i = 0; i < token.length; i++) {


                if (token[i].equalsIgnoreCase("Student")) {

                    phones = new ArrayList<>();
                    if (token[4].startsWith("Apt.")) {
                        String[] split = token[4].split(" ");
                        Student s1 = new Student(token[1], token[2], token[9], new Address(Integer.parseInt(token[3]), Integer.parseInt(split[1]), token[5], token[6], token[7], Integer.parseInt(token[8])), phones, token[10]);

                        people.add(s1);

                    } else {
                        Student s1 = new Student(token[1], token[2], token[8], new Address(Integer.parseInt(token[3]), -9999, token[5], token[6], token[4], Integer.parseInt(token[7])), phones, token[9]);
                        people.add(s1);

                    }


                } else if (token[i].equalsIgnoreCase("Staff")) {

                    phones = new ArrayList<>();

                    if (token[4].startsWith("Apt")) {
                        String[] split = token[4].split(" ");
                        Staff s1 = new Staff(token[1], token[2], token[9], new Address(Integer.parseInt(token[3]), Integer.parseInt(split[1]), token[5], token[6], token[7], Integer.parseInt(token[8])), phones, token[10], Double.parseDouble(token[11]), token[12]);
                        people.add(s1);
                    } else {
                        Staff s1 = new Staff(token[1],token[2],token[8],new Address(Integer.parseInt(token[3]),-9999,token[4],token[5],token[6],Integer.parseInt(token[7])),phones,token[9],Double.parseDouble(token[10]),token[11]);
                        people.add(s1);
                    }

                } else if (token[i].equalsIgnoreCase("Person")) {

                    phones = new ArrayList<>();

                    if (token[4].startsWith("Apt")){
                        String[] split = token[4].split(" ");
                        Person p1 = new Person(token[1],token[2],token[9],new Address(Integer.parseInt(token[3]),Integer.parseInt(split[1]),token[5],token[6],token[7],Integer.parseInt(token[8])),phones);

                        people.add(p1);
                    }
                    else{
                        Person p1 = new Person(token[1],token[2],token[8],new Address(Integer.parseInt(token[3]),-9999,token[4],token[5],token[6],Integer.parseInt(token[7])),phones);

                        people.add(p1);
                    }


                } else if (token[i].equalsIgnoreCase("Employee")) {
                    phones = new ArrayList<>();
                    if(token[4].startsWith("Apt")){
                        String[] split = token[4].split(" ");
                        Employee e1 = new Employee(token[1],token[2],token[9],new Address(Integer.parseInt(token[3]),Integer.parseInt(split[1]),token[5],token[6],token[7],Integer.parseInt(token[8])),phones,token[10],Double.parseDouble(token[11]));
                        people.add(e1);
                    }else{
                        Employee e1 = new Employee(token[1],token[2],token[8],new Address(Integer.parseInt(token[3]),-9999,token[4],token[5],token[6],Integer.parseInt(token[7])),phones,token[9],Double.parseDouble(token[10]));
                        people.add(e1);
                    }


                } else if (token[i].equalsIgnoreCase("Faculty")) {
                    phones = new ArrayList<>();

                    if (token[4].startsWith("Apt.")) {
                        String[] split = token[4].split(" ");
                        Faculty f1 = new Faculty(token[1], token[2], token[9], new Address(Integer.parseInt(token[3]), Integer.parseInt(split[1]), token[5], token[6], token[7], Integer.parseInt(token[8])), phones, token[10], Double.parseDouble(token[11]), token[12], token[13]);
                        people.add(f1);

                    } else {
                        Faculty f1 = new Faculty(token[1],token[2],token[8],new Address(Integer.parseInt(token[3]),-9999,token[4],token[5],token[6],Integer.parseInt(token[7])),phones,token[9],Double.parseDouble(token[10]),token[11],token[12]);
                        people.add(f1);
                    }


                } else if (token[i].equalsIgnoreCase("Phone")) {

                    String[] split = token[2].split("-");
                    PhoneNumber test = new PhoneNumber(token[1], Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                    phones.add(test);
                }


            }

        }


        return people;

    }

    public void writeFile(ArrayList<Person> data){
        //write an array list of people to a txt file
        File create = new File("database_output.txt");

        PrintWriter pw = null;
        populate = data;

        try{
            pw = new PrintWriter(create);
        } catch(FileNotFoundException ex){
            System.out.println("could not find file");
        }
        for (int i = 0; i < populate.size(); i++){
            pw.println(populate.get(i).toString() + "\r");


        }


        pw.close();

    }
}
