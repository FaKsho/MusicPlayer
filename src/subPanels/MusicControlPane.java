package subPanels;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import application.MainPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import models.*;

public class MusicControlPane extends HBox {
	
	private MusicControlButton previousButton, nextButton;
	private PlayPauseButton playPauseButton;
	
	private ArrayList<MusicControlButton> controls;
	
	public MusicControlPane() {
		
		// layout setup
		
		setPadding(new Insets(5));
		setAlignment(Pos.CENTER);
		setSpacing(5);

		
		// controls
		controls = new ArrayList<>();
	
		playPauseButton = new PlayPauseButton();
		previousButton = new MusicControlButton("<<");
		nextButton = new MusicControlButton(">>");
		
		playPauseButton.setOnAction(e -> playHandler());
		
		// adding
	
		controls.add(previousButton);
		controls.add(playPauseButton);
		controls.add(nextButton);
		
		getChildren().addAll(controls);
	
		
	}
	
	
	public void playHandler() {
		
		boolean playing = PlayerEventHandler.isPlaying();
		
		try {
			
			if(!playing) {
				
				PlayerEventHandler.play();
				
				
			} else {
				
				PlayerEventHandler.pause();
				
			}
			
		} catch (Exception e) {
			
			System.out.println("Elija un archivo"); // esto no debería estar acá
			e.printStackTrace();
			
		}
	
	}
	
}
