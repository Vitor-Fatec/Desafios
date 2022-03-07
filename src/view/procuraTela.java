package view;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.execControl;

public class procuraTela extends JFrame {

	private JPanel contentPane;
	private JTextField tfPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					procuraTela frame = new procuraTela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public procuraTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite o caminho do exec\u00FAtavel ou clique em procurar");
		lblNewLabel.setBounds(20, 22, 298, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(10, 140, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(132, 140, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(264, 140, 89, 23);
		contentPane.add(btnPesquisar);
		
		JLabel lblNewLabel_1 = new JLabel("Abrir");
		lblNewLabel_1.setBounds(10, 98, 48, 14);
		contentPane.add(lblNewLabel_1);
		
		tfPesquisar = new JTextField();
		tfPesquisar.setBounds(55, 95, 298, 20);
		contentPane.add(tfPesquisar);
		tfPesquisar.setColumns(10);
		
		
//Execução dos botões		
		ActionListener busca = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				execControl execControl = new execControl(tfPesquisar);
				execControl.procuraArquivo();
			}
		};
		btnPesquisar.addActionListener(busca);
		
		ActionListener abrir = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				execControl execControl = new execControl(tfPesquisar);
				execControl.abrirArquivo();
				
			}
		};
		btnOk.addActionListener(abrir);
		
		ActionListener fechar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				execControl execControl = new execControl(null);
				execControl.fecharJanela();
				
			}
		};
		btnCancelar.addActionListener(fechar);
	}
	
	
	
}
