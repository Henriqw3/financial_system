package view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
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
import model.Gerente;
import registers.DadosAgencias;
import registers.DadosFuncionarios;

public class FrmAgencia {
	
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
	private JLabel titulo;
	public FrmAgencia(DadosAgencias listaAgencias, DadosFuncionarios listaFuncionarios) {
		initialize(listaAgencias, listaFuncionarios);
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
	
	private void initialize(DadosAgencias listaAgencias, DadosFuncionarios listaFuncionarios) {
		consulta = vP.getConsulta();
		tableConsulta = vP.getTabelaConsulta();
		tableConsulta.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	            	
	            },
	            new String [] {
	                "Número", "Nome Fictício", "Gerente", "Associados", "Contas"
	            }
	    ));
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
		comboBoxGerente.setModel(new DefaultComboBoxModel<String>(listaFuncionarios.getListaGerentes()));
		comboBoxGerente.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				comboBoxGerente.setModel(new DefaultComboBoxModel<String>(listaFuncionarios.getListaGerentes()));
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		cadastro.add(comboBoxGerente);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(362, 310, 150, 50);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCadastrarActionPerformed(arg0, listaAgencias, listaFuncionarios);
			}
		});
		
		cadastro.add(btnCadastrar);
		endereco = vE.getEndereco();
		cadastro.add(endereco);
		tabbedPane =  new  JTabbedPane();
		tabbedPane.add(cadastro);
                titulo = new JLabel("Lista Agências");
                titulo.setBounds(412, 20, 300, 42);
                titulo.setFont(new Font("Arial", 0, 32));
                consulta.add(titulo);
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
	
	public void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt,  DadosAgencias listaAgencias, DadosFuncionarios listaFuncionarios) {
		try {
			Endereco endereco = new Endereco(vE.getTextFieldCEP().getText(), 
					Integer.parseInt( vE.getTextFieldNumero().getText()),  vE.getTextFieldRua().getText(),
					 vE.getTextFieldBairro().getText(),  vE.getTextFieldCidade().getText(), 
					 vE.getComboBoxEstado().getSelectedItem().toString(),  vE.getTextFieldComplemento().getText());

			Agencia agencia = new Agencia(listaAgencias.nextNum(), txtNomeFicticio.getText(), endereco, 
					(Gerente) listaFuncionarios.buscarFuncionarioPorNome(comboBoxGerente.getSelectedItem().toString()));
		
		listaAgencias.adicionarAgencia(agencia);
		cleanScreen(cadastro);
		cleanScreen(this.endereco);
		loadTable(listaAgencias);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
        
}
