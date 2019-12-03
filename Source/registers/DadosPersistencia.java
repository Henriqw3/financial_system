package registers;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class DadosPersistencia {
    
    public static boolean gravar(Object obj, String arquivo ){
        try {
            //Gera o arquivo para armazenar os objetos
            FileOutputStream arquivoGrav = new FileOutputStream(arquivo);
            //Classe responsavel por inserir os objetos
            ObjectOutputStream objGravar = new
            ObjectOutputStream(arquivoGrav);
            //Grava o objeto cliente no arquivo
            objGravar.writeObject(obj);
            objGravar.flush();
            objGravar.close();
            arquivoGrav.flush();
            arquivoGrav.close();
            return true;
        }
        catch(Exception e){ 
            return false; 
        }
    }
    
    public void salvarLista(List list, String nomeArquivo){
        try {
            FileOutputStream out = new FileOutputStream(nomeArquivo);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            
            objOut.writeObject(list);
            objOut.close();
   
        } catch (Exception e) {
        }
    }
    
    public static Object takeFromFile(String arquivo){
        Object obj = null;
        FileInputStream arquivoLeitura = null;
        ObjectInputStream objLeitura = null;
        try {
            //Carrega o arquivo
            arquivoLeitura = new FileInputStream(arquivo);
            //Classe responsavel por recuperar os objetos do arquivo
            objLeitura = new ObjectInputStream(arquivoLeitura);
            //Le o objeto
            obj = objLeitura.readObject();
            objLeitura.close();
            arquivoLeitura.close();
        }
        catch( Exception e ){
            return null;
        }
        return obj;
    }
    
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
			System.out.println("Não foi possível criar o arquivo!");
		}
	}
}

