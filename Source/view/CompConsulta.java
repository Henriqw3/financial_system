package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class CompConsulta {

	private JPanel consulta;
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
		
		
		consulta.add(tableScroll);
	}

	public JPanel getConsulta() {
		return consulta;
	}
}