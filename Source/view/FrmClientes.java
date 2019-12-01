package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Agencia;
import model.Clientes;
import model.Endereco;
import registers.DadosClientes;

public class FrmClientes {

	private DadosClientes listaClientes = new DadosClientes();
	private CompCadastro vC = new CompCadastro();
	private CompConsulta vP = new CompConsulta();
	private CompEndereco vE = new CompEndereco();
	private JTabbedPane tabbedPane;
	private JPanel consulta;
	private JPanel endereco;
	private JPanel cadastro;
	private JLabel labelEscolaridade;
	private JTextField textFieldEscolaridade;
	private JButton btnCadastrar;
	private JButton btnRemover;
	private JTable tableConsulta;

	public FrmClientes() {
		initialize();
		loadTable(listaClientes);
	}

	public JTable getTableClientes() {
		return vP.getTabelaConsulta();
	}
	
	public JTabbedPane getClientesView() {
		return tabbedPane;
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
		endereco = vE.getEndereco();
		tabbedPane = new JTabbedPane();
		labelEscolaridade = new JLabel("Escolaridade");
		labelEscolaridade.setBounds(745, 135, 100, 15);
		textFieldEscolaridade = new JTextField();
		textFieldEscolaridade.setBounds(845, 130, 129, 24);
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(362, 310, 150, 50);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCadastrarActionPerformed(arg0);
			}
		});
		tableConsulta = vP.getTabelaConsulta();
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(522, 310, 150, 50);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRemoverActionPerformed(arg0);
			}
		});
		cadastro = vC.getCadastro();
		consulta = vP.getConsulta();
		cadastro.add(labelEscolaridade);
		cadastro.add(textFieldEscolaridade);
		cadastro.add(btnCadastrar);
		cadastro.add(btnRemover);
		cadastro.add(endereco);
		vE.getTextFieldComplemento().setSize(180, 24);
		tabbedPane.add(cadastro);
		tabbedPane.add(consulta);
		tabbedPane.setTitleAt(0, "Dados Pessoais");
		tabbedPane.setTitleAt(1, "Consulta");
	}
	
	private void loadTable(DadosClientes clientes) {
		DefaultTableModel dados = (DefaultTableModel)tableConsulta.getModel();
		dados.setNumRows(0);
		for(Clientes cliente : clientes.getListaClientes()) {
			dados.addRow(new Object [] {
					cliente.getNome(),
					cliente.getCpf(),
					cliente.getEndereco().getCep(),
					cliente.getAgencia()
			});
		}
		tableConsulta.setModel(dados);
	}
	
	private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Endereco endereco = new Endereco( vE.getTextFieldCEP().getText(), 
					Integer.parseInt( vE.getTextFieldNumero().getText()),  vE.getTextFieldRua().getText(),
					vE.getTextFieldBairro().getText(),  vE.getTextFieldCidade().getText(), 
					vE.getComboBoxEstado().getSelectedItem().toString(),  vE.getTextFieldComplemento().getText());
			
			Clientes cliente = new Clientes(vC.getTextFieldNomeCadastro().getText(), 
					vC.getTextFieldCPFCadastro().getText().replace(".","").replace("-", ""), 
					new SimpleDateFormat("dd/MM/yyyy").parse(vC.getTextFieldDataNascimento().getText()), 
					vC.getComboBoxSexo().getSelectedItem().toString().charAt(0),
					vC.getTextFieldRG().getText(), vC.getComboBoxEstadoCivil().getSelectedItem().toString(), new Agencia(), endereco, 
					 textFieldEscolaridade.getText());
			
			listaClientes.adicionarCliente(cliente);
			cleanScreen(cadastro);
			loadTable(listaClientes);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Endereco endereco = new Endereco( vE.getTextFieldCEP().getText(), 
					Integer.parseInt( vE.getTextFieldNumero().getText()),  vE.getTextFieldRua().getText(),
					vE.getTextFieldBairro().getText(),  vE.getTextFieldCidade().getText(), 
					vE.getComboBoxEstado().getSelectedItem().toString(),  vE.getTextFieldComplemento().getText());
			
			Clientes cliente = new Clientes(vC.getTextFieldNomeCadastro().getText(), 
					vC.getTextFieldCPFCadastro().getText().replace(".","").replace("-", ""), 
					new SimpleDateFormat("dd/MM/yyyy").parse(vC.getTextFieldDataNascimento().getText()), 
					vC.getComboBoxSexo().getSelectedItem().toString().charAt(0),
					vC.getTextFieldRG().getText(), vC.getComboBoxEstadoCivil().getSelectedItem().toString(), new Agencia(), endereco, 
					 textFieldEscolaridade.getText());
			
			listaClientes.adicionarCliente(cliente);
			cleanScreen(cadastro);
			loadTable(listaClientes);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
