
package registers;

import java.util.ArrayList;
import java.util.List;

import model.Funcionarios;

public class DadosFuncionarios {
  
    List<Funcionarios> listaFuncionarios;
    
    public DadosFuncionarios(){
        
        listaFuncionarios = new ArrayList<>();
    }
    
    public boolean adicionarFuncionario(Funcionarios funcionario){
        try {
            this.listaFuncionarios.add(funcionario);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean excluirFuncionario(Funcionarios funcionario){
        try {
        	this.listaFuncionarios.remove(funcionario);
        } catch (Exception e) {
            return false;
        }
        return true;   
    }
     
    public int quantidadeFuncionarios(){
        return listaFuncionarios.size();
    }
    
    public Funcionarios buscarFuncionarioPorNome(String nome) {
    	return listaFuncionarios.stream().filter(funcionario -> funcionario.getNome().equals(nome)).findAny().orElse(null);
    }
    
    public Funcionarios buscarFuncionarioPorCPF(String cpf) {
    	return listaFuncionarios.stream().filter(funcionario -> funcionario.getCpf().equals(cpf)).findAny().orElse(null);
    }

}
