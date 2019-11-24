package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Administrador;

public class FrmLogin {

	private JFrame frame;
	private JPanel painel;
	private JButton btnLogin;
	private JLabel labelConta;
	private JTextField textFieldConta;
	private JLabel labelSenha;
	private JPasswordField textFieldSenha;
	private JLabel logo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin window = new FrmLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmLogin() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		painel = new JPanel();
		logo = new JLabel();
		logo.setBounds(260, 40, 200, 200);
		logo.setIcon(new ImageIcon("/home/breno/Workspace/financial_system/Source/view/logo.png"));
		labelConta = new JLabel("Conta");
		labelConta.setBounds(284, 285, 43, 15);
		textFieldConta = new JTextField();
		textFieldConta.setBounds(337, 285, 90, 25);
		labelSenha = new JLabel("Senha");
		labelSenha.setBounds(284, 315, 43, 15);
		textFieldSenha = new JPasswordField();
		textFieldSenha.setBounds(337, 315, 90, 25);
		btnLogin = new JButton("Conectar-se");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnLoginActionPerformed(arg0);
			}
		});
		btnLogin.setSize(143, 30);
		btnLogin.setLocation(284, 355);
		frame.setBounds(100, 100, 720, 540);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(painel);
		painel.setLayout(null);
		painel.add(logo);
		painel.add(labelConta);
		painel.add(textFieldConta);
		painel.add(labelSenha);
		painel.add(textFieldSenha);
		painel.add(btnLogin);
	}
	private void cleanScreen(JPanel container){
        Component components[] = container.getComponents();
        for(Component component: components){
            if(component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
        }
    }
	
	private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
		Administrador administrador = new Administrador();
		if (textFieldConta.getText().equals(administrador.getUsuario())) {
//			if (textFieldSenha.getPassword().equals(administrador.getSenha())) {
				Frmcliente windowAdministracao = new Frmcliente();
				windowAdministracao.setVisible(true);
				this.frame.setVisible(false);
//			}
		} else {
		}
		cleanScreen(painel);
	}
	
}
