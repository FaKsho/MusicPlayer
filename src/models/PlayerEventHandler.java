package models;

import java.io.File;

import javafx.scene.control.ListView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import subPanels.MusicListPane;

public class PlayerEventHandler {
	
	private static MediaPlayer mediaPlayer; 

	private static boolean playing = false;
	
	
	public PlayerEventHandler(File selectedSong) {
		
		mediaPlayer = startMediaPlayer(selectedSong);
	}

	
	public static boolean isPlaying() {
		
		return playing;
	}
	
	public static void play() {
		
		if(!playing) {
			
			mediaPlayer.play();
			playing = true;
		} else {
			
			pause();
			play();
		}
	}
	
	public static void pause() {
		
		if(playing) {
			
			mediaPlayer.pause();
			playing = false;
		}
		
	}
	
	private static MediaPlayer startMediaPlayer(File fileSetted) {	
		
		mediaPlayer = new MediaPlayer(new Media(fileSetted.toURI().toString()));
		return mediaPlayer;
	}
}
