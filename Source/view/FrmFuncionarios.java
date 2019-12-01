package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import enumeradores.EnumEstado;
import model.Agencia;
import model.Endereco;
import model.Funcionarios;
import model.Gerente;
import registers.DadosFuncionarios;

public class FrmFuncionarios {

	private DadosFuncionarios listaFuncionarios = new DadosFuncionarios();
	private CompCadastro vC = new CompCadastro();
	private CompConsulta vP = new CompConsulta();
	private CompEndereco vE = new CompEndereco();
	private JTabbedPane tabbedPane;
	private JPanel consulta;
	private JPanel endereco;
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
	private JLabel lblFormacao;
	private JCheckBox boxFormacao;
	private JTextField txtCargo;
	private JLabel lblDataIngresso;
	private JFormattedTextField txtDataIngresso;
	
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
		endereco = vE.getEndereco();
		tabbedPane = new JTabbedPane();
		tableConsulta = new JTable();
		
		lblFormacao = new JLabel("Formação");
		lblFormacao.setBounds(50, 205, 65, 15);
		boxFormacao = new JCheckBox();
		boxFormacao.setBounds(125, 200, 25, 25);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(100, 200, 150, 24);
		txtCargo.setVisible(false);
		
		lblDataIngresso = new JLabel("Data Ingresso");
		lblDataIngresso.setBounds(160, 205, 90, 15);
		txtDataIngresso = new JFormattedTextField();
		txtDataIngresso.setBounds(260, 200, 105, 24);
		
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
		comboBoxCargo.setModel(new DefaultComboBoxModel(new String[] {"Gerente", "Outro"}));
		comboBoxCargo.setBounds(653, 165, 130, 24);
		comboBoxCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxCargo.getSelectedItem().toString().equals("Gerente")) {
					lblFormacao.setText("Formação");
					txtCargo.setVisible(false);
					boxFormacao.setVisible(true);
					lblDataIngresso.setVisible(true);
					txtDataIngresso.setVisible(true);
					
				} else {
					lblFormacao.setText("Cargo");
					boxFormacao.setVisible(false);
					txtCargo.setVisible(true);
					lblDataIngresso.setVisible(false);
					txtDataIngresso.setVisible(false);
				}
			}
		});
		
		labelSalario = new JLabel("Salário");
		labelSalario.setBounds(793, 170, 50, 15);
		textFieldSalario = new JTextField();
		textFieldSalario.setBounds(848, 165, 126, 24);
		
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
		cadastro = vC.getCadastro();
	
		cadastro.add(lblDataIngresso);
		cadastro.add(txtDataIngresso);
		cadastro.add(lblFormacao);
		cadastro.add(boxFormacao);
		cadastro.add(txtCargo);
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
		cadastro.add(endereco);
		
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
			Endereco endereco = new Endereco(vE.getTextFieldCEP().getText(), 
					Integer.parseInt( vE.getTextFieldNumero().getText()),  vE.getTextFieldRua().getText(),
					 vE.getTextFieldBairro().getText(),  vE.getTextFieldCidade().getText(), 
					 vE.getComboBoxEstado().getSelectedItem().toString(),  vE.getTextFieldComplemento().getText());
			
			if (comboBoxCargo.getSelectedItem().toString().equals("Outro")) {
				Funcionarios funcionario = new Funcionarios(vC.getTextFieldNomeCadastro().getText(), 
						 vC.getTextFieldCPFCadastro().getText(), new SimpleDateFormat("dd/MM/yyyy").parse(vC.getTextFieldDataNascimento().getText()),
						 vC.getComboBoxSexo().getSelectedItem().toString().charAt(0),  vC.getTextFieldRG().getText(),
						 vC.getComboBoxEstadoCivil().getSelectedItem().toString(), new Agencia(), endereco, 
						textFieldNumCTPS.getText() + " " + textFieldSerieCTPS.getText() + " " + comboBoxUFCTPS.getSelectedItem().toString().charAt(0),
						txtCargo.getText(), Double.parseDouble(textFieldSalario.getText()));
				
				listaFuncionarios.adicionarFuncionario(funcionario);
			} else {
				Gerente gerente = new Gerente(vC.getTextFieldNomeCadastro().getText(), 
						vC.getTextFieldCPFCadastro().getText(), new SimpleDateFormat("dd/MM/yyyy").parse(vC.getTextFieldDataNascimento().getText()), 
						vC.getComboBoxSexo().toString().charAt(0), vC.getTextFieldRG().getText(),
						vC.getComboBoxEstadoCivil().toString(), new Agencia(), endereco,
						textFieldNumCTPS.getText() + " " + textFieldSerieCTPS.getText() + " " 
						+ comboBoxUFCTPS.getSelectedItem().toString(), 
						Double.parseDouble(textFieldSalario.getText()),
						new SimpleDateFormat("dd/MM/yyyy").parse(txtDataIngresso.getText()), 
						boxFormacao.isSelected());
				listaFuncionarios.adicionarFuncionario(gerente);
			}
			cleanScreen(cadastro);
			loadTable(listaFuncionarios);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Endereco endereco = new Endereco(vE.getTextFieldCEP().getText(), 
					Integer.parseInt( vE.getTextFieldNumero().getText()),  vE.getTextFieldRua().getText(),
					 vE.getTextFieldBairro().getText(),  vE.getTextFieldCidade().getText(), 
					 vE.getComboBoxEstado().getSelectedItem().toString(),  vE.getTextFieldComplemento().getText());
			
			if (comboBoxCargo.getSelectedItem().toString().equals("Outro")) {
				Funcionarios funcionario = new Funcionarios(vC.getTextFieldNomeCadastro().getText(), 
						 vC.getTextFieldCPFCadastro().getText(), new SimpleDateFormat("dd/MM/yyyy").parse(vC.getTextFieldDataNascimento().getText()),
						 vC.getComboBoxSexo().getSelectedItem().toString().charAt(0),  vC.getTextFieldRG().getText(),
						 vC.getComboBoxEstadoCivil().getSelectedItem().toString(), new Agencia(), endereco, 
						textFieldNumCTPS.getText() + " " + textFieldSerieCTPS.getText() + " " + comboBoxUFCTPS.getSelectedItem().toString().charAt(0),
						txtCargo.getText(), Double.parseDouble(textFieldSalario.getText()));
				
				listaFuncionarios.excluirFuncionario(funcionario);
			} else {
				Gerente gerente = new Gerente(vC.getTextFieldNomeCadastro().getText(), 
						vC.getTextFieldCPFCadastro().getText(), new SimpleDateFormat("dd/MM/yyyy").parse(vC.getTextFieldDataNascimento().getText()), 
						vC.getComboBoxSexo().toString().charAt(0), vC.getTextFieldRG().getText(),
						vC.getComboBoxEstadoCivil().toString(), new Agencia(), endereco,
						textFieldNumCTPS.getText() + " " + textFieldSerieCTPS.getText() + " " 
						+ comboBoxUFCTPS.getSelectedItem().toString(), 
						Double.parseDouble(textFieldSalario.getText()),
						new SimpleDateFormat("dd/MM/yyyy").parse(txtDataIngresso.getText()), 
						boxFormacao.isSelected());
				listaFuncionarios.excluirFuncionario(gerente);
			}
			cleanScreen(cadastro);
			loadTable(listaFuncionarios);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
