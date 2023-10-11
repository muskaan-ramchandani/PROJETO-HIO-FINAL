package view;

import javax.swing.*;
import org.w3c.dom.events.MouseEvent;
import vo.Aluno;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;


import controller.OlimpiadaCONTROLLER;
import view.TelasGuiOlimpiadasAluno.*;
import vo.Olimpiada;

public class GuiOlimpiadasAluno extends JFrame{
	private Container contentPane;
	private JLayeredPane lp;
	private JMenuBar barra;
	private JLabel lblLogo;
	private JLabel lblNomeOlimp;
	private JButton btnLivros;
	private JButton btnVideos;
	private JButton btnAssuntos;
	private JButton btnFlashcards;
	private JButton btnCronograma;
	private JButton btnVoltar;
	
	private JLabel lblAluno;
	private JLabel lblFrase1;
	private JLabel lblFrase2;
	private JLabel lblImagem;
	
	public GuiOlimpiadasAluno(Olimpiada olimp, Aluno aluno) {
		inicializarComponentes(olimp, aluno);
		definirEventos(olimp, aluno);
	}
	public void inicializarComponentes(Olimpiada olimp, Aluno aluno) {
		//configura tela
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height-40);
		contentPane=getContentPane();
        contentPane.setBackground(Color.white);

		
		//inicializa
		lp= new JLayeredPane();
		barra= new JMenuBar();
		
		lblLogo  = new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//bonequinhoSFMEDIO.png"));
		
		lblNomeOlimp = new JLabel(olimp.getNome());
		btnLivros = new JButton("<html><u>Livros</u></html>"); //Sublinhado
		btnVideos= new JButton("<html><u>Videos</u></html>");
		btnAssuntos = new JButton("<html><u>Assuntos</u></html>");
		btnFlashcards= new JButton("<html><u>Flashcards</u></html>");
		btnCronograma= new JButton("<html><u>Cronograma</u></html>");
		
		lblAluno = new JLabel("ALUNO");
		lblFrase1 = new JLabel("<html>O sucesso nas Olimpíadas <br>está ao seu alcance.</html>");
		lblFrase2 = new JLabel("Tenha acesso a livros, vídeos e muito mais.");
		lblImagem = new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//Projeto HIO//PROJETO-HIO-FINAL//"
				+"PROJETO-HIO-FINAL//Imagens HIO//imagemGUIOlimpiadasAlunoRecepcao.png"));
		//cores
		Color roxoIndigo = new Color(75,0,130);
		
		barra.setBackground(roxoIndigo);
		lblNomeOlimp.setBackground(roxoIndigo);
		lblNomeOlimp.setForeground(Color.WHITE);
		btnLivros.setBackground(roxoIndigo);
		btnLivros.setForeground(Color.WHITE);
		btnVideos.setBackground(roxoIndigo);
		btnVideos.setForeground(Color.WHITE);
		btnAssuntos.setBackground(roxoIndigo);
		btnAssuntos.setForeground(Color.WHITE);
		btnFlashcards.setBackground(roxoIndigo);
		btnFlashcards.setForeground(Color.WHITE);
		btnCronograma.setBackground(roxoIndigo);
		btnCronograma.setForeground(Color.WHITE);
		
		lblAluno.setForeground(roxoIndigo);
		lblFrase1.setForeground(Color.BLACK);
		lblFrase2.setForeground(Color.BLACK);
		
		//formatações
		lblNomeOlimp.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		
		Font fonteBarra = new Font("Trebuchet MS", Font.PLAIN, 20);
		btnLivros.setFont(fonteBarra);
		btnVideos.setFont(fonteBarra);
		btnAssuntos.setFont(fonteBarra);
		btnFlashcards.setFont(fonteBarra);
		btnCronograma.setFont(fonteBarra);

		lblAluno.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblFrase1.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		lblFrase2.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		
		//coordenadas
		lp.setBounds(0, 0, screenSize.width, screenSize.height-40);
        barra.setBounds(0,0,screenSize.width, 50);
        lblLogo.setBounds(10,5,44,35);
        lblNomeOlimp.setBounds(80, 15, 250, 20);
        btnLivros.setBounds(235,7, 100, 35);
		btnVideos.setBounds(403,7,100,35);
		btnAssuntos.setBounds(578,7,100,35);
		btnFlashcards.setBounds(765,7,130,35);
		btnCronograma.setBounds(980,7,130,35);
		
		lblAluno.setBounds(100,180,150,40);
		lblFrase1.setBounds(100,100,650,350);
		lblFrase2.setBounds(100,330,500,40);
		lblImagem.setBounds(700,130,567,425);
		
		btnVoltar = new JButton(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//setaPequenaRoxa.png"));
		btnVoltar.setContentAreaFilled(false); // Deixa a área de preenchimento transparente
		btnVoltar.setBorderPainted(false); // Remove a borda
		btnVoltar.setFocusPainted(false);
    	btnVoltar.setBounds(10, 650, 28,25);
    	
		//adiciona
		contentPane.add(lp);
		lp.add(barra, new Integer(1));
		lp.add(lblLogo, new Integer(2));
		lp.add(lblNomeOlimp, new Integer(3));
		lp.add(btnLivros, new Integer(4));
		lp.add(btnVideos, new Integer(5));
		lp.add(btnAssuntos, new Integer(6));
		lp.add(btnFlashcards, new Integer(7));
		lp.add(btnCronograma, new Integer(8));
		lp.add(lblAluno, new Integer(9));
		lp.add(lblFrase1, new Integer(10));
		lp.add(lblFrase2, new Integer(11));
		lp.add(lblImagem, new Integer(12));
		lp.add(btnVoltar, new Integer(13));
		
		setLayout(new BorderLayout());
        add(lp, BorderLayout.CENTER);
        btnVideos.setBorderPainted(false);
        btnAssuntos.setBorderPainted(false);
        btnFlashcards.setBorderPainted(false);
        btnCronograma.setBorderPainted(false);
        btnLivros.setBorderPainted(false);
		
		setVisible(true);
	}
	public void definirEventos(Olimpiada olimp, Aluno aluno) {		
		
		btnLivros.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaLivrosAluno livros = new TelaLivrosAluno(olimp, aluno);
				setVisible(false);
			}
		});
		
		btnLivros.addMouseListener(new MouseListener() {
			Color roxoIndigo = new Color(75,0,130);
			Color roxoVioleta = new Color(148,0,211);

			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnLivros.setBackground(roxoVioleta);
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnLivros.setBackground(roxoIndigo); // Retorna à cor padrão do botão
			}
        });
		
		
		btnVideos.addMouseListener(new MouseListener() {
			Color roxoIndigo = new Color(75,0,130);
			Color roxoVioleta = new Color(148,0,211);
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnVideos.setBackground(roxoVioleta);
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnVideos.setBackground(roxoIndigo); // Retorna à cor padrão do botão
			}
        });
		
		btnVideos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaVideosAluno videos = new TelaVideosAluno(olimp, aluno);
				setVisible(false);

			}
		});
		
		btnAssuntos.addMouseListener(new MouseListener() {
			Color roxoIndigo = new Color(75,0,130);
			Color roxoVioleta = new Color(148,0,211);
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnAssuntos.setBackground(roxoVioleta);
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnAssuntos.setBackground(roxoIndigo); // Retorna à cor padrão do botão
			}
        });
		
		btnAssuntos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaAssuntosAluno assuntos = new TelaAssuntosAluno(olimp, aluno);
				setVisible(false);

			}
		});
		
		btnFlashcards.addMouseListener(new MouseListener() {
			Color roxoIndigo = new Color(75,0,130);
			Color roxoVioleta = new Color(148,0,211);
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnFlashcards.setBackground(roxoVioleta);
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnFlashcards.setBackground(roxoIndigo); // Retorna à cor padrão do botão
			}
        });
		
		btnFlashcards.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaFlashcardsAluno flashcards = new TelaFlashcardsAluno(olimp, aluno);
				setVisible(false);
				flashcards.setVisible(true);
			}
		});
		
		btnCronograma.addMouseListener(new MouseListener() {
			Color roxoIndigo = new Color(75,0,130);
			Color roxoVioleta = new Color(148,0,211);
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnCronograma.setBackground(roxoVioleta);
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
            	btnCronograma.setBackground(roxoIndigo); // Retorna à cor padrão do botão
			}
        });
		
		btnCronograma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCronogramaAluno cronograma = new TelaCronogramaAluno(olimp, aluno);
				setVisible(false);

			}
		});
		
		 btnVoltar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					TelaInicialAluno tela = new TelaInicialAluno(aluno, true);
				     setVisible(false);
				}
			});
	}
}
