package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import enumeradores.EnumCargos;
import enumeradores.EnumEstado;
import model.Agencia;
import model.Endereco;
import model.Funcionarios;
import registers.DadosFuncionarios;

public class FrmFuncionarios extends CompCadastro{

	DadosFuncionarios listaFuncionarios = new DadosFuncionarios();
	private JFrame frame;
	private JTabbedPane tabbedPane;
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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFuncionarios window = new FrmFuncionarios();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmFuncionarios() {
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame("Financial System - CADASTRO FUNCIONÁRIOS");
		tabbedPane = new JTabbedPane();
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
		comboBoxUFCTPS.setBounds(520, 165, 62, 24);
		labelCargo = new JLabel("Cargo");
		labelCargo.setBounds(592, 170, 46, 15);
		comboBoxCargo = new JComboBox<String>();
		comboBoxCargo.setModel(new DefaultComboBoxModel(EnumCargos.values()));
		comboBoxCargo.setBounds(643, 165, 140, 24);
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
		frame.setBounds(100, 100, 1024, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		cadastro = getCadastro();
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
		frame.add(tabbedPane);
		tabbedPane.add(cadastro);
		tabbedPane.setTitleAt(0, "Dados");
	}
	
	private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
		Endereco endereco = new Endereco( getTextFieldCEP().getText(), 
				Integer.parseInt( getTextFieldNumero().getText()),  getTextFieldRua().getText(),
				 getTextFieldBairro().getText(),  getTextFieldCidade().getText(), 
				 getComboBoxEstado().getSelectedItem().toString(),  getTextFieldComplemento().getText());
		
		Funcionarios funcionario = new Funcionarios( getTextFieldNomeCadastro().getText(), 
				 getTextFieldCPFCadastro().getText(), new Date(),
				 getComboBoxSexo().getSelectedItem().toString().charAt(0),  getTextFieldRG().getText(),
				 getComboBoxEstadoCivil().getSelectedItem().toString(), new Agencia(), endereco, 
				textFieldNumCTPS.getText() + " " + textFieldSerieCTPS.getText() + " " + comboBoxUFCTPS.getSelectedItem().toString().charAt(0),
				comboBoxCargo.getSelectedItem().toString(), Double.parseDouble(textFieldSalario.getText()));
		
		listaFuncionarios.adicionarFuncionario(funcionario);
		System.out.println(listaFuncionarios.quantidadeFuncionarios());
		cleanScreen(cadastro);
	}
}
