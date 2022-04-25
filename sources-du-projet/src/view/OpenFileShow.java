package view;

import java.io.File;

import javax.naming.OperationNotSupportedException;

import javafx.scene.control.TreeItem;
/**
 * Permet d'afficher la liste des ply dans le dossier exemples
 * @author colin
 *
 */
public final class OpenFileShow {
	
	private OpenFileShow() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
	/**
	 * Permet d'avoir la liste des ply dans le répértoire exemples
	 * @return
	 */
	public static TreeItem<String> getNodesForDirectory() {
		File repertoire = new File("exemples");
		TreeItem<String> liste = new TreeItem<>(repertoire.getName());
		for (File f : repertoire.listFiles()) {
			if (f.isDirectory()) {
				liste.getChildren().add(getNodesForDirectory());
			} else {
				liste.getChildren().add(new TreeItem<String>(f.getName()));
			}
		}
		return liste;
	}
}
