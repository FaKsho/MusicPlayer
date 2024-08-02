package models;

import java.io.File;


import application.Main;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FolderSelector  {
	
	private static DirectoryChooser dirSelected;
	
	public FolderSelector() {
		
		dirSelected = new DirectoryChooser();
		dirSelected.setTitle("Elije una carpeta");
		
	}
		
	public static File openFolderSelector() {
		
		return dirSelected.showDialog(Main.getStage());
	}
}
