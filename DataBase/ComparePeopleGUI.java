package DataBase;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ComparePeopleGUI extends BorderPane {
    Stage compareStage;
    GridPane compareGrid;
    Text CompareTitle;

    public ComparePeopleGUI() {
        Insets seperateWindow = new Insets(10, 10, 10, 10);
        compareStage = new Stage();
        compareGrid = comparePeople();
        CompareTitle = DataBaseTitle();

        compareGrid.setAlignment(Pos.CENTER);

        this.getStylesheets().add("Style/Effects.css");
        this.getStyleClass().add("CompareMenuBackGround");
        this.setCenter(compareGrid);
        setAlignment(CompareTitle, Pos.TOP_CENTER);
        this.setTop(CompareTitle);
        this.setPadding(seperateWindow);

        Scene scene = new Scene(this, 800, 800);
        compareStage.setScene(scene);
        compareStage.setTitle("DataBase");
        compareStage.sizeToScene();
        compareStage.show();
    }

    public GridPane comparePeople() {
        GridPane pairing = new GridPane();

        Button bt_compare = new Button("Compare");
        Button bt_back = new Button("Back");

        bt_compare.getStyleClass().add("mainMenuButton");
        bt_compare.setEffect(ds());
        bt_back.getStyleClass().add("mainMenuButton");
        bt_back.setEffect(ds());

        pairing.setVgap(10);
        pairing.setHgap(10);

        ArrayList<CheckBox> cb_people = peopleBox();

        for (int i = 0, row = 0, column = 0; i < cb_people.size(); i++, row++) {
            if (row % 10 == 0) {
                column++;
                row = 0;
            }
            pairing.add(cb_people.get(i), column, row);
        }

        Label lb_checker = new Label();

        lb_checker.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_checker.setTextFill(Color.WHITE);


        pairing.add(lb_checker,1,12);
        pairing.add(bt_back,1,11);
        pairing.add(bt_compare,2,11);

        GridPane.setHalignment(bt_back, HPos.LEFT);
        GridPane.setHalignment(bt_compare, HPos.CENTER);
        GridPane.setHalignment(lb_checker, HPos.CENTER);
        GridPane.setColumnSpan(lb_checker, 3);

        EventHandler<ActionEvent> handler = e -> {

            int tabs = 0;
            int counter = 0;
            for (int i = 0; i < cb_people.size(); i++){
                if (cb_people.get(i).isSelected()){
                    counter++;
                    if (counter == 2){
                        boolean compare = CreateMainMenuDataBase.data.get(i).equals(CreateMainMenuDataBase.data.get(tabs));
                        String cool = "the Person in " + (tabs + 1) + " index and "  + (i + 1) + " index ";
                        cool += (compare == true) ? "Is Equal to" : "Is not equal to";
                        lb_checker.setText(cool);
                    }
                    tabs = i;
                }

            }

        };
        bt_back.setOnAction(event -> {
            CreateMainMenuDataBase back = new CreateMainMenuDataBase();
            compareStage.close();
        });
        bt_compare.setOnAction(handler);
        return pairing;


    }

    public ArrayList<CheckBox> peopleBox() {

        ArrayList<CheckBox> people = new ArrayList<>();

        int maxCBSelected = 2;

        ChangeListener<Boolean> listener = new ChangeListener<Boolean>() {
            int counter = 0;
            @Override
            public void changed(ObservableValue<? extends Boolean> o, Boolean oldValue, Boolean ifCheckBoxIsSelected) {
                if (ifCheckBoxIsSelected) {
                    counter++;
                    if (counter == maxCBSelected) {
                        // checks the count and disable all other checkbox if the counter is reached.
                        for (int i = 0; i < people.size(); i++) {
                            if (!(people.get(i).isSelected())) {
                                people.get(i).setDisable(true);
                            }
                        }
                    }
                }
                else {
                        if (counter == maxCBSelected) {
                            // enable the checkbox to be used again.
                            for (int i = 0; i < people.size(); i++) {
                                    people.get(i).setDisable(false);
                            }
                        }
                    counter--;
                }
            }
        };

        for (int i = 0; i < CreateMainMenuDataBase.data.size(); i++) {
            CheckBox get = new CheckBox(CreateMainMenuDataBase.data.get(i).getFirstName() + " " +
                    CreateMainMenuDataBase.data.get(i).getLastName());
            get.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
            get.setTextFill(Color.WHITE);
            get.selectedProperty().addListener(listener);
            people.add(get);
        }

        return people;
    }


    public Text DataBaseTitle() {
        Text title = new Text(75, 75, "Compare Person");
        title.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD, 45));
        title.setFill(Color.WHITESMOKE);
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
