package registers;

import java.util.ArrayList;
import model.Clientes;
import java.util.List;


public class DadosClientes {
    
    
    List<Clientes> listaClientes;
    
    public DadosClientes(){
        listaClientes = new ArrayList<>();
    }
    public boolean adicionarCliente(Clientes cliente){
        try {
            this.listaClientes.add(cliente);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean excluirCliente(Clientes cliente) {
        try {
            this.listaClientes.remove(cliente);
        } catch (Exception e) {
            return false;
        }
        return true;   
    }
    
    public int quantidadeClientes(){
        return listaClientes.size();
    }
    
    public Clientes buscarClientePorNome(String nome) {
    	return listaClientes.stream()
    			.filter(cliente -> cliente.getNome().equals(nome))
    			.findAny().orElse(null);
    }
    
    public Clientes buscarClientePorCPF(String cpf) {
    	return listaClientes.stream()
    			.filter(cliente -> cliente.getCpf().equals(cpf))
    			.findAny().orElse(null);
    }
}
