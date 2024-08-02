package models;

import javafx.scene.control.Button;

public class MusicControlButton extends Button {

	
	public MusicControlButton(){
		super();
		
		getStyleClass().add("music-control-button");
	}
	
	public MusicControlButton(String title){
		super(title);
		
		
		getStyleClass().add("music-control-button");
	}
	
}
