package registers;

import java.util.ArrayList;
import model.Clientes;
import java.util.List;


public class DadosClientes {
    
    //ArrayList clist;
    
    List<Clientes> clist;//lista de obj Clientes
    
    public DadosClientes(){
        
      //clist = new ArrayList();        
        clist = new ArrayList<>();
    }
    public boolean addCliente(Clientes cl){
        try {
            this.clist.add(cl);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean excluirCliente(Clientes cl){//nome ou cpf
        try {
            this.clist.remove(cl);
        } catch (Exception e) {
            return false;
        }
        return true;   
    }
    
    public int qtdClientes(){
        return clist.size();
    }
    
    // BuscarClientepor nome
    // BuscarCliente por cpf
    // Listar Clientes
    // Alterar Cliente?
    
}
