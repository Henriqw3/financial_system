package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Agencia;
import model.Endereco;
import registers.DadosAgencias;

public class FrmAgencia {
	
	private DadosAgencias listaAgencias = new DadosAgencias();
	private JTabbedPane tabbedPane;
	private JPanel consulta;
	private JPanel cadastro;
	private JTextField txtNomeFicticio;
	private CompEndereco vE = new CompEndereco();
	private CompConsulta vP = new CompConsulta();
	private JButton btnCadastrar;
	private JButton btnRemover;
	private JPanel endereco;
	private JTable tableConsulta;
	private JComboBox<String> comboBoxGerente;
	
	public FrmAgencia() {
		initialize();
		loadTable(listaAgencias);
	}

	public JTabbedPane getAgenciaView() {
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
		consulta = vP.getConsulta();
		tableConsulta = vP.getTabelaConsulta();
		tableConsulta.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	            	
	            },
	            new String [] {
	                "Número", "Nome Fictício", "Gerente", "Associados", "Contas"
	            }
	    ));
		vP.getLblCpf().setVisible(false);
		vP.getTxtCpfConsulta().setVisible(false);
		
		cadastro = new JPanel();
		cadastro.setSize(1024, 480);
		cadastro.setLayout(null);
		
		JLabel lblNomeFicticio = new JLabel("Nome Fictício");
		lblNomeFicticio.setBounds(50, 30, 100, 15);
		cadastro.add(lblNomeFicticio);
		
		txtNomeFicticio = new JTextField();
		txtNomeFicticio.setBounds(150, 25, 594, 24);
		cadastro.add(txtNomeFicticio);
		txtNomeFicticio.setColumns(120);
		
		JLabel lblGerente = new JLabel("Gerente");
		lblGerente.setBounds(764, 30, 60, 15);
		cadastro.add(lblGerente);
		
		comboBoxGerente = new JComboBox<String>();
		comboBoxGerente.setBounds(834, 25, 140, 24);
		cadastro.add(comboBoxGerente);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(362, 310, 150, 50);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCadastrarActionPerformed(arg0);
			}
		});
		
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(522, 310, 150, 50);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRemoverActionPerformed(arg0);
			}
		});
		
		
		cadastro.add(btnCadastrar);
		cadastro.add(btnRemover);
		endereco = vE.getEndereco();
		cadastro.add(endereco);
		tabbedPane =  new  JTabbedPane();
		tabbedPane.add(cadastro);
		tabbedPane.add(consulta);
		tabbedPane.setTitleAt(0, "Cadastrar");
		tabbedPane.setTitleAt(1, "Consultar");
	}
	
	private void loadTable(DadosAgencias agencias) {
		DefaultTableModel dados = (DefaultTableModel)tableConsulta.getModel();
		dados.setNumRows(0);
		for(Agencia agencia : agencias.getListaAgencias()) {
			dados.addRow(new Object [] {
					agencia.getNumeroAgencia(),
					agencia.getNomeAgencia(),
					agencia.getGerenteAgencia().getNome(),
					agencia.getAssociadosAgencia(),
					agencia.getContas()
			});
		}
		tableConsulta.setModel(dados);
	}
	
	public void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Endereco endereco = new Endereco(vE.getTextFieldCEP().getText(), 
					Integer.parseInt( vE.getTextFieldNumero().getText()),  vE.getTextFieldRua().getText(),
					 vE.getTextFieldBairro().getText(),  vE.getTextFieldCidade().getText(), 
					 vE.getComboBoxEstado().getSelectedItem().toString(),  vE.getTextFieldComplemento().getText());

//			Agencia agencia = new Agencia(listaAgencias.nextNum(), txtNomeFicticio.getText(), endereco, gerenteAgencia)
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {
		Endereco endereco = new Endereco(vE.getTextFieldCEP().getText(), 
				Integer.parseInt( vE.getTextFieldNumero().getText()),  vE.getTextFieldRua().getText(),
				 vE.getTextFieldBairro().getText(),  vE.getTextFieldCidade().getText(), 
				 vE.getComboBoxEstado().getSelectedItem().toString(),  vE.getTextFieldComplemento().getText());

		cleanScreen(cadastro);
	}
}
