package fr.formation.afpa.io.reader.writer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedReaderExample { // PERMET DE LIRE DES LIGNES ENTIERES ET NON PLUS CARACTERE PAR CARACTERE OU PAR
										// LOT

	public static void main(String[] args) {

		try {
			File file = new File("rw/multi_lines.txt");
			file.createNewFile();
			InputStream in = new FileInputStream("rw/multi_lines.txt");
			Reader reader = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(reader);

			String s = null;
			int i = 0;

			while ((s = br.readLine()) != null) {
				i++;
				System.out.println(i+ " : "+ s);
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
