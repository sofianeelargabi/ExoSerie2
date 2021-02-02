package exosWRSerie2;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exo3 {
	private double val;

	public Exo3(double val) {
		this.val = val;
	}

	public double getVal() {
		return val;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		try {
			File f = new File("exo3");
			System.out.println("Entrez votre valeur : ");
			double val=scan.nextDouble();
			
			Exo3 e = new Exo3(val);
			
			remplitFichier(f, e.getVal());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.err.println("entrée non valide");
		} 
		catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void remplitFichier(File f, double val) throws Exception {
	
		if (f.exists()) {
			if (f.isFile()) {
				
				OutputStream w = new FileOutputStream(f);
				DataOutputStream dos = new DataOutputStream(w);
				double total = 0;
	
					for (int i = 1; i < 6; i++) {
						total = val * i;
						System.out.println(i+" "+total);
					}

				dos.close();
			}
		}

	}

}
