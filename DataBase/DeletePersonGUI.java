package DataBase;

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

public class DeletePersonGUI extends BorderPane {
    Stage findPersonStage;
    GridPane findPersonGrid;
    Text findPersonTitle;

    public DeletePersonGUI(){

        Insets seperateWindow = new Insets(10,10,10,10);
        findPersonStage = new Stage();
        findPersonGrid = deletePeople();
        findPersonTitle = DataBaseTitle();

        findPersonGrid.setAlignment(Pos.CENTER);

        this.getStylesheets().add("Style/Effects.css");
        this.getStyleClass().add("deletingMenuBackGround");
        this.setCenter(findPersonGrid);
        this.setAlignment(findPersonTitle, Pos.TOP_CENTER);
        this.setTop(findPersonTitle);
        this.setPadding(seperateWindow);

        Scene scene = new Scene(this,800,800);
        findPersonStage.setScene(scene);
        findPersonStage.setTitle("DataBase");
        findPersonStage.sizeToScene();
        findPersonStage.show();
    }

    public GridPane deletePeople() {
        GridPane pairing = new GridPane();

        Button bt_compare = new Button("delete");
        pairing.setVgap(10);
        pairing.setHgap(10);

        ArrayList<RadioButton> cb_people = peopleRadioButton();

        for (int i = 0, row = 0, column = 0; i < cb_people.size(); i++, row++) {
            if (row % 10 == 0) {
                column++;
                row = 0;
            }
            pairing.add(cb_people.get(i), column, row);
        }

        Label lb_checker = new Label();

        pairing.add(lb_checker,1,12);
        pairing.add(bt_compare,2,11);

        GridPane.setHalignment(bt_compare, HPos.CENTER);
        GridPane.setHalignment(lb_checker, HPos.CENTER);
        GridPane.setColumnSpan(lb_checker, 3);

        EventHandler<ActionEvent> handler = e -> {
            for (int i = 0; i < cb_people.size(); i++){

                if (cb_people.get(i).isSelected()){
                    try{
                        pairing.getChildren().remove(cb_people.get(i));
                        cb_people.get(i).setSelected(false);
                        String cool = CreateMainMenuDataBase.data.get(i).getFirstName() + " is removed";
                        CreateMainMenuDataBase.data.remove(CreateMainMenuDataBase.data.get(i));
                        lb_checker.setText(cool);
                    }
                    catch (IndexOutOfBoundsException message){

                    }

                }

            }

        };

        bt_compare.setOnAction(handler);
        return pairing;
    }

    public ArrayList<RadioButton> peopleRadioButton() {

        ArrayList<RadioButton> people = new ArrayList<>();

        for (int i = 0; i < CreateMainMenuDataBase.data.size(); i++) {
            RadioButton get = new RadioButton(CreateMainMenuDataBase.data.get(i).getFirstName() + " " +
                    CreateMainMenuDataBase.data.get(i).getLastName());
            get.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
            get.setTextFill(Color.WHITE);
            people.add(get);
        }

        return people;
    }


    public Text DataBaseTitle() {
        Text title = new Text(75, 75, "Delete Person");
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
