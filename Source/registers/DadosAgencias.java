package registers;

import java.util.ArrayList;
import model.Agencia;
import model.Clientes;

import java.util.List;

public class DadosAgencias {
   
    List<Agencia> listaAgencias;
    
    public DadosAgencias(){
        listaAgencias = new ArrayList<>();
    }
    
    public boolean adicionarAgencia(Agencia agencia){
        try {
            this.listaAgencias.add(agencia);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean excluirAgencia(Agencia agencia){
        try {
            this.listaAgencias.remove(agencia);
        } catch (Exception e) {
            return false;
        }
        return true;   
    }
    
    public int quantidadeAgencia(){
        return listaAgencias.size();
    }
    
    public List<Agencia> getListaAgencias() {
  		return listaAgencias;
  	}
}
