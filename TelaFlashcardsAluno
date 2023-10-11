package view.TelasGuiOlimpiadasAluno;

import javax.swing.*;
import javax.swing.border.Border;
import view.*;
import controller.FlashcardCONTROLLER;
import view.ExibirFlashcard;
import view.TelaInicialProf;
import view.TelasGuiOlimpiadasProf.TelaLivrosProf;
import view.TelasGuiOlimpiadasProf.TelaVideosProf;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import vo.Aluno;
import vo.Flashcard;
import vo.Olimpiada;

public class TelaFlashcardsAluno extends JFrame{

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
	
	private JTextField txtFiltro;
    private JLabel lblFiltro;
    private JLabel lblPesquisar;
    
    private Color roxoIndigo = new Color(75,0,130);
        
    private ArrayList<Flashcard> flashsDaOlimpiada = new ArrayList<Flashcard>();
    JLabel[] vetCaixa;
	JLabel[] vetTitulo;
	JLabel[] vetPChave;
	JLabel[] vetEmailProf;
	JButton[] vetAcessar;
	
	public TelaFlashcardsAluno(Olimpiada olimp, Aluno aluno) {
		inicializarComponentes(olimp, aluno);
		definirEventos(olimp, aluno);
	}

	private void inicializarComponentes(Olimpiada olimp, Aluno aluno) {
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
      		txtFiltro = new JTextField(300);
      		lblFiltro= new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
      				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//funilPequeno.png"));
      	    lblPesquisar= new JLabel("Procurar por título");
      	    
      		
      		//cores		
      		barra.setBackground(roxoIndigo);
      		lblNomeOlimp.setBackground(roxoIndigo);
      		lblNomeOlimp.setForeground(Color.WHITE);
      		btnLivros.setBackground(roxoIndigo);
      		btnLivros.setForeground(Color.WHITE);
      		btnAssuntos.setBackground(roxoIndigo);
      		btnAssuntos.setForeground(Color.WHITE);
      		btnVideos.setBackground(roxoIndigo);
      		btnVideos.setForeground(Color.WHITE);
      		btnCronograma.setBackground(roxoIndigo);
      		btnCronograma.setForeground(Color.WHITE);
      		Color roxoVioleta = new Color(148,0,211);
      		btnFlashcards.setBackground(roxoVioleta);
      		btnFlashcards.setForeground(Color.WHITE);
      		lblPesquisar.setBackground(Color.white);
      		lblPesquisar.setForeground(Color.black);

      		lblNomeOlimp.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));

    		Font fonteBarra = new Font("Trebuchet MS", Font.PLAIN, 21);
    		btnLivros.setFont(fonteBarra);
    		btnVideos.setFont(fonteBarra);
    		btnAssuntos.setFont(fonteBarra);
    		btnFlashcards.setFont(fonteBarra);
    		btnCronograma.setFont(fonteBarra);     
            
    		txtFiltro.setFont(new Font("Trebuchet  MS", Font.PLAIN, 25));
    	    lblPesquisar.setFont(new Font("Trebuchet  MS", Font.PLAIN, 25));
    		
    		
    		//definir as posições
            barra.setBounds(0,0,screenSize.width, 50); 
            lblLogo.setBounds(10,5,44,35);
            btnLivros.setBounds(235,7, 100, 35);
    		btnVideos.setBounds(403,7,100,35);
    		btnAssuntos.setBounds(578,7,100,35);
    		btnFlashcards.setBounds(765,7,130,35);
    		btnCronograma.setBounds(980,7,130,35);		
    		lblFiltro.setBounds(180, 105, 23, 25);
    		txtFiltro.setBounds(209, 100, 960, 35);
    		lblPesquisar.setBounds(225, 100, 950, 35);
            lblNomeOlimp.setBounds(80, 15, 250, 20);
            
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
    		lp.add(lblFiltro, new Integer(24));
    		lp.add(txtFiltro, new Integer(25));
    		lp.add(lblPesquisar, new Integer(26));
    		
    		setLayout(new BorderLayout());
            add(lp, BorderLayout.CENTER);
            btnLivros.setBorderPainted(false);
            btnVideos.setBorderPainted(false);
            btnAssuntos.setBorderPainted(false);
            btnFlashcards.setBorderPainted(false);
            btnCronograma.setBorderPainted(false);
            
    		FlashcardCONTROLLER controla = new FlashcardCONTROLLER();
    		flashsDaOlimpiada= controla.retornaFlashOlimpiada(olimp);
    		
    		vetCaixa = new JLabel[flashsDaOlimpiada.size()];
			vetTitulo = new JLabel[flashsDaOlimpiada.size()];
			vetPChave = new JLabel[flashsDaOlimpiada.size()];
			vetEmailProf = new JLabel[flashsDaOlimpiada.size()];
			vetAcessar = new JButton[flashsDaOlimpiada.size()];
			
    		int camada=25;
    		int xCaixa=75; //tamanho da caixa 200 por 155
    		int yCaixa=200;
    		int xTitulo=170;
    		int yTitulo=200;
    		int xPalavraChave=85;
    		int yPalavraChave=250;
    		int xEmailProf=85;
    		int yEmailProf=275;
    		int xBotao=125;
    		int yBotao=315;

    		int indice=0;
    		int cont=1;
    		
    		if(flashsDaOlimpiada.size()==0) {
    			JLabel lblNaoTem = new JLabel("<html>Não há flashcards cadastrados<br>     nesta olimpíada<html>");
    			lblNaoTem.setForeground(Color.BLACK);
    			lblNaoTem.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
    			lblNaoTem.setBounds(100, 350, 1000, 70);
    			lp.add(lblNaoTem, new Integer(30));
    		}else {
    			for(Flashcard f : flashsDaOlimpiada) {
        			if(cont<=4) {//ainda está dentro do limite, apenas muda X
        				


        				vetCaixa[indice]= new JLabel("");
        				Border borda = BorderFactory.createLineBorder(roxoIndigo, 1);
        				vetCaixa[indice].setBorder(borda);
        				vetCaixa[indice].setBounds(xCaixa, yCaixa, 250, 155);
        				lp.add(vetCaixa[indice], new Integer(camada+=1));

        				
        				vetTitulo[indice] = new JLabel(f.getTitulo());
        				vetTitulo[indice].setForeground(Color.BLACK);
        				vetTitulo[indice].setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        				vetTitulo[indice].setBounds(xTitulo, yTitulo, 100, 30);
        				lp.add(vetTitulo[indice], new Integer(camada+=1));

        				
        				vetPChave[indice] = new JLabel (f.getPalavrasChave());
        				vetPChave[indice].setForeground(Color.BLACK);
        				vetPChave[indice].setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        				vetPChave[indice].setBounds(xPalavraChave, yPalavraChave, 150, 25);
        				lp.add(vetPChave[indice], new Integer(camada+=1));
        				
        				vetEmailProf[indice] = new JLabel("Professor:"+f.getEmailProf());
        				vetEmailProf[indice].setForeground(Color.BLACK);
        				vetEmailProf[indice].setBackground(new Color(220,220,220));
        				vetEmailProf[indice].setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        				vetEmailProf[indice].setBounds(xEmailProf, yEmailProf, 200, 25);
        				lp.add(vetEmailProf[indice], new Integer(camada+=1));

        				
        				vetAcessar[indice] = new JButton("Acessar");
        				vetAcessar[indice].setForeground(Color.WHITE);
        				vetAcessar[indice].setBackground(roxoIndigo);
        				vetAcessar[indice].setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
        				vetAcessar[indice].setBounds(xBotao, yBotao, 150, 23);
        				lp.add(vetAcessar[indice], new Integer(camada+=1));   

        				
        				camada+=1;
        				xCaixa+=280; 
        	    		xTitulo+=280;
        	    		xPalavraChave+=280;
        	    		xEmailProf+=280;
        	    		xBotao+=280;
            			cont++;
        	    		
            			vetAcessar[indice].addActionListener(new ActionListener() {
            				@Override
            				public void actionPerformed(ActionEvent e) {
            					ExibirFlashcard flash = new ExibirFlashcard(f.getTitulo());
            					flash.setVisible(true);
            			        flash.setLocationRelativeTo(null);

            				}
            			});
            			
        			}else { //passou do limite, voltam às configurações normais, porém agora y é maior
        				xCaixa=75; 
        	    		yCaixa+=200;
        	    		xTitulo=170;
        	    		yTitulo+=200;
        	    		xPalavraChave=85;
        	    		yPalavraChave+=200;
        	    		xEmailProf=85;
        	    		yEmailProf+=200;
        	    		xBotao=125;
        	    		yBotao+=200;
        				
        	    		vetCaixa[indice]= new JLabel("");
        				Border borda = BorderFactory.createLineBorder(roxoIndigo, 1);
        				vetCaixa[indice].setBorder(borda);
        				vetCaixa[indice].setBounds(xCaixa, yCaixa, 250, 155);
        				lp.add(vetCaixa[indice], new Integer(camada+=1));

        				
        				vetTitulo[indice] = new JLabel(f.getTitulo());
        				vetTitulo[indice].setForeground(Color.BLACK);
        				vetTitulo[indice].setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        				vetTitulo[indice].setBounds(xTitulo, yTitulo, 100, 30);
        				lp.add(vetTitulo[indice], new Integer(camada+=1));

        				
        				vetPChave[indice] = new JLabel (f.getPalavrasChave());
        				vetPChave[indice].setForeground(Color.BLACK);
        				vetPChave[indice].setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        				vetPChave[indice].setBounds(xPalavraChave, yPalavraChave, 150, 25);
        				lp.add(vetPChave[indice], new Integer(camada+=1));
        				
        				vetEmailProf[indice] = new JLabel("Professor:"+f.getEmailProf());
        				vetEmailProf[indice].setForeground(Color.BLACK);
        				vetEmailProf[indice].setBackground(new Color(220,220,220));
        				vetEmailProf[indice].setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        				vetEmailProf[indice].setBounds(xEmailProf, yEmailProf, 200, 25);
        				lp.add(vetEmailProf[indice], new Integer(camada+=1));

        				
        				vetAcessar[indice] = new JButton("Acessar");
        				vetAcessar[indice].setForeground(Color.WHITE);
        				vetAcessar[indice].setBackground(roxoIndigo);
        				vetAcessar[indice].setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
        				vetAcessar[indice].setBounds(xBotao, yBotao, 150, 23);
        				lp.add(vetAcessar[indice], new Integer(camada+=1));


        				camada+=1;
        				xCaixa+=280; 
        	    		xTitulo+=280;
        	    		xPalavraChave+=280;
        	    		xEmailProf+=280;
        	    		xBotao+=280;
        	    		
            			cont=1;
            			
            			vetAcessar[indice].addActionListener(new ActionListener() {
            				@Override
            				public void actionPerformed(ActionEvent e) {
            					ExibirFlashcard flash = new ExibirFlashcard(f.getTitulo());
            					flash.setVisible(true);
            			        flash.setLocationRelativeTo(null);

            				}
            			});
        			}
        			indice++;
        		}
    		}
		
	}

	private void definirEventos(Olimpiada olimp, Aluno aluno) {
		
		txtFiltro.addKeyListener((KeyListener) new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				String titulo = "%" + txtFiltro.getText() + "%";           
	            
				int camada=60;
	    		int xCaixa=75; //tamanho da caixa 200 por 155
	    		int yCaixa=200;
	    		int xTitulo=170;
	    		int yTitulo=200;
	    		int xPalavraChave=85;
	    		int yPalavraChave=250;
	    		int xEmailProf=85;
	    		int yEmailProf=275;
	    		int xBotao=125;
	    		int yBotao=315;
	    		
	    		for (JLabel label : vetCaixa) {
				    lp.remove(label); // Remove cada JLabel do JLayeredPane
				}
				for (JLabel label : vetTitulo) {
				    lp.remove(label); // Remove cada JLabel do JLayeredPane
				}
				for (JLabel label : vetPChave) {
				    lp.remove(label); // Remove cada JLabel do JLayeredPane
				}
				for (JLabel label : vetEmailProf) {
				    lp.remove(label); // Remove cada JLabel do JLayeredPane
				}
				for (JButton but : vetAcessar) {
				    lp.remove(but); // Remove cada JLabel do JLayeredPane
				}
		    	lp.repaint();
		    	
	    		int cont=1;
	    		int indice=0;
	    		

			    FlashcardCONTROLLER controller = new FlashcardCONTROLLER();
			    ArrayList<Flashcard> lista = controller.consultarFlashcardsPorTitulo(titulo, olimp);
			    
			    vetCaixa = new JLabel[lista.size()];
				vetTitulo = new JLabel[lista.size()];
				vetPChave = new JLabel[lista.size()];
				vetEmailProf = new JLabel[lista.size()];
				vetAcessar = new JButton[lista.size()];

			    for(Flashcard f : lista) {
        			if(cont<=4) {//ainda está dentro do limite, apenas muda X
        				vetCaixa[indice]= new JLabel("");
        				Border borda = BorderFactory.createLineBorder(roxoIndigo, 1);
        				vetCaixa[indice].setBorder(borda);
        				vetCaixa[indice].setBounds(xCaixa, yCaixa, 250, 155);
        				lp.add(vetCaixa[indice], new Integer(camada+=1));

        				
        				vetTitulo[indice] = new JLabel(f.getTitulo());
        				vetTitulo[indice].setForeground(Color.BLACK);
        				vetTitulo[indice].setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        				vetTitulo[indice].setBounds(xTitulo, yTitulo, 100, 30);
        				lp.add(vetTitulo[indice], new Integer(camada+=1));

        				
        				vetPChave[indice] = new JLabel (f.getPalavrasChave());
        				vetPChave[indice].setForeground(Color.BLACK);
        				vetPChave[indice].setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        				vetPChave[indice].setBounds(xPalavraChave, yPalavraChave, 150, 25);
        				lp.add(vetPChave[indice], new Integer(camada+=1));
        				
        				vetEmailProf[indice] = new JLabel("Professor:"+f.getEmailProf());
        				vetEmailProf[indice].setForeground(Color.BLACK);
        				vetEmailProf[indice].setBackground(new Color(220,220,220));
        				vetEmailProf[indice].setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        				vetEmailProf[indice].setBounds(xEmailProf, yEmailProf, 200, 25);
        				lp.add(vetEmailProf[indice], new Integer(camada+=1));

        				
        				vetAcessar[indice] = new JButton("Acessar");
        				vetAcessar[indice].setForeground(Color.WHITE);
        				vetAcessar[indice].setBackground(roxoIndigo);
        				vetAcessar[indice].setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
        				vetAcessar[indice].setBounds(xBotao, yBotao, 150, 23);
        				lp.add(vetAcessar[indice], new Integer(camada+=1));          		

        				
        				camada+=1;
        				xCaixa+=280; 
        	    		xTitulo+=280;
        	    		xPalavraChave+=280;
        	    		xEmailProf+=280;
        	    		xBotao+=280;
            			cont++;
        	    		
            			vetAcessar[indice].addActionListener(new ActionListener() {
            				@Override
            				public void actionPerformed(ActionEvent e) {
            					ExibirFlashcard flash = new ExibirFlashcard(f.getTitulo());
            					flash.setVisible(true);
            			        flash.setLocationRelativeTo(null);

            				}
            			});
            			
        			}else { //passou do limite, voltam às configurações normais, porém agora y é maior
        				xCaixa=75; 
        	    		yCaixa+=200;
        	    		xTitulo=170;
        	    		yTitulo+=200;
        	    		xPalavraChave=85;
        	    		yPalavraChave+=200;
        	    		xEmailProf=85;
        	    		yEmailProf+=200;
        	    		xBotao=125;
        	    		yBotao+=200;
        				
        	    		vetCaixa[indice]= new JLabel("");
        				Border borda = BorderFactory.createLineBorder(roxoIndigo, 1);
        				vetCaixa[indice].setBorder(borda);
        				vetCaixa[indice].setBounds(xCaixa, yCaixa, 250, 155);
        				lp.add(vetCaixa[indice], new Integer(camada+=1));

        				
        				vetTitulo[indice] = new JLabel(f.getTitulo());
        				vetTitulo[indice].setForeground(Color.BLACK);
        				vetTitulo[indice].setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        				vetTitulo[indice].setBounds(xTitulo, yTitulo, 100, 30);
        				lp.add(vetTitulo[indice], new Integer(camada+=1));

        				
        				vetPChave[indice] = new JLabel (f.getPalavrasChave());
        				vetPChave[indice].setForeground(Color.BLACK);
        				vetPChave[indice].setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        				vetPChave[indice].setBounds(xPalavraChave, yPalavraChave, 150, 25);
        				lp.add(vetPChave[indice], new Integer(camada+=1));
        				
        				vetEmailProf[indice] = new JLabel("Professor:"+f.getEmailProf());
        				vetEmailProf[indice].setForeground(Color.BLACK);
        				vetEmailProf[indice].setBackground(new Color(220,220,220));
        				vetEmailProf[indice].setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        				vetEmailProf[indice].setBounds(xEmailProf, yEmailProf, 200, 25);
        				lp.add(vetEmailProf[indice], new Integer(camada+=1));

        				
        				vetAcessar[indice] = new JButton("Acessar");
        				vetAcessar[indice].setForeground(Color.WHITE);
        				vetAcessar[indice].setBackground(roxoIndigo);
        				vetAcessar[indice].setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
        				vetAcessar[indice].setBounds(xBotao, yBotao, 150, 23);
        				lp.add(vetAcessar[indice], new Integer(camada+=1));   

        				

        				camada+=1;
        				xCaixa+=280; 
        	    		xTitulo+=280;
        	    		xPalavraChave+=280;
        	    		xEmailProf+=280;
        	    		xBotao+=280;
        	    		
            			cont=1;
            			
            			vetAcessar[indice].addActionListener(new ActionListener() {
            				public void actionPerformed(ActionEvent e) {
            					ExibirFlashcard flash = new ExibirFlashcard(f.getTitulo());
            					flash.setVisible(true);
            			        flash.setLocationRelativeTo(null);

            				}
            			});
        			}
        			indice++;
        		}
	    		
	    			
		    	}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			

			});	

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
		
		btnLivros.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaLivrosAluno livro = new TelaLivrosAluno(olimp, aluno);
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
				//TelaAssuntosAluno video = new TelaAssuntosAluno(olimp, aluno);
			     setVisible(false);

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
