package DataBase;

import java.util.ArrayList;

import contact_information.Address;
import contact_information.PhoneNumber;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import people.Faculty;
import people.Person;
import people.Staff;
import people.Student;
import university_database.GUIDatabase;

public class CreateMainMenuDataBase extends BorderPane {
	static GUIDatabase data = new GUIDatabase(dataBase());
	Stage mainMenuStage;
	Text title;
	VBox menu;
	
	public GUIDatabase getData() {
		return data;
	}

	public void GUIsetData(GUIDatabase data) {
		this.data = data;
	}

	public Stage getMainMenuStage() {
		return mainMenuStage;
	}

	public void setMainMenuStage(Stage mainMenuStage) {
		this.mainMenuStage = mainMenuStage;
	}

	public Text getTitle() {
		return title;
	}

	public void setTitle(Text title) {
		this.title = title;
	}

	public VBox getMenu() {
		return menu;
	}

	public void setMenu(VBox menu) {
		this.menu = menu;
	}

	public CreateMainMenuDataBase(){
		Insets seperateWindow = new Insets(10,10,10,10);
		mainMenuStage = new Stage();
		menu = options();
		title = DataBaseTitle();
		
		menu.setAlignment(Pos.CENTER);
		
		this.getStylesheets().add("Style/Effects.css");
		this.getStyleClass().add("secondMenuBackGround");
		this.setCenter(menu);
		this.setAlignment(title, Pos.TOP_CENTER);
		this.setTop(title);
		this.setPadding(seperateWindow);
		
		Scene scene = new Scene(this,800,800);
		mainMenuStage.setScene(scene);
		mainMenuStage.setTitle("DataBase");
		mainMenuStage.sizeToScene();
		mainMenuStage.show();
	}
	
	public VBox options(){
    	
        VBox position = new VBox();
        position.setSpacing(20);
        
        Button bt_FindPerson = new Button("Find a Person in the Database");
        Button bt_ComparePeople = new Button("Compare People in the Database ");
        Button bt_AddPerson = new Button("Add a person into the Database");
        Button bt_DeletePerson = new Button("Delete a person from the Database");
        Button bt_UseCSVFile = new Button("Populate the Database with csv File");
        Button bt_back = new Button("Back");
        
        bt_ComparePeople.setEffect(ds());
        bt_ComparePeople.getStyleClass().add("mainMenuButton");
        
        bt_AddPerson.setEffect(ds());
        bt_AddPerson.getStyleClass().add("mainMenuButton");
        
        bt_DeletePerson.setEffect(ds());
        bt_DeletePerson.getStyleClass().add("mainMenuButton");
        
        bt_FindPerson.setEffect(ds());
        bt_FindPerson.getStyleClass().add("mainMenuButton");
        
        bt_UseCSVFile.setEffect(ds());
        bt_UseCSVFile.getStyleClass().add("mainMenuButton");

        bt_back.setEffect(ds());
        bt_back.getStyleClass().add("mainMenuButton");
        
        position.getChildren().addAll(bt_FindPerson,bt_ComparePeople,
        								bt_AddPerson,bt_DeletePerson,
        								bt_UseCSVFile,
                                        bt_back);
        
        
        bt_FindPerson.setOnAction(e ->{
        	FindPersonGUI person = new FindPersonGUI();
        	mainMenuStage.close();
        	
        });
        
		bt_ComparePeople.setOnAction(e ->{
			ComparePeopleGUI comparePeople = new ComparePeopleGUI();
			mainMenuStage.close();
		});
		bt_AddPerson.setOnAction(e ->{
			AddPersonGUI addPerson = new AddPersonGUI();
			mainMenuStage.close();
		});
		bt_DeletePerson.setOnAction(e ->{
			DeletePersonGUI deletePerson = new DeletePersonGUI();
		});
		
		bt_UseCSVFile.setOnAction(e ->{
			UseCSVFileGUI populate = new UseCSVFileGUI();
			mainMenuStage.close();
		});
		bt_back.setOnAction(event -> {
		    CreateMenuDataBase menuBack = new CreateMenuDataBase();
		    mainMenuStage.close();
        });
        
        

        return position;
    }
	
	 public Text DataBaseTitle(){
	        Text title = new Text(75,75,"DataBase");
	        title.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD,45));
	        title.setFill(Color.WHITE);
	        title.setEffect(reflection());

	        return title;
	    }
	
	public Reflection reflection(){
    	Reflection reflection = new Reflection();
    	reflection.setFraction(0.8);
    	reflection.setTopOffset(-20);
    	
    	return reflection;
    }
    
    public DropShadow ds(){
    	DropShadow ds = new DropShadow();
    	ds.setOffsetX(5.0);
    	ds.setOffsetY(5.0);
    	ds.setColor(Color.GRAY);
    	return ds;
    }
	
	public Text title(){
		Text title = new Text(75,75,"DataBase");
        title.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD,45));
        title.setFill(Color.WHITE);
        title.setEffect(reflection());

        return title;
	}
	
	public static ArrayList<PhoneNumber> FirstNumber() {
		ArrayList<PhoneNumber> numbers = new ArrayList<>();

		PhoneNumber p1 = new PhoneNumber("Cell", 310, 876, 7975);
		PhoneNumber p2 = new PhoneNumber("Cell", 310, 387, 7975);

		numbers.add(p1);
		numbers.add(p2);

		return numbers;
	}

	public static ArrayList<PhoneNumber> SecondNumber() {
		ArrayList<PhoneNumber> numbers = new ArrayList<>();

		PhoneNumber p1 = new PhoneNumber("Cell", 310, 876, 7975);
		PhoneNumber p2 = new PhoneNumber("Cell", 310, 387, 7975);
		PhoneNumber p3 = new PhoneNumber("Home:", 310, 567, 8197);

		numbers.add(p1);
		numbers.add(p2);
		numbers.add(p3);

		return numbers;
	}

	public static ArrayList<PhoneNumber> ThirdNumber() {
		ArrayList<PhoneNumber> numbers = new ArrayList<>();

		PhoneNumber p1 = new PhoneNumber("Work", 818, 876, 6543);

		numbers.add(p1);

		return numbers;
	}
	
	public static ArrayList<Person> dataBase() {
		Address a1 = new Address(123, -9999, "Eastern ave", "Los Angeles", "CA", 90249);
		Address a2 = new Address(310, 13, "Hollywood", "Los Angeles", "CA", 90325);
		Address a3 = new Address(166, -9999, "plain ave", "Gardenia", "MA", 25467);

		ArrayList<Person> people = new ArrayList<>();

		Student s1 = new Student("Carlos", "Mendoza", "Cmendo77@calstatela.edu", a1, FirstNumber(), "Sophomore");
		Student s2 = new Student("Daniel", "Ramirez", "default@calstatela.edu", a3, SecondNumber(), "Freshman");
		Student s3 = new Student("Rafael", "Mendoza", "Rmendo007@calstatela.edu", a3, ThirdNumber(), "Senior");
		Student s4 = new Student("Gonzo", "Gonzalez", "Ggonzo@calstatela.edu", a1, FirstNumber(), "Junior");
		Student s5 = new Student();
		Student s6 = new Student("Alexis", "cerventes", "Clexix@calstatela.edu", a2, SecondNumber(), "Graduate");
		Student s7 = new Student("Enri-k", "ruiz", "Eruiz@calstatela.edu", a1, ThirdNumber(), "Graduate");
		Student s8 = new Student("Lili", "Sana", "default@calstatela.edu", a3, FirstNumber(), "Freshman");
		Student s9 = new Student("Brandon", "Arava", "Barava@calstatela.edu", a2, FirstNumber(), "Senior");
		Student s10 = new Student("keith", "Quilario", "Kquila@calstatela.edu", a2, ThirdNumber(), "Junior");

		Faculty f1 = new Faculty();
		Faculty f2 = new Faculty("keenan", "knaur", "knar@caltstatela.edu", a3, SecondNumber(), "E&T A-310", 100000,
				"Tuesday: 10am - 1:30pm", "full time");
		Faculty f3 = new Faculty("john", "hurley", "Jhurly@caltstatela.edu", a1, FirstNumber(), "E&T A-310", 75000,
				"Monday: 10am - 1:30pm", "full time");
		Faculty f4 = new Faculty("John", "smmith", "Jsmith@calstatela.edu", a1, ThirdNumber(), "King hall 1130A", 50000,
				"Wednesday: 10am - 1:30pm", "part time");
		Faculty f5 = new Faculty("valerie", "mendez", "Vmendez@calstatela.edu", a2, FirstNumber(), "Salazar hall 365A",
				65000, "Tuesday & Thursday: 10am - 1:30pm", "full time");
		Faculty f6 = new Faculty("ana", "verado", "Aver@calstatela.edu", a1, SecondNumber(), "Physical Science 39B",
				45000, "Friday: 1pm - 1:30pm", "part time");
		Faculty f7 = new Faculty("Acer", "tracer", "Atacer@calstatela.edu", a3, SecondNumber(), "Library Palmer wing",
				51000, "Tuesday: 10am - 1:30pm", "part time");
		Faculty f8 = new Faculty("lenovo", "over", "Lover@calstatela.edu", a3, FirstNumber(), "E&T A-110", 35000,
				"Monday & Wednesday: 10am - 1:30pm", "full time");
		Faculty f9 = new Faculty("jessica", "ferndandez", "Jfern@calstatela.edu", a1, ThirdNumber(), "king hall 3130B",
				54000, "Tuesday: 10am - 1:30pm", "part time");
		Faculty f10 = new Faculty();

		Staff staf1 = new Staff("bob", "the builder", "Bder@calstatela.edu", a1, ThirdNumber(), "King hall b350", 32000,
				"Architect");
		Staff staf2 = new Staff("Dora", "the explorer", "Dora55@calstatela.edu", a2, SecondNumber(),
				"Salazar hall B213", 43000, "Head librarian");
		Staff staf3 = new Staff("trevor", "vero", "vero43@calstatela.edu", a2, FirstNumber(), "E&T A210", 12000,
				"IT manager");
		Staff staf4 = new Staff("brianna", "light", "Light55@calstatela.edu", a3, ThirdNumber(), "Biology 245", 11000,
				"teachers assistance");
		Staff staf5 = new Staff("omen", "HP", "omen34@calstatela.edu", a1, ThirdNumber(), "king hall C3200", 58000,
				"Head technician");
		Staff staf6 = new Staff("mario", "bro", "Mario97@calstatela.edu", a3, SecondNumber(), "Salazar Hall C135",
				23000, "Head Janitor");
		Staff staf7 = new Staff("Luigi", "bro", "Luigi97@calstatela.edu", a2, FirstNumber(), "Salazar Hall C135", 10000,
				"assistance janitor");
		Staff staf8 = new Staff("Browser", "dino", "dino@calstatela.edu", a2, FirstNumber(), "Salazar Hall B135", 51000,
				"Coordinator");
		Staff staf9 = new Staff("mark", "rubio", "Mrubio@calstatela.edu", a3, SecondNumber(), "E&T 440", 23000,
				"Desk manager");
		Staff staf10 = new Staff("leanardo", "decaprio", "Lcaprio@calstatela.edu", a1, FirstNumber(), "E&T 550", 97000,
				"Film producer");

		// 1
		people.add(f1);
		// 2
		people.add(f2);
		// 3
		people.add(f3);
		// 4
		people.add(f4);
		// 5
		people.add(f5);
		// 6
		people.add(f6);
		// 7
		people.add(f7);
		// 8
		people.add(f8);
		// 9
		people.add(f9);
		// 10
		people.add(f10);
		// 11
		people.add(staf1);
		// 12
		people.add(staf2);
		// 13
		people.add(staf3);
		// 14
		people.add(staf4);
		// 15
		people.add(staf5);
		// 16
		people.add(staf6);
		// 17
		people.add(staf7);
		// 18
		people.add(staf8);
		// 19
		people.add(staf9);
		// 20
		people.add(staf10);
		// 21
		people.add(s1);
		// 22
		people.add(s2);
		// 23
		people.add(s3);
		// 24
		people.add(s4);
		// 25
		people.add(s5);
		// 26
		people.add(s6);
		// 27
		people.add(s7);
		// 28
		people.add(s8);
		// 29
		people.add(s9);
		// 30
		people.add(s10);
		return people;

	}
}
