package subPanels;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import models.FolderSelector;
import models.PlayerEventHandler;


// Es un stackPane pq no se me ocurre q otra panel usar
public class MusicListPane extends StackPane {
	
	private static ListView<File> playList;
	
	public MusicListPane() {
		
		new FolderSelector();
		
		playList = new ListView<File>();
		playList.setOnMouseClicked(e -> {
			new PlayerEventHandler(playList.getSelectionModel().getSelectedItem());
			PlayerEventHandler.play();
		});
		
		getChildren().add(playList);
		
	}
	
	
	// # Setea los archivos que se muestran en la lista de canciones
	public static void setListFiles(File... files) {
		
		playList.getItems().clear();
		
		ObservableList<File> observableFiles = FXCollections.observableArrayList(files);
		
		playList.setItems(observableFiles);
		

		//TODO: hacer un filtro de solo archivos de audio
		
		playList.setCellFactory(listView -> new ListCell<File>() {
			
			@Override
            protected void updateItem(File file, boolean empty) {
                super.updateItem(file, empty);

                if (file == null || empty) {
                    setText(null);
                } else {

                    setText(file.getName()); // Solo mostrar el nombre del archivo
                    
                }
            }
		});
		
	}
	
	public static ListView<File> getPlayList() {
		
		return playList;
	}
}
