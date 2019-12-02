package view;

import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import model.Gerente;
import registers.DadosClientes;
import registers.DadosFuncionarios;

public class TelaGerente {

	private JFrame frame;
	private DadosFuncionarios listaFuncionarios = new DadosFuncionarios();
	private DadosClientes listaClientes = new DadosClientes();
	private FrmClientes frmClientes = new FrmClientes(listaClientes);
	private FrmFuncionarios frmFuncionarios = new FrmFuncionarios(listaFuncionarios);
	private JTabbedPane clientesPane;
	private JTabbedPane funcionariosPane;
	private JTabbedPane tabbedPane;

	public TelaGerente(Gerente gerente) {
		initialize(gerente);
	}
	
	public void setVisible(boolean arg) {
		frame.setVisible(arg);
	}

	private void initialize(Gerente gerente) {
		frame = new JFrame("Financial System - TELA GERENTE");
		clientesPane = frmClientes.getClientesView();
		funcionariosPane = frmFuncionarios.getFuncionariosView();
		frame.setBounds(100, 100, 1024, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1024, 480);
		tabbedPane.add(clientesPane);
		tabbedPane.add(funcionariosPane);
		tabbedPane.setTitleAt(0, "Clientes");
		tabbedPane.setTitleAt(1, "Funcionários");
		frmClientes.getComboBoxAgencia().setModel(new DefaultComboBoxModel<String>(new String[] { 
				gerente.getAgencia().getNomeAgencia()
		}));
		frmFuncionarios.getComboBoxAgencia().setModel(new DefaultComboBoxModel<String>(new String[] { 
				gerente.getAgencia().getNomeAgencia()
		}));
		frmFuncionarios.getComboBoxCargo().setVisible(false);
		frmFuncionarios.getComboBoxCargo().setSelectedItem("Outro2");
		frmFuncionarios.getBoxFormacao().setVisible(false);
		frmFuncionarios.getLblFormacao().setVisible(false);
		frmFuncionarios.getLblDataIngresso().setVisible(false);
		frmFuncionarios.getTxtDataIngresso().setBounds(653, 165, 130, 24);
		try {
			frmFuncionarios.getTxtDataIngresso().setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		frame.getContentPane().add(tabbedPane);
	}

}
