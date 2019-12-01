package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TelaAdministrador {

	private JFrame frame;
	private FrmClientes frmClientes = new FrmClientes();
	private FrmFuncionarios frmFuncionarios = new FrmFuncionarios();
	private FrmAgencia frmAgencias = new FrmAgencia();
	private JTabbedPane clientesPane;
	private JTabbedPane agenciasPane;
	private JTabbedPane funcionariosPane;
	private JTabbedPane tabbedPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministrador window = new TelaAdministrador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TelaAdministrador() {
		initialize();
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initialize() {
		frame = new JFrame("Financial System - ADMINISTRADOR");
		clientesPane = frmClientes.getClientesView();
		funcionariosPane = frmFuncionarios.getFuncionariosView();
		agenciasPane = frmAgencias.getAgenciaView();
		frame.setBounds(100, 100, 1024, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1024, 480);
		tabbedPane.add(clientesPane);
		tabbedPane.add(funcionariosPane);
		tabbedPane.add(agenciasPane);
		tabbedPane.setTitleAt(0, "Clientes");
		tabbedPane.setTitleAt(1, "Funcionários");
		tabbedPane.setTitleAt(2, "Agências");
		frame.getContentPane().add(tabbedPane);
	}
	
	public void setVisible(boolean arg) {
		frame.setVisible(arg);
	}
}
