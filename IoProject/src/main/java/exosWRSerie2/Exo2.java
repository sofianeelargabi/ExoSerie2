package exosWRSerie2;


import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class Exo2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Entrez le nom du fichier à partir duquel vous souhaiter lire/copier :");
			String a = sc.nextLine();

			System.out.println("Entrez le nom du fichier vers lequel vous souhaiter écrire/coller :");
			String b = sc.nextLine();
			Exo2Const ex = new Exo2Const(a, b);

			File source = new File(ex.getSource());

			File dest = new File(ex.getDest());

			try {
				copiesLignes(source, dest);
				//copiesCaracteres(source, dest);
			} catch (FileNotFoundException e) {
				System.out.println("Fichier introuvable");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public static void copiesCaracteres(File a, File b) throws Exception {
		FileInputStream in = new FileInputStream(a);
		FileOutputStream out = new FileOutputStream(b);
		try {
			int n;
			while ((n = in.read()) != -1) {
				out.write(n);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
		System.out.println("Fichier copié");
	}

	public static void copiesLignes(File a, File b) throws Exception {

		InputStream in = new FileInputStream(a);
		Reader reader = new InputStreamReader(in);
		OutputStream out = new FileOutputStream(b);
		Writer writer = new OutputStreamWriter(out);
		
		try {
			int s = 0;

			while ((s = reader.read()) != -1) {

				writer.write(s);

			}

		} finally {
			if (reader != null) {
				reader.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
		System.out.println("Fichier copié");
	}

}