package handler;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeItem;
import model.PLYData;
import model.PLYModel;
import parser.PLYParser;
/**
 * ChooseFileListHandler Affiche la liste des ply du projet et permet de choisir un ply
 * @author colin
 *
 */
public class ChooseFileListHandler implements ChangeListener<TreeItem<String>> {
	/**
	 * Model attaché
	 */
	private final PLYModel model;
	/**
	 * Construteur
	 * @param model
	 */
	public ChooseFileListHandler(PLYModel model) {
		this.model = model;
	}

	@Override
	public void changed(
			ObservableValue<? extends TreeItem<String>> observable, 
					TreeItem<String> oldValue,
					TreeItem<String> newValue) {
		
		String file = newValue.getValue();
		
		try {
			
			PLYData data = PLYParser.parsingPLY(file);
			model.setData(data);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
