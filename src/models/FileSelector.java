package models;

import java.io.File;


import application.Main;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FileSelector  {
	
	private FileChooser fileChooser;
	private File fileSelected;
	
	public FileSelector() {
		
		fileChooser = new FileChooser();
		fileChooser.setTitle("Elije una canción");
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"));
		
	}
		
	public File openFileSelector() {
		
		return fileSelected = fileChooser.showOpenDialog(Main.getStage());
	}
}
