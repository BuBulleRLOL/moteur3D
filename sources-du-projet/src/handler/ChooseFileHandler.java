package handler;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.PLYData;
import model.PLYModel;
import parser.PLYParser;
/**
 * ChooseFileHandler permet de choisir un ply sur son ordinateur
 * @author colin
 *
 */
public class ChooseFileHandler implements EventHandler<ActionEvent> {
	
	public static final String BASE_DIR_FILES = '.' + File.separatorChar + "exemples";
	
	private final PLYModel model;
	
	public ChooseFileHandler(PLYModel model) {
		this.model = model;
	}

	@Override
	public void handle(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("ply Files", "*.ply"));
		
		File f = fileChooser.showOpenDialog(null);
		
		try {
			PLYData plyData = PLYParser.parsingPLY(f);
			model.setData(plyData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
