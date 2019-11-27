package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class CompConsulta {

	private JPanel consulta;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JTextField txtNomeConsulta;
	private JTextField txtCpfConsulta;
	private JScrollPane tableScroll;
	private JTable table;
	public CompConsulta() {
		initialize();
	}
	
	public JTable getTabelaConsulta() {
		return table;
	}
	
	private void initialize() {
		tableScroll = new JScrollPane();
		tableScroll.setBounds(50, 70, 924, 280);
		table = new JTable();
		table.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "Nome", "CPF", "CEP", "Agência"
	            }
	    ));
		table.getTableHeader().setEnabled(false);
		table.setEnabled(false);
		tableScroll.setViewportView(table);
		
		consulta = new JPanel();		
		consulta.setLayout(null);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 30, 50, 15);
		consulta.add(lblNome);
		
		txtNomeConsulta = new JTextField();
		txtNomeConsulta.setBounds(100, 25, 500, 24);
		consulta.add(txtNomeConsulta);
		txtNomeConsulta.setColumns(10);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(610, 30, 30, 15);
		consulta.add(lblCpf);
		
		txtCpfConsulta = new JTextField();
		txtCpfConsulta.setBounds(650, 25, 104, 24);
		consulta.add(txtCpfConsulta);
		txtCpfConsulta.setColumns(10);
		
		JButton btnConsulta = new JButton("Procurar");
		btnConsulta.setBounds(824, 25, 150, 24);
		consulta.add(btnConsulta);
		consulta.add(tableScroll);
	}

	public JPanel getConsulta() {
		return consulta;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public JLabel getLblCpf() {
		return lblCpf;
	}

	public JTextField getTxtNomeConsulta() {
		return txtNomeConsulta;
	}

	public JTextField getTxtCpfConsulta() {
		return txtCpfConsulta;
	}

}
