package model;

import java.util.Date;

public class Transacao {
	
	private Date data;
	private Double valor;
	private String canal;
	
	public Transacao(Date data, Double valor, String canal) {
		super();
		setCanal(canal);
		setData(data);
		setValor(valor);
	}
        
        public boolean transferencia(double value, Conta orig, Conta dest){
            try {
                if(orig.getSaldo() < value) return false;
                dest.setSaldo(dest.getSaldo()+value);
                orig.setSaldo(orig.getSaldo()-value);
                setData(new Date());
                setValor(value);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        
        public boolean saque(double value, Conta contClient){
            try {
                if(contClient.getSaldo() < value) return false;
                contClient.setSaldo(contClient.getSaldo()-value);
                setData(new Date());
                setValor(value);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        
        public boolean depositar(Conta dest, double value){
            try {
                dest.setSaldo(dest.getSaldo()+value);
                setData(new Date());
                setValor(value);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            return false;
        
        }
        
        public boolean pagarConta(Conta client, double value){
            try {
                if(client.getSaldo()>value){
                client.setSaldo(client.getSaldo()-value);
                setData(new Date());
                setValor(value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public String getCanal() {
		return canal;
	}
	
	public void setCanal(String canal) {
		this.canal = canal;
	}
	
}
