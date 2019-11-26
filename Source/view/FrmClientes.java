package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import model.Agencia;
import model.Clientes;
import model.Endereco;
import registers.DadosClientes;

public class FrmClientes {

	private DadosClientes listaClientes = new DadosClientes();
	private CompCadastro vC = new CompCadastro();
	private CompConsulta vP = new CompConsulta();
	private JTabbedPane tabbedPane;
	private JPanel consulta;
	private JPanel cadastro;
	private JLabel labelEscolaridade;
	private JTextField textFieldEscolaridade;
	private JButton btnCadastrar;
	private JButton btnRemover;

	public FrmClientes() {
		initialize();
	}

	public JTabbedPane getClientesView() {
		return tabbedPane;
	}
	
	private void cleanScreen(JPanel container){
        Component components[] = container.getComponents();
        for(Component component: components){
            if(component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
        }
    }
	
	private void initialize() {
		tabbedPane = new JTabbedPane();
		labelEscolaridade = new JLabel("Escolaridade");
		labelEscolaridade.setBounds(745, 135, 100, 15);
		textFieldEscolaridade = new JTextField();
		textFieldEscolaridade.setBounds(845, 130, 129, 24);
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(362, 310, 150, 50);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCadastrarActionPerformed(arg0);
			}
		});
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(522, 310, 150, 50);
		cadastro = vC.getCadastro();
		consulta = vP.getConsulta();
		cadastro.add(labelEscolaridade);
		cadastro.add(textFieldEscolaridade);
		cadastro.add(btnCadastrar);
		cadastro.add(btnRemover);
		vC.getTextFieldComplemento().setSize(180, 24);
		tabbedPane.add(cadastro);
		tabbedPane.add(consulta);
		tabbedPane.setTitleAt(0, "Dados Pessoais");
		tabbedPane.setTitleAt(1, "Consulta");
	}
	
	private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Endereco endereco = new Endereco( vC.getTextFieldCEP().getText(), 
					Integer.parseInt( vC.getTextFieldNumero().getText()),  vC.getTextFieldRua().getText(),
					vC.getTextFieldBairro().getText(),  vC.getTextFieldCidade().getText(), 
					vC.getComboBoxEstado().getSelectedItem().toString(),  vC.getTextFieldComplemento().getText());
			
			Clientes cliente = new Clientes(vC.getTextFieldNomeCadastro().getText(), 
					vC.getTextFieldCPFCadastro().getText(), new Date(), vC.getComboBoxSexo().getSelectedItem().toString().charAt(0),
					vC.getTextFieldRG().getText(), vC.getComboBoxEstadoCivil().getSelectedItem().toString(), new Agencia(), endereco, 
					 textFieldEscolaridade.getText());
			
			listaClientes.adicionarCliente(cliente);
			System.out.println(listaClientes.quantidadeClientes());
			cleanScreen(cadastro);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
