package formation.afpaStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DataInputStringExample {

	public static void main(String[] args) {

		InputStream is;
		try {
			is = new FileInputStream("toto/data.txt");
			DataInputStream dis = new DataInputStream(is);
			
			int codePostal = dis.readInt();
			String nom = dis.readUTF();
			long nbr = dis.readLong();
			float tmp = dis.readFloat(); 
			
			System.out.println("CodePostal : "+codePostal);
			System.out.println("Nom ville : "+nom);
			System.out.println("Nombre d'habitants : "+nbr);
			System.out.println("Température : "+tmp+ " °");
			
			
			dis.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}