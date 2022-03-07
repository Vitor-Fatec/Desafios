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

	// M�todo para procurar os aruqivos pelo bot�o Pesquisar	
	
	public  void procuraArquivo()  {
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos execut�veis (.exe)", "exe");
		
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
//M�todo para executar os arquivos digitados no JField
	public void abrirArquivo()  {
		String caminhoArquivo = tfPesquisar.getText();
		try {
			Runtime.getRuntime().exec(caminhoArquivo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Voc� precisa escrever um valor v�lido ","ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
	}

// M�todo finalizar janela
	public void fecharJanela() {
		JOptionPane.showMessageDialog(null,"Obrigado por utilizar meu programa de pesquisa!! \nAutor : Vitor Augusto");
		System.exit(0);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
