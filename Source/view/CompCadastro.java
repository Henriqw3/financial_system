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
}
