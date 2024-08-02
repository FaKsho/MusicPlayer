module MusicPlayer {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.media;
	requires javafx.base;
	
	exports models;
	
	opens application to javafx.graphics, javafx.fxml;
}
