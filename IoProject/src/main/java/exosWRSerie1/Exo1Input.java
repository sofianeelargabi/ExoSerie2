package exosWRSerie1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Exo1Input {

	public static void main(String[] args) {

		try {
			InputStream is = new FileInputStream("chocho");
			Reader reader = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(reader);
			String s = null;


			while ((s = br.readLine()) != null) {
				
				System.out.println( s);
			}
			
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

//		try {
//			InputStream is = new FileInputStream("2");
//			DataInputStream dis = new DataInputStream(is);
//
//			int i = 0;
//			byte[] tmp = new byte[20];
//			while ((i = is.read(tmp)) != -1) {
//
//				String s = new String(tmp, 0, i);
//				System.out.println(s);
//			}
//			dis.close();
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}

	}
}
