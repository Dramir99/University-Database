package DataBase;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import people.Person;
import university_database.DatabaseFileIO;
import university_database.GUIDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UseCSVFileGUI extends BorderPane {

    Stage populateDataStage;
    GridPane populateDataGrid;
    Text populateDataTitle;

    public UseCSVFileGUI(){
        Insets seperateWindow = new Insets(10,10,10,10);
        populateDataStage = new Stage();
        populateDataGrid = populatedPeople();
        populateDataTitle = DataBaseTitle();

        populateDataGrid.setAlignment(Pos.CENTER);

        this.getStylesheets().add("Style/Effects.css");
        this.getStyleClass().add("populateMenuBackGround");
        this.setCenter(populateDataGrid);
        this.setAlignment(populateDataTitle, Pos.TOP_CENTER);
        this.setTop(populateDataTitle);
        this.setPadding(seperateWindow);

        Scene scene = new Scene(this,800,640);
        populateDataStage.setScene(scene);
        populateDataStage.setTitle("File Selector");
        populateDataStage.sizeToScene();
        populateDataStage.show();
    }

    public GridPane populatedPeople(){
        GridPane position = new GridPane();

        position.setVgap(10);
        position.setHgap(10);

        Button bt_populate = new Button("Populate Data");
        Button bt_back = new Button("Back");
        Button bt_write = new Button("Write to a file");

        bt_populate.setEffect(ds());
        bt_back.setEffect(ds());
        bt_write.setEffect(ds());

        bt_populate.getStyleClass().add("mainMenuButton");
        bt_back.getStyleClass().add("mainMenuButton");
        bt_write.getStyleClass().add("mainMenuButton");

        Label checker = new Label();

        position.add(bt_populate,0,0);
        position.add(bt_write,0,1);
        position.add(bt_back,0,2);
        position.add(checker,0,3);

        bt_populate.setOnAction(event -> {
            try {
                CreateMainMenuDataBase.data = new GUIDatabase(getFile());
                checker.setText("A File was read.");
            } catch (FileNotFoundException e) {
                checker.setText("A File was not Found.");
            } catch (NullPointerException e){
                checker.setText("A File was not Selected.");
            }
        });
        bt_back.setOnAction(event -> {
        CreateMainMenuDataBase back = new CreateMainMenuDataBase();
        populateDataStage.close();
        });
        bt_write.setOnAction(event -> {
            DatabaseFileIO write = new DatabaseFileIO(CreateMainMenuDataBase.data);
            write.writeFile(CreateMainMenuDataBase.data);
            checker.setText("The File was Written");
        });

        return position;
    }

    public ArrayList<Person> getFile() throws FileNotFoundException, NullPointerException{
        File inFile = null;

        FileChooser choosing = new FileChooser();
        String currentDir = System.getProperty("user.dir");
        File currentFile = new File(currentDir);

        choosing.setInitialDirectory(currentFile);

        choosing.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("CSV File", "*.csv"));

        inFile = choosing.showOpenDialog(populateDataStage);

        DatabaseFileIO tester = new DatabaseFileIO();

        if(inFile != null){
            tester = new DatabaseFileIO(inFile);
        }

        return tester.readFile();

    }


    public Text DataBaseTitle(){
        Text title = new Text(75,75,"Find A File");
        title.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD,45));
        title.setFill(Color.BLACK);
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
}
