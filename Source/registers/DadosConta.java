package registers;
    
import java.util.List;
import java.util.ArrayList;
import model.*;

public class DadosConta {

    List<Conta> listaContas;
    
    public DadosConta(){
        
        listaContas = new ArrayList<>();
    }
    
    public boolean adicionarContas(Conta ct){
        try {
            this.listaContas.add(ct);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean removerConta(Conta ct){
        try {
            this.listaContas.remove(ct);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public List listarContas(){
        return listaContas;
    }
    
    public int quantidadeContas(){
        return listaContas.size();
    }
    
}
