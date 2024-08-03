package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import models.FileSelector;
import models.FolderSelector;
import javafx.scene.Scene;

public class Main extends Application {
	
	static Stage primaryStage;
	
	@Override
	
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		
		try {
			
			MainPane root = new MainPane();
			
			Scene scene = new Scene(root,400,200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setTitle("Music Player");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Stage getStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
