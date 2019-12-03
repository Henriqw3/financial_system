package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import model.Clientes;

public class FrmConta {

	private JFrame frame;
	private JLabel lblSaudacao;
	private JTabbedPane tabbedPane;
	private JPanel corrente;
	private JPanel poupanca;
	private JPanel salario;
	private JLabel lblNumeroConta;
	private JLabel lblSaldo;
	private JLabel lblDataUlt;
	private JLabel lblNumAgencia;
        private JLabel lblNumeroConta1;
	private JLabel lblSaldo1;
	private JLabel lblDataUlt1;
	private JLabel lblNumAgencia1;
        private JLabel lblNumeroConta2;
	private JLabel lblSaldo2;
	private JLabel lblDataUlt2;
	private JLabel lblNumAgencia2;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConta window = new FrmConta(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FrmConta(Clientes cliente) {
		initialize(cliente);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			UIManager.getSystemLookAndFeelClassName();
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initialize(Clientes cliente) {
		frame = new JFrame("Financial System - TELA CONTA");
		frame.setBounds(100, 100, 720, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		frame.getContentPane().setLayout(null);
		
		lblSaudacao = new JLabel("Olá, " + cliente.getNome() + "!");
		lblSaudacao.setBounds(20, 12, 720, 24);
		frame.getContentPane().add(lblSaudacao);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 40, 720, 500);
		frame.getContentPane().add(tabbedPane);
		
		if (cliente.getContas()[0] != null) {
			corrente = new JPanel();
            corrente.setLayout(null);
			tabbedPane.addTab("Conta Corrente", null, corrente, null);
			lblNumeroConta = new JLabel("Número da Conta: " + cliente.getContas()[0].getNumConta());;
			lblNumeroConta.setBounds(20, 40, 400, 24);
			corrente.add(lblNumeroConta);
			lblNumAgencia = new JLabel("Número da Conta: " + cliente.getContas()[0].getNumConta());
			lblNumAgencia.setBounds(20, 80, 400, 24);
			corrente.add(lblNumAgencia);
			lblSaldo = new JLabel("Saldo: R$" + cliente.getContas()[0].getSaldo());
			lblSaldo.setBounds(20, 120, 400, 24);
			corrente.add(lblSaldo);
		} else {
			corrente = new JPanel();
            corrente.setLayout(null);
			tabbedPane.addTab("Conta Corrente", null, corrente, null);
			lblNumeroConta = new JLabel("Número da Conta: ");;
			lblNumeroConta.setBounds(20, 40, 400, 24);
			corrente.add(lblNumeroConta);
			lblNumAgencia = new JLabel("Número da Conta: ");
			lblNumAgencia.setBounds(20, 80, 400, 24);
			corrente.add(lblNumAgencia);
			lblSaldo = new JLabel("Saldo: R$");
			lblSaldo.setBounds(20, 120, 400, 24);
			corrente.add(lblSaldo);
		}
		
		if (cliente.getContas()[1] != null) {
			poupanca = new JPanel();
	                poupanca.setLayout(null);
			tabbedPane.addTab("Conta Poupança", null, poupanca, null);
			lblNumeroConta1 = new JLabel("Número da Conta: " + cliente.getContas()[1].getNumConta());;
			lblNumeroConta1.setBounds(20, 40, 400, 24);
			poupanca.add(lblNumeroConta1);
			lblNumAgencia1 = new JLabel("Número da Conta: " + cliente.getContas()[1].getNumConta());
			lblNumAgencia1.setBounds(20, 80, 400, 24);
			poupanca.add(lblNumAgencia1);
			lblSaldo1 = new JLabel("Saldo: R$" + cliente.getContas()[1].getSaldo());
			lblSaldo1.setBounds(20, 120, 400, 24);
			poupanca.add(lblSaldo1);
		} else {
			poupanca = new JPanel();
            poupanca.setLayout(null);
			tabbedPane.addTab("Conta Poupança", null, poupanca, null);
			lblNumeroConta1 = new JLabel("Número da Conta: " );;
			lblNumeroConta1.setBounds(20, 40, 400, 24);
			poupanca.add(lblNumeroConta1);
			lblNumAgencia1 = new JLabel("Número da Conta: " );
			lblNumAgencia1.setBounds(20, 80, 400, 24);
			poupanca.add(lblNumAgencia1);
			lblSaldo1 = new JLabel("Saldo: R$" );
			lblSaldo1.setBounds(20, 120, 400, 24);
			poupanca.add(lblSaldo1);
		}
		
		if (cliente.getContas()[2] != null) {
			salario = new JPanel();
            salario.setLayout(null);
			tabbedPane.addTab("Conta Salário", null, salario, null);
		            lblNumeroConta2 = new JLabel("Número da Conta: " + cliente.getContas()[2].getNumConta());;
			lblNumeroConta2.setBounds(20, 40, 400, 24);
			salario.add(lblNumeroConta2);
			lblNumAgencia2 = new JLabel("Número da Conta: " + cliente.getContas()[2].getNumConta());
			lblNumAgencia2.setBounds(20, 80, 400, 24);
			salario.add(lblNumAgencia2);
			lblSaldo2 = new JLabel("Saldo: R$" + cliente.getContas()[2].getSaldo());
			lblSaldo2.setBounds(20, 120, 400, 24);
			salario.add(lblSaldo2);
		} else {
			salario = new JPanel();
            salario.setLayout(null);
			tabbedPane.addTab("Conta Salário", null, salario, null);
		            lblNumeroConta2 = new JLabel("Número da Conta: " );;
			lblNumeroConta2.setBounds(20, 40, 400, 24);
			salario.add(lblNumeroConta2);
			lblNumAgencia2 = new JLabel("Número da Conta: " );
			lblNumAgencia2.setBounds(20, 80, 400, 24);
			salario.add(lblNumAgencia2);
			lblSaldo2 = new JLabel("Saldo: R$");
			lblSaldo2.setBounds(20, 120, 400, 24);
			salario.add(lblSaldo2);
		}
	}

	public void setVisible(boolean arg) {
		frame.setVisible(arg);
	}
}