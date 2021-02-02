package formation.afpaStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectOutputStreamExample {

	public static void main(String[] args) {

		try {
//			File file = new File("momo");  // CREATION DU DOSSIER MOMO AFIN DE POURVOIR Y CREER LE FICHIER OBJET.TXT
//			file.mkdirs();
			
			OutputStream os = new FileOutputStream("toto/objet.txt");
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			oos.writeUTF("voiture de luxe");
			oos.writeObject(new Date());
			
			Voiture v1 = new Voiture ("audi", "S3",2020);
			Voiture v2 = new Voiture ("audi", "RS4",2019);
			Voiture v3 = new Voiture ("audi", "R8",2021);
			List <Voiture> l = new ArrayList<Voiture>();
			
			l.add(v1);
			l.add(v2);
			l.add(v3);
			oos.writeObject(l);
		

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
