package view;
import javax.swing.*;
import javax.swing.border.AbstractBorder;

import vo.Aluno;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TelaFavoritos extends JFrame{
	private Container contentPane;
	private JLayeredPane lp;
	private JMenuBar barra;
	private JButton btnFavoritos;
	private JLabel lblPesquisar;
	private JLabel lblFiltro;
	private JLabel txtLivro;
	private JLabel txtVideo;
	private JLabel txtFlashcard;
	private JButton btnVoltar;
    private JTextField txtFiltro;
	
	private int numeroLabels = 14;

	private JLabel[] EspacoLivro = new JLabel[numeroLabels];
	int camadasEL = 30;
	int linhaEL = 75;
	int colunaEL = 250;
	//int limite = 7;

	private JLabel[] espacoTituloLivro = new JLabel[numeroLabels];
	int camadasETL = 60;
	int linhaETL = 75;
	int colunaETL = 400;
	
	private JLabel[] EspacoVideo = new JLabel[numeroLabels];
	int camadasEV = 30;
	int linhaEV = 75;
	int colunaEV = 500;
	//int limite = 7;

	private JLabel[] espacoTituloVideo = new JLabel[numeroLabels];
	int camadasETV = 60;
	int linhaETV = 75;
	int colunaETV = 650;
	
	
	private JLabel[] EspacoFlashcard = new JLabel[numeroLabels];
	int camadasEF = 30;
	int linhaEF = 75;
	int colunaEF = 750;
	//int limite = 7;

	private JLabel[] espacoTituloFlashcard = new JLabel[numeroLabels];
	int camadasETF = 60;
	int linhaETF = 75;
	int colunaETF = 900;
	
	private JButton livroScrollButton;
	private JButton livroScrollButton2;
	private int livroScrollValue = 100;
	private final int labelWidth = 150;
    private final int labelCount = 14;
    private int scrollValue = 0;
    
    private JButton videoScrollButton;
	private JButton videoScrollButton2;
    
	public TelaFavoritos(Aluno aluno) {
		inicializarComponentes(aluno);
		definirEventos(aluno);
		setVisible(true);
	}

	private void inicializarComponentes(Aluno aluno) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height-40);
		lp = new JLayeredPane();
		lp.setBounds(0, 0, screenSize.width, screenSize.height-40);
		contentPane = new JPanel();
        //contentPane.setLayout(new BorderLayout());
        contentPane=getContentPane();
        contentPane.setBackground(Color.white);
        setLocationRelativeTo(null);
        
        
        barra= new JMenuBar();
        btnFavoritos = new JButton("Favoritos");
        lblPesquisar= new JLabel("Procurar por título");
	    txtFiltro= new JTextField(300);
        livroScrollButton = new JButton(">");
        livroScrollButton2 = new JButton("<");
        videoScrollButton = new JButton(">");
        videoScrollButton2 = new JButton("<");
        txtLivro = new JLabel ("LIVROS:");
    	txtVideo = new JLabel ("VIDEOS:");
    	txtFlashcard = new JLabel ("FLASHCARDS:");
        
        lblFiltro= new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//funilPequeno.png"));
        

		
		btnVoltar = new JButton(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//setaVoltarPequena.png"));
		btnVoltar.setContentAreaFilled(false); // Deixa a área de preenchimento transparente
		btnVoltar.setBorderPainted(false); // Remove a borda
		btnVoltar.setFocusPainted(false);
        
        
        Color roxoEscuro=new Color(75,0,130);
        barra.setBackground(roxoEscuro);
        btnFavoritos.setBackground(roxoEscuro);
        btnFavoritos.setForeground(Color.WHITE);
        livroScrollButton.setBackground(roxoEscuro);
        livroScrollButton.setForeground(Color.WHITE);
        livroScrollButton2.setBackground(roxoEscuro);
        livroScrollButton2.setForeground(Color.WHITE);
        videoScrollButton.setBackground(roxoEscuro);
        videoScrollButton.setForeground(Color.WHITE);
        videoScrollButton2.setBackground(roxoEscuro);
        videoScrollButton2.setForeground(Color.WHITE);
        txtLivro.setForeground(Color.BLACK);
    	txtVideo.setForeground(Color.BLACK);
    	txtFlashcard.setForeground(Color.BLACK);
    	
    	
        
        Font fonteBarra = new Font( "Trebuchet MS", Font.PLAIN, 20);
		btnFavoritos.setFont(fonteBarra);
		
        Font fontePasse = new Font( "Trebuchet MS", Font.PLAIN, 25);
		livroScrollButton.setFont(fontePasse);
		livroScrollButton2.setFont(fontePasse);
		videoScrollButton.setFont(fontePasse);
		videoScrollButton2.setFont(fontePasse);
		
		
		Font separadores = new Font( "Trebuchet MS", Font.BOLD, 25);
		txtLivro.setFont(separadores);
    	txtVideo.setFont(separadores);
    	txtFlashcard.setFont(separadores);
		
    	txtFiltro.setFont(new Font("Trebuchet  MS", Font.PLAIN, 25));
	    lblPesquisar.setFont(new Font("Trebuchet  MS", Font.PLAIN, 25));
		
		lp.setBounds(0, 0, screenSize.width, screenSize.height-40);
	    barra.setBounds(0,0,screenSize.width, 50);
	    btnFavoritos.setBounds(60, 7, 140, 35);
	    lblFiltro.setBounds(180, 105, 23, 25);
		txtFiltro.setBounds(209, 100, 960, 35);
		lblPesquisar.setBounds(225, 100, 950, 35);
	    livroScrollButton.setBounds(1280,260,55,55);
	    livroScrollButton2.setBounds(10,260,55,55);
	    videoScrollButton.setBounds(1280,510,55,55);
	    videoScrollButton2.setBounds(10,510,55,55);
	    txtLivro.setBounds(75,150,300,100);
    	txtVideo.setBounds(75,400,300,100);
    	txtFlashcard.setBounds(75,650,300,100);
    	btnVoltar.setBounds(10, 12, 28,25);
    	
	    contentPane.add(lp);
	    lp.add(barra, new Integer(1));
	    lp.add(btnFavoritos, new Integer(2));
	    lp.add(txtFiltro, new Integer(3));
	    lp.add(lblFiltro, new Integer(4));
	    lp.add(lblPesquisar, new Integer(5));
	    lp.add(livroScrollButton, new Integer(1000)); 
	    lp.add(livroScrollButton2, new Integer(1000 )); 
	    lp.add(videoScrollButton, new Integer(1000)); 
	    lp.add(videoScrollButton2, new Integer(1000 )); 
	    lp.add(txtLivro, new Integer(11)); 
	    lp.add(txtVideo, new Integer(12)); 
	    lp.add(txtFlashcard, new Integer(13)); 
	    lp.add(btnVoltar, new Integer(14));
	    //lp.add(scrollPane, new Integer(2000));
	    
	    JScrollPane scrollPane = new JScrollPane(lp);
	    contentPane.add(scrollPane, BorderLayout.CENTER);
	    
	    setLayout(new BorderLayout());
	    add(lp, BorderLayout.CENTER);
	    btnFavoritos.setBorderPainted(false);
	     
	     
	    btnFavoritos.setFocusPainted(false);
	    
	    for(int i=0;i < numeroLabels; i++) {
	    	int referencia = 1;
			EspacoLivro[i] = new JLabel (""+(referencia+i));
			EspacoLivro[i].setOpaque(true);
			EspacoLivro[i].setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
			EspacoLivro[i].setBackground(Color.WHITE);
			EspacoLivro[i].setForeground(Color.BLACK);
			EspacoLivro[i].setBounds(linhaEL,colunaEL-20,100,100);
			lp.add(EspacoLivro[i], new Integer(camadasEL));
			linhaEL= linhaEL+175;
			camadasEL++;
			
		}
	    
	    for(int i=0;i < numeroLabels; i++) {
	    	espacoTituloLivro[i] = new JLabel("");
	    	espacoTituloLivro[i].setOpaque(true);
	    	espacoTituloLivro[i].setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
	    	espacoTituloLivro[i].setBackground(Color.WHITE);
	    	espacoTituloLivro[i].setForeground(Color.BLACK);
	    	espacoTituloLivro[i].setBounds(linhaETL,colunaETL-70,100,40);
			lp.add(espacoTituloLivro[i], new Integer(camadasETL));
			linhaETL= linhaETL+175;
			camadasETL++;
		}
	    
	    
	    for(int i=0;i < numeroLabels; i++) {
	    	int referencia = 1;
			EspacoVideo[i] = new JLabel (""+(referencia+i));
			EspacoVideo[i].setOpaque(true);
			EspacoVideo[i].setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
			EspacoVideo[i].setBackground(Color.WHITE);
			EspacoVideo[i].setForeground(Color.BLACK);
			EspacoVideo[i].setBounds(linhaEV,colunaEV-20,100,100);
			lp.add(EspacoVideo[i], new Integer(camadasEV));
			linhaEV= linhaEV+175;
			camadasEV++;
			
		}
	    
	    for(int i=0;i < numeroLabels; i++) {
	    	espacoTituloVideo[i] = new JLabel("");
	    	espacoTituloVideo[i].setOpaque(true);
	    	espacoTituloVideo[i].setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
	    	espacoTituloVideo[i].setBackground(Color.WHITE);
	    	espacoTituloVideo[i].setForeground(Color.BLACK);
	    	espacoTituloVideo[i].setBounds(linhaETV,colunaETV-70,100,40);
			lp.add(espacoTituloVideo[i], new Integer(camadasETV));
			linhaETV= linhaETV+175;
			camadasETV++;
		}
	    
	    
	    for(int i=0;i < numeroLabels; i++) {
	    	int referencia = 1;
			EspacoFlashcard[i] = new JLabel (""+(referencia+i));
			EspacoFlashcard[i].setOpaque(true);
			EspacoFlashcard[i].setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
			EspacoFlashcard[i].setBackground(Color.WHITE);
			EspacoFlashcard[i].setForeground(Color.BLACK);
			EspacoFlashcard[i].setBounds(linhaEF,colunaEF-70,100,100);
			lp.add(EspacoFlashcard[i], new Integer(camadasEF));
			linhaEF= linhaEF+175;
			camadasEF++;
			
		}
	    
	    for(int i=0;i < numeroLabels; i++) {
	    	espacoTituloFlashcard[i] = new JLabel("");
	    	espacoTituloFlashcard[i].setOpaque(true);
	    	espacoTituloFlashcard[i].setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
	    	espacoTituloFlashcard[i].setBackground(Color.WHITE);
	    	espacoTituloFlashcard[i].setForeground(Color.BLACK);
	    	espacoTituloFlashcard[i].setBounds(linhaETF,colunaETF-70,100,40);
			lp.add(espacoTituloFlashcard[i], new Integer(camadasETF));
			linhaETF= linhaETF+175;
			camadasETF++;
		}
	    
	    livroScrollButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            int maxScroll = (numeroLabels - 1) * 175; // Máximo valor de rolagem
	            
	            if (scrollValue < maxScroll) {
	                scrollValue += 175; // Atualiza a quantidade de rolagem
	                
	                for (int i = 0; i < numeroLabels; i++) {
	                    EspacoLivro[i].setLocation(EspacoLivro[i].getX() - 175, EspacoLivro[i].getY());
	                    espacoTituloLivro[i].setLocation(espacoTituloLivro[i].getX() - 175, espacoTituloLivro[i].getY());
	                }
	            }
	        }
	    });

	    livroScrollButton2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (scrollValue > 0) {
	                scrollValue -= 175; // Atualiza a quantidade de rolagem
	                
	                for (int i = 0; i < numeroLabels; i++) {
	                    EspacoLivro[i].setLocation(EspacoLivro[i].getX() + 175, EspacoLivro[i].getY());
	                    espacoTituloLivro[i].setLocation(espacoTituloLivro[i].getX() + 175, espacoTituloLivro[i].getY());
	                }
	            }
	        }
	    });
	    
	    
	    
	    
	    videoScrollButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            int maxScroll = (numeroLabels - 1) * 200; // Máximo valor de rolagem
	            
	            if (scrollValue < maxScroll) {
	                scrollValue += 175; // Atualiza a quantidade de rolagem
	                
	                for (int i = 0; i < numeroLabels; i++) {
	                	EspacoVideo[i].setLocation(EspacoVideo[i].getX() - 175, EspacoVideo[i].getY());
	                    espacoTituloVideo[i].setLocation(espacoTituloVideo[i].getX() - 175, espacoTituloVideo[i].getY());
	                }
	            }
	        }
	    });

	    videoScrollButton2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (scrollValue > 0) {
	                scrollValue -= 175; // Atualiza a quantidade de rolagem
	                
	                for (int i = 0; i < numeroLabels; i++) {
	                    EspacoVideo[i].setLocation(EspacoVideo[i].getX() + 175, EspacoVideo[i].getY());
	                    espacoTituloVideo[i].setLocation(espacoTituloVideo[i].getX() + 175, espacoTituloVideo[i].getY());
	                }
	            }
	        }
	    });
	}
	
	public void definirEventos(Aluno aluno) {
	    
	    lblPesquisar.addMouseListener(new MouseListener() {	
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				lp.remove(lblPesquisar);
                repaint();			}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
			}
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				if (!lp.isAncestorOf(lblPesquisar)) {
					lp.add(lblPesquisar, new Integer(26));
                    repaint();
                }
			}
        });
        getContentPane().add(lp);
        
        btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaInicialAluno tela = new TelaInicialAluno(aluno, true);
			     setVisible(false);
			}
		});
	}
}