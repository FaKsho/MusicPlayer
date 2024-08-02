package application;

import java.io.File;

import javafx.geometry.Insets;

import javafx.scene.media.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import models.*;
import subPanels.*;



public class MainPane extends BorderPane {
	
	MenuBar menuBar;
	Menu menuFile;
	Menu subMenuOpen;
	MenuItem menuItemOpenFile, menuItemOpenFolder;
	
	FileSelector fileSelector;
	
	MediaPlayer mediaPlayer;
	
	MainPane() {
		
		
		/*
		Image image = new Image(getClass().getResource("/res/play.png").toExternalForm());
		mcb.setGraphic(new ImageView(image));
		*/

		
		// menu 
		
		menuBar = new MenuBar();
		menuFile = new Menu("Archivo");
		
		menuItemOpenFile = new MenuItem("Archivo");
		menuItemOpenFolder = new MenuItem("Carpeta");
		
		menuFile.getItems().addAll(menuItemOpenFile, menuItemOpenFolder);
		menuItemOpenFile.setOnAction(e -> openFileSelector());
		menuItemOpenFolder.setOnAction(e -> openFolderSelector());
		
		menuBar.getMenus().addAll(menuFile);
		
		
		
		// adding
		setTop(menuBar);
		setCenter(new MusicListPane());
		setBottom(new MusicControlPane());

	}
	
	// estos métodos deberían estar en otro lado
	
	public static void openFileSelector() {
			
		FileSelector fs = new FileSelector();
			
		File file = fs.openFileSelector();
			
		MusicListPane.setFiles(file);

	}
		
	public static void openFolderSelector() {
			
		File folder = FolderSelector.openFolderSelector();
			
		MusicListPane.setFiles(folder.listFiles());

	}

}
