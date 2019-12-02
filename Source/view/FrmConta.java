package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import model.Clientes;

public class FrmConta {

	private JFrame frame;
	private JPanel panel;

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
	
	public FrmConta(Clientes cliente) {
		initialize(cliente);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			UIManager.getSystemLookAndFeelClassName();
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initialize(Clientes cliente) {
		frame = new JFrame("Financial System - TELA CONTA");
		panel = new JPanel();
		frame.setBounds(100, 100, 720, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	}

	public void setVisible(boolean arg) {
		frame.setVisible(arg);
	}
}
