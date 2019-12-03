package registers;

import java.util.ArrayList;
import java.util.List;

import model.Agencia;
import model.Endereco;
import model.Gerente;

public class DadosAgencias {
   
    List<Agencia> listaAgencias;
    
    public DadosAgencias(){
        listaAgencias = new ArrayList<>();
        listaAgencias.add(new Agencia(0, "Agência 0", new Endereco(), new Gerente()));
    }
    
    public int nextNum() {
    	int higher =  listaAgencias.isEmpty() ?  1 : listaAgencias.get(0).getNumeroAgencia();
    	if (!listaAgencias.isEmpty()) {
    		for(Agencia agencia : listaAgencias) {
        		if (agencia.getNumeroAgencia() > higher)
        				higher = agencia.getNumeroAgencia();
        	}
    	}
    	return higher + 1;
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
    
    public String[] getListaNomeAgencias() {
    	String[] nomes = new String[listaAgencias.size()];
    	int i = 0;
    	for(Agencia agencia : listaAgencias) {
    		nomes[i] = agencia.getNomeAgencia();
    		i++;
    	}
    	return nomes;
    }
    
    public Agencia buscarAgenciaPorNome(String nome) {
    	return listaAgencias.stream().filter(agencia -> agencia.getNomeAgencia().equals(nome)).findAny().orElse(null);
    }
    
    
    
}
