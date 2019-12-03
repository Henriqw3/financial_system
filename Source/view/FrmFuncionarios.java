package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import enumeradores.EnumEstado;
import java.awt.Font;
import model.Endereco;
import model.Funcionarios;
import model.Gerente;
import registers.DadosAgencias;
import registers.DadosFuncionarios;

public class FrmFuncionarios {

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
	private JTable tableConsulta;
	private JLabel lblFormacao;
	private JCheckBox boxFormacao;
	private JTextField txtCargo;
	private JLabel lblDataIngresso;
	private JFormattedTextField txtDataIngresso;
	private JLabel titulo;
        
	public JTabbedPane getFuncionariosView() {
		return tabbedPane;
	}
	
	public FrmFuncionarios(DadosFuncionarios listaFuncionarios, DadosAgencias listaAgencias) {
		initialize(listaFuncionarios, listaAgencias);
		loadTable(listaFuncionarios);
	}
	
	public FrmFuncionarios(DadosFuncionarios listaFuncionarios) {
		initialize(listaFuncionarios, new DadosAgencias());
		loadTable(listaFuncionarios);
	}

	public JComboBox<String> getComboBoxAgencia() {
		return vC.getComboBoxAgencia();
	}
	
	public JComboBox<String> getComboBoxCargo() {
		return comboBoxCargo;
	}
	
	public JFormattedTextField getTxtDataIngresso() {
		return txtDataIngresso;
	}

	public JLabel getLblFormacao() {
		return lblFormacao;
	}

	public JCheckBox getBoxFormacao() {
		return boxFormacao;
	}

	public JLabel getLblDataIngresso() {
		return lblDataIngresso;
	}

	public void setTxtDataIngresso(JFormattedTextField txtDataIngresso) {
		this.txtDataIngresso = txtDataIngresso;
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
	private void initialize(DadosFuncionarios listaFuncionarios, DadosAgencias listaAgencias) {
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
				btnCadastrarActionPerformed(arg0, listaFuncionarios, listaAgencias);
			}
		});

		cadastro = vC.getCadastro();
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
	
		cadastro.add(lblDataIngresso);
		cadastro.add(txtDataIngresso);
		try {
			txtDataIngresso.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		cadastro.add(lblFormacao);
		cadastro.add(boxFormacao);
		cadastro.add(txtCargo);
		cadastro.add(btnCadastrar);
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
		endereco = vE.getEndereco();
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
                titulo = new JLabel("Lista Funcinários");
                titulo.setBounds(412, 20, 300, 42);
                titulo.setFont(new Font("Arial", 0, 32));
                consulta.add(titulo);
		tabbedPane.setTitleAt(0, "Dados Pessoais");
		tabbedPane.setTitleAt(1, "Consulta");
	}
	
	private void loadTable(DadosFuncionarios funcionarios) {
		DefaultTableModel dados = (DefaultTableModel)tableConsulta.getModel();
		dados.setNumRows(0);
		for(Funcionarios funcionario : funcionarios.getListaFuncionarios()) {
			dados.addRow(new Object [] {
					funcionario.getNome(),
					funcionario.getCpf().substring(0, 3) + "." + 
					funcionario.getCpf().substring(3, 6) + "." + 
					funcionario.getCpf().substring(6, 9) + "-" +
					funcionario.getCpf().substring(9, 11),
					funcionario.getEndereco().getCep(),
					funcionario.getAgencia().getNomeAgencia(),
					funcionario.getCargoEmpresa()
			});
		}
		tableConsulta.setModel(dados);
	}
	
	private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt, DadosFuncionarios listaFuncionarios, DadosAgencias listaAgencias) {
		try {
			Endereco endereco = new Endereco(vE.getTextFieldCEP().getText(), 
					Integer.parseInt( vE.getTextFieldNumero().getText()),  vE.getTextFieldRua().getText(),
					 vE.getTextFieldBairro().getText(),  vE.getTextFieldCidade().getText(), 
					 vE.getComboBoxEstado().getSelectedItem().toString(),  vE.getTextFieldComplemento().getText());
			
			if (comboBoxCargo.getSelectedItem().toString().equals("Outro") || comboBoxCargo.getSelectedItem().toString().equals("Outro2")) {
				Funcionarios funcionario = new Funcionarios(vC.getTextFieldNomeCadastro().getText(), 
						 vC.getTextFieldCPFCadastro().getText().replace(".","").replace("-", ""), new SimpleDateFormat("dd/MM/yyyy").parse(vC.getTextFieldDataNascimento().getText()),
						 vC.getComboBoxSexo().getSelectedItem().toString().charAt(0),  vC.getTextFieldRG().getText(),
						 vC.getComboBoxEstadoCivil().getSelectedItem().toString(), 
						 listaAgencias.buscarAgenciaPorNome(vC.getComboBoxAgencia().getSelectedItem().toString()), 
						 endereco, textFieldNumCTPS.getText() + " " + textFieldSerieCTPS.getText() + " " + 
						 comboBoxUFCTPS.getSelectedItem().toString().charAt(0),
						 txtCargo.getText(), Double.parseDouble(textFieldSalario.getText()));
				
				listaFuncionarios.adicionarFuncionario(funcionario);
			} else {
				Gerente gerente = new Gerente(vC.getTextFieldNomeCadastro().getText(), 
						vC.getTextFieldCPFCadastro().getText().replace(".","").replace("-", ""), new SimpleDateFormat("dd/MM/yyyy").parse(vC.getTextFieldDataNascimento().getText()), 
						vC.getComboBoxSexo().toString().charAt(0), vC.getTextFieldRG().getText(),
						vC.getComboBoxEstadoCivil().toString(), 
						listaAgencias.buscarAgenciaPorNome(vC.getComboBoxAgencia().getSelectedItem().toString()), 
						endereco, textFieldNumCTPS.getText() + " " + textFieldSerieCTPS.getText() + " " 
						+ comboBoxUFCTPS.getSelectedItem().toString(), 
						Double.parseDouble(textFieldSalario.getText()),
						new SimpleDateFormat("dd/MM/yyyy").parse(txtDataIngresso.getText()), 
						boxFormacao.isSelected());
				listaFuncionarios.adicionarFuncionario(gerente);
			}
			cleanScreen(cadastro);
			cleanScreen(this.endereco);
			loadTable(listaFuncionarios);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
