package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import model.Clientes;

public class FrmConta {

	private JFrame frame;
	private JPanel panel;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConta window = new FrmConta(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmConta(Clientes cliente) {
		initialize(cliente);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Clientes cliente) {
		
		frame = new JFrame();
		panel = new JPanel();
		frame.setBounds(100, 100, 720, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().add(panel);
	}

	public void setVisible(boolean arg) {
		frame.setVisible(arg);
	}
}
