package model;

import java.util.Arrays;

import moteur.Face;
import moteur.Point;
/**
 * Stock les points et les faces d'un ply
 * @author colin
 *
 */
public class PLYData {

	public Point[] points;
	public Face[] faces;

	public PLYData(Point[] points, Face[] faces) {
		this.points = points;
		this.faces = faces;
	}

	public Point[] getPoints() {
		return points;
	}

	public void setPoints(Point[] points) {
		this.points = points;
	}

	public Face[] getFaces() {
		return faces;
	}

	public void setFaces(Face[] faces) {
		this.faces = faces;
	}

	public boolean isEmpty() {
		return points == null || points.length == 0;
	}

	@Override
	public String toString() {
		return "PLYData [faces=" + Arrays.toString(faces) + "]";
	}

}
