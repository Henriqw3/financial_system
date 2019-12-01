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

public class CompEndereco {
	
	private JPanel panel;
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

	public CompEndereco() {
		initialize();
	}

	public JPanel getEndereco() {
		return panel;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(1024,480);
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
		panel.add(labelCEP);
		panel.add(textFieldCEP);
		panel.add(labelRua);
		panel.add(textFieldRua);
		panel.add(labelNumero);
		panel.add(textFieldNumero);
		panel.add(labelBairro);
		panel.add(textFieldBairro);
		panel.add(labelCidade);
		panel.add(textFieldCidade);
		panel.add(labelEstado);
		panel.add(comboBoxEstado);
		panel.add(labelComplemento);
		panel.add(textFieldComplemento);
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
