package models;

import subPanels.MusicControlPane;

public class PlayPauseButton extends MusicControlButton {

	boolean playing;
	
	public PlayPauseButton() {
		super();
		
		this.setText("|>");
		
		this.playing = MusicControlPane.isPlaying();
	
		this.setOnAction(e -> update());
	}	
	
	private void update() {
		
		if(playing) this.setText("||");
		else this.setText("|>");
	}
}
