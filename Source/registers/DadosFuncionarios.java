
package registers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Agencia;
import model.Endereco;
import model.Funcionarios;
import model.Gerente;

public class DadosFuncionarios {
  
    List<Funcionarios> listaFuncionarios;
    
    public DadosFuncionarios(){
        
        listaFuncionarios = new ArrayList<>();
        listaFuncionarios.add(new Gerente("Gerente teste", "65106903653", new Date(), 'F', "16389174", "Casado", new Agencia(), new Endereco(), "111", 1002.20, new Date(), true));
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
    
    public List<Funcionarios> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(List<Funcionarios> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	public Funcionarios buscarFuncionarioPorNome(String nome) {
    	return listaFuncionarios.stream().filter(funcionario -> funcionario.getNome().equals(nome)).findAny().orElse(null);
    }
    
    public Funcionarios buscarFuncionarioPorCPF(String cpf) {
    	return listaFuncionarios.stream().filter(funcionario -> funcionario.getCpf().equals(cpf)).findAny().orElse(null);
    }

    public String[] getListaGerentes() {
    	String[] model = new String[listaFuncionarios.size()];
		int i = 0;
		for(Funcionarios funcionario : listaFuncionarios) {
			if (funcionario.getCargoEmpresa().equals("Gerente")) {
				model[i] = funcionario.getNome();
				i++;
			}
		}
    	return model;
    }
}
