package DataBase;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateMenuDataBase extends BorderPane {
	final int width = 377;
	final int height = 334;
	Stage menuStage;
	Text title;
    VBox button;

    public CreateMenuDataBase(){
        menuStage = new Stage();
        title = MenuTitle();
        button = button();

        button.setAlignment(Pos.CENTER);
        this.setCenter(button);

        this.setAlignment(title, Pos.TOP_CENTER);
        this.setTop(title);
        
        this.getStylesheets().add("Style/Effects.css");
        this.getStyleClass().add("menuBackGround");

        Scene scene = new Scene(this,width,height);

        menuStage.setTitle("Menu");
        menuStage.setScene(scene);
        menuStage.setResizable(false);
        menuStage.show();
        

    }

    public Text MenuTitle(){
        Text title = new Text(75,75,"Menu");
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

    public VBox button(){
    	
        VBox position = new VBox();

        Button play = new Button("Start");
        
        play.setEffect(ds());
        play.getStyleClass().add("start");
        
        Button quit = new Button("Quit");
        
        quit.setEffect(ds());
        quit.getStyleClass().add("exit");

        position.setSpacing(20);

        position.getChildren().addAll(play,quit);

        play.setOnAction(e ->{
        	menuStage.close();
        	CreateMainMenuDataBase menu = new CreateMainMenuDataBase();
        });

        quit.setOnAction(e ->{
            System.exit(0);
        });

        return position;
    }


}
