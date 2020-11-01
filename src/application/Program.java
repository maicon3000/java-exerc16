package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entre com o caminho do arquivo: ");
		String pathIn = sc.nextLine();
		File file = new File(pathIn);
		String pathOut = file.getParent();
		
		new File(pathOut + "\\out").mkdir();
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathIn)); BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut + "\\out\\summary.csv", true))) {
			String line = br.readLine();
			
			while(line != null) {
				System.out.println(line);
				String[] vect = line.split(",");
				double total = Double.parseDouble(vect[1]) * Integer.parseInt(vect[2]);
				bw.write(vect[0] + "," + String.format("%.2f", total));
				bw.newLine();
				
				line = br.readLine();
			}	
		} catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
		}
	}