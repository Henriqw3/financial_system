package registers;

import java.util.ArrayList;
import model.Agencia;
import java.util.List;

public class DadosAgencias {
    
    //ArrayList aglist;
    
    List<Agencia> aglist;//lista de obj Agencia
    
    public DadosAgencias(){
        
      //aglist = new ArrayList();        
        aglist = new ArrayList<>();
    }
    
    public boolean addAgencia(Agencia cl){
        try {
            this.aglist.add(cl);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean excluirAgencia(Agencia cl){//nome ou cpf
        try {
            this.aglist.remove(cl);
        } catch (Exception e) {
            return false;
        }
        return true;   
    }
    
    public int qtdAgencia(){
        return aglist.size();
    }
    
    // BuscarClientepor nome
    // BuscarCliente por cpf
    // Listar Clientes
    // Alterar Cliente?
}
