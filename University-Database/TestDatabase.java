/*
    Author: Daniel Ramirez
    Purpose: allow the user to use al the methods in the Database class
 */
package university_database;

import contact_information.Address;
import contact_information.PhoneNumber;
import contact_information.PhoneNumberFormatException;
import people.*;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestDatabase {
	static Database data = new Database(dataBase());

	public static void main(String[] args) {

		while (true) {
			int choice = check();
			System.out.println(option(choice));
		}

	}

	public static int check() {
		// create a scanner
		Scanner in = new Scanner(System.in);

		// have a dummy integer, it will be changed later in the loop
		int choice = -999;

		// create a boolean and set it to false by default
		boolean isValid = false;

		while (isValid == false) {

			// print out my menu
			firstMenu();

			System.out.println("\nWhat would you like Displayed from [1,2]: ");

			// check to make sure the user ONLY enter an integer
			if (in.hasNextInt()) {
				// if the user entered an integer then grab that number
				choice = in.nextInt();

				// check to make sure the number they put is within the
				// boundaries
				if (choice <= 2 && choice >= 1) {

					// if everything is true then i will take thier input
					isValid = true;
				} else {
					// print a new line so their isn't an infinite loop
					in.nextLine();

					// show the error to the user, which is they need to have
					// their number with the boundaries
					System.out.println(
							"---------------------ERROR! please choose a number between[1,2]-------------------\n");
				}
			} else {
				// print next line so their isn't a infinite loop
				in.nextLine();

				// show the user their error, which is they need to input a
				// number
				System.out.println(
						"-------------------------Error! Please enter a number------------------------------\n");
			}
		}

		// return their choice
		return choice;
	}

	public static int checkSecondMenu() {
		// create a scanner
		Scanner in = new Scanner(System.in);

		// have a dummy integer, it will be changed later in the loop
		int choice = -999;

		// create a boolean and set it to false by default
		boolean isValid = false;

		while (isValid == false) {

			// print out my menu
			secondMenu();

			System.out.println("\nWhat would you like Displayed from [1,13]: ");

			// check to make sure the user ONLY enter an integer
			if (in.hasNextInt()) {
				// if the user entered an integer then grab that number
				choice = in.nextInt();

				// check to make sure the number they put is within the
				// boundaries
				if (choice <= 13 && choice >= 1) {

					// if everything is true then i will take thier input
					isValid = true;
				} else {
					// print a new line so their isn't an infinite loop
					in.nextLine();

					// show the error to the user, which is they need to have
					// their number with the boundaries
					System.out.println(
							"---------------------ERROR! please choose a number between[1,13]-------------------\n");
				}
			} else {
				// print next line so their isn't a infinite loop
				in.nextLine();

				// show the user their error, which is they need to input a
				// number
				System.out.println(
						"-------------------------Error! Please enter a number------------------------------\n");
			}
		}

		// return their choice
		return choice;
	}

	public static void firstMenu() {
		System.out.println("-------------Menu-------------");
		System.out.println("|   (1) Enter the database   |");
		System.out.println("|   (2) Quit                 |");
		System.out.println("-------------Menu-------------");
	}

	public static void studentMenu() {
		System.out.println("-------------------Student Menu-------------------");
		System.out.println("|(1) Get Number of Students in the Database      |");
		System.out.println("|(2) Get Number of students by class standing    |");
		System.out.println("-------------------Student Menu-------------------");
	}

	public static void secondMenu() {
		System.out.println("-------------------Database-------------------");
		System.out.println("|   (1) View everyone in the Database        |");
		System.out.println("|   (2) View certain data in the Database  |");
		System.out.println("|   (3) View Student's                       |");
		System.out.println("|   (4) View Employee's                      |");
		System.out.println("|   (5) View Staff                           |");
		System.out.println("|   (6) View Faculty                         |");
		System.out.println("|   (7) View Person's                        |");
		System.out.println("|   (8) Compare People in the Database       |");
		System.out.println("|   (9) Add a person into the Database       |");
		System.out.println("|   (10) Delete a person from the Database   |");
		System.out.println("|   (11) Find someone from the Database      |");
		System.out.println("|   (12) Populate the Database with csv File |");
		System.out.println("|   (13) Write the Database to a txt File 	 |");
		System.out.println("-------------------Database-------------------");
	}

	public static void employeeMenu() {
		System.out.println("-------------------Employee Menu-------------------");
		System.out.println("|(1) Get Number of Employee's in the Database     |");
		System.out.println("|(2) view number of Employee's greater than salary|");
		System.out.println("|(3) view number of Employee's less than salary   |");
		System.out.println("|(4) view number of Employee's equal to salary    |");
		System.out.println("-------------------Employee Menu-------------------");
	}

	public static void staffMenu() {
		System.out.println("-------------------Staff Menu-------------------");
		System.out.println("|(1) Get Number of Staff's in the Database     |");
		System.out.println("-------------------Staff Menu-------------------");
	}

	public static void facultyMenu() {
		System.out.println("-------------------Faculty Menu-------------------");
		System.out.println("|(1) Get Number of Faculty's in the Database     |");
		System.out.println("-------------------Faculty Menu-------------------");
	}

	public static void personMenu() {
		System.out.println("-------------------Person Menu-------------------");
		System.out.println("|(1) Get Number of Person's in the Database     |");
		System.out.println("-------------------Person Menu-------------------");
	}

	public static void addingPeopleMenu(){
		System.out.println("-------------------People---------------------");
		System.out.println("|   (1) Add a Person				         |");
		System.out.println("|   (2) Add a Employee					     |");
		System.out.println("|   (3) Add a Staff	                         |");
		System.out.println("|   (4) Add a Faculty	                     |");
		System.out.println("|   (5) Add a Student                        |");
		System.out.println("-------------------People---------------------");
	}

	public static String option(int choice) {
		String output = "";

		switch (choice) {
		case 1:
			int second = checkSecondMenu();
			output = secondOption(second);
			break;
		case 2:
			// allow the user to break out of the while-loop
			System.out.println("Have a nice day!");
			System.exit(0);
			break;
		default:
			// if their number is not in my switches then this method will run
			check();
			break;
		}

		// return output
		return output;
	}

	public static String secondOption(int choice) {

		String output = "";

		switch (choice) {
		case 1:
			output = data.printDatabase();
			break;
		case 2:
			output = data.printDatabase(askUser());
			break;
		case 3:
			int third = checkStudentMenu();
			output = studentOption(third);
			break;
		case 4:
			int fourth = checkEmployeeMenu();
			output = employeeOption(fourth);
			break;
		case 5:
			int fifth = checkStaffMenu();
			output = staffOption(fifth);
			break;
		case 6:
			int sixth = checkFacultyMenu();
			output = facultyOption(sixth);
			break;
		case 7:
			int seventh = checkPersonMenu();
			output = personOption(seventh);
			break;
		case 8:
			testEqualTo();
			break;
		case 9:
			int ninth = checkAddPersonMenu();

			output = addingOption(ninth);

				break;
		case 10:
			String firstName = checkGetPersonFirstName();
			String lastName = checkGetPersonLastName();

			output = data.deletePerson(firstName,lastName);
				break;
		case 11:
			output = data.findPerson(checkGetPersonFirstName(),checkGetPersonLastName());
				break;
			case 12:
				try {
					data = new Database(getFile());
				} catch (FileNotFoundException e) {
                    System.out.println("A file was not found");
                    System.out.println("You will be sent to the main menu");
					break;
				}
                catch (NullPointerException e) {
                    System.out.println("A file was not chosen");
                    System.out.println("You will be sent to the main menu");
                    break;
                }
				output = "The file has been read";
				break;
            case 13:
                DatabaseFileIO write = new DatabaseFileIO(data);
                write.writeFile(data);

                output = "the file has been written";
                break;
		default:
			checkSecondMenu();
			break;

		}
		return output;
	}

	public static String checkGetPersonFirstName(){
		Scanner in = new Scanner(System.in);

		for(int i = 0; i < data.size(); i++){
			System.out.println( "(" + (i + 1) + "). " + data.get(i).getFirstName() + " " + data.get(i).getLastName());
		}

		System.out.println("what is the person's first name?");
		String firstName = in.nextLine();

		return firstName;
	}

	public static String checkGetPersonLastName(){
		Scanner in = new Scanner(System.in);

		System.out.println("what is the person's last name?");
		String lastName = in.nextLine();

		return lastName;
	}

	public static int checkPersonMenu() {
		// create a scanner
		Scanner in = new Scanner(System.in);

		// have a dummy integer, it will be changed later in the loop
		int choice = -999;

		// create a boolean and set it to false by default
		boolean isValid = false;

		while (isValid == false) {

			// print out my menu
			personMenu();

			System.out.println("\nWhat would you like Displayed from [1]: ");

			// check to make sure the user ONLY enter an integer
			if (in.hasNextInt()) {
				// if the user entered an integer then grab that number
				choice = in.nextInt();

				// check to make sure the number they put is within the
				// boundaries
				if (choice <= 1 && choice >= 1) {

					// if everything is true then i will take thier input
					isValid = true;
				} else {
					// print a new line so their isn't an infinite loop
					in.nextLine();

					// show the error to the user, which is they need to have
					// their number with the boundaries
					System.out.println(
							"---------------------ERROR! please choose a number between[1]-------------------\n");
				}
			} else {
				// print next line so their isn't a infinite loop
				in.nextLine();

				// show the user their error, which is they need to input a
				// number
				System.out.println(
						"-------------------------Error! Please enter a number------------------------------\n");
			}
		}

		// return their choice
		return choice;
	}

	public static int checkFacultyMenu() {
		// create a scanner
		Scanner in = new Scanner(System.in);

		// have a dummy integer, it will be changed later in the loop
		int choice = -999;

		// create a boolean and set it to false by default
		boolean isValid = false;

		while (isValid == false) {

			// print out my menu
			facultyMenu();

			System.out.println("\nWhat would you like Displayed from [1]: ");

			// check to make sure the user ONLY enter an integer
			if (in.hasNextInt()) {
				// if the user entered an integer then grab that number
				choice = in.nextInt();

				// check to make sure the number they put is within the
				// boundaries
				if (choice <= 1 && choice >= 1) {

					// if everything is true then i will take thier input
					isValid = true;
				} else {
					// print a new line so their isn't an infinite loop
					in.nextLine();

					// show the error to the user, which is they need to have
					// their number with the boundaries
					System.out.println(
							"---------------------ERROR! please choose a number between[1,4]-------------------\n");
				}
			} else {
				// print next line so their isn't a infinite loop
				in.nextLine();

				// show the user their error, which is they need to input a
				// number
				System.out.println(
						"-------------------------Error! Please enter a number------------------------------\n");
			}
		}

		// return their choice
		return choice;
	}

	public static int checkStaffMenu() {
		// create a scanner
		Scanner in = new Scanner(System.in);

		// have a dummy integer, it will be changed later in the loop
		int choice = -999;

		// create a boolean and set it to false by default
		boolean isValid = false;

		while (isValid == false) {

			// print out my menu
			staffMenu();

			System.out.println("\nWhat would you like Displayed from [1]: ");

			// check to make sure the user ONLY enter an integer
			if (in.hasNextInt()) {
				// if the user entered an integer then grab that number
				choice = in.nextInt();

				// check to make sure the number they put is within the
				// boundaries
				if (choice <= 1 && choice >= 1) {

					// if everything is true then i will take thier input
					isValid = true;
				} else {
					// print a new line so their isn't an infinite loop
					in.nextLine();

					// show the error to the user, which is they need to have
					// their number with the boundaries
					System.out.println(
							"---------------------ERROR! please choose a number between[1]-------------------\n");
				}
			} else {
				// print next line so their isn't a infinite loop
				in.nextLine();

				// show the user their error, which is they need to input a
				// number
				System.out.println(
						"-------------------------Error! Please enter a number------------------------------\n");
			}
		}

		// return their choice
		return choice;
	}

	public static int checkStudentMenu() {
		// create a scanner
		Scanner in = new Scanner(System.in);

		// have a dummy integer, it will be changed later in the loop
		int choice = -999;

		// create a boolean and set it to false by default
		boolean isValid = false;

		while (isValid == false) {

			// print out my menu
			studentMenu();

			System.out.println("\nWhat would you like Displayed from [1,2]: ");

			// check to make sure the user ONLY enter an integer
			if (in.hasNextInt()) {
				// if the user entered an integer then grab that number
				choice = in.nextInt();

				// check to make sure the number they put is within the
				// boundaries
				if (choice <= 2 && choice >= 1) {

					// if everything is true then i will take thier input
					isValid = true;
				} else {
					// print a new line so their isn't an infinite loop
					in.nextLine();

					// show the error to the user, which is they need to have
					// their number with the boundaries
					System.out.println(
							"---------------------ERROR! please choose a number between[1,2]-------------------\n");
				}
			} else {
				// print next line so their isn't a infinite loop
				in.nextLine();

				// show the user their error, which is they need to input a
				// number
				System.out.println(
						"-------------------------Error! Please enter a number------------------------------\n");
			}
		}

		// return their choice
		return choice;
	}

	public static int checkEmployeeMenu() {
		// create a scanner
		Scanner in = new Scanner(System.in);

		// have a dummy integer, it will be changed later in the loop
		int choice = -999;

		// create a boolean and set it to false by default
		boolean isValid = false;

		while (isValid == false) {

			// print out my menu
			employeeMenu();

			System.out.println("\nWhat would you like Displayed from [1,4]: ");

			// check to make sure the user ONLY enter an integer
			if (in.hasNextInt()) {
				// if the user entered an integer then grab that number
				choice = in.nextInt();

				// check to make sure the number they put is within the
				// boundaries
				if (choice <= 4 && choice >= 1) {

					// if everything is true then i will take thier input
					isValid = true;
				} else {
					// print a new line so their isn't an infinite loop
					in.nextLine();

					// show the error to the user, which is they need to have
					// their number with the boundaries
					System.out.println(
							"---------------------ERROR! please choose a number between[1,4]-------------------\n");
				}
			} else {
				// print next line so their isn't a infinite loop
				in.nextLine();

				// show the user their error, which is they need to input a
				// number
				System.out.println(
						"-------------------------Error! Please enter a number------------------------------\n");
			}
		}

		// return their choice
		return choice;
	}

	public static int checkAddPersonMenu() {
		// create a scanner
		Scanner in = new Scanner(System.in);

		// have a dummy integer, it will be changed later in the loop
		int choice = -999;

		// create a boolean and set it to false by default
		boolean isValid = false;

		while (isValid == false) {

			// print out my menu
			addingPeopleMenu();

			System.out.println("\nWhat would you like Displayed from [1,5]: ");

			// check to make sure the user ONLY enter an integer
			if (in.hasNextInt()) {
				// if the user entered an integer then grab that number
				choice = in.nextInt();

				// check to make sure the number they put is within the
				// boundaries
				if (choice <= 5 && choice >= 1) {

					// if everything is true then i will take thier input
					isValid = true;
				} else {
					// print a new line so their isn't an infinite loop
					in.nextLine();

					// show the error to the user, which is they need to have
					// their number with the boundaries
					System.out.println(
							"---------------------ERROR! please choose a number between[1,5]-------------------\n");
				}
			} else {
				// print next line so their isn't a infinite loop
				in.nextLine();

				// show the user their error, which is they need to input a
				// number
				System.out.println(
						"-------------------------Error! Please enter a number------------------------------\n");
			}
		}

		// return their choice
		return choice;
	}

	public static String addingOption(int choice){
		String output = "";

		switch (choice){
			case 1:
				data.add(addPerson());
				break;
			case 2:
				data.add(addEmployee());
				break;
			case 3:
				data.add(addStaff());
				break;
			case 4:
				data.add(addFaculty());
				break;
			case 5:
				data.add(addStudent());
				break;
			default:
				checkAddPersonMenu();
				break;
		}
		return output;
	}

	public static String personOption(int choice) {
		String output = "";

		switch (choice) {
		case 1:
			output = "Their are " + data.getNumberOfPeople() + " People in the Database";
			break;

		default:
			checkPersonMenu();
			break;

		}
		return output;

	}

	public static String facultyOption(int choice) {
		String output = "";

		switch (choice) {
		case 1:
			output = "Their are " + data.getNumberOfFaculty() + " Faculty in the Database";
			break;

		default:
			checkFacultyMenu();
			break;

		}
		return output;

	}

	public static String studentOption(int choice) {
		String output = "";

		switch (choice) {
		case 1:
			output = "Their are " + data.getNumberOfStudents() + " Student's in the Database";
			break;
		case 2:
			output = "their are " + data.getNumberOfStudentsByClassStanding(classStanding()) + " in that class";
			break;
		default:
			checkStudentMenu();
			break;

		}
		return output;

	}

	public static String staffOption(int choice) {
		String output = "";

		switch (choice) {
		case 1:
			output = "Their are " + data.getNumberOfStaff() + " Staff in the Database";
			break;

		default:
			checkStaffMenu();
			break;

		}
		return output;

	}

	public static String employeeOption(int choice) {
		String output = "";

		switch (choice) {
		case 1:
			output = "their are " + data.getNumberOfEmployees() + " Employee's in the Database";
			break;
		case 2:
			output = data.displayEmployeesGreaterThanSalary(askForSalary());
			break;
		case 3:
			output = data.displayEmployeesLessThanSalary(askForSalary());
			break;
		case 4:
			output = data.displayEmployeesEqualToSalary(askForSalary());
			break;
		default:
			checkEmployeeMenu();
			break;

		}
		return output;
	}

	public static Person addPerson(){

		Person p1 = new Person(askForFirstName(),askForLastName(),askForEmail(),askForAddress(),askForPhoneNumbers());
        System.out.println(p1.getFirstName() + " was added");
		return p1;
	}

	public static Faculty addFaculty(){
	    Faculty f1 = new Faculty(askForFirstName(),askForLastName(),askForEmail(),askForAddress(),askForPhoneNumbers(),askForOfficeLoc(),askForPersonsSalary(),askForOfficeHrs(),askForRank());
        System.out.println(f1.getFirstName() + " was added");
	    return f1;
    }

	public static Employee addEmployee(){
		Employee e1 = new Employee(askForFirstName(),askForFirstName(),askForEmail(),askForAddress(),askForPhoneNumbers(),askForOfficeLoc(),askForPersonsSalary());
        System.out.println(e1.getFirstName() + " was added");
		return e1;

	}

	public static Staff addStaff(){
		Staff s1 = new Staff(askForFirstName(),askForLastName(),askForEmail(),askForAddress(),askForPhoneNumbers(),askForOfficeLoc(),askForPersonsSalary(),askForJobTitle());
        System.out.println(s1.getFirstName() + " was added");
		return s1;
	}

	public static Student addStudent(){
		Student s1 = new Student(askForFirstName(),askForLastName(),askForEmail(),askForAddress(),askForPhoneNumbers(),askForClassStanding());
        System.out.println(s1.getFirstName() + " was added");
		return s1;
	}

	public static String askForOfficeHrs(){
	    Scanner in = new Scanner(System.in);

        System.out.println("What time is the person's office hours?");
        String output = in.nextLine();

        return output;
    }

    public static String askForRank(){
	    Scanner in = new Scanner(System.in);

        System.out.println("what is the rank of the person\npart-time or full-time");
        String output = in.nextLine();

        while(!output.equalsIgnoreCase("part-time") && !output.equalsIgnoreCase("full-time")){
            System.out.println("Person must be either \"part-time\" or \"full-time\"");
            output = in.nextLine();
        }
        return output;
    }

	public static String askForFirstName(){
		Scanner in = new Scanner(System.in);

		System.out.println("What is the person's First Name");
		String output = in.nextLine();

		return output;
	}

	public static String askForLastName(){
		Scanner in = new Scanner(System.in);

		System.out.println("What is the person's Last Name");
		String output = in.nextLine();

		return output;
	}

	public static String askForEmail(){
		Scanner in = new Scanner(System.in);

		System.out.println("What is the person's Email");
		String output = in.nextLine();

		return output;
	}

	public static Address askForAddress(){
		Scanner in = new Scanner(System.in);
        boolean checkStreetNum = true;
		boolean checkAddress = true;
		boolean checkApartNum = true;
		boolean checkZipCode = true;
		boolean hasAddress = false;
		int apartmentNum = -9999;
		int streetNum = 0;
		int zipCode = 0;

		Address personAddress;

		while(checkStreetNum){
		    try{
                System.out.println("What is the person's Street number");
                streetNum = in.nextInt();
                checkStreetNum = false;
            }
            catch(InputMismatchException ex){
                System.out.println("ERROR! Incorrect input: it must be an integer");
                in.nextLine();
            }
        }


		while(checkAddress){
			try {
			System.out.println("Does the Person live in a Apartment\nTrue or False");
			hasAddress = in.nextBoolean();

			in.nextLine();

			checkAddress = false;
			}
			catch(InputMismatchException ex){
				System.out.println("ERROR! Incorrect input: it must be true or false");
				in.nextLine();
			}
		}

		if (!hasAddress){
			apartmentNum = -9999;
		}
		else if (hasAddress){
            while(checkApartNum){
                try{
                    System.out.println("What is the person's Apartment number");
                    apartmentNum = in.nextInt();
                    checkApartNum = false;

                    in.nextLine();
                }
                catch(InputMismatchException ex){
                    System.out.println("ERROR! Incorrect input: it must be an integer");
                    in.nextLine();
                }
            }
		}

		System.out.println("What is the Person's Street Name");
		String streetName = in.nextLine();

		System.out.println("What is the Person's City");
		String city = in.nextLine();

        while(checkZipCode){
            try{
                System.out.println("What is the person's Zip Code");
                zipCode = in.nextInt();
                checkZipCode = false;

                in.nextLine();
            }
            catch(InputMismatchException ex){
                System.out.println("ERROR! Incorrect input: it must be an integer");
                in.nextLine();
            }
        }

		System.out.println("What is the Person's State home");
		String state = in.nextLine();

		personAddress = new Address(streetNum,apartmentNum,streetName,city,state,zipCode);

		return personAddress;
	}

	public static ArrayList<PhoneNumber> askForPhoneNumbers(){
		Scanner in = new Scanner(System.in);
		boolean checkNumber = true;
		boolean hasFormat = true;

		int userNumber = 0;
		String format = "";
		String type = "";

		ArrayList<PhoneNumber> newPersonNumber = new ArrayList<>();

		while (checkNumber){
			try{
				System.out.println("How Many Number's will this person have ?");
				userNumber = in.nextInt();

				checkNumber = false;
			}
			catch (InputMismatchException ex) {

				System.out.println("Incorrect input: an integer is required)");

				in.nextLine(); // discard input

			}

		}

		in.nextLine();

		while(hasFormat){
			for(int i = 0; i < userNumber; i++){
                System.out.println("What is the type of Phone");
                type = in.nextLine();
				try{
					format = askForFormat();

					String[] split = format.split("-");

					newPersonNumber.add(new PhoneNumber(type,Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2])));

				}
				catch (PhoneNumberFormatException ex){
					System.out.println(ex.getMessage());
					i--;

				}
			}
			hasFormat = false;

		}

		return newPersonNumber;
	}

	public static String askForFormat() throws PhoneNumberFormatException{
	    Scanner in = new Scanner(System.in);


        System.out.println("what is the number of the person? ");
        String format = in.nextLine();

        boolean check = format.matches("\\d{3}-\\d{3}-\\d{4}");

        if (check){
            return format;
        }
        else{
            throw new PhoneNumberFormatException("Phone Number must be in the correct format\n123-123-1234");
        }
    }

	public static String askForOfficeLoc(){
		Scanner in = new Scanner(System.in);

		System.out.println("What is the location of the office");
		String offLoc = in.nextLine();

		return offLoc;

	}

	public static double askForPersonsSalary(){
		Scanner in = new Scanner(System.in);
		double salary = 0;
		boolean check = true;

		while(check){
			try{
				System.out.println("What is the person's salary");
				salary = in.nextDouble();

				check = false;
			}
			catch(InputMismatchException ex){
				System.out.println("Incorrect input: an number is needed");
				in.nextLine();
			}
		}


		return salary;
	}

	public static String askForJobTitle(){
		Scanner in = new Scanner(System.in);

		System.out.println("What is the person's Job Title?");
		String output = in.nextLine();

		return output;
	}

	public static String askForClassStanding(){
		Scanner in = new Scanner(System.in);

		System.out.println("What is the Student's class standing?");
		String classStanding = in.nextLine();

		while (!(classStanding.equalsIgnoreCase("Freshman")) && (!classStanding.equalsIgnoreCase("Sophomore"))
				&& !(classStanding.equalsIgnoreCase("Junior")) && !(classStanding.equalsIgnoreCase("Senior"))
				&& !(classStanding.equalsIgnoreCase("Graduate"))) {

			System.out.println(
					"Please enter a class standing from the Database\n Freshman,Sophomore,Junior,Senior,Graduate");
			classStanding = in.nextLine();
		}
		return classStanding;
	}

	public static String askUser() {
		// create a scanner
		Scanner in = new Scanner(System.in);

		System.out.println(
				"\nWho would you like displayed from the Database\n" + "Student,Person,Staff,Employee,Faculty");
		String output = in.nextLine();

		while (!(output.equalsIgnoreCase("Student")) && (!output.equalsIgnoreCase("Faculty"))
				&& !(output.equalsIgnoreCase("Staff")) && !(output.equalsIgnoreCase("Employee"))
				&& !(output.equalsIgnoreCase("Person"))) {

			System.out.println("Please enter someone from the Database\n Student,Person,Staff,Employee,Faculty");
			output = in.nextLine();

		}
		// return their choice
		return output;
	}

	public static int askForSalary() {
		Scanner in = new Scanner(System.in);

		System.out.println("What kind of Salary would you like to see");

		int choice = in.nextInt();

		return choice;

	}

	public static String classStanding() {
		Scanner in = new Scanner(System.in);

		System.out.println("\nWhich class standing would you like to view\n Freshman,Sophomore,Junior,Senior,Graduate");

		String output = in.nextLine();

		while (!(output.equalsIgnoreCase("Freshman")) && (!output.equalsIgnoreCase("Sophomore"))
				&& !(output.equalsIgnoreCase("Junior")) && !(output.equalsIgnoreCase("Senior"))
				&& !(output.equalsIgnoreCase("Graduate"))) {

			System.out.println(
					"Please enter a class standing from the Database\n Freshman,Sophomore,Junior,Senior,Graduate");
			output = in.nextLine();

		}

		return output;

	}

//	public static ArrayList<PhoneNumber> FirstNumber() {
//		ArrayList<PhoneNumber> numbers = new ArrayList<>();
//
//		PhoneNumber p1 = new PhoneNumber("Cell", 310, 876, 7975);
//		PhoneNumber p2 = new PhoneNumber("Cell", 310, 387, 7975);
//
//		numbers.add(p1);
//		numbers.add(p2);
//
//		return numbers;
//	}

//	public static ArrayList<PhoneNumber> SecondNumber() {
//		ArrayList<PhoneNumber> numbers = new ArrayList<>();
//
//		PhoneNumber p1 = new PhoneNumber("Cell", 310, 876, 7975);
//		PhoneNumber p2 = new PhoneNumber("Cell", 310, 387, 7975);
//		PhoneNumber p3 = new PhoneNumber("Home:", 310, 567, 8197);
//
//		numbers.add(p1);
//		numbers.add(p2);
//		numbers.add(p3);
//
//		return numbers;
//	}

//	public static ArrayList<PhoneNumber> ThirdNumber() {
//		ArrayList<PhoneNumber> numbers = new ArrayList<>();
//
//		PhoneNumber p1 = new PhoneNumber("Work", 818, 876, 6543);
//
//		numbers.add(p1);
//
//		return numbers;
//	}

	public static void testEqualTo() {
		Scanner in = new Scanner(System.in);

		System.out.println("who would you like to compare from the class in the list [1,30]");
		int first = in.nextInt();
		while (first <= 0) {
			System.out.println("please choose a number between [1,30]");
			first = in.nextInt();
		}

		System.out.println("Who would you like to compare it to in the list");
		int second = in.nextInt();

		while (second <= 0) {
			System.out.println("please choose a number between [1,30]");
			second = in.nextInt();
		}
		boolean compare = data.get(first - 1).equals(data.get(second - 1));

		System.out.print("the Person in " + first + " index and " + second + " index ");
		System.out.println((compare == true) ? "Is Equal to" : "Is not equal to");

	}

    public static ArrayList<Person> getFile() throws FileNotFoundException{
		//set the file to null
        File inFile = null;

        //use Jframe so the Jfile doesn't open in the background
        JFrame JFileChooserFrame;
        JFileChooserFrame = new JFrame();
        JFileChooserFrame.setVisible(true);
        JFileChooserFrame.setExtendedState(JFrame.ICONIFIED);
        JFileChooserFrame.setExtendedState(JFrame.NORMAL);
        JFileChooser jfc = new JFileChooser(".");

        int jfcUserOption = jfc.showOpenDialog(null);


        if (jfcUserOption == JFileChooser.APPROVE_OPTION){
        	//if they choose the file then get the file and close the JFrame
            inFile = jfc.getSelectedFile();
            JFileChooserFrame.setVisible(false);

            System.out.println("The file you chose was: " + inFile.getName());
        }
        else if(jfcUserOption == JFileChooser.CANCEL_OPTION){
            System.out.println("You chose cancel");
            JFileChooserFrame.setVisible(false);
            throw new NullPointerException();
        }
        else if(jfcUserOption == JFileChooser.ERROR_OPTION){
            System.out.println("There was some error!");
            JFileChooserFrame.setVisible(false);
            throw new FileNotFoundException();
        }
		//set the secnd file to null
        File secondFile = null;
        //check to make sure the file doesn't throw an exception
        boolean keepAsking = true;

        while(keepAsking) {

            try {
                secondFile = inFile;
                keepAsking = false;

            }
            catch(NullPointerException ex){
                System.exit(0);
            }
        }

        DatabaseFileIO test = new DatabaseFileIO(secondFile);

        return test.readFile();

    }

	public static ArrayList<Person> dataBase() {
//		Address a1 = new Address(123, -9999, "Eastern ave", "Los Angeles", "CA", 90249);
//		Address a2 = new Address(310, 13, "Hollywood", "Los Angeles", "CA", 90325);
//		Address a3 = new Address(166, -9999, "plain ave", "Gardenia", "MA", 25467);

		ArrayList<Person> people = new ArrayList<>();
//
//		Student s1 = new Student("Carlos", "Mendoza", "Cmendo77@calstatela.edu", a1, FirstNumber(), "Sophomore");
//		Student s2 = new Student("Daniel", "Ramirez", "default@calstatela.edu", a3, SecondNumber(), "Freshman");
//		Student s3 = new Student("Rafael", "Mendoza", "Rmendo007@calstatela.edu", a3, ThirdNumber(), "Senior");
//		Student s4 = new Student("Gonzo", "Gonzalez", "Ggonzo@calstatela.edu", a1, FirstNumber(), "Junior");
//		Student s5 = new Student();
//		Student s6 = new Student("Alexis", "cerventes", "Clexix@calstatela.edu", a2, SecondNumber(), "Graduate");
//		Student s7 = new Student("Enri-k", "ruiz", "Eruiz@calstatela.edu", a1, ThirdNumber(), "Graduate");
//		Student s8 = new Student("Daniel", "Ramirez", "default@calstatela.edu", a3, FirstNumber(), "Freshman");
//		Student s9 = new Student("Brandon", "Arava", "Barava@calstatela.edu", a2, FirstNumber(), "Senior");
//		Student s10 = new Student("keith", "Quilario", "Kquila@calstatela.edu", a2, ThirdNumber(), "Junior");
//
//		Faculty f1 = new Faculty();
//		Faculty f2 = new Faculty("keenan", "knaur", "knar@caltstatela.edu", a3, SecondNumber(), "E&T A-310", 100000,
//				"Tuesday: 10am - 1:30pm", "full time");
//		Faculty f3 = new Faculty("john", "hurley", "Jhurly@caltstatela.edu", a1, FirstNumber(), "E&T A-310", 75000,
//				"Monday: 10am - 1:30pm", "full time");
//		Faculty f4 = new Faculty("John", "smmith", "Jsmith@calstatela.edu", a1, ThirdNumber(), "King hall 1130A", 50000,
//				"Wednesday: 10am - 1:30pm", "part time");
//		Faculty f5 = new Faculty("valerie", "mendez", "Vmendez@calstatela.edu", a2, FirstNumber(), "Salazar hall 365A",
//				65000, "Tuesday & Thursday: 10am - 1:30pm", "full time");
//		Faculty f6 = new Faculty("ana", "verado", "Aver@calstatela.edu", a1, SecondNumber(), "Physical Science 39B",
//				45000, "Friday: 1pm - 1:30pm", "part time");
//		Faculty f7 = new Faculty("Acer", "tracer", "Atacer@calstatela.edu", a3, SecondNumber(), "Library Palmer wing",
//				51000, "Tuesday: 10am - 1:30pm", "part time");
//		Faculty f8 = new Faculty("lenovo", "over", "Lover@calstatela.edu", a3, FirstNumber(), "E&T A-110", 35000,
//				"Monday & Wednesday: 10am - 1:30pm", "full time");
//		Faculty f9 = new Faculty("jessica", "ferndandez", "Jfern@calstatela.edu", a1, ThirdNumber(), "king hall 3130B",
//				54000, "Tuesday: 10am - 1:30pm", "part time");
//		Faculty f10 = new Faculty();
//
//		Staff staf1 = new Staff("bob", "the builder", "Bder@calstatela.edu", a1, ThirdNumber(), "King hall b350", 32000,
//				"Architect");
//		Staff staf2 = new Staff("Dora", "the explorer", "Dora55@calstatela.edu", a2, SecondNumber(),
//				"Salazar hall B213", 43000, "Head librarian");
//		Staff staf3 = new Staff("trevor", "vero", "vero43@calstatela.edu", a2, FirstNumber(), "E&T A210", 12000,
//				"IT manager");
//		Staff staf4 = new Staff("brianna", "light", "Light55@calstatela.edu", a3, ThirdNumber(), "Biology 245", 11000,
//				"teachers assistance");
//		Staff staf5 = new Staff("omen", "HP", "omen34@calstatela.edu", a1, ThirdNumber(), "king hall C3200", 58000,
//				"Head technician");
//		Staff staf6 = new Staff("mario", "bro", "Mario97@calstatela.edu", a3, SecondNumber(), "Salazar Hall C135",
//				23000, "Head Janitor");
//		Staff staf7 = new Staff("Luigi", "bro", "Luigi97@calstatela.edu", a2, FirstNumber(), "Salazar Hall C135", 10000,
//				"assistance janitor");
//		Staff staf8 = new Staff("Browser", "dino", "dino@calstatela.edu", a2, FirstNumber(), "Salazar Hall B135", 51000,
//				"Coordinator");
//		Staff staf9 = new Staff("mark", "rubio", "Mrubio@calstatela.edu", a3, SecondNumber(), "E&T 440", 23000,
//				"Desk manager");
//		Staff staf10 = new Staff("leanardo", "decaprio", "Lcaprio@calstatela.edu", a1, FirstNumber(), "E&T 550", 97000,
//				"Film producer");
//
//		// 1
//		people.add(f1);
//		// 2
//		people.add(f2);
//		// 3
//		people.add(f3);
//		// 4
//		people.add(f4);
//		// 5
//		people.add(f5);
//		// 6
//		people.add(f6);
//		// 7
//		people.add(f7);
//		// 8
//		people.add(f8);
//		// 9
//		people.add(f9);
//		// 10
//		people.add(f10);
//		// 11
//		people.add(staf1);
//		// 12
//		people.add(staf2);
//		// 13
//		people.add(staf3);
//		// 14
//		people.add(staf4);
//		// 15
//		people.add(staf5);
//		// 16
//		people.add(staf6);
//		// 17
//		people.add(staf7);
//		// 18
//		people.add(staf8);
//		// 19
//		people.add(staf9);
//		// 20
//		people.add(staf10);
//		// 21
//		people.add(s1);
//		// 22
//		people.add(s2);
//		// 23
//		people.add(s3);
//		// 24
//		people.add(s4);
//		// 25
//		people.add(s5);
//		// 26
//		people.add(s6);
//		// 27
//		people.add(s7);
//		// 28
//		people.add(s8);
//		// 29
//		people.add(s9);
//		// 30
//		people.add(s10);
		return people;

	}

}
