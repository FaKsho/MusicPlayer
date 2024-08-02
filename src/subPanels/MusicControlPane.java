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
	
	private static MediaPlayer mediaPlayer; 
	
	private static boolean playing;
	
	private static File fileSetted;
	
	ListView<File> lv = MusicListPane.getPlayList();
	
	public MusicControlPane() {
		
		playing = false;
		
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
		
		fileSetted = lv.getSelectionModel().getSelectedItem();
		
		mediaPlayer.setVolume(0.05);
		
		try {
			
			if(!playing) {
				mediaPlayer.play();
				playing = true;
			} else {
				mediaPlayer.pause();
				playing = false;
			}
			
		} catch (Exception e) {
			
			System.out.println("Elija un archivo"); // esto no debería estar acá
			e.printStackTrace();
			
		}
	
	}
	

	public static MediaPlayer startMediaPlayer() {	
		
		mediaPlayer = new MediaPlayer(new Media(fileSetted.toURI().toString()));
		return mediaPlayer;
	}
	
	public static boolean isPlaying() {
		
		return playing;
	}
	

}
