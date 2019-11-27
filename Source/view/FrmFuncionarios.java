package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import enumeradores.EnumCargos;
import enumeradores.EnumEstado;
import model.Agencia;
import model.Endereco;
import model.Funcionarios;
import registers.DadosFuncionarios;

public class FrmFuncionarios {

	private DadosFuncionarios listaFuncionarios = new DadosFuncionarios();
	private CompCadastro vC = new CompCadastro();
	private CompConsulta vP = new CompConsulta();
	private JTabbedPane tabbedPane;
	private JPanel consulta;
	private JPanel cadastro;
	private JLabel labelNumCTPS;
	private JTextField textFieldNumCTPS;
	private JLabel labelSerieCTPS;
	private JTextField textFieldSerieCTPS;
	private JLabel labelUFCTPS;
	private JComboBox<String> comboBoxUFCTPS;
	private JLabel labelCargo;
	private JComboBox<String> comboBoxCargo;
	private JLabel labelSalario;
	private JTextField textFieldSalario;
	private JButton btnCadastrar;
	private JButton btnRemover;
	private JTable tableConsulta;
	
	public JTabbedPane getFuncionariosView() {
		return tabbedPane;
	}
	
	public FrmFuncionarios() {
		initialize();
		loadTable(listaFuncionarios);
	}

	private void cleanScreen(JPanel container){
        Component components[] = container.getComponents();
        for(Component component: components){
            if(component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
        }
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		tabbedPane = new JTabbedPane();
		tableConsulta = new JTable();
		btnCadastrar = new JButton("Cadastrar");
		labelNumCTPS = new JLabel("Número CTPS");
		labelNumCTPS.setBounds(50, 170, 100, 15);
		textFieldNumCTPS = new JTextField();
		textFieldNumCTPS.setBounds(150, 165, 100, 24);
		labelSerieCTPS = new JLabel("Série CTPS");
		labelSerieCTPS.setBounds(260, 170, 80, 15);
		textFieldSerieCTPS = new JTextField();
		textFieldSerieCTPS.setBounds(345, 165, 100, 24);
		labelUFCTPS = new JLabel("UF CTPS");
		labelUFCTPS.setBounds(455, 170, 60, 15);
		comboBoxUFCTPS = new JComboBox<String>();
		comboBoxUFCTPS.setModel(new DefaultComboBoxModel(EnumEstado.values()));
		comboBoxUFCTPS.setBounds(520, 165, 72, 24);
		labelCargo = new JLabel("Cargo");
		labelCargo.setBounds(602, 170, 46, 15);
		comboBoxCargo = new JComboBox<String>();
		comboBoxCargo.setModel(new DefaultComboBoxModel(EnumCargos.values()));
		comboBoxCargo.setBounds(653, 165, 130, 24);
		labelSalario = new JLabel("Salário");
		labelSalario.setBounds(793, 170, 50, 15);
		textFieldSalario = new JTextField();
		textFieldSalario.setBounds(848, 165, 126, 24);
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
		cadastro = vC.getCadastro();
		cadastro.add(btnCadastrar);
		cadastro.add(btnRemover);
		cadastro.add(labelNumCTPS);
		cadastro.add(textFieldNumCTPS);
		cadastro.add(labelSerieCTPS);
		cadastro.add(textFieldSerieCTPS);
		cadastro.add(labelUFCTPS);
		cadastro.add(comboBoxUFCTPS);
		cadastro.add(labelCargo);
		cadastro.add(comboBoxCargo);
		cadastro.add(labelSalario);
		cadastro.add(textFieldSalario);
		
		consulta = vP.getConsulta();
		tableConsulta = vP.getTabelaConsulta();
		tableConsulta.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	            	
	            },
	            new String [] {
	                "Nome", "CPF", "CEP", "Agência", "Cargo"
	            }
	    ));
		tabbedPane.add(cadastro);
		tabbedPane.add(consulta);
		tabbedPane.setTitleAt(0, "Dados Pessoais");
		tabbedPane.setTitleAt(1, "Consulta");
	}
	
	private void loadTable(DadosFuncionarios funcionarios) {
		DefaultTableModel dados = (DefaultTableModel)tableConsulta.getModel();
		dados.setNumRows(0);
		for(Funcionarios funcionario : funcionarios.getListaFuncionarios()) {
			dados.addRow(new Object [] {
					funcionario.getNome(),
					funcionario.getCpf(),
					funcionario.getEndereco().getCep(),
					funcionario.getAgencia(),
					funcionario.getCargoEmpresa()
			});
		}
		tableConsulta.setModel(dados);
	}
	
	private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Endereco endereco = new Endereco(vC.getTextFieldCEP().getText(), 
					Integer.parseInt( vC.getTextFieldNumero().getText()),  vC.getTextFieldRua().getText(),
					 vC.getTextFieldBairro().getText(),  vC.getTextFieldCidade().getText(), 
					 vC.getComboBoxEstado().getSelectedItem().toString(),  vC.getTextFieldComplemento().getText());
			
			Funcionarios funcionario = new Funcionarios(vC.getTextFieldNomeCadastro().getText(), 
					 vC.getTextFieldCPFCadastro().getText(), new Date(),
					 vC.getComboBoxSexo().getSelectedItem().toString().charAt(0),  vC.getTextFieldRG().getText(),
					 vC.getComboBoxEstadoCivil().getSelectedItem().toString(), new Agencia(), endereco, 
					textFieldNumCTPS.getText() + " " + textFieldSerieCTPS.getText() + " " + comboBoxUFCTPS.getSelectedItem().toString().charAt(0),
					comboBoxCargo.getSelectedItem().toString(), Double.parseDouble(textFieldSalario.getText()));
			
			listaFuncionarios.adicionarFuncionario(funcionario);
			cleanScreen(cadastro);
			loadTable(listaFuncionarios);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Endereco endereco = new Endereco(vC.getTextFieldCEP().getText(), 
					Integer.parseInt( vC.getTextFieldNumero().getText()),  vC.getTextFieldRua().getText(),
					 vC.getTextFieldBairro().getText(),  vC.getTextFieldCidade().getText(), 
					 vC.getComboBoxEstado().getSelectedItem().toString(),  vC.getTextFieldComplemento().getText());
			
			Funcionarios funcionario = new Funcionarios(vC.getTextFieldNomeCadastro().getText(), 
					 vC.getTextFieldCPFCadastro().getText(), new Date(),
					 vC.getComboBoxSexo().getSelectedItem().toString().charAt(0),  vC.getTextFieldRG().getText(),
					 vC.getComboBoxEstadoCivil().getSelectedItem().toString(), new Agencia(), endereco, 
					textFieldNumCTPS.getText() + " " + textFieldSerieCTPS.getText() + " " + comboBoxUFCTPS.getSelectedItem().toString().charAt(0),
					comboBoxCargo.getSelectedItem().toString(), Double.parseDouble(textFieldSalario.getText()));
			
			listaFuncionarios.excluirFuncionario(funcionario);
			cleanScreen(cadastro);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
