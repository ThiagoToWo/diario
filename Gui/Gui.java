package Gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Gui {		

	JFrame janela;
	JTextField numero = new JTextField(2);
	JTextField nome = new JTextField(20);
	JTextField bimestre = new JTextField(2);
	JTextField nota1Inst = new JTextField(3);
	JTextField rec1Inst = new JTextField(3);
	JTextField nota2Inst = new JTextField(3);
	JTextField rec2Inst = new JTextField(3);
	JTextField nota3Inst = new JTextField(3);
	JTextField rec3Inst = new JTextField(3);	
	JTextArea infoDaTurma = new JTextArea(20, 20);	

	public void Janela() {
		JFrame janela = new JFrame("Diário de Classe");
		JMenuBar barraDeMenu = new JMenuBar();
		JMenu menuSobre = new JMenu("Sobre");
		JMenuItem autor = new JMenuItem("Autor");
		autor.addActionListener(new AutorListener());
		JMenuItem versao = new JMenuItem("Versão");
		versao.addActionListener(new VersaoListener());
		menuSobre.add(autor);
		menuSobre.add(versao);
		barraDeMenu.add(menuSobre);
		janela.setJMenuBar(barraDeMenu);
		JPanel painelAluno = new JPanel();
		painelAluno.setLayout(new BoxLayout(painelAluno,BoxLayout.X_AXIS));
		JLabel rotuloNumero = new JLabel("Número");	
		JLabel rotuloNome = new JLabel("Nome");	
		JLabel rotuloBimestre = new JLabel("Bimestre");	
		JLabel rotuloNot1Inst = new JLabel("1o inst.");	
		JLabel rotuloRec1Inst = new JLabel("Rec. 1o inst.");	
		JLabel rotuloNot2Inst = new JLabel("2o inst.");	
		JLabel rotuloRec2Inst = new JLabel("Rec. 2o inst.");
		JLabel rotuloNot3Inst = new JLabel("3o inst.");	
		JLabel rotuloRec3Inst = new JLabel("Rec. 3o inst.");		
		Box infoAluno = new Box(BoxLayout.X_AXIS);
		infoAluno.add(rotuloNumero);
		infoAluno.add(numero);
		infoAluno.add(rotuloNome);
		infoAluno.add(nome);
		infoAluno.add(rotuloBimestre);
		infoAluno.add(bimestre);
		infoAluno.add(rotuloNot1Inst);
		infoAluno.add(nota1Inst);
		infoAluno.add(rotuloRec1Inst);
		infoAluno.add(rec1Inst);
		infoAluno.add(rotuloNot2Inst);
		infoAluno.add(nota2Inst);
		infoAluno.add(rotuloRec2Inst);
		infoAluno.add(rec2Inst);
		infoAluno.add(rotuloNot3Inst);
		infoAluno.add(nota3Inst);
		infoAluno.add(rotuloRec3Inst);
		infoAluno.add(rec3Inst);		
		painelAluno.add(infoAluno);
		JButton botaoSalvarComo = new JButton("Salvar Como");
		botaoSalvarComo.addActionListener(new SalvarComoListener());
		JButton botaoAdicionar = new JButton("Adicionar");
		botaoAdicionar.addActionListener(new AdicionarListener());		
		painelAluno.add(botaoAdicionar);		
		painelAluno.add(botaoSalvarComo);
		janela.getContentPane().add(BorderLayout.NORTH, painelAluno);
		
		JPanel painelTurma = new JPanel();
		painelTurma.setLayout(new BoxLayout(painelTurma, BoxLayout.Y_AXIS));
		Font fonteAreaDeTexto = new Font("sanserif", Font.PLAIN, 24);
		infoDaTurma.setFont(fonteAreaDeTexto);
		infoDaTurma.setLineWrap(false);
		infoDaTurma.setEditable(true);
		JScrollPane barraDeRolagem = new JScrollPane(infoDaTurma);
		barraDeRolagem.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		barraDeRolagem.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		painelTurma.add(barraDeRolagem);		
		janela.getContentPane().add(BorderLayout.CENTER, painelTurma);
		
		JPanel painelSul = new JPanel();
		JButton botaoCarregar = new JButton("Carregar Turma");
		botaoCarregar.addActionListener(new CarregarListener());
		JButton botaoLimpar = new JButton("Limpar");
		botaoLimpar.addActionListener(new LimparListener());
		painelSul.add(botaoCarregar);
		painelSul.add(botaoLimpar);
		janela.getContentPane().add(BorderLayout.SOUTH, painelSul);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true);		
	}
	
	public Double somaDepoisDaRec() {
		Double nota1 = Double.parseDouble(nota1Inst.getText());
		Double rec1 = Double.parseDouble(rec1Inst.getText());
		Double nota2 = Double.parseDouble(nota2Inst.getText());
		Double rec2 = Double.parseDouble(rec2Inst.getText());
		Double nota3 = Double.parseDouble(nota3Inst.getText());
		Double rec3 = Double.parseDouble(rec3Inst.getText());
		Double notaPrimeiroInstrumento;
		Double notaSegundoInstrumento;
		Double notaTerceiroInstrumento;
		
		if (nota1 <= rec1) {
			notaPrimeiroInstrumento = rec1;
		} else {
			notaPrimeiroInstrumento = nota1;
		}
		
		if (nota2 <= rec2) {
			notaSegundoInstrumento = rec2;
		} else {
			notaSegundoInstrumento = nota2;
		}
		
		if (nota3 <= rec3) {
			notaTerceiroInstrumento = rec3;
		} else {
			notaTerceiroInstrumento = nota3;
		}
		
		Double notaFinal = notaPrimeiroInstrumento + notaSegundoInstrumento + notaTerceiroInstrumento;		
		return notaFinal;	
	}
	
	public Double somaAntesDaRec() {
		Double nota1 = Double.parseDouble(nota1Inst.getText());		
		Double nota2 = Double.parseDouble(nota2Inst.getText());		
		Double nota3 = Double.parseDouble(nota3Inst.getText());		
		
		Double notaProvisoria = nota1 + nota2 + nota3;
		return notaProvisoria;
		
	}
	
	public class LimparListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			infoDaTurma.setText("");

		}

	}
	
	public class CarregarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser carregarArquivo = new JFileChooser();
			carregarArquivo.showOpenDialog(janela);
			try {
				BufferedReader br = new BufferedReader(new FileReader(carregarArquivo.getSelectedFile()));
				String linha = null;
				while ((linha = br.readLine())!= null) {					
					infoDaTurma.append(linha + "\n");					
				}
				br.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}

		}

	}

	public class AdicionarListener implements ActionListener {	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String aluno = infoDaTurma.getText() + numero.getText() + " " + nome.getText() + "    " + "Bimestre " 
		                      + bimestre.getText() + "    " + "Notas" + " " + "|"
						      + nota1Inst.getText() + "|" + rec1Inst.getText() + "|" + nota2Inst.getText() + "|" 
		                      + rec2Inst.getText() + "|" + nota3Inst.getText() + "|" + rec3Inst.getText() + "|" 
						      + "    " + "Nota antes da rec. = " + somaAntesDaRec()+ " "  
						      + "Nota depois da rec. = " + somaDepoisDaRec() + "\n";
			infoDaTurma.setText(aluno);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Soluções: (1) Preencha todas as entradas de nota antes de adicionar." +
			                                  "\n (2) Se for separar os décimos, use '.' (ponto) ao invés de ',' (vírgula).",						 
						                     "Erro nas entradas de nota", JOptionPane.WARNING_MESSAGE);
			}			
			numero.setText("");
			nome.setText("");
			bimestre.setText("");
			nota1Inst.setText("");
			rec1Inst.setText("");
			nota2Inst.setText("");
			rec2Inst.setText("");
			nota3Inst.setText("");
			rec3Inst.setText("");
			numero.requestFocus();
		}

	}	

	public class SalvarComoListener implements ActionListener {	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser salvarNovoArquivo = new JFileChooser();
			salvarNovoArquivo.showSaveDialog(janela);
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(salvarNovoArquivo.getSelectedFile()));				
				String infoDoAluno = infoDaTurma.getText();
				bw.write(infoDoAluno);
				bw.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}

		}

	}
	
	public class AutorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {			
			JOptionPane.showMessageDialog(null, "Autor: Thiago de Oliveira Alves", "Sobre mim", JOptionPane.INFORMATION_MESSAGE);

		}

	}
	
	public class VersaoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Versão: 0.0 \n 06-02-2020", "Sobre este", JOptionPane.INFORMATION_MESSAGE);

		}

	}
}