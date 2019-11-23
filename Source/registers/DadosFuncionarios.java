
package registers;

import model.Funcionarios;
import java.util.List;
import java.util.ArrayList;

public class DadosFuncionarios {
    
    //ArrayList fclist;
    
    List<Funcionarios> fclist;//lista de obj Funcionarios
    
    public DadosFuncionarios(){
        
      //fclist = new ArrayList();        
        fclist = new ArrayList<>();
    }
    
    public boolean addCliente(Funcionarios cl){
        try {
            this.fclist.add(cl);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean excluirCliente(Funcionarios cl){//nome ou cpf
        try {
            this.fclist.remove(cl);
        } catch (Exception e) {
            return false;
        }
        return true;   
    }
    
    public int qtdFuncionarios(){
        return fclist.size();
    }
    
    // BuscarFuncionario por nome
    // BuscarFuncionario por cpf
    // Listar Funcionarios
    // Alterar Funcionario?

}
