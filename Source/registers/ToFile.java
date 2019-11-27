package registers;

import java.io.*;
import java.util.Scanner;

public class ToFile {
	
	public static void ReadFile(String arquivo) {
		try {
			Scanner read = new Scanner(new FileInputStream(arquivo+".txt"));
			
			while(read.hasNextLine()) {
				String line = read.nextLine();
				System.out.println(line);
			}
				read.close();
		}catch (FileNotFoundException error) {
			System.out.println("Arquivo não encontrado!");
		}
	}

	public static void WriteFile(String msg, String nomeArq) {
		
		try {
			PrintStream write = new PrintStream(nomeArq+".txt");
			write.println(msg);
		} catch(FileNotFoundException error){
			System.out.println("Não foi possível criar o arquivo!")
		}
	}
}