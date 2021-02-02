package formation.afpaStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {
	public static void main(String[] args) {


		try {
			InputStream	is = new FileInputStream("toto/toto.txt"); //InputStream est abstraite donc utiliser une classe non abstraite qui l'implément pur instancier un objet
			int i = -1;
//			while ((i=is.read())!=-1) { //tant que i est différent de -1 tu stockes dans i et lecture byte par byte sinon tu sors de la boucle
//				System.out.println(i +":"+(char)i);
//			}
			byte [] tmp = new byte[10];
			while ((i=is.read(tmp)) != -1) {
				String s = new String (tmp,0,i);
				System.out.println(s);
			}
		
			is.close();   //fermeture du flux cruciale !

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){

			e.printStackTrace();
		}

	}
}