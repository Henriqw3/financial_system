package registers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Agencia;
import model.Clientes;
import model.Endereco;


public class DadosClientes {
    
    
    List<Clientes> listaClientes;
    
    public DadosClientes(){
        listaClientes = new ArrayList<>();
        listaClientes.add(new Clientes("Cliente Teste", "15538446611", new Date(), 'M', "16389174", "Solteiro", new Agencia(), new Endereco(), "teste"));
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
    
    public List<Clientes> getListaClientes() {
		return listaClientes;
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
