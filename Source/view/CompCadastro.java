package view;

import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import enumeradores.EnumEstado;
import enumeradores.EnumEstadoCivil;
import enumeradores.EnumSexo;

public class CompCadastro {

	private JPanel cadastro;
	private JLabel labelNome;
	private JTextField textFieldNomeCadastro;
	private JLabel labelCPF;
	private JFormattedTextField textFieldCPFCadastro;
	private JLabel labelDataNascimento;
	private JFormattedTextField textFieldDataNascimento;
	private JLabel labelSexo;
	private JComboBox<String> comboBoxSexo;
	private JLabel labelRG;
	private JFormattedTextField textFieldRG;
	private JLabel labelEstadoCivil;
	private JComboBox<String> comboBoxEstadoCivil;
	private JLabel labelAgencia;
	private JComboBox<String> comboBoxAgencia;
	private JLabel labelCEP;
	private JFormattedTextField textFieldCEP;
	private JLabel labelRua;
	private JTextField textFieldRua;
	private JLabel labelNumero;
	private JTextField textFieldNumero;
	private JLabel labelBairro;
	private JTextField textFieldBairro;
	private JLabel labelCidade;
	private JTextField textFieldCidade;
	private JLabel labelEstado;
	private JComboBox<String> comboBoxEstado;
	private JLabel labelComplemento;
	private JTextField textFieldComplemento;

	public CompCadastro() {
		initialize();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		cadastro = new JPanel();
		labelNome = new JLabel("Nome");
		labelNome.setBounds(50, 30, 50, 15);
		textFieldNomeCadastro = new JTextField();
		textFieldNomeCadastro.setBounds(100, 25, 620,24);
		labelDataNascimento = new JLabel("Data de Nascimento");
		labelDataNascimento.setBounds(729, 30, 147, 15);
		textFieldDataNascimento = new JFormattedTextField();
		textFieldDataNascimento.setBounds(886, 25, 88, 24);
		try {
			textFieldDataNascimento.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		labelSexo = new JLabel("Sexo");
		labelSexo.setBounds(487, 65, 43, 15);
		comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setModel(new DefaultComboBoxModel(EnumSexo.values()));
		comboBoxSexo.setBounds(533, 60, 50, 24);
		labelEstadoCivil = new JLabel("Estado Civil");
		labelEstadoCivil.setBounds(50, 65, 89, 15);
		comboBoxEstadoCivil = new JComboBox<String>();
		comboBoxEstadoCivil.setModel(new DefaultComboBoxModel(EnumEstadoCivil.values()));
		comboBoxEstadoCivil.setBounds(139, 60, 122, 24);
		labelAgencia = new JLabel("Agencia");
		labelAgencia.setBounds(276, 65, 64, 15);
		comboBoxAgencia = new JComboBox<String>();
		comboBoxAgencia.setBounds(345, 60, 132, 24);
		labelCPF = new JLabel("CPF");
		labelCPF.setBounds(595, 65, 26, 15);
		textFieldCPFCadastro = new JFormattedTextField();
		textFieldCPFCadastro.setBounds(631, 60, 160, 24);
		try {
			textFieldCPFCadastro.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		labelRG = new JLabel("RG");
		labelRG.setBounds(801, 65, 19, 15);
		textFieldRG = new JFormattedTextField();
		textFieldRG.setBounds(830, 60, 144, 24);
		try {
			textFieldRG.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##.###.###")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		labelCEP = new JLabel("CEP");
		labelCEP.setBounds(50, 100, 26, 15);
		textFieldCEP = new JFormattedTextField();
		textFieldCEP.setBounds(86, 95, 154, 24);
		try {
			textFieldCEP.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####-###")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		labelRua = new JLabel("Rua");
		labelRua.setBounds(250, 100, 36, 15);
		textFieldRua = new JTextField();
		textFieldRua.setBounds(291, 95, 295, 24);
		labelNumero = new JLabel("Nº");
		labelNumero.setBounds(596, 100, 17, 15);
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(623, 95, 60, 24);
		labelBairro = new JLabel("Bairro");
		labelBairro.setBounds(693, 100, 51, 15);
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(754, 95, 220, 24);
		labelCidade = new JLabel("Cidade");
		labelCidade.setBounds(50, 135, 57, 15);
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(107, 130, 200, 24);
		labelEstado = new JLabel("Estado");
		labelEstado.setBounds(317, 135, 56, 15);
		comboBoxEstado = new JComboBox<String>();
		comboBoxEstado.setModel(new DefaultComboBoxModel(EnumEstado.values()));
		comboBoxEstado.setBounds(378, 130, 65, 24);
		labelComplemento = new JLabel("Complemento");
		labelComplemento.setBounds(450, 135, 105, 15);
		textFieldComplemento = new JTextField();
		textFieldComplemento.setBounds(555, 130, 419, 24);
		cadastro.setLayout(null);
		cadastro.add(labelNome);
		cadastro.add(textFieldNomeCadastro);
		cadastro.add(labelDataNascimento);
		cadastro.add(textFieldDataNascimento);
		cadastro.add(labelSexo);
		cadastro.add(comboBoxSexo);
		cadastro.add(labelEstadoCivil);
		cadastro.add(comboBoxEstadoCivil);
		cadastro.add(labelAgencia);
		cadastro.add(comboBoxAgencia);
		cadastro.add(labelCPF);
		cadastro.add(textFieldCPFCadastro);
		cadastro.add(labelRG);
		cadastro.add(textFieldRG);
		cadastro.add(labelCEP);
		cadastro.add(textFieldCEP);
		cadastro.add(labelRua);
		cadastro.add(textFieldRua);
		cadastro.add(labelNumero);
		cadastro.add(textFieldNumero);
		cadastro.add(labelBairro);
		cadastro.add(textFieldBairro);
		cadastro.add(labelCidade);
		cadastro.add(textFieldCidade);
		cadastro.add(labelEstado);
		cadastro.add(comboBoxEstado);
		cadastro.add(labelComplemento);
		cadastro.add(textFieldComplemento);
	}

	public JPanel getCadastro() {
		return cadastro;
	}

	public JComboBox<String> getComboBoxAgencia() {
		return comboBoxAgencia;
	}

	public void setComboBoxAgencia(JComboBox<String> comboBoxAgencia) {
		this.comboBoxAgencia = comboBoxAgencia;
	}

	public JTextField getTextFieldNomeCadastro() {
		return textFieldNomeCadastro;
	}

	public JFormattedTextField getTextFieldCPFCadastro() {
		return textFieldCPFCadastro;
	}

	public JFormattedTextField getTextFieldDataNascimento() {
		return textFieldDataNascimento;
	}

	public JComboBox<String> getComboBoxSexo() {
		return comboBoxSexo;
	}

	public JFormattedTextField getTextFieldRG() {
		return textFieldRG;
	}

	public JComboBox<String> getComboBoxEstadoCivil() {
		return comboBoxEstadoCivil;
	}

	public JFormattedTextField getTextFieldCEP() {
		return textFieldCEP;
	}

	public JTextField getTextFieldRua() {
		return textFieldRua;
	}

	public JTextField getTextFieldNumero() {
		return textFieldNumero;
	}

	public JTextField getTextFieldBairro() {
		return textFieldBairro;
	}

	public JTextField getTextFieldCidade() {
		return textFieldCidade;
	}

	public JComboBox<String> getComboBoxEstado() {
		return comboBoxEstado;
	}

	public JTextField getTextFieldComplemento() {
		return textFieldComplemento;
	}
	
	
}
