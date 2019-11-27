package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import model.Clientes;

public class FrmConta {

	private JFrame frame;
	private JPanel panel;
	private JTable table;
	private JScrollPane jScrollPane1;

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
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			UIManager.getSystemLookAndFeelClassName();
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Clientes cliente) {
		frame = new JFrame();
		panel = new JPanel();
		table = new JTable();
		jScrollPane1 = new JScrollPane();
		jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setLocation(50, 25);
		jScrollPane1.setSize(620, 200);
        jScrollPane1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Status", "Dados"
			}
		));
		table.setBounds(258, 65, 150, 16);
		frame.setBounds(100, 100, 720, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.add(jScrollPane1);
	}

	public void setVisible(boolean arg) {
		frame.setVisible(arg);
	}
}
