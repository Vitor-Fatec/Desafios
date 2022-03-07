package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


// Instanciando variaveis
public class execControl implements ActionListener {
	
	private JTextField tfPesquisar;

	public execControl (JTextField tfPesquisar) {
		this.tfPesquisar = tfPesquisar;
	}

	// Método para procurar os aruqivos pelo botão Pesquisar	
	
	public  void procuraArquivo()  {
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos executáveis (.exe)", "exe");
		
		String diretorioBase = System.getProperty("user.home")+"/Desktop";
		File dir = new File(diretorioBase);
		
		JFileChooser choose = new JFileChooser();
		choose.setCurrentDirectory(dir);
		choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
		choose.setAcceptAllFileFilterUsed(false);
		choose.addChoosableFileFilter(filtro);
		String caminhoArquivo = "";
		
		int retorno = choose.showOpenDialog(null);
		if(retorno == JFileChooser.APPROVE_OPTION) {
			caminhoArquivo = choose.getSelectedFile().getAbsolutePath();
			tfPesquisar.setText(caminhoArquivo);
		}
	}
//Método para executar os arquivos digitados no JField
	public void abrirArquivo()  {
		String caminhoArquivo = tfPesquisar.getText();
		try {
			Runtime.getRuntime().exec(caminhoArquivo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Você precisa escrever um valor válido ","ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
	}

// Método finalizar janela
	public void fecharJanela() {
		JOptionPane.showMessageDialog(null,"Obrigado por utilizar meu programa de pesquisa!! \nAutor : Vitor Augusto");
		System.exit(0);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
