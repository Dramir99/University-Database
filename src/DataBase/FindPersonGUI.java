package DataBase;

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

public class FindPersonGUI extends BorderPane {
	
	Stage findPersonStage;
	GridPane findPersonGrid;
	Text findPersonTitle;
	
	public FindPersonGUI(){
	    
		Insets seperateWindow = new Insets(10,10,10,10);
		findPersonStage = new Stage();
		findPersonGrid = options();
		findPersonTitle = DataBaseTitle();
		
		findPersonGrid.setAlignment(Pos.CENTER);
		
		this.getStylesheets().add("Style/Effects.css");
		this.getStyleClass().add("findMenuBackGround");

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

public GridPane options(){
	
        GridPane position = new GridPane();
        
        Label lb_firstName = new Label("First Name");
        Label lb_lastName = new Label("Last Name");
        Label lb_PersonType = new Label("Person Type");
        Label lb_ClassStanding = new Label("Student Year");
        Label lb_JobTitle = new Label("Job Title");
        Label lb_Rank = new Label("Rank");

        lb_firstName.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_firstName.setTextFill(Color.WHITE);

        lb_lastName.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_lastName.setTextFill(Color.WHITE);

        lb_PersonType.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_PersonType.setTextFill(Color.WHITE);

        lb_ClassStanding.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_ClassStanding.setTextFill(Color.WHITE);

        lb_JobTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_JobTitle.setTextFill(Color.WHITE);

        lb_Rank.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_Rank.setTextFill(Color.WHITE);
        
        position.setHgap(10);
        position.setVgap(10);
        
        TextField tf_FirstName = new TextField();
        TextField tf_LastName = new TextField();
        ComboBox<String> cb_PersonType = new ComboBox();
        cb_PersonType.getItems().addAll("Person","Employee","Staff","Faculty","Student");
        ComboBox<String> cb_ClassStanding = new ComboBox();
        cb_ClassStanding.getItems().addAll("None","Freshman","Sophomore","Junior","Senior","Graduate");
        TextField tf_JobTitle = new TextField();
        TextField tf_Rank = new TextField();
        Button bt_complete = new Button("Find");
        Button bt_back = new Button("Back");
        
        tf_FirstName.setPromptText("First Name");
        tf_FirstName.setEffect(ds());
        tf_FirstName.getStyleClass().add("mainMenuButton");

        tf_LastName.setPromptText("Last Name");
        tf_LastName.setEffect(ds());
        tf_LastName.getStyleClass().add("mainMenuButton");
        
        cb_PersonType.getSelectionModel().select(0);
        cb_PersonType.setEffect(ds());
        cb_PersonType.getStyleClass().add("mainMenuButton");
        
        cb_ClassStanding.getSelectionModel().select(0);
        cb_ClassStanding.setEffect(ds());
        cb_ClassStanding.getStyleClass().add("mainMenuButton");
        cb_ClassStanding.setVisible(false);
        
        tf_JobTitle.setPromptText("Job Title");
        tf_JobTitle.setVisible(false);
        tf_JobTitle.setEffect(ds());
        tf_JobTitle.getStyleClass().add("mainMenuButton");
        
        tf_Rank.setPromptText("Rank");
        tf_Rank.setVisible(false);
        tf_Rank.setEffect(ds());
        tf_Rank.getStyleClass().add("mainMenuButton");
        
        bt_complete.setEffect(ds());
        bt_complete.getStyleClass().add("mainMenuButton");

        bt_back.setEffect(ds());
        bt_back.getStyleClass().add("mainMenuButton");
        
        position.add(lb_firstName, 0, 0);
        position.add(tf_FirstName, 1, 0);
        position.add(lb_lastName, 0, 1);
        position.add(tf_LastName, 1, 1);
        position.add(lb_PersonType, 0, 2);
        position.add(cb_PersonType,1,2);
        position.add(lb_ClassStanding,0,3);
        position.add(cb_ClassStanding,1,3);
        position.add(lb_JobTitle,0,4);
        position.add(tf_JobTitle, 1, 4);
        position.add(lb_Rank, 0, 5);
        position.add(tf_Rank, 1, 5);
        position.add(bt_complete, 1, 6);
        position.add(bt_back, 0, 6);
        position.setHalignment(bt_complete, HPos.RIGHT);
        position.setHalignment(bt_back, HPos.RIGHT);
        
        cb_PersonType.valueProperty().addListener((arg0, before, after) -> {
            if(before != null){

                if(after.equalsIgnoreCase("Student")){
                    cb_ClassStanding.setVisible(true);
                }
                else{
                    cb_ClassStanding.setVisible(false);
                    cb_ClassStanding.getSelectionModel().select(0);
                }

                if(after.equalsIgnoreCase("Faculty")){
                    tf_Rank.setVisible(true);
                }
                else{
                    tf_Rank.setVisible(false);
                    tf_Rank.clear();
                }

                if(after.equalsIgnoreCase("Staff")){
                    tf_JobTitle.setVisible(true);
                }
                else{
                    tf_JobTitle.setVisible(false);
                    tf_JobTitle.clear();
                }


            }

        });
        bt_back.setOnAction(e ->{
            CreateMainMenuDataBase menuBack = new CreateMainMenuDataBase();
            findPersonStage.close();
        });
        
        bt_complete.setOnAction(e ->{
        	VBox content = new VBox();
        	Stage st_complete = new Stage();
        	BorderPane pane = new BorderPane();
        	
        	pane.setPadding(new Insets(5, 5, 5, 5));
        	
        	ScrollPane scrollPane = new ScrollPane(content);
    	    scrollPane.setFitToHeight(true);
    	    
    	    Text person = new Text("test");

    	    
    	    //------------------------------Person--------------------------
        	//find person by firstName
        	if( !(tf_FirstName.getText().equalsIgnoreCase("")) && (tf_LastName.getText().equalsIgnoreCase("")) 
        		&& !(cb_PersonType.getValue().equalsIgnoreCase("")) && cb_ClassStanding.getValue().equalsIgnoreCase("None")
                    && tf_JobTitle.getText().equalsIgnoreCase("") && (tf_Rank.getText().equalsIgnoreCase("")) ){
        		
        		person = new Text(CreateMainMenuDataBase.data.findPersonByFirstName(tf_FirstName.getText(), cb_PersonType.getValue()));
        		person.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        	}
        	
        	//find person by lastName
        	else if( (tf_FirstName.getText().equalsIgnoreCase("")) && !(tf_LastName.getText().equalsIgnoreCase("")) 
        		    && !(cb_PersonType.getValue().equalsIgnoreCase("")) && cb_ClassStanding.getValue().equalsIgnoreCase("None")
                    && tf_JobTitle.getText().equalsIgnoreCase("") && (tf_Rank.getText().equalsIgnoreCase(""))){
        		
        		 person = new Text(CreateMainMenuDataBase.data.findPersonByLastName(tf_LastName.getText(), cb_PersonType.getValue()));
        		person.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        	}
        	//find person by firstName,lastName
        	else if( (!(tf_FirstName.getText().equalsIgnoreCase("")) && !(tf_LastName.getText().equalsIgnoreCase(""))) 
        		    && !(cb_PersonType.getValue().equalsIgnoreCase("")) && cb_ClassStanding.getValue().equalsIgnoreCase("None")
                    && tf_JobTitle.getText().equalsIgnoreCase("") && (tf_Rank.getText().equalsIgnoreCase(""))){
        		
        		 person = new Text(CreateMainMenuDataBase.data.findPerson(tf_FirstName.getText(),tf_LastName.getText(), cb_PersonType.getValue()));
        		person.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        	}
        	
        	//find person by just Person Type
        	else if(tf_FirstName.getText().equalsIgnoreCase("") && tf_LastName.getText().equalsIgnoreCase("")
        			&& !(cb_PersonType.getValue().equalsIgnoreCase("")) && cb_ClassStanding.getValue().equalsIgnoreCase("None")
                    && tf_JobTitle.getText().equalsIgnoreCase("") && (tf_Rank.getText().equalsIgnoreCase("")) ){
        		
        		 person = new Text(CreateMainMenuDataBase.data.printDatabase(cb_PersonType.getValue()));
        		person.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
			     
        	}
        	//---------------------------------Student-------------------------------------
			//find a student by class standing
			else if( (tf_FirstName.getText().equalsIgnoreCase("")) && (tf_LastName.getText().equalsIgnoreCase(""))
					&& cb_PersonType.getValue().equalsIgnoreCase("Student") && !(cb_ClassStanding.getValue().equalsIgnoreCase(""))
                    && (tf_Rank.getText().equalsIgnoreCase("")) ){

				person = new Text(CreateMainMenuDataBase.data.findStudentByClassStandingType( cb_ClassStanding.getValue() ));
				person.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

			}
            //find a student by class standing using lastName
            else if( (tf_FirstName.getText().equalsIgnoreCase("")) && !(tf_LastName.getText().equalsIgnoreCase(""))
                    && cb_PersonType.getValue().equalsIgnoreCase("Student") && !(cb_ClassStanding.getValue().equalsIgnoreCase(""))
                    && (tf_Rank.getText().equalsIgnoreCase(""))){

                person = new Text(CreateMainMenuDataBase.data.findStudentByClassStandingLastName(tf_LastName.getText(), cb_ClassStanding.getValue()));
                person.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

            }
            //find a student by class standing using firstName
            else if( !(tf_FirstName.getText().equalsIgnoreCase("")) && (tf_LastName.getText().equalsIgnoreCase(""))
                    && cb_PersonType.getValue().equalsIgnoreCase("Student") && !(cb_ClassStanding.getValue().equalsIgnoreCase(""))
                    && (tf_Rank.getText().equalsIgnoreCase("")) ){

                person = new Text(CreateMainMenuDataBase.data.findStudentByClassStandingFirstName(tf_FirstName.getText(), cb_ClassStanding.getValue()));
                person.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

            }
        	//find a student by class standing using first and last name
        	else if( !(tf_FirstName.getText().equalsIgnoreCase("")) && !(tf_LastName.getText().equalsIgnoreCase(""))
        			&& cb_PersonType.getValue().equalsIgnoreCase("Student") && !(cb_ClassStanding.getValue().equalsIgnoreCase(""))
                    && (tf_Rank.getText().equalsIgnoreCase("")) ){

        		 person = new Text(CreateMainMenuDataBase.data.findStudentByClassStanding(tf_FirstName.getText(),tf_LastName.getText(), cb_ClassStanding.getValue()));
        		person.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        	}
        	//-----------------------------------Staff--------------------------
            //find a staff by JobTitle
            else if( tf_FirstName.getText().equalsIgnoreCase("") && tf_LastName.getText().equalsIgnoreCase("")
                    && cb_PersonType.getValue().equalsIgnoreCase("Staff") && cb_ClassStanding.getValue().equalsIgnoreCase("None")
                    && !(tf_JobTitle.getText().equalsIgnoreCase("")) && (tf_Rank.getText().equalsIgnoreCase("")) ){



                person = new Text(CreateMainMenuDataBase.data.findStaffByJobTitle(tf_JobTitle.getText()));
                person.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

            }
            //find a staff by first name and job title
            else if ( !(tf_FirstName.getText().equalsIgnoreCase("")) && tf_LastName.getText().equalsIgnoreCase("")
                    && cb_PersonType.getValue().equalsIgnoreCase("Staff") && cb_ClassStanding.getValue().equalsIgnoreCase("None")
                    && !(tf_JobTitle.getText().equalsIgnoreCase("")) && (tf_Rank.getText().equalsIgnoreCase("")) ){

                person = new Text(CreateMainMenuDataBase.data.findStaffByJobTitleFirstName(tf_JobTitle.getText(), tf_FirstName.getText()));
                person.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));


            }
            //find a staff by last name and job title
            else if ( (tf_FirstName.getText().equalsIgnoreCase("")) && !(tf_LastName.getText().equalsIgnoreCase(""))
                    && cb_PersonType.getValue().equalsIgnoreCase("Staff") && cb_ClassStanding.getValue().equalsIgnoreCase("None")
                    && !(tf_JobTitle.getText().equalsIgnoreCase("")) && (tf_Rank.getText().equalsIgnoreCase("")) ){



                person = new Text(CreateMainMenuDataBase.data.findStaffByJobTitleLastName(tf_JobTitle.getText(), tf_LastName.getText()));
                person.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

            }
            //find a staff by firstName and lastName and job title
            else if ( !(tf_FirstName.getText().equalsIgnoreCase("")) && !(tf_LastName.getText().equalsIgnoreCase(""))
                    && cb_PersonType.getValue().equalsIgnoreCase("Staff") && cb_ClassStanding.getValue().equalsIgnoreCase("None")
                    && !(tf_JobTitle.getText().equalsIgnoreCase("")) && (tf_Rank.getText().equalsIgnoreCase("")) ){



                person = new Text(CreateMainMenuDataBase.data.findStaffByJobTitleFirstAndLastName(tf_JobTitle.getText(), tf_FirstName.getText(),tf_LastName.getText() ));
                person.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

            }
            //-------------------------------------Faculty-----------------------------
            //find a Faculty by Rank
            else if( tf_FirstName.getText().equalsIgnoreCase("") && tf_LastName.getText().equalsIgnoreCase("")
                    && cb_PersonType.getValue().equalsIgnoreCase("Faculty") && cb_ClassStanding.getValue().equalsIgnoreCase("None")
                    && tf_JobTitle.getText().equalsIgnoreCase("") && !(tf_Rank.getText().equalsIgnoreCase("")) ) {

                person = new Text(CreateMainMenuDataBase.data.findFacultyByRank(tf_Rank.getText() ));
                person.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));


            }
            //find a Faculty by first name and rank
            else if( !(tf_FirstName.getText().equalsIgnoreCase("")) && tf_LastName.getText().equalsIgnoreCase("")
                    && cb_PersonType.getValue().equalsIgnoreCase("Faculty") && cb_ClassStanding.getValue().equalsIgnoreCase("None")
                    && tf_JobTitle.getText().equalsIgnoreCase("") && !(tf_Rank.getText().equalsIgnoreCase("")) ) {

                person = new Text(CreateMainMenuDataBase.data.findFacultyByRankFirstName(tf_Rank.getText(),tf_FirstName.getText() ));
                person.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));


            }
            //find a Faculty by Last name and Rank
            else if( (tf_FirstName.getText().equalsIgnoreCase("")) && !(tf_LastName.getText().equalsIgnoreCase(""))
                    && cb_PersonType.getValue().equalsIgnoreCase("Faculty") && cb_ClassStanding.getValue().equalsIgnoreCase("None")
                    && tf_JobTitle.getText().equalsIgnoreCase("") && !(tf_Rank.getText().equalsIgnoreCase("")) ) {

                person = new Text(CreateMainMenuDataBase.data.findFacultyByRankLastName(tf_Rank.getText(),tf_LastName.getText() ));
                person.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

            }
            //find faculty by First and LastName and rank
            else if( !(tf_FirstName.getText().equalsIgnoreCase("")) && !(tf_LastName.getText().equalsIgnoreCase(""))
                    && cb_PersonType.getValue().equalsIgnoreCase("Faculty") && cb_ClassStanding.getValue().equalsIgnoreCase("None")
                    && tf_JobTitle.getText().equalsIgnoreCase("") && !(tf_Rank.getText().equalsIgnoreCase("")) ) {

                person = new Text(CreateMainMenuDataBase.data.findFacultyByRankFirstAndLastName(tf_Rank.getText(),tf_FirstName.getText(),tf_LastName.getText() ));
                person.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

            }

            content.getChildren().add(person);

            pane.setCenter(scrollPane);
            pane.setAlignment(scrollPane, Pos.CENTER);
        	
            Scene scene = new Scene(pane);

            st_complete.setTitle("People"); 

            st_complete.setScene(scene); 
            
            st_complete.sizeToScene();

            st_complete.show(); 
        	
        });
        
        

        return position;
    }

    public Text DataBaseTitle(){
        Text title = new Text(75,75,"Find Person");
        title.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD,45));
        title.setFill(Color.WHITESMOKE);
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
