package DataBase;

import contact_information.Address;
import contact_information.PhoneNumber;
import contact_information.PhoneNumberFormatException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import people.*;

import java.util.ArrayList;

public class AddPersonGUI extends BorderPane {
    Stage AddPersonStage;
    GridPane AddPersonGrid;
    Text AddPersonTitle;
    int row;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public AddPersonGUI() {

        Insets seperateWindow = new Insets(10, 10, 10, 10);
        AddPersonStage = new Stage();
        AddPersonGrid = Person();
        AddPersonTitle = DataBaseTitle();

        AddPersonGrid.setAlignment(Pos.CENTER);

        this.getStylesheets().add("Style/Effects.css");
        this.getStyleClass().add("addMenuBackGround");

        this.setCenter(AddPersonGrid);
        setAlignment(AddPersonTitle, Pos.TOP_CENTER);
        this.setTop(AddPersonTitle);
        this.setPadding(seperateWindow);

        Scene scene = new Scene(this, 803, 525);
        AddPersonStage.setScene(scene);
        AddPersonStage.setTitle("DataBase");
        AddPersonStage.setResizable(false);
        AddPersonStage.show();
    }

    public GridPane Person() {
        GridPane peoplePosition = new GridPane();

        peoplePosition.setHgap(10);
        peoplePosition.setVgap(10);


        Button bt_Person = new Button("Person");
        Button bt_Employee = new Button("Employee");
        Button bt_Staff = new Button("Staff");
        Button bt_Faculty = new Button("Faculty");
        Button bt_Student = new Button("Student");
        Button bt_back = new Button("Back");


        bt_Person.setEffect(ds());
        bt_Person.getStyleClass().add("mainMenuButton");

        bt_Employee.setEffect(ds());
        bt_Employee.getStyleClass().add("mainMenuButton");

        bt_Staff.setEffect(ds());
        bt_Staff.getStyleClass().add("mainMenuButton");

        bt_Faculty.setEffect(ds());
        bt_Faculty.getStyleClass().add("mainMenuButton");

        bt_Student.setEffect(ds());
        bt_Student.getStyleClass().add("mainMenuButton");

        bt_back.setEffect(ds());
        bt_back.getStyleClass().add("mainMenuButton");

        peoplePosition.add(bt_Person, 0, 0);
        peoplePosition.add(bt_Employee, 0, 1);
        peoplePosition.add(bt_Staff, 0, 2);
        peoplePosition.add(bt_Faculty, 0, 3);
        peoplePosition.add(bt_Student, 0, 4);
        peoplePosition.add(bt_back, 0, 5);

        bt_Person.setOnAction(e -> {
            createPerson(bt_Person.getText());
                });
        bt_Employee.setOnAction(e ->{
            createPerson(bt_Employee.getText());
        });
        bt_Staff.setOnAction(e ->{
            createPerson(bt_Staff.getText());
        });
        bt_Faculty.setOnAction(e ->{
            createPerson(bt_Faculty.getText());
        });
        bt_Student.setOnAction(e ->{
            createPerson(bt_Student.getText());
        });
        bt_back.setOnAction(e -> {
            CreateMainMenuDataBase menuBack = new CreateMainMenuDataBase();
            AddPersonStage.close();

        });


        return peoplePosition;
    }

    public String createPerson(String type) {
        String output = "";
        this.setRow(0);
        switch (type) {
            case "Person":
                output = askingOptionsForPerson(type);
                break;
            case "Employee":
                output = askingOptionsForEmployee(type);
                break;
            case "Staff":
                output = askingOptionsForStaff(type);
                break;
            case "Faculty":
                output = askingOptionsForFaculty(type);
                break;
            case "Student":
                output = askingOptionsForStudent(type);
                break;
            default:
                output = "Not Created create persron";
        }

        return output;
    }

    public String askingOptionsForPerson(String type) {

        String output = "";
        ComboBox<String> cb_type = new ComboBox<>();
        cb_type.getItems().addAll("Work","Home","Cell");
        cb_type.setEffect(ds());
        cb_type.getStyleClass().add("mainMenuButton");
        cb_type.getSelectionModel().select(0);
        Stage askingStage = new Stage();
        GridPane askPosition = new GridPane();

        ArrayList<TextField> ALtf_AddressFromUser = addressInformation();
        ArrayList<TextField> ALtf_getPhoneFromUser = askingPhoneNumber();
        ArrayList<TextField> ALtf_basicInformation = basicInformation(type);
        ArrayList<PhoneNumber> AL_addPhoneNumbers = new ArrayList<>();

        askPosition.setHgap(10);
        askPosition.setVgap(10);

        Insets separateWindow = new Insets(10, 10, 10, 10);
        askPosition.setPadding(separateWindow);

        Label lb_checker = new Label();

        lb_checker.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_checker.setTextFill(Color.WHITE);

        Button bt_addPhone = new Button("+");
        Button bt_submit = new Button("Submit");

        bt_addPhone.setEffect(ds());
        bt_addPhone.getStyleClass().add("mainMenuButton");

        bt_submit.setEffect(ds());
        bt_submit.getStyleClass().add("mainMenuButton");

        for (int i = 0, column = 0; i < labels(type).size(); i++){
            askPosition.add(labels(type).get(i),column,i);
        }

        for (int i = 0, column = 1 ; i < ALtf_basicInformation.size(); i++,row++){
            askPosition.add(ALtf_basicInformation.get(i),column,row);
        }

        for (int i = 0, column = 1; i < ALtf_AddressFromUser.size(); i++,row++){
            askPosition.add(ALtf_AddressFromUser.get(i),column,row);
        }

        askPosition.add(cb_type,2,9);
        askPosition.add(bt_addPhone,3,9);


        for (int i = 0; i < ALtf_getPhoneFromUser.size(); i++,row++){
            askPosition.add(ALtf_getPhoneFromUser.get(i),1,row);
        }

        askPosition.add(bt_submit, 1, ALtf_getPhoneFromUser.size() + row + 1);
        askPosition.add(lb_checker, 1, ALtf_getPhoneFromUser.size() + row + 2);

        GridPane.setHalignment(bt_submit, HPos.LEFT);
        GridPane.setColumnSpan(lb_checker, 3);

        bt_addPhone.setOnAction(e ->{

            TextField temptf_Phone = new TextField();
            temptf_Phone.setPromptText("123-123-1234");
            temptf_Phone.setEffect(ds());
            temptf_Phone.getStyleClass().add("mainMenuButton");
            ALtf_getPhoneFromUser.add(temptf_Phone);
            this.setRow(this.getRow() + 1);

            askPosition.add(ALtf_getPhoneFromUser.get(ALtf_getPhoneFromUser.size() - 1),1,row);

            askPosition.getChildren().remove(bt_submit);
            askPosition.getChildren().remove(lb_checker);

            askPosition.add(bt_submit, 1, ALtf_getPhoneFromUser.size() + row + 1);
            askPosition.add(lb_checker, 1, ALtf_getPhoneFromUser.size() + row + 2);

        });

        bt_submit.setOnAction(event -> {

            if ( checkInformation(ALtf_basicInformation,type) || checkerAddress(ALtf_AddressFromUser) ) {

                try {


                    if (checkPhone(ALtf_getPhoneFromUser)){
                        AL_addPhoneNumbers.addAll( addPhoneNumber(ALtf_getPhoneFromUser,cb_type.getValue() ));
                    }

                    Person copy = new Person( ALtf_basicInformation.get(0).getText(), ALtf_basicInformation.get(1).getText(), ALtf_basicInformation.get(2).getText(),
                            new Address(Integer.parseInt(ALtf_AddressFromUser.get(0).getText()), Integer.parseInt(ALtf_AddressFromUser.get(1).getText()), ALtf_AddressFromUser.get(2).getText(),
                                    ALtf_AddressFromUser.get(3).getText(), ALtf_AddressFromUser.get(4).getText(), Integer.parseInt(ALtf_AddressFromUser.get(5).getText())),
                            AL_addPhoneNumbers);

                    CreateMainMenuDataBase.data.add(copy);
                    lb_checker.setText(ALtf_basicInformation.get(0).getText() + " was made.");
                }
                catch (PhoneNumberFormatException e){
                    lb_checker.setText(e.getMessage() );
                }
                catch (NumberFormatException e) {
                    lb_checker.setText("ZipCode/Apt number/StreetNumber must be a number");
                }
            }
            else{
                lb_checker.setText("Their are Text Fields that are empty");
            }

        });



        askPosition.setAlignment(Pos.CENTER);
        BorderPane center = new BorderPane();
        center.setCenter(askPosition);

        center.getStylesheets().add("Style/Effects.css");
        center.getStyleClass().add("creatingMenuBackGround");

        Scene scene = new Scene(center,734,719);

        askingStage.setScene(scene);
        askingStage.setTitle("Information");
        askingStage.sizeToScene();
        askingStage.show();

        output = lb_checker.getText();
        return output;
    }

    public String askingOptionsForStudent(String type) {

        String output = "";
        ComboBox<String> cb_type = new ComboBox<>();
        cb_type.getItems().addAll("Work","Home","Cell");
        cb_type.setEffect(ds());
        cb_type.getStyleClass().add("mainMenuButton");
        cb_type.getSelectionModel().select(0);
        Stage askingStage = new Stage();
        GridPane askPosition = new GridPane();

        ArrayList<TextField> ALtf_AddressFromUser = addressInformation();
        ArrayList<TextField> ALtf_getPhoneFromUser = askingPhoneNumber();
        ArrayList<TextField> ALtf_basicInformation = basicInformation(type);
        ArrayList<PhoneNumber> AL_addPhoneNumbers = new ArrayList<>();

        askPosition.setHgap(10);
        askPosition.setVgap(10);

        Insets separateWindow = new Insets(10, 10, 10, 10);
        askPosition.setPadding(separateWindow);

        Label lb_checker = new Label();
        lb_checker.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_checker.setTextFill(Color.WHITE);

        Button bt_addPhone = new Button("+");
        Button bt_submit = new Button("Submit");

        bt_addPhone.setEffect(ds());
        bt_addPhone.getStyleClass().add("mainMenuButton");

        bt_submit.setEffect(ds());
        bt_submit.getStyleClass().add("mainMenuButton");

        for (int i = 0, column = 0; i < labels(type).size(); i++){
            askPosition.add(labels(type).get(i),column,i);
        }

        for (int i = 0, column = 1 ; i < ALtf_basicInformation.size(); i++,row++){
            askPosition.add(ALtf_basicInformation.get(i),column,row);
        }

        for (int i = 0, column = 1; i < ALtf_AddressFromUser.size(); i++,row++){
            askPosition.add(ALtf_AddressFromUser.get(i),column,row);
        }

        askPosition.add(cb_type,2,9);
        askPosition.add(bt_addPhone,3,9);


        for (int i = 0; i < ALtf_getPhoneFromUser.size(); i++,row++){
            askPosition.add(ALtf_getPhoneFromUser.get(i),1,row);
        }

        askPosition.add(bt_submit, 1, ALtf_getPhoneFromUser.size() + row + 1);
        askPosition.add(lb_checker, 1, ALtf_getPhoneFromUser.size() + row + 2);

        GridPane.setHalignment(bt_submit, HPos.LEFT);
        GridPane.setColumnSpan(lb_checker, 3);

        bt_addPhone.setOnAction(e ->{

            TextField temptf_Phone = new TextField();
            temptf_Phone.setPromptText("123-123-1234");
            temptf_Phone.setEffect(ds());
            temptf_Phone.getStyleClass().add("mainMenuButton");
            ALtf_getPhoneFromUser.add(temptf_Phone);
            this.setRow(this.getRow() + 1);

            askPosition.add(ALtf_getPhoneFromUser.get(ALtf_getPhoneFromUser.size() - 1),1,row);

            askPosition.getChildren().remove(bt_submit);
            askPosition.getChildren().remove(lb_checker);

            askPosition.add(bt_submit, 1, ALtf_getPhoneFromUser.size() + row + 1);
            askPosition.add(lb_checker, 1, ALtf_getPhoneFromUser.size() + row + 2);

        });

        bt_submit.setOnAction(event -> {

            if ( checkInformation(ALtf_basicInformation,type) || checkerAddress(ALtf_AddressFromUser) ) {

                try {


                    if (checkPhone(ALtf_getPhoneFromUser)){
                        AL_addPhoneNumbers.addAll( addPhoneNumber(ALtf_getPhoneFromUser,cb_type.getValue() ));
                    }

                    Student copy = new Student( ALtf_basicInformation.get(0).getText(), ALtf_basicInformation.get(1).getText(), ALtf_basicInformation.get(2).getText(),
                            new Address(Integer.parseInt(ALtf_AddressFromUser.get(0).getText()), Integer.parseInt(ALtf_AddressFromUser.get(1).getText()), ALtf_AddressFromUser.get(2).getText(),
                                    ALtf_AddressFromUser.get(3).getText(), ALtf_AddressFromUser.get(4).getText(), Integer.parseInt(ALtf_AddressFromUser.get(5).getText())),
                            AL_addPhoneNumbers,ALtf_basicInformation.get(3).getText());

                    CreateMainMenuDataBase.data.add(copy);
                    lb_checker.setText(ALtf_basicInformation.get(0).getText() + " was made.");
                }
                catch (PhoneNumberFormatException e){
                    lb_checker.setText(e.getMessage() );
                }
                catch (NumberFormatException e) {
                    lb_checker.setText("ZipCode/Apt number/StreetNumber must be a number");
                }
            }
            else{
                lb_checker.setText("Their are Text Fields that are empty");
            }

        });

        askPosition.setAlignment(Pos.CENTER);
        BorderPane center = new BorderPane();
        center.setCenter(askPosition);

        center.getStylesheets().add("Style/Effects.css");
        center.getStyleClass().add("creatingMenuBackGround");

        Scene scene = new Scene(center,734,719);

        askingStage.setScene(scene);
        askingStage.setTitle("Information");
        askingStage.sizeToScene();
        askingStage.show();

        output = lb_checker.getText();
        return output;
    }

    public String askingOptionsForEmployee(String type) {

        String output = "";
        ComboBox<String> cb_type = new ComboBox<>();
        cb_type.getItems().addAll("Work","Home","Cell");
        cb_type.setEffect(ds());
        cb_type.getStyleClass().add("mainMenuButton");
        cb_type.getSelectionModel().select(0);
        Stage askingStage = new Stage();
        GridPane askPosition = new GridPane();

        ArrayList<TextField> ALtf_AddressFromUser = addressInformation();
        ArrayList<TextField> ALtf_getPhoneFromUser = askingPhoneNumber();
        ArrayList<TextField> ALtf_basicInformation = basicInformation(type);
        ArrayList<PhoneNumber> AL_addPhoneNumbers = new ArrayList<>();

        askPosition.setHgap(10);
        askPosition.setVgap(10);

        Insets separateWindow = new Insets(10, 10, 10, 10);
        askPosition.setPadding(separateWindow);

        Label lb_checker = new Label();

        lb_checker.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_checker.setTextFill(Color.WHITE);

        Button bt_addPhone = new Button("+");
        Button bt_submit = new Button("Submit");

        bt_addPhone.setEffect(ds());
        bt_addPhone.getStyleClass().add("mainMenuButton");

        bt_submit.setEffect(ds());
        bt_submit.getStyleClass().add("mainMenuButton");

        for (int i = 0, column = 0; i < labels(type).size(); i++){
            askPosition.add(labels(type).get(i),column,i);
        }

        for (int i = 0, column = 1 ; i < ALtf_basicInformation.size(); i++,row++){
            askPosition.add(ALtf_basicInformation.get(i),column,row);
        }

        for (int i = 0, column = 1; i < ALtf_AddressFromUser.size(); i++,row++){
            askPosition.add(ALtf_AddressFromUser.get(i),column,row);
        }

        askPosition.add(cb_type,2,9);
        askPosition.add(bt_addPhone,3,9);


        for (int i = 0; i < ALtf_getPhoneFromUser.size(); i++,row++){
            askPosition.add(ALtf_getPhoneFromUser.get(i),1,row);
        }

        askPosition.add(bt_submit, 1, ALtf_getPhoneFromUser.size() + row + 1);
        askPosition.add(lb_checker, 1, ALtf_getPhoneFromUser.size() + row + 2);

        GridPane.setHalignment(bt_submit, HPos.LEFT);
        GridPane.setColumnSpan(lb_checker, 3);

        bt_addPhone.setOnAction(e ->{

            TextField temptf_Phone = new TextField();
            temptf_Phone.setPromptText("123-123-1234");
            temptf_Phone.setEffect(ds());
            temptf_Phone.getStyleClass().add("mainMenuButton");
            ALtf_getPhoneFromUser.add(temptf_Phone);
            this.setRow(this.getRow() + 1);

            askPosition.add(ALtf_getPhoneFromUser.get(ALtf_getPhoneFromUser.size() - 1),1,row);

            askPosition.getChildren().remove(bt_submit);
            askPosition.getChildren().remove(lb_checker);


            askPosition.add(bt_submit, 1, ALtf_getPhoneFromUser.size() + row + 1);
            askPosition.add(lb_checker, 1, ALtf_getPhoneFromUser.size() + row + 2);

        });

        bt_submit.setOnAction(event -> {

                try {
                    if ( checkInformation(ALtf_basicInformation, type) || checkerAddress(ALtf_AddressFromUser) ) {

                    if (checkPhone(ALtf_getPhoneFromUser)){
                        AL_addPhoneNumbers.addAll( addPhoneNumber(ALtf_getPhoneFromUser,cb_type.getValue() ));
                    }

                    Employee copy = new Employee( ALtf_basicInformation.get(0).getText(), ALtf_basicInformation.get(1).getText(), ALtf_basicInformation.get(2).getText(),
                            new Address(Integer.parseInt(ALtf_AddressFromUser.get(0).getText()), Integer.parseInt(ALtf_AddressFromUser.get(1).getText()), ALtf_AddressFromUser.get(2).getText(),
                                    ALtf_AddressFromUser.get(3).getText(), ALtf_AddressFromUser.get(4).getText(), Integer.parseInt(ALtf_AddressFromUser.get(5).getText())),
                            AL_addPhoneNumbers,ALtf_basicInformation.get(3).getText(),Double.parseDouble(ALtf_basicInformation.get(4).getText()));

                    CreateMainMenuDataBase.data.add(copy);
                    lb_checker.setText(ALtf_basicInformation.get(0).getText() + " was made.");

                    }

                    else{
                        lb_checker.setText("Their are Text Fields that are empty");
                    }
                }
                catch (PhoneNumberFormatException e){
                    lb_checker.setText(e.getMessage() );
                }
                catch (NumberFormatException e) {
                    lb_checker.setText("ZipCode/Apt number/StreetNumber/Salary must be a number");
                }



        });

        askPosition.setAlignment(Pos.CENTER);
        BorderPane center = new BorderPane();
        center.setCenter(askPosition);

        center.getStylesheets().add("Style/Effects.css");
        center.getStyleClass().add("creatingMenuBackGround");

        Scene scene = new Scene(center,734,719);

        askingStage.setScene(scene);
        askingStage.setTitle("Information");
        askingStage.sizeToScene();

        askingStage.show();

        output = lb_checker.getText();
        return output;
    }

    public String askingOptionsForStaff(String type) {

        String output = "";
        ComboBox<String> cb_type = new ComboBox<>();
        cb_type.getItems().addAll("Work","Home","Cell");
        cb_type.setEffect(ds());
        cb_type.getStyleClass().add("mainMenuButton");
        cb_type.getSelectionModel().select(0);
        Stage askingStage = new Stage();
        GridPane askPosition = new GridPane();

        ArrayList<TextField> ALtf_AddressFromUser = addressInformation();
        ArrayList<TextField> ALtf_getPhoneFromUser = askingPhoneNumber();
        ArrayList<TextField> ALtf_basicInformation = basicInformation(type);
        ArrayList<PhoneNumber> AL_addPhoneNumbers = new ArrayList<>();

        askPosition.setHgap(10);
        askPosition.setVgap(10);

        Insets separateWindow = new Insets(10, 10, 10, 10);
        askPosition.setPadding(separateWindow);

        Label lb_checker = new Label();

        lb_checker.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_checker.setTextFill(Color.WHITE);

        Button bt_addPhone = new Button("+");
        Button bt_submit = new Button("Submit");

        bt_addPhone.setEffect(ds());
        bt_addPhone.getStyleClass().add("mainMenuButton");

        bt_submit.setEffect(ds());
        bt_submit.getStyleClass().add("mainMenuButton");

        for (int i = 0, column = 0; i < labels(type).size(); i++){
            askPosition.add(labels(type).get(i),column,i);
        }

        for (int i = 0, column = 1 ; i < ALtf_basicInformation.size(); i++,row++){
            askPosition.add(ALtf_basicInformation.get(i),column,row);
        }

        for (int i = 0, column = 1; i < ALtf_AddressFromUser.size(); i++,row++){
            askPosition.add(ALtf_AddressFromUser.get(i),column,row);
        }

        askPosition.add(cb_type,2,9);
        askPosition.add(bt_addPhone,3,9);


        for (int i = 0; i < ALtf_getPhoneFromUser.size(); i++,row++){
            askPosition.add(ALtf_getPhoneFromUser.get(i),1,row);
        }

        askPosition.add(bt_submit, 1, ALtf_getPhoneFromUser.size() + row + 1);
        askPosition.add(lb_checker, 1, ALtf_getPhoneFromUser.size() + row + 2);

        GridPane.setHalignment(bt_submit, HPos.LEFT);
        GridPane.setColumnSpan(lb_checker, 3);

        bt_addPhone.setOnAction(e ->{

            TextField temptf_Phone = new TextField();
            temptf_Phone.setPromptText("123-123-1234");
            temptf_Phone.setEffect(ds());
            temptf_Phone.getStyleClass().add("mainMenuButton");
            ALtf_getPhoneFromUser.add(temptf_Phone);
            this.setRow(this.getRow() + 1);

            askPosition.add(ALtf_getPhoneFromUser.get(ALtf_getPhoneFromUser.size() - 1),1,row);

            askPosition.getChildren().remove(bt_submit);
            askPosition.getChildren().remove(lb_checker);

            askPosition.add(bt_submit, 1, ALtf_getPhoneFromUser.size() + row + 1);
            askPosition.add(lb_checker, 1, ALtf_getPhoneFromUser.size() + row + 2);

        });

        bt_submit.setOnAction(event -> {

            try {
                if ( checkInformation(ALtf_basicInformation, type) || checkerAddress(ALtf_AddressFromUser) ) {

                    if (checkPhone(ALtf_getPhoneFromUser)){
                        AL_addPhoneNumbers.addAll( addPhoneNumber(ALtf_getPhoneFromUser,cb_type.getValue() ));
                    }

                    Staff copy = new Staff( ALtf_basicInformation.get(0).getText(), ALtf_basicInformation.get(1).getText(), ALtf_basicInformation.get(2).getText(),
                            new Address(Integer.parseInt(ALtf_AddressFromUser.get(0).getText()), Integer.parseInt(ALtf_AddressFromUser.get(1).getText()), ALtf_AddressFromUser.get(2).getText(),
                                    ALtf_AddressFromUser.get(3).getText(), ALtf_AddressFromUser.get(4).getText(), Integer.parseInt(ALtf_AddressFromUser.get(5).getText())),
                            AL_addPhoneNumbers,ALtf_basicInformation.get(3).getText(),Double.parseDouble(ALtf_basicInformation.get(4).getText()),ALtf_basicInformation.get(5).getText());

                    CreateMainMenuDataBase.data.add(copy);
                    lb_checker.setText(ALtf_basicInformation.get(0).getText() + " was made.");

                }

                else{
                    lb_checker.setText("Their are Text Fields that are empty");
                }
            }
            catch (PhoneNumberFormatException e){
                lb_checker.setText(e.getMessage() );
            }
            catch (NumberFormatException e) {
                lb_checker.setText("ZipCode/Apt number/StreetNumber/Salary must be a number");
            }



        });

        askPosition.setAlignment(Pos.CENTER);
        BorderPane center = new BorderPane();
        center.setCenter(askPosition);

        center.getStylesheets().add("Style/Effects.css");
        center.getStyleClass().add("creatingMenuBackGround");

        Scene scene = new Scene(center,734,719);

        askingStage.setScene(scene);
        askingStage.setTitle("Information");
        askingStage.sizeToScene();
        askingStage.show();

        output = lb_checker.getText();
        return output;
    }

    public String askingOptionsForFaculty(String type) {

        String output = "";
        ComboBox<String> cb_type = new ComboBox<>();
        cb_type.getItems().addAll("Work","Home","Cell");

        cb_type.setEffect(ds());
        cb_type.getStyleClass().add("mainMenuButton");

        cb_type.getSelectionModel().select(0);
        Stage askingStage = new Stage();
        GridPane askPosition = new GridPane();

        ArrayList<TextField> ALtf_AddressFromUser = addressInformation();
        ArrayList<TextField> ALtf_getPhoneFromUser = askingPhoneNumber();
        ArrayList<TextField> ALtf_basicInformation = basicInformation(type);
        ArrayList<PhoneNumber> AL_addPhoneNumbers = new ArrayList<>();

        askPosition.setHgap(10);
        askPosition.setVgap(10);

        Insets separateWindow = new Insets(10, 10, 10, 10);
        askPosition.setPadding(separateWindow);

        Label lb_checker = new Label();

        lb_checker.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_checker.setTextFill(Color.WHITE);

        Button bt_addPhone = new Button("+");
        Button bt_submit = new Button("Submit");

        bt_addPhone.setEffect(ds());
        bt_addPhone.getStyleClass().add("mainMenuButton");

        bt_submit.setEffect(ds());
        bt_submit.getStyleClass().add("mainMenuButton");

        for (int i = 0, column = 0; i < labels(type).size(); i++){
            askPosition.add(labels(type).get(i),column,i);
        }

        for (int i = 0, column = 1 ; i < ALtf_basicInformation.size(); i++,row++){
            askPosition.add(ALtf_basicInformation.get(i),column,row);
        }

        for (int i = 0, column = 1; i < ALtf_AddressFromUser.size(); i++,row++){
            askPosition.add(ALtf_AddressFromUser.get(i),column,row);
        }

        askPosition.add(cb_type,2,9);
        askPosition.add(bt_addPhone,3,9);


        for (int i = 0; i < ALtf_getPhoneFromUser.size(); i++,row++){
            askPosition.add(ALtf_getPhoneFromUser.get(i),1,row);
        }

        askPosition.add(bt_submit, 1, ALtf_getPhoneFromUser.size() + row + 1);
        askPosition.add(lb_checker, 1, ALtf_getPhoneFromUser.size() + row + 2);

        GridPane.setHalignment(bt_submit, HPos.LEFT);
        GridPane.setColumnSpan(lb_checker, 3);

        bt_addPhone.setOnAction(e ->{

            TextField temptf_Phone = new TextField();

            temptf_Phone.setPromptText("123-123-1234");
            temptf_Phone.setEffect(ds());
            temptf_Phone.getStyleClass().add("mainMenuButton");
            ALtf_getPhoneFromUser.add(temptf_Phone);
            this.setRow(this.getRow() + 1);

            askPosition.add(ALtf_getPhoneFromUser.get(ALtf_getPhoneFromUser.size() - 1),1,row);

            askPosition.getChildren().remove(bt_submit);
            askPosition.getChildren().remove(lb_checker);


            askPosition.add(bt_submit, 1, ALtf_getPhoneFromUser.size() + row + 1);
            askPosition.add(lb_checker, 1, ALtf_getPhoneFromUser.size() + row + 2);

        });

        bt_submit.setOnAction(event -> {

            try {
                if ( checkInformation(ALtf_basicInformation, type) || checkerAddress(ALtf_AddressFromUser) ) {

                    if (checkPhone(ALtf_getPhoneFromUser)){
                        AL_addPhoneNumbers.addAll( addPhoneNumber(ALtf_getPhoneFromUser,cb_type.getValue() ));
                    }

                    Faculty copy = new Faculty( ALtf_basicInformation.get(0).getText(), ALtf_basicInformation.get(1).getText(), ALtf_basicInformation.get(2).getText(),
                            new Address(Integer.parseInt(ALtf_AddressFromUser.get(0).getText()), Integer.parseInt(ALtf_AddressFromUser.get(1).getText()), ALtf_AddressFromUser.get(2).getText(),
                                    ALtf_AddressFromUser.get(3).getText(), ALtf_AddressFromUser.get(4).getText(), Integer.parseInt(ALtf_AddressFromUser.get(5).getText())),
                            AL_addPhoneNumbers,ALtf_basicInformation.get(3).getText(),Double.parseDouble(ALtf_basicInformation.get(4).getText()),ALtf_basicInformation.get(5).getText(),
                            ALtf_basicInformation.get(6).getText());

                    CreateMainMenuDataBase.data.add(copy);
                    lb_checker.setText(ALtf_basicInformation.get(0).getText() + " was made.");

                }

                else{
                    lb_checker.setText("Their are Text Fields that are empty");
                }
            }
            catch (PhoneNumberFormatException e){
                lb_checker.setText(e.getMessage() );
            }
            catch (NumberFormatException e) {
                lb_checker.setText("ZipCode/Apt number/StreetNumber/Salary must be a number");
            }



        });

        askPosition.setAlignment(Pos.CENTER);
        BorderPane center = new BorderPane();
        center.setCenter(askPosition);

        center.getStylesheets().add("Style/Effects.css");
        center.getStyleClass().add("creatingMenuBackGround");

        Scene scene = new Scene(center,734,719);

        askingStage.setScene(scene);
        askingStage.setTitle("Information");
        askingStage.sizeToScene();
        askingStage.show();

        output = lb_checker.getText();
        return output;
    }

    public ArrayList<TextField> basicInformation(String type) {
        ArrayList<TextField> informationArrayList = new ArrayList<>();

        TextField tf_FirstName = new TextField();
        TextField tf_LastName = new TextField();
        TextField tf_Email = new TextField();

        tf_FirstName.setPromptText("First Name");
        tf_FirstName.setEffect(ds());
        tf_FirstName.getStyleClass().add("mainMenuButton");

        tf_LastName.setPromptText("Last Name");
        tf_LastName.setEffect(ds());
        tf_LastName.getStyleClass().add("mainMenuButton");

        tf_Email.setPromptText("Email");
        tf_Email.setEffect(ds());
        tf_Email.getStyleClass().add("mainMenuButton");

        informationArrayList.add(tf_FirstName);
        informationArrayList.add(tf_LastName);
        informationArrayList.add(tf_Email);

        if (type.equalsIgnoreCase("Student")){
            TextField tf_ClassRank = new TextField();

            tf_ClassRank.setPromptText("Class Rank");
            tf_ClassRank.setEffect(ds());
            tf_ClassRank.getStyleClass().add("mainMenuButton");

            informationArrayList.add(tf_ClassRank);
        }

        if (type.equalsIgnoreCase("Employee") || type.equalsIgnoreCase("Staff") ||
            type.equalsIgnoreCase("Faculty") ){

            TextField tf_officeLocation = new TextField();
            TextField tf_Salary = new TextField();

            tf_officeLocation.setPromptText("Office Location");
            tf_officeLocation.setEffect(ds());
            tf_officeLocation.getStyleClass().add("mainMenuButton");

            tf_Salary.setPromptText("Salary");
            tf_Salary.setEffect(ds());
            tf_Salary.getStyleClass().add("mainMenuButton");

            informationArrayList.add(tf_officeLocation);
            informationArrayList.add(tf_Salary);

            if (type.equalsIgnoreCase("Faculty")){
                TextField tf_officeHrs = new TextField();
                TextField tf_rank = new TextField();

                tf_officeHrs.setPromptText("Office Hours");
                tf_officeHrs.setEffect(ds());
                tf_officeHrs.getStyleClass().add("mainMenuButton");

                tf_rank.setPromptText("Rank");
                tf_rank.setEffect(ds());
                tf_rank.getStyleClass().add("mainMenuButton");

                informationArrayList.add(tf_officeHrs);
                informationArrayList.add(tf_rank);
            }
            if(type.equalsIgnoreCase("Staff")){
                TextField tf_jobTitle = new TextField();

                tf_jobTitle.setPromptText("Job title");
                tf_jobTitle.setEffect(ds());
                tf_jobTitle.getStyleClass().add("mainMenuButton");

                informationArrayList.add(tf_jobTitle);
            }
        }


        return informationArrayList;
    }

    public ArrayList<TextField> addressInformation() {

        ArrayList<TextField> informationArrayList = new ArrayList<>();

        TextField streetNumber = new TextField();
        TextField apartmentNumber = new TextField();
        TextField streetName = new TextField();
        TextField city = new TextField();
        TextField state = new TextField();
        TextField zipCode = new TextField();

        streetNumber.setPromptText("Street Number");
        streetNumber.setEffect(ds());
        streetNumber.getStyleClass().add("mainMenuButton");

        apartmentNumber.setPromptText("Apart Number");
        apartmentNumber.setEffect(ds());
        apartmentNumber.getStyleClass().add("mainMenuButton");

        streetName.setPromptText("Street Name");
        streetName.setEffect(ds());
        streetName.getStyleClass().add("mainMenuButton");

        city.setPromptText("City Name");
        city.setEffect(ds());
        city.getStyleClass().add("mainMenuButton");

        state.setPromptText("State Name");
        state.setEffect(ds());
        state.getStyleClass().add("mainMenuButton");

        zipCode.setPromptText("Zip Code");
        zipCode.setEffect(ds());
        zipCode.getStyleClass().add("mainMenuButton");

        informationArrayList.add(streetNumber);
        informationArrayList.add(apartmentNumber);
        informationArrayList.add(streetName);
        informationArrayList.add(city);
        informationArrayList.add(state);
        informationArrayList.add(zipCode);

        return informationArrayList;
    }

    public ArrayList<TextField> askingPhoneNumber() {
        ArrayList<TextField> onePhone = new ArrayList<>();

        TextField phone = new TextField();

        phone.setPromptText("123-123-1234");
        phone.setEffect(ds());
        phone.getStyleClass().add("mainMenuButton");

        onePhone.add(phone);
        return onePhone;
    }

    public boolean checkerAddress(ArrayList<TextField> everything) {

        for (int i = 0; i < everything.size(); i ++){
            if ( everything.get(i).getText().isEmpty() ){
                return false;
            }
        }
        return true;
    }
    public boolean checkInformation(ArrayList<TextField> everything, String type) {

        for (int i = 0; i < everything.size(); i ++){
            if ( everything.get(i).getText().isEmpty() ){
                return false;
            }

        }
        return true;
    }

    public ArrayList<Label> labels(String type){
        ArrayList<Label> labelArrayList = new ArrayList<>();

        Label lb_FirstName = new Label("First Name");
        Label lb_LastName = new Label("Last Name");
        Label lb_Email = new Label("Email");
        Label lb_StreetNumber = new Label("Street Number");
        Label lb_apartmentNumber = new Label("Apartment Number");
        Label lb_streetName = new Label("Street Name");
        Label lb_city = new Label("City");
        Label lb_state = new Label("State");
        Label lb_zipCode = new Label("Zip Code");
        Label lb_PhoneNumber = new Label("PhoneNumber");

        lb_FirstName.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_FirstName.setTextFill(Color.WHITE);

        lb_LastName.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_LastName.setTextFill(Color.WHITE);

        lb_Email.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_Email.setTextFill(Color.WHITE);

        lb_StreetNumber.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_StreetNumber.setTextFill(Color.WHITE);

        lb_apartmentNumber.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_apartmentNumber.setTextFill(Color.WHITE);

        lb_streetName.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_streetName.setTextFill(Color.WHITE);

        lb_city.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_city.setTextFill(Color.WHITE);

        lb_state.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_state.setTextFill(Color.WHITE);

        lb_zipCode.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_zipCode.setTextFill(Color.WHITE);

        lb_PhoneNumber.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_PhoneNumber.setTextFill(Color.WHITE);


        labelArrayList.add(lb_FirstName);
        labelArrayList.add(lb_LastName);
        labelArrayList.add(lb_Email);



        if (type.equalsIgnoreCase("Student")){
            Label lb_classRank = new Label("Class Rank");

            lb_classRank.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
            lb_classRank.setTextFill(Color.WHITE);

            labelArrayList.add(lb_classRank);
        }

        if ( type.equalsIgnoreCase("Employee") || type.equalsIgnoreCase("Staff") ||
                type.equalsIgnoreCase("Faculty")){

            Label lb_officeLocation = new Label("Office Location");
            Label lb_salary = new Label("Salary");

            lb_officeLocation.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
            lb_officeLocation.setTextFill(Color.WHITE);

            lb_salary.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
            lb_salary.setTextFill(Color.WHITE);

            labelArrayList.add(lb_officeLocation);
            labelArrayList.add(lb_salary);

            if (type.equalsIgnoreCase("Staff")){
                Label lb_jobTitle = new Label("Job Title");

                lb_jobTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
                lb_jobTitle.setTextFill(Color.WHITE);

                labelArrayList.add(lb_jobTitle);
            }

            if (type.equalsIgnoreCase("Faculty")){
                Label lb_officeHours = new Label("Office Hours");
                Label lb_Rank = new Label("Rank");

                lb_officeHours.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
                lb_officeHours.setTextFill(Color.WHITE);

                lb_Rank.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
                lb_Rank.setTextFill(Color.WHITE);
                labelArrayList.add(lb_officeHours);
                labelArrayList.add(lb_Rank);
            }
        }


        labelArrayList.add(lb_StreetNumber);
        labelArrayList.add(lb_apartmentNumber);
        labelArrayList.add(lb_streetName);
        labelArrayList.add(lb_city);
        labelArrayList.add(lb_state);
        labelArrayList.add(lb_zipCode);
        labelArrayList.add(lb_PhoneNumber);

        return labelArrayList;
    }

    public boolean checkPhone(ArrayList<TextField> everyPhone) throws PhoneNumberFormatException {

        for (int i = 0; i < everyPhone.size(); i ++){
            if ( everyPhone.get(i).getText().isEmpty() ){
                return false;
            }
            if ( !everyPhone.get(i).getText().matches("\\d{3}-\\d{3}-\\d{4}") ){
                throw new PhoneNumberFormatException("Phone Number must be in the correct format\n123-123-1234");
            }
        }
        return true;
    }

    public ArrayList<PhoneNumber> addPhoneNumber(ArrayList<TextField> addPhone, String type){
        ArrayList<PhoneNumber> test = new ArrayList<>();
        for (int i = 0; i < addPhone.size(); i++){
            String[] split = addPhone.get(i).getText().split("-");
            PhoneNumber newPersonNumber = new PhoneNumber(type,Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2]));
            test.add(newPersonNumber);
        }

        return test;
    }

    public Text DataBaseTitle() {
        Text title = new Text(75, 75, "Add A Person");
        title.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD, 45));
        title.setFill(Color.BLACK);
        title.setEffect(reflection());

        return title;
    }

    public Reflection reflection() {
        Reflection reflection = new Reflection();
        reflection.setFraction(0.8);
        reflection.setTopOffset(-20);

        return reflection;
    }

    public DropShadow ds() {
        DropShadow ds = new DropShadow();
        ds.setOffsetX(5.0);
        ds.setOffsetY(5.0);
        ds.setColor(Color.GRAY);
        return ds;
    }
}
