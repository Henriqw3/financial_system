package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import model.Clientes;
import javax.swing.JPanel;

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
		
		corrente = new JPanel();
		tabbedPane.addTab("Conta Corrente", null, corrente, null);
		lblNumeroConta = new JLabel("Número da Conta: " + cliente.getContas()[0].getNumConta());
		lblNumeroConta.setBounds(20, 12, 720, 24);
		corrente.add(lblNumeroConta);
		lblNumAgencia = new JLabel("Número da Conta: " + cliente.getContas()[0].getNumConta());
		lblNumAgencia.setBounds(20, 12, 720, 24);
		corrente.add(lblNumAgencia);
		lblSaldo = new JLabel("Saldo: R$" + cliente.getContas()[0].getSaldo());
		lblSaldo.setBounds(20, 12, 720, 24);
		corrente.add(lblSaldo);
		
		poupanca = new JPanel();
		tabbedPane.addTab("Conta Poupança", null, poupanca, null);
		
		salario = new JPanel();
		tabbedPane.addTab("Conta Salário", null, salario, null);
	}

	public void setVisible(boolean arg) {
		frame.setVisible(arg);
	}
}
