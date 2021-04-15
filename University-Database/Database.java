/*
    Author: Daniel Ramirez
    Purpose: create a Database where it extends an Array List of Person
 */

package university_database;

import people.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Database extends ArrayList<Person> {

    ArrayList<Person> people;

    public Database() {
        people = this;
    }

    public Database(ArrayList<Person> people) {
        for (int i = 0; i < people.size(); i++) {
            this.add(people.get(i));
        }
    }

    public String printDatabase() {
        String output = "";

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) instanceof Student) {
                output += "-------------------Student-------------------\r\n";
                output += this.get(i).toString();
                output += "-------------------Student-------------------\r\n";
            } else if (this.get(i) instanceof Faculty) {
                output += "-------------------Faculty-------------------\r\n";
                output += this.get(i).toString();
                output += "-------------------Faculty-------------------\r\n";
            } else if (this.get(i) instanceof Staff) {
                output += "-------------------Staff-------------------\r\n";
                output += this.get(i).toString();
                output += "-------------------Staff-------------------\r\n";
            } else if (this.get(i) instanceof Employee) {
                output += "-------------------Employee-------------------\r\n";
                output += this.get(i).toString();
                output += "-------------------Employee-------------------\r\n";
            }else if (this.get(i) instanceof Person) {
                output += "-------------------Person-------------------\r\n";
                output += this.get(i).toString();
                output += "-------------------Person-------------------\r\n";
            }

        }
        if (output.equalsIgnoreCase("")){
            output += "empty";
        }
        return output;
    }

    public String printDatabase(String response) {

        String output = "";

        for (int i = 0; i < this.size(); i++) {

            if (response.equalsIgnoreCase("Student")) {
                if (this.get(i) instanceof Student) {
                    output += "-------------------Student-------------------\r\n";
                    output += this.get(i).toString();
                    output += "-------------------Student-------------------\r\n";
                }
            } else if (response.equalsIgnoreCase("Faculty")) {
                if (this.get(i) instanceof Faculty) {
                    output += "-------------------Faculty-------------------\r\n";
                    output += this.get(i).toString();
                    output += "-------------------Faculty-------------------\r\n";
                }
            } else if (response.equalsIgnoreCase("Staff")) {
                if (this.get(i) instanceof Staff) {
                    output += "-------------------Staff-------------------\r\n";
                    output += this.get(i).toString();
                    output += "-------------------Staff-------------------\r\n";
                }
            } else if (response.equalsIgnoreCase("Employee")) {
                if (this.get(i) instanceof Employee) {
                    output += "-------------------Employee-------------------\r\n";
                    output += this.get(i).toString();
                    output += "-------------------Employee-------------------\r\n";
                }
            } else if (response.equalsIgnoreCase("Person")) {
                if (this.get(i) instanceof Person) {
                    output += "-------------------Person-------------------\r\n";
                    output += this.get(i).toString();
                    output += "-------------------Person-------------------\r\n";
                }
            }

        }

        if (output.equalsIgnoreCase("")) {
            output = "their is no one in the Database";
        }
        return output;
    }

    public int getNumberOfPeople() {
        int person = 0;

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) instanceof Person) {
                person++;
            }
        }
        return person;
    }

    public int getNumberOfStudents() {
        int student = 0;

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) instanceof Student) {
                student++;
            }
        }

        return student;
    }

    public int getNumberOfEmployees() {
        int employee = 0;

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) instanceof Employee) {
                employee++;
            }
        }

        return employee;
    }

    public int getNumberOfStaff() {
        int staff = 0;

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) instanceof Staff) {
                staff++;
            }
        }

        return staff;
    }

    public int getNumberOfFaculty() {
        int faculty = 0;

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) instanceof Faculty) {
                faculty++;
            }
        }
        return faculty;
    }

    public int getNumberOfStudentsByClassStanding(String response) {
        int standing = 0;

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) instanceof Student) {
                Student temp = (Student) this.get(i);

                if (temp.getClassStanding().equalsIgnoreCase(response)) {
                    standing++;
                }
            }
        }

        return standing;
    }

    public String displayEmployeesGreaterThanSalary(int salary) {
        String output = "";

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) instanceof Employee) {
                Employee temp = (Employee) this.get(i);

                if (temp.getSalary() > salary) {
                    output += "-------------------Employee-------------------\r\n";
                    output += temp.toString();
                    output += "-------------------Employee-------------------\r\n";
                }

            }

        }
        if (output.equalsIgnoreCase("")) {
            output += "their are 0 Employee's with a Salary greater than " + salary;
        }

        return output;
    }

    public String displayEmployeesEqualToSalary(int salary) {
        String output = "";

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) instanceof Employee) {
                Employee temp = (Employee) this.get(i);

                if (temp.getSalary() == salary) {
                    output += "-------------------Employee-------------------\r\n";
                    output += temp.toString();
                    output += "-------------------Employee-------------------\r\n";
                }

            }

        }
        if (output.equalsIgnoreCase("")) {
            output += "their are 0 Employee's with a Salary equal to " + salary;
        }

        return output;
    }

    public String displayEmployeesLessThanSalary(int salary) {
        String output = "";

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) instanceof Employee) {
                Employee temp = (Employee) this.get(i);

                if (temp.getSalary() < salary) {
                    output += "-------------------Employee-------------------\r\n";
                    output += temp.toString();
                    output += "-------------------Employee-------------------\r\n";
                }

            }

        }
        if (output.equalsIgnoreCase("")) {
            output += "their are 0 Employee's with a Salary less than " + salary;
        }

        return output;
    }

    public String deletePerson(String firstName, String lastName) {
        Scanner in = new Scanner(System.in);

        ArrayList<Person> deleting = new ArrayList<>();

        int count = 0;
        String output = "";

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFirstName().equalsIgnoreCase(firstName) && this.get(i).getLastName().equalsIgnoreCase(lastName)) {
                count++;
            }
        }

        if (count == 0) {
            output = "their is no one with that name";
        } else if (count == 1) {
            for (int i = 0; i < this.size(); i++) {

                if (this.get(i).getFirstName().equalsIgnoreCase(firstName) && this.get(i).getLastName().equalsIgnoreCase(lastName)) {
                    output = this.get(i).getFirstName() + " was removed";
                    this.remove(this.get(i));
                }
            }
        } else if (count > 1) {

            for (int i = 0, place = 0; i < this.size(); i++) {

                if (this.get(i).getFirstName().equalsIgnoreCase(firstName) && this.get(i).getLastName().equalsIgnoreCase(lastName)) {

                    System.out.println("(" + (++place) + "). " + this.get(i).toString());
                    deleting.add(this.get(i));

                }
            }

            System.out.println("who would you like to delete ?");
            int choice = in.nextInt();

            while (choice <  1 || choice >= deleting.size()) {
                System.out.println("you must choose between [1," + deleting.size() + "]");
                choice = in.nextInt();
            }

            for (int i = 0; i < deleting.size(); i++) {
                for (int j = 0; j < this.size(); j++) {
                    if (deleting.get(choice - 1).equals(this.get(j))) {
                        output = this.get(j).getFirstName() + " was removed";
                        this.remove(this.get(j));
                    }
                }
            }

        }

        return output;
    }

    public String findPerson(String firstName, String lastName) {
        String output = "";

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFirstName().equalsIgnoreCase(firstName) && this.get(i).getLastName().equalsIgnoreCase(lastName)) {

                output += "(" + (i + 1) + "). " + this.get(i).toString();
            }

        }
        if (output.equalsIgnoreCase("")){
            output = "no one was found";
        }
        return output;
    }

}
