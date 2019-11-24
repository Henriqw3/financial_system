package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import model.Agencia;
import model.Clientes;
import model.Endereco;
import registers.DadosClientes;

public class FrmClientes extends CompCadastro{

	DadosClientes listaClientes = new DadosClientes();
	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel cadastro;
	private JLabel labelEscolaridade;
	private JTextField textFieldEscolaridade;
	private JButton btnCadastrar;
	private JButton btnRemover;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmClientes window = new FrmClientes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmClientes() {
		initialize();
	}

	private void cleanScreen(JPanel container){
        Component components[] = container.getComponents();
        for(Component component: components){
            if(component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
        }
    }
	
	private void initialize() {
		frame = new JFrame("Financial System - CADASTRO CLIENTES");
		tabbedPane = new JTabbedPane();
		labelEscolaridade = new JLabel("Escolaridade");
		labelEscolaridade.setBounds(50, 170, 90, 15);
		textFieldEscolaridade = new JTextField();
		textFieldEscolaridade.setBounds(150, 165, 157, 24);
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(362, 310, 150, 50);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCadastrarActionPerformed(arg0);
			}
		});
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(522, 310, 150, 50);
		frame.setBounds(100, 100, 1024, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		cadastro =  getCadastro();
		cadastro.add(labelEscolaridade);
		cadastro.add(textFieldEscolaridade);
		cadastro.add(btnCadastrar);
		cadastro.add(btnRemover);
		frame.add(tabbedPane);
		tabbedPane.add(cadastro);
		tabbedPane.setTitleAt(0, "Dados");
	}
	
	private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
		Endereco endereco = new Endereco( getTextFieldCEP().getText(), 
				Integer.parseInt( getTextFieldNumero().getText()),  getTextFieldRua().getText(),
				 getTextFieldBairro().getText(),  getTextFieldCidade().getText(), 
				 getComboBoxEstado().getSelectedItem().toString(),  getTextFieldComplemento().getText());
		
		Clientes cliente = new Clientes(getTextFieldNomeCadastro().getText(), 
				 getTextFieldCPFCadastro().getText(), new Date(), getComboBoxSexo().getSelectedItem().toString().charAt(0),
				 getTextFieldRG().getText(), getComboBoxEstadoCivil().getSelectedItem().toString(), new Agencia(), endereco, 
				 textFieldEscolaridade.getText());
		
		listaClientes.adicionarCliente(cliente);
		System.out.println(listaClientes.quantidadeClientes());
		cleanScreen(cadastro);
	}
}
