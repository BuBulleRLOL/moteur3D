package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.naming.OperationNotSupportedException;

import model.PLYData;
import moteur.Face;
import moteur.Point;
/**
 * PLYParser lit les données d'un fichier ply et les envoies à PLYData afin de les utiliser plus tard
 * @author colin
 *
 */
public final class PLYParser {
	
	static Logger logger = Logger.getLogger(PLYParser.class.getName());
	
	private PLYParser() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
	
	/**
	 * Appelle la fonction de parsing en lui passant le chemin (par d�faut exemples/) + le nom du fichier PLY
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static PLYData parsingPLY(String fileName) throws IOException, NumberFormatException, ArrayIndexOutOfBoundsException {
		return parsingPLY(new File("exemples/" + fileName ));
	}
	
	/**
	 * Fonction principale du Parser
	 * Elle s'occupe de r�cup�rer toutes les infos importantes d'un fichier PLY donn� en param�tre
	 * Cette fonction s'appuie sur des fonctions de parsing sp�cifiques
	 * @param plyFile
	 * @return
	 * @throws IOException
	 */
	public static PLYData parsingPLY(File plyFile) throws IOException {
		Point[] points;
		Face[] faces;
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(plyFile)))){

			String head = reader.readLine();
			if(!head.equals("ply")) {
				logger.fine("La ligne ne correspond pas au type ply");
				return null;
			}

			String format = reader.readLine();
			if(!verifFormat(format)) {
				logger.fine("Le format n'est pas correct");
				return null;
			}

			String lineVertex = readWhileNotContains(reader, "vertex");
			Integer nbVertex = getNumberData(lineVertex);
			if(nbVertex == null) {
				logger.fine("Le nombre de vertex ne peut pas etre lu");
				return null;
			}

			String line = readWhileNotContains(reader, "face");
			Integer nbFaces = getNumberData(line);
			if(nbFaces == null) {
				logger.fine("Le nombre de faces ne peut pas etre lu");
				return null;
			}

			line = readWhileNotContains(reader, "end_header");

			points = readVertex(reader, nbVertex);
			if(points == null) {
				logger.fine("Impossible de lire les points");
				return null;
			}
			
			faces = readFaces(reader, nbFaces, points);
			if(faces == null) {
				logger.fine("Impossible de lire les faces");
				return null;
			}
		}
		return new PLYData(points, faces);
	}


	private static Face[] readFaces(BufferedReader reader, Integer nbFaces, Point[] points) throws IOException {
	
		Face[] faces = new Face[nbFaces];
		
		for(int i = 0; i < nbFaces ; i++) {
			String line = reader.readLine();
			String[] coord = line.split(" ");
			int numberPoint = Integer.parseInt(coord[0]);
			if(coord.length - 1 != numberPoint) {
				//throw
				logger.fine("La longueur ne correspond pas "+ (coord.length - 1) + " /= "+ numberPoint);
				return null;
			}

			Point[] pointsFace = new Point[numberPoint];
			for(int cpt = 0 ; cpt < numberPoint ; cpt++) {
				int indexPoint = Integer.parseInt(coord[cpt + 1]);
				pointsFace[cpt] = points[indexPoint];
			}

			faces[i] = new Face(pointsFace);
		}
		
		return faces;
	}

	private static Point[] readVertex(BufferedReader reader, int nbVertex) throws IOException {
		logger.fine("Vertex : "+nbVertex);
		Point[] points = new Point[nbVertex];
		
		for(int i = 0; i < nbVertex ; i++) {
			String line = reader.readLine();
			String[] coord = line.split(" ");
			final int REGEX = 3;
			if(coord.length < REGEX) {
				//throw
				logger.fine("Coordonn�es probl�mes : "+Arrays.toString(coord));
				return null;
			}
			points[i] = new Point(Double.parseDouble(coord[0]), -Double.parseDouble(coord[1]), Double.parseDouble(coord[2]));
		}
		
		return points;
	}

	private static String readWhileNotContains(BufferedReader reader, String value) throws IOException {
		String line = reader.readLine();
		while(!line.contains(value)) {
			line = reader.readLine(); 
		}
		return line;
	}
	
	/**
	 * R�cup�re le nombre de la ligne
	 * Essentiel pour r�cup�rer le nombre de vertex et de faces
	 * @param line
	 * @return
	 */
	public static Integer getNumberData(String line) {
		int index = line.lastIndexOf(' ');
		if(index == -1) return null;

		try {
			return Integer.parseInt(line.substring(index + 1));
		}catch(NumberFormatException e) {
			return null;
		}
	}

	private static boolean verifFormat(String line) {
		return line.contains("ascii 1.0");
	}	
	
}