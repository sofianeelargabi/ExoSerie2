package formation.afpaStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectInputStringExample {

	public static void main(String[] args) {
		InputStream is;
		try {
			is = new FileInputStream("toto/objet.txt");
			ObjectInputStream dis = new ObjectInputStream(is);

			try {
				String nom = dis.readUTF();
				Date date = (Date) dis.readObject();
				Voiture v1 = (Voiture) dis.readObject();
				Voiture v2 = (Voiture) dis.readObject();
				Voiture v3 = (Voiture) dis.readObject();
				List <Voiture> l = new ArrayList<Voiture>();
				for (Voiture o : l) {
					System.out.println(o.getMarque()+" "+o.getModele()+" année "+o.getAnnee()) ;
					
				}
				System.out.println();
				System.out.println("Nom : "+nom);
				System.out.println("Date : "+date);
				System.out.println("Voiture 1 : "+ v1.getMarque()+ " " +v1.getModele()+ " année " +v1.getAnnee());
				System.out.println("Voiture 2 : "+ v2.getMarque()+ " " +v2.getModele()+ " année " +v2.getAnnee());
				System.out.println("Voiture 3 : "+ v3.getMarque()+ " " +v3.getModele()+ " année " +v3.getAnnee());;

				dis.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}