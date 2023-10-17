package view;
import java.awt.Window;
import javax.swing.*;
import javax.swing.border.AbstractBorder;

import conexaoBD.Conexao;
import vo.Aluno;
import vo.Olimpiada;
import vo.Professor;
import controller.AlunoCONTROLLER;
import controller.LivroCONTROLLER;
import controller.OlimpiadaCONTROLLER;
import controller.ProfessorCONTROLLER;
import controller.VideoCONTROLLER;
import dao.AlunoDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaInicialProf extends JFrame{
	Color roxoEscuro = new Color(75, 0,130);
	
	private Container contentPane;
	private JLayeredPane lp;
	private JLabel LivrosR;
	private JLabel VideosR;
	private JLabel Pesquisa;
	private JLabel OlimpR;
	
	private JLabel Play;
	private JLabel Livro;
	

	private JButton btnPerfil;
	private JButton btnPesquisa;
 
	private ImageIcon Perfil;
	private ImageIcon PesquisaIm; 
		
	private JMenuBar Barra;
	private JButton Livros;
	private JButton Videos;
	
	private JButton OlimpiadasR;
	
	private JTextField PesOlimpiadas;
	
	//private ArrayList<JButton> botoesOlimp = new ArrayList<>();

	 
	public TelaInicialProf(Professor prof, boolean login) {
		inicializarComponentes(prof);
		definirEventos(prof);
	}

	
	private void definirEventos(Professor prof) {
		btnPesquisa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean retorna=false;
				String olimp = PesOlimpiadas.getText();
				OlimpiadaCONTROLLER controlaOlimp = new OlimpiadaCONTROLLER();

				while(retorna==false) {
					if(olimp.equals(" Pesquisar Olimpíadas")) {
						JOptionPane.showMessageDialog(null, "Digite algo para que a pesquisa seja realizada!");
						PesOlimpiadas.setText(null);
						PesOlimpiadas.setText(" Pesquisar Olimpíadas");
						retorna=false;
						return;
					}else {
						if(controlaOlimp.consultar(olimp)==true) {
							JButton btnOlimp = new JButton(olimp);
							btnOlimp.setForeground(roxoEscuro);
							btnOlimp.setBackground(Color.WHITE);
							btnOlimp.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
							btnOlimp.setBorder(BorderFactory.createLineBorder(roxoEscuro, 2)); // Cria uma borda de 2 pixels de largura
							btnOlimp.setBounds(760,151,550,50);
							
							lp.add(btnOlimp, new Integer(23));
							
							btnOlimp.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									Olimpiada nomeOlimp=new Olimpiada(olimp);
									GuiOlimpiadasProf olimpiada = new GuiOlimpiadasProf(nomeOlimp, prof);
		    						setVisible(false);
								}
							});
							
							retorna=true;
							
						}else if(controlaOlimp.consultar(olimp)==false) {
							JOptionPane.showMessageDialog(null, "Olimpíada inexistente no sistema!");
							PesOlimpiadas.setText(null);
							PesOlimpiadas.setText(" Pesquisar Olimpíadas");
							retorna=false;
							return;
						}
					}
					
				}				
			}
		});		
		
		btnPerfil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaPerfilProf tela = new TelaPerfilProf(prof);
			     setVisible(false);
			}
			 
		 });
	}

	private void inicializarComponentes(Professor prof) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height-40);
        contentPane=getContentPane();
        contentPane.setBackground(Color.white);
        lp = new JLayeredPane();

        
        //logica para videos e livros recentes
        LivroCONTROLLER controlaLiv = new LivroCONTROLLER();
        VideoCONTROLLER controlaVid  = new VideoCONTROLLER();
        ArrayList<String> listaISBNLiv = controlaLiv.exibirHistoricoLivrosProfISBN(prof.getEmail());
        ArrayList<String> listaTituloLiv = controlaLiv.exibirHistoricoLivrosProfTITULO(prof.getEmail());

        ArrayList<String> listaUPCVid = controlaVid.exibirHistoricoVideosProfUPC(prof.getEmail());
        ArrayList<String> listaTituloVid = controlaVid.exibirHistoricoVideosProfTITULO(prof.getEmail());

    	JLabel LivrosRecente1;
    	JLabel LivrosRecente2;
    	JButton btLivrosRecente1;
    	JButton btLivrosRecente2;
    	

       if(listaISBNLiv.size()==2) {
    	   LivrosRecente1 = new JLabel(listaTituloLiv.get(0));
           LivrosRecente2 = new JLabel(listaTituloLiv.get(1));
           btLivrosRecente1 = new JButton(listaISBNLiv.get(0));
           btLivrosRecente2 = new JButton(listaISBNLiv.get(1));
           
           btLivrosRecente1.setFocusPainted(false);
           btLivrosRecente2.setFocusPainted(false);
           
           btLivrosRecente1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
           btLivrosRecente2.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
           btLivrosRecente1.setBackground(Color.WHITE);
           btLivrosRecente1.setForeground(Color.BLACK);
           btLivrosRecente2.setBackground(Color.WHITE);
           btLivrosRecente2.setForeground(Color.BLACK);
           
           LivrosRecente1.setBackground(Color.white);
           LivrosRecente1.setForeground(Color.BLACK);
           LivrosRecente2.setBackground(Color.white);
           LivrosRecente2.setForeground(Color.BLACK);
           LivrosRecente1.setBorder(BorderFactory.createLineBorder(roxoEscuro, 2)); // Cria uma borda de 2 pixels de largura em preto
           LivrosRecente1.setHorizontalAlignment(SwingConstants.CENTER); 
           LivrosRecente2.setBorder(BorderFactory.createLineBorder(roxoEscuro, 2)); // Cria uma borda de 2 pixels de largura em preto
           LivrosRecente2.setHorizontalAlignment(SwingConstants.CENTER); 
           
           LivrosRecente1.setBounds(80, 165, 150, 150);
           btLivrosRecente1.setBounds(80,315,150,40); //botao

           LivrosRecente2.setBounds(280, 165, 150, 150); //algo
           btLivrosRecente2.setBounds(280,315,150,40);
           
           LivrosRecente1.setBounds(80, 165, 150, 150);
           btLivrosRecente1.setBounds(80,315,150,40); //botao

           LivrosRecente2.setBounds(280, 165, 150, 150); //algo
           btLivrosRecente2.setBounds(280,315,150,40);
         
           
           lp.add(LivrosRecente1, new Integer(9));
           lp.add(LivrosRecente2, new Integer(10));
           lp.add(btLivrosRecente1, new Integer(16));
           lp.add(btLivrosRecente2, new Integer(17));
           
       }else if (listaISBNLiv.size()==1) {
    	   LivrosRecente1 = new JLabel(listaTituloLiv.get(0));
           btLivrosRecente1 = new JButton(listaISBNLiv.get(0));
           
           btLivrosRecente1.setFocusPainted(false);
           
           btLivrosRecente1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
           btLivrosRecente1.setBackground(Color.WHITE);
           btLivrosRecente1.setForeground(Color.BLACK);
      
           
           LivrosRecente1.setBackground(Color.white);
           LivrosRecente1.setForeground(Color.BLACK);
           LivrosRecente1.setBorder(BorderFactory.createLineBorder(roxoEscuro, 2)); // Cria uma borda de 2 pixels de largura em preto
           LivrosRecente1.setHorizontalAlignment(SwingConstants.CENTER); 
     
           
           LivrosRecente1.setBounds(80, 165, 150, 150);
           btLivrosRecente1.setBounds(80,315,150,40); //botao

           
           LivrosRecente1.setBounds(80, 165, 150, 150);
           btLivrosRecente1.setBounds(80,315,150,40); //botao

           
           lp.add(LivrosRecente1, new Integer(9));
           lp.add(btLivrosRecente1, new Integer(16));
       
       }else {
    	   //não há historico
       }
       
        JButton btVideosRecente1;
   	 	JButton btVideosRecente2;
   	 	JLabel VideosRecente1;
   	 	JLabel VideosRecente2;
       
       if(listaUPCVid.size()==2) {
    	   VideosRecente1 = new JLabel(listaTituloVid.get(0));
    	   VideosRecente2 = new JLabel(listaTituloVid.get(1));
           btVideosRecente1 = new JButton(listaUPCVid.get(0));
           btVideosRecente2 = new JButton(listaUPCVid.get(1));
           
           btVideosRecente1.setFocusPainted(false);
           btVideosRecente2.setFocusPainted(false);
           
           btVideosRecente1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
           btVideosRecente2.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
           
           
           
           btVideosRecente1.setBackground(Color.WHITE);
           btVideosRecente1.setForeground(Color.BLACK);
           btVideosRecente2.setBackground(Color.WHITE);
           btVideosRecente2.setForeground(Color.BLACK);
           
           
           VideosRecente1.setBackground(Color.white);
           VideosRecente1.setForeground(Color.BLACK);
           VideosRecente2.setBackground(Color.white);
           VideosRecente2.setForeground(Color.BLACK);
           
            VideosRecente1.setBorder(BorderFactory.createLineBorder(roxoEscuro, 2)); // Cria uma borda de 2 pixels de largura em preto
           VideosRecente1.setHorizontalAlignment(SwingConstants.CENTER); 
           VideosRecente2.setBorder(BorderFactory.createLineBorder(roxoEscuro, 2)); // Cria uma borda de 2 pixels de largura em preto
           VideosRecente2.setHorizontalAlignment(SwingConstants.CENTER); 
           
           VideosRecente1.setBounds(80, 430, 150, 150);
           btVideosRecente1.setBounds(80,580,150,40);

           VideosRecente2.setBounds(280, 430, 150, 150);
           btVideosRecente2.setBounds(280,580,150,40);
           VideosRecente1.setBounds(80, 430, 150, 150);
           btVideosRecente1.setBounds(80,580,150,40);

           VideosRecente2.setBounds(280, 430, 150, 150);
           btVideosRecente2.setBounds(280,580,150,40);
           
           lp.add(VideosRecente1, new Integer(9));
           lp.add(VideosRecente2, new Integer(10));
           lp.add(btVideosRecente1, new Integer(16));
           lp.add(btVideosRecente2, new Integer(17));
           
       }else if (listaUPCVid.size()==1) {
    	   VideosRecente1 = new JLabel(listaTituloVid.get(0));
           btVideosRecente1 = new JButton(listaUPCVid.get(0));
           
           btVideosRecente1.setFocusPainted(false);
           
           btVideosRecente1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
           
           
           
           btVideosRecente1.setBackground(Color.WHITE);
           btVideosRecente1.setForeground(Color.BLACK);
           
           
           VideosRecente1.setBackground(Color.white);
           VideosRecente1.setForeground(Color.BLACK);
       
           
            VideosRecente1.setBorder(BorderFactory.createLineBorder(roxoEscuro, 2)); // Cria uma borda de 2 pixels de largura em preto
           VideosRecente1.setHorizontalAlignment(SwingConstants.CENTER); 
          
           
           VideosRecente1.setBounds(80, 430, 150, 150);
           btVideosRecente1.setBounds(80,580,150,40);

       
           VideosRecente1.setBounds(80, 430, 150, 150);
           btVideosRecente1.setBounds(80,580,150,40);

           
           lp.add(VideosRecente1, new Integer(9));
           lp.add(btVideosRecente1, new Integer(16));
       
       }else {
    	   //não há historico
       }


        //
        
        Barra = new JMenuBar();
        LivrosR = new JLabel("<html>Livros postados recentemente:");        
        VideosR = new JLabel("<html>Vídeos postados recentemente: ");  
        OlimpR = new JLabel("Olimpíadas acessadas anteriormente: ");
        Livros = new JButton("Livros");
        Videos = new JButton("Vídeos");
        PesOlimpiadas = new JTextField(" Pesquisar Olimpíadas");
       
        
        
        
        
        Play = new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//videoPlayBranco.png"));
        
        Livro = new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//livrinho.png"));
        
        Perfil = new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//iconePerfilpequeno.png");
        
        PesquisaIm = new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//lupaPequena.png");
        
   
        
        Livros.setFocusPainted(false);
        Videos.setFocusPainted(false);
        
        
        
        btnPerfil = new JButton(Perfil);
        btnPerfil.setContentAreaFilled(false); // Deixa a área de preenchimento transparente
        btnPerfil.setBorderPainted(false); // Remove a borda
        btnPerfil.setFocusPainted(false);
        
        btnPesquisa = new JButton(PesquisaIm);
        btnPesquisa.setContentAreaFilled(false); // Deixa a área de preenchimento transparente
        btnPesquisa.setBorderPainted(false); // Remove a borda
        btnPesquisa.setFocusPainted(false);
        
        PesOlimpiadas.setBorder( new BordaCantoArredondado() );
        
        Color roxoEscuro=new Color(75,0,130);
        Barra.setBackground(roxoEscuro);
        LivrosR.setForeground(Color.black);
        VideosR.setForeground(Color.black);
        OlimpR.setForeground(Color.black);
        Livros.setBackground(roxoEscuro);
        Livros.setForeground(Color.WHITE);
        Videos.setBackground(roxoEscuro);
        Videos.setForeground(Color.WHITE);
        
        Livros.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
        Videos.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
      
        
        Font fonteLabelsDesc = new Font( "Trebuchet MS", Font.PLAIN, 30);
        LivrosR.setFont(fonteLabelsDesc);
        VideosR.setFont(fonteLabelsDesc);
        OlimpR.setFont(fonteLabelsDesc);
        PesOlimpiadas.setFont(fonteLabelsDesc);

        
        Font fonteBarra = new Font( "Trebuchet MS", Font.PLAIN, 20);
		Livros.setFont(fonteBarra);
		Videos.setFont(fonteBarra);
		
        lp.setBounds(0, 0, screenSize.width, screenSize.height-40);
        Barra.setBounds(0,0,screenSize.width, 50);
        btnPerfil.setBounds(10,5,44, 35);
        Livros.setBounds(60, 7, 140, 35);
        Livro.setBounds(165,14,21,20);
        Videos.setBounds(220, 7, 150, 35);
        Play.setBounds(330,15,20,20);
        
        
        btnPesquisa.setBounds(700,105,45, 46);
        PesOlimpiadas.setBounds(760,100,550,50);
        OlimpR.setBounds(760,210,550,60);

        LivrosR.setBounds(50,100,430,60);
        VideosR.setBounds(50,365,430,60);
       
        
        
        
        
        contentPane.add(lp);
        lp.add(Barra, new Integer(1));
        lp.add(LivrosR, new Integer(2));
        lp.add(VideosR, new Integer(3));
        lp.add(OlimpR,  new Integer(4));
        lp.add(btnPesquisa, new Integer(5));
        lp.add(PesOlimpiadas, new Integer(6));
        lp.add(Livros, new Integer(7));
        lp.add(Videos, new Integer(8));
        lp.add(Play, new Integer(20));
        lp.add(btnPerfil, new Integer(20));
        lp.add(Livro, new Integer(20));
        
        setLayout(new BorderLayout());
        add(lp, BorderLayout.CENTER);
        
		setVisible(true);
		
		
	}
    
    
private class BordaCantoArredondado extends AbstractBorder {
        
        private static final BasicStroke CONTORNO = new BasicStroke( 2 );
                
        @Override
        public void paintBorder( Component c, Graphics g, int x, int y, int width, int height ) {
            
            super.paintBorder( c, g, x, y, width, height );
            
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
            g2d.setStroke( CONTORNO );
            
            g2d.setColor( Color.BLACK );
            g2d.drawRoundRect( x, y, width-1, height-1, 20, 20 );
            
            g2d.dispose();
            
        }
        
    }
	



}