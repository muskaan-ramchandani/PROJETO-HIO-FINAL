package view;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAlunoProfessor extends JFrame{
	private Container contentPane;
    private JLayeredPane layeredPane;
    private JPanel panelRoxo;
    private JPanel panelBranco;
	private JLabel lblVoceE;
	private JButton btnAluno;
	private JButton btnProfessor;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JLabel lblImagem; //jlabel1
	
	public TelaAlunoProfessor() {
		inicializarComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		//configura tela
		setTitle("Cadastro");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height-40);
        contentPane=getContentPane();
        contentPane.setBackground(Color.white);
		
		//Roxo padrão do projeto
		Color roxoEscuro= new Color(75,0,130);
		
		//inicializa
		layeredPane = new JLayeredPane();
		panelRoxo = new JPanel();;
		panelBranco  = new JPanel();;
		lblVoceE = new JLabel("Você é...");
		btnAluno= new JButton("Aluno");
		btnProfessor = new JButton("Professor");
		lblImagem = new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//estudante1.png"));
		
		jLabel3 = new JLabel("montar seu plano de estudo");
		jLabel4 = new JLabel("determinada olimpíada");
		jLabel5 = new JLabel("cronogramas, além de");
		jLabel6 = new JLabel("(livros, vídeos, etc) e");
		jLabel7 = new JLabel("Possui acesso a materiais");
		jLabel8 = new JLabel("Compartilha livros e ví-");
		jLabel9 = new JLabel("deos relacionados a uma");
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		//Cor e fontes
		panelRoxo.setBackground(roxoEscuro);
		panelBranco.setBackground(Color.WHITE);
		btnAluno.setBackground(Color.WHITE);
		btnAluno.setForeground(roxoEscuro);
		btnProfessor.setBackground(Color.WHITE);
		btnProfessor.setForeground(roxoEscuro);
		jLabel3.setForeground(Color.white);
		jLabel4.setForeground(Color.white);
		jLabel5.setForeground(Color.white);
		jLabel6.setForeground(Color.white);
		jLabel7.setForeground(Color.white);
		jLabel8.setForeground(Color.white);
		jLabel9.setForeground(Color.white);
		        
        Font fonteTamanho = new Font( "Trebuchet MS", Font.PLAIN, 65);
        lblVoceE.setForeground(Color.white);
	    lblVoceE.setFont(fonteTamanho);
	    
	    
	    Font fonteTamanhoBotao = new Font( "Trebuchet MS", Font.PLAIN, 30);
	    btnAluno.setFont(fonteTamanhoBotao);
	    btnProfessor.setFont(fonteTamanhoBotao);
	    
	    Font fonteLabelstxt = new Font("Trebuchet MS", 0, 24);
	    jLabel3.setFont(fonteLabelstxt);
	    jLabel4.setFont(fonteLabelstxt);
	    jLabel5.setFont(fonteLabelstxt);
	    jLabel6.setFont(fonteLabelstxt);
	    jLabel7.setFont(fonteLabelstxt);
	    jLabel8.setFont(fonteLabelstxt);
	    jLabel9.setFont(fonteLabelstxt);
	   

		//Coordenadas
		panelRoxo.setBounds(0,0,(screenSize.width/2)+200, screenSize.height-40);
		panelBranco.setBounds((screenSize.width/2)+201, 0, (screenSize.width/2)+500, screenSize.height-40);
        lblVoceE.setBounds(300, 50, 650, 120);
        btnAluno.setBounds(100, 280, 170, 70);
        jLabel7.setBounds(50, 350, 400, 50);
        jLabel6.setBounds(70,385,400,50);
        jLabel5.setBounds(68,420, 400, 50);
        jLabel3.setBounds(35, 455, 400, 50);
        
        btnProfessor.setBounds(550, 280, 170, 70);
        jLabel8.setBounds(515, 365, 400, 50);
        jLabel9.setBounds(505, 400, 400, 50);
        jLabel4.setBounds(510,435, 400, 50);
        
        lblImagem.setBounds((screenSize.width/2)+40,90, 800,screenSize.height-40);
        
		//Adiciona
		contentPane.add(layeredPane);
		layeredPane.add(panelRoxo, new Integer(1));
		layeredPane.add(panelBranco, new Integer(2));
		layeredPane.add(lblVoceE, new Integer(3));
		layeredPane.add(btnAluno, new Integer(4));
		layeredPane.add(btnProfessor, new Integer(5));
		layeredPane.add(jLabel7, new Integer(6));
		layeredPane.add(jLabel6, new Integer(7));
		layeredPane.add(jLabel5, new Integer(8));
		layeredPane.add(jLabel3, new Integer(9));
		layeredPane.add(jLabel8, new Integer(10));
		layeredPane.add(jLabel9, new Integer(11));
		layeredPane.add(jLabel4, new Integer(12));
		layeredPane.add(lblImagem, new Integer(13));
		
		setVisible(true);
	}

	private void definirEventos() {
		btnAluno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastroAluno telaCad1= new TelaCadastroAluno();
			    setVisible(false);
			}
			 
		 });
		
		btnProfessor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProf telaCad1= new TelaCadastroProf();
			     setVisible(false);
;
			}
			 
		 });
	}
	
}
