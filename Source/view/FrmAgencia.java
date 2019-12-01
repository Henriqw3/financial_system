package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Agencia;
import model.Endereco;
import model.Gerente;
import registers.DadosAgencias;

public class FrmAgencia {
	
	private DadosAgencias listaAgencias = new DadosAgencias();
	private JTabbedPane tabbedPane;
	private JPanel consulta;
	private JPanel cadastro;
	private JTextField txtNomeFicticio;
	private CompEndereco vE = new CompEndereco();
	private JButton btnCadastrar;
	private JButton btnRemover;
	private JPanel endereco;
	private JTable tableConsulta;
	private JComboBox<String> comboBoxGerente;
	
	public FrmAgencia() {
		initialize();
		loadTable(listaAgencias);
	}

	public JTabbedPane getAgenciaView() {
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
		consulta = new JPanel();
		consulta.setSize(1024, 480);
		consulta.setLayout(null);
		
		cadastro = new JPanel();
		cadastro.setSize(1024, 480);
		cadastro.setLayout(null);
		
		JLabel lblNomeFicticio = new JLabel("Nome Fictício");
		lblNomeFicticio.setBounds(50, 30, 100, 15);
		cadastro.add(lblNomeFicticio);
		
		txtNomeFicticio = new JTextField();
		txtNomeFicticio.setBounds(150, 25, 594, 24);
		cadastro.add(txtNomeFicticio);
		txtNomeFicticio.setColumns(120);
		
		JLabel lblGerente = new JLabel("Gerente");
		lblGerente.setBounds(764, 30, 60, 15);
		cadastro.add(lblGerente);
		
		comboBoxGerente = new JComboBox<String>();
		comboBoxGerente.setBounds(834, 25, 140, 24);
		cadastro.add(comboBoxGerente);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(362, 310, 150, 50);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCadastrarActionPerformed(arg0);
			}
		});
		
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(522, 310, 150, 50);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRemoverActionPerformed(arg0);
			}
		});
		
		
		cadastro.add(btnCadastrar);
		cadastro.add(btnRemover);
		endereco = vE.getEndereco();
		cadastro.add(endereco);
		tabbedPane =  new  JTabbedPane();
		tabbedPane.add(cadastro);
		tabbedPane.add(consulta);
		tabbedPane.setTitleAt(0, "Cadastrar");
		tabbedPane.setTitleAt(1, "Consultar");
	}
	
	private void loadTable(DadosAgencias agencias) {
//		DefaultTableModel dados = (DefaultTableModel)tableConsulta.getModel();
//		dados.setNumRows(0);
//		for(Agencia agencia : agencias.getListaAgencias()) {
//			dados.addRow(new Object [] {
//			});
//		}
//		tableConsulta.setModel(dados);
	}
	
	public void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
		Endereco endereco = new Endereco(vE.getTextFieldCEP().getText(), 
				Integer.parseInt( vE.getTextFieldNumero().getText()),  vE.getTextFieldRua().getText(),
				 vE.getTextFieldBairro().getText(),  vE.getTextFieldCidade().getText(), 
				 vE.getComboBoxEstado().getSelectedItem().toString(),  vE.getTextFieldComplemento().getText());

	}
	
	public void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {
		Endereco endereco = new Endereco(vE.getTextFieldCEP().getText(), 
				Integer.parseInt( vE.getTextFieldNumero().getText()),  vE.getTextFieldRua().getText(),
				 vE.getTextFieldBairro().getText(),  vE.getTextFieldCidade().getText(), 
				 vE.getComboBoxEstado().getSelectedItem().toString(),  vE.getTextFieldComplemento().getText());

		cleanScreen(cadastro);
	}
}
