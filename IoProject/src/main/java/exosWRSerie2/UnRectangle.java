package exosWRSerie2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class UnRectangle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2824126506186420755L;
	private int largeur, hauteur;
	private UnPoint coin;

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public UnPoint getCoin() {
		return coin;
	}

	public UnRectangle(UnPoint clg, int i, int h) {
		if (clg == null)
			coin = new UnPoint(0, 0);
		else
			coin = clg;
		if (i < 1)
			largeur = 1;
		else
			largeur = i;
		if (h < 1)
			hauteur = 1;
		else
			hauteur = h;
	}

	public void translation(int dx, int dy) {
		coin.translation(dx, dy);
	}

	public void saveRectangle() {

		File file = new File("saverectangle.txt");

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static UnRectangle restitutionRectangle() {

		UnRectangle rectangle = null;

		File file = new File("saverectangle.txt");

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(fis);
			try {
				rectangle = (UnRectangle) ois.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return rectangle;
	}

	public static void main(String[] args) {

		UnRectangle premier = new UnRectangle(new UnPoint(2, 3), 5, 5);

		System.out.println("Hauteur : " + premier.getHauteur() + " Largeur : " + premier.getLargeur());
		System.out.println("Coin Premier : " + premier.getCoin().toString());

		premier.saveRectangle();

		UnRectangle second = null;

		second = restitutionRectangle();

		System.out.println("Hauteur : " + second.getHauteur() + " Largeur : " + second.getLargeur());
		System.out.println("Coin Second : " + second.getCoin().toString());

	}

}
