package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Clientes;
import model.Endereco;
import registers.DadosAgencias;
import registers.DadosClientes;

public class FrmClientes {

	private CompCadastro vC = new CompCadastro();
	private CompConsulta vP = new CompConsulta();
	private CompEndereco vE = new CompEndereco();
	private JTabbedPane tabbedPane;
	private JPanel consulta;
	private JPanel enderecoPanel;
	private JPanel cadastro;
	private JLabel labelEscolaridade;
	private JTextField textFieldEscolaridade;
	private JButton btnCadastrar;
	private JButton btnRemover;
	private JTable tableConsulta;

	public FrmClientes(DadosClientes listaClientes, DadosAgencias listaAgencias) {
		initialize(listaClientes, listaAgencias);
		loadTable(listaClientes);
	}
	
	public FrmClientes(DadosClientes listaClientes) {
		initialize(listaClientes, new DadosAgencias());
		loadTable(listaClientes);
	}

	public JTable getTableClientes() {
		return vP.getTabelaConsulta();
	}
	
	public JTabbedPane getClientesView() {
		return tabbedPane;
	}
	
	public JComboBox<String> getComboBoxAgencia() {
		return vC.getComboBoxAgencia();
	}
	
	private void cleanScreen(JPanel container){
        Component components[] = container.getComponents();
        for(Component component: components){
            if(component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
        }
    }
	
	private void initialize(DadosClientes listaClientes, DadosAgencias listaAgencias) {
		enderecoPanel = vE.getEndereco();
		tabbedPane = new JTabbedPane();
		labelEscolaridade = new JLabel("Escolaridade");
		labelEscolaridade.setBounds(745, 135, 100, 15);
		textFieldEscolaridade = new JTextField();
		textFieldEscolaridade.setBounds(845, 130, 129, 24);
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(362, 310, 150, 50);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCadastrarActionPerformed(arg0, listaClientes, listaAgencias);
			}
		});
		tableConsulta = vP.getTabelaConsulta();
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(522, 310, 150, 50);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRemoverActionPerformed(arg0, listaClientes,listaAgencias);
			}
		});
		cadastro = vC.getCadastro();
		consulta = vP.getConsulta();
		vC.getComboBoxAgencia().setModel(new DefaultComboBoxModel<String>(listaAgencias.getListaNomeAgencias()));
		vC.getComboBoxAgencia().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				vC.getComboBoxAgencia().setModel(new DefaultComboBoxModel<String>(listaAgencias.getListaNomeAgencias()));
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		cadastro.add(labelEscolaridade);
		cadastro.add(textFieldEscolaridade);
		cadastro.add(btnCadastrar);
		cadastro.add(btnRemover);
		cadastro.add(enderecoPanel);
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
					cliente.getCpf().substring(0, 3) + "." + 
					cliente.getCpf().substring(3, 6) + "." + 
					cliente.getCpf().substring(6, 9) + "-" +
					cliente.getCpf().substring(9, 11),
					cliente.getEndereco().getCep(),
					cliente.getAgencia().getNomeAgencia()
			});
		}
		tableConsulta.setModel(dados);
	}
	
	private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt, DadosClientes listaClientes, DadosAgencias listaAgencias) {
		try {
			Endereco endereco = new Endereco( vE.getTextFieldCEP().getText(), 
					Integer.parseInt( vE.getTextFieldNumero().getText()),  vE.getTextFieldRua().getText(),
					vE.getTextFieldBairro().getText(),  vE.getTextFieldCidade().getText(), 
					vE.getComboBoxEstado().getSelectedItem().toString(),  vE.getTextFieldComplemento().getText());
			
			Clientes cliente = new Clientes(vC.getTextFieldNomeCadastro().getText(), 
					vC.getTextFieldCPFCadastro().getText().replace(".","").replace("-", ""), 
					new SimpleDateFormat("dd/MM/yyyy").parse(vC.getTextFieldDataNascimento().getText()), 
					vC.getComboBoxSexo().getSelectedItem().toString().charAt(0),
					vC.getTextFieldRG().getText(), vC.getComboBoxEstadoCivil().getSelectedItem().toString(),
					listaAgencias.buscarAgenciaPorNome(vC.getComboBoxAgencia().getSelectedItem().toString()), endereco, 
					 textFieldEscolaridade.getText());
			
			listaClientes.adicionarCliente(cliente);
			cleanScreen(cadastro);
			cleanScreen(enderecoPanel);
			loadTable(listaClientes);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt, DadosClientes listaClientes, DadosAgencias listaAgencias) {
		try {
			Endereco endereco = new Endereco( vE.getTextFieldCEP().getText(), 
					Integer.parseInt( vE.getTextFieldNumero().getText()),  vE.getTextFieldRua().getText(),
					vE.getTextFieldBairro().getText(),  vE.getTextFieldCidade().getText(), 
					vE.getComboBoxEstado().getSelectedItem().toString(),  vE.getTextFieldComplemento().getText());
			
			Clientes cliente = new Clientes(vC.getTextFieldNomeCadastro().getText(), 
					vC.getTextFieldCPFCadastro().getText().replace(".","").replace("-", ""), 
					new SimpleDateFormat("dd/MM/yyyy").parse(vC.getTextFieldDataNascimento().getText()), 
					vC.getComboBoxSexo().getSelectedItem().toString().charAt(0),
					vC.getTextFieldRG().getText(), vC.getComboBoxEstadoCivil().getSelectedItem().toString(),
					listaAgencias.buscarAgenciaPorNome(vC.getComboBoxAgencia().getSelectedItem().toString()), endereco, 
					textFieldEscolaridade.getText());
			
			listaClientes.excluirCliente(cliente);
			cleanScreen(cadastro);
			cleanScreen(enderecoPanel);
			loadTable(listaClientes);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
