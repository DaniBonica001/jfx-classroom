package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Classroom;

public class Main extends Application {
	
	//Atributes
	private Classroom classroom;
	private ClassroomGUI classroomGUI;
	
	public Main() {
		classroom = new Classroom();
		classroomGUI = new ClassroomGUI(classroom);
	}

	public static void main(String[] args) {		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader mainFxml = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		mainFxml.setController(classroomGUI);
		Parent mainRoot = mainFxml.load();
		
		Scene scene = new Scene(mainRoot);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Classroom");
		primaryStage.show();		
				
	}

	

}
