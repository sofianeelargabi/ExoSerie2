package formation.afpaStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamExample {    //CETTE CLASSE NE PERMET L'ECRITURE QUE BYTE PAR BYTE 

	public static void main(String[] args) {
		try {
			File file = new File("toto");
		
			file.mkdirs();
		

			OutputStream w = new FileOutputStream("toto/toto.txt");
			
			byte[] bonjour = {'B','o','n','j','o','u','r',' '};
			byte[] bonsoir = {'B','o','n','s','o','i','r','\n'};
//			for (int i = 0; i < bonjour.length; i++) {
//				byte b = bonjour[i];
//				w.write(b);
//			}
			w.write(bonjour);
			w.flush(); // vide le canal (close temporaire qui permet d'écrire qd même après)
			w.write(bonsoir);
			
				
				
			
				
			w.write(97); // code ASCII
			w.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
