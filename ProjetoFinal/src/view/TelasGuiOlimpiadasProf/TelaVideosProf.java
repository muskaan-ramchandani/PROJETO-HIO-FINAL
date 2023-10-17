package view.TelasGuiOlimpiadasProf;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.time.LocalDate;
import org.w3c.dom.events.MouseEvent;
import vo.Professor;
import vo.Video;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import controller.VideoCONTROLLER;
import controller.LivroCONTROLLER;
import controller.OlimpiadaCONTROLLER;
import dao.VideoDAO;
import view.TelaInicialProf;
import vo.Olimpiada;

public class TelaVideosProf extends JFrame{
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
	
	ArrayList<Video> videosDaOlimpiada = new ArrayList<Video>();
	private JLabel[] EspacoVideo;
	private JLabel[] espacoTitulo;
	
	
	private JLabel lblCadastrarVideo;
	private JLabel lblProdutor;
	private JTextField txtProdutor;
	private JLabel lblTitulo;
	private JTextField txtTitulo;
	private JLabel lblDataPublicacao;
	private JFormattedTextField txtDataPublicacao;
	private JLabel lblArquivoVideo;
	private JButton selecioneVideo;
	private JFileChooser selecionaVideo;
	private JButton btnCadastrar;
    private JTextField txtFiltro;
    private JLabel lblFiltro;
    private JLabel lblPesquisar;
    private JLabel lblUPC;
    private JTextField txtUPC;

    private Color roxoIndigo = new Color(75,0,130);
	
	public TelaVideosProf(Olimpiada olimp, Professor prof) {
		inicializarComponentes(olimp, prof);
		definirEventos(olimp, prof);
		setVisible(true);
	}
	public void inicializarComponentes(Olimpiada olimp, Professor prof) {
		//configura tela
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height-40);
		contentPane=getContentPane();
        contentPane.setBackground(Color.white);
		
        //configuração de exbição dos livros
        VideoCONTROLLER controla = new VideoCONTROLLER();
    	videosDaOlimpiada= controla.retornaVideoOlimpiada(olimp);
    	
    	int numeroLabels = videosDaOlimpiada.size();
    	
    	EspacoVideo = new JLabel[numeroLabels];
    	int camadasEL = 30;
    	int linhaEL = 75;
    	int colunaEL = 200;
    	int limite = 3;
    	//
    	espacoTitulo = new JLabel[numeroLabels];
    	int camadas = 60;
    	int linha = 75;
    	int coluna = 350;
        
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
		selecioneVideo= new JButton("Selecione o arquivo de vídeo:");
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
		btnFlashcards.setBackground(roxoIndigo);
		btnFlashcards.setForeground(Color.WHITE);
		btnCronograma.setBackground(roxoIndigo);
		btnCronograma.setForeground(Color.WHITE);
		selecioneVideo.setBackground(Color.white);
		selecioneVideo.setForeground(Color.black);
		Color roxoVioleta = new Color(148,0,211);
		btnVideos.setBackground(roxoVioleta);
		btnVideos.setForeground(Color.WHITE);
		lblPesquisar.setBackground(Color.white);
		lblPesquisar.setForeground(Color.black);

		
		//formatações
		lblNomeOlimp.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		
		Font fonteBarra = new Font("Trebuchet MS", Font.PLAIN, 20);
		btnLivros.setFont(fonteBarra);
		btnVideos.setFont(fonteBarra);
		btnAssuntos.setFont(fonteBarra);
		btnFlashcards.setFont(fonteBarra);
		btnCronograma.setFont(fonteBarra);

		
		txtFiltro.setFont(new Font("Trebuchet  MS", Font.PLAIN, 25));
	    lblPesquisar.setFont(new Font("Trebuchet  MS", Font.PLAIN, 25));
	    
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
		lblFiltro.setBounds(75, 115, 23, 25);
		txtFiltro.setBounds(104, 110, 490, 35);
		lblPesquisar.setBounds(108, 110, 450, 35);
		
		if(numeroLabels==0) {
			JLabel lblNaoTem = new JLabel("<html>Não há vídeos cadastrados<br>     nesta olimpíada<html>");
			lblNaoTem.setForeground(Color.BLACK);
			lblNaoTem.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
			lblNaoTem.setBounds(100, 350, 1000, 70);
			lp.add(lblNaoTem, new Integer(30));
		}else {
			//JLabels dos espaços para a capa;
			for(int i=0;i < numeroLabels; i++) {
				Video videoDaLista = videosDaOlimpiada.get(i);
				EspacoVideo[i] = new JLabel (videoDaLista.getTitulo());
				EspacoVideo[i].setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
				EspacoVideo[i].setHorizontalAlignment(SwingConstants.CENTER);
				EspacoVideo[i].setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
				EspacoVideo[i].setBackground(Color.WHITE);
				EspacoVideo[i].setForeground(Color.BLACK);
				if(i >= limite) {
					colunaEL = colunaEL+250;
					limite = limite + 3;
					linhaEL = 80;
				}
				EspacoVideo[i].setBounds(linhaEL,colunaEL,150,150);
				lp.add(EspacoVideo[i], new Integer(camadasEL));
				linhaEL= linhaEL+180;
				camadasEL++;
				
			}
			
			
			//JLabels dos espaços para titulos
			limite = 3;
			for(int i=0;i < numeroLabels; i++) {
				Video videoDaLista = videosDaOlimpiada.get(i);
				espacoTitulo[i] = new JLabel(videoDaLista.getUpc());
				espacoTitulo[i].setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
				espacoTitulo[i].setHorizontalAlignment(SwingConstants.CENTER);
				espacoTitulo[i].setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
				espacoTitulo[i].setBackground(Color.WHITE);
				espacoTitulo[i].setForeground(Color.BLACK);
				if(i >= limite) {
					coluna = colunaEL+150;
					limite = limite + 3;
					linha = 80;
				}
				espacoTitulo[i].setBounds(linha,coluna,150,40);
				lp.add(espacoTitulo[i], new Integer(camadas));
				linha= linha+180;
				camadas++;
			}
			}
	    
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
		
		
		 // Primeira área (sem JScrollPane) CADASTRO
  		lblCadastrarVideo = new JLabel("Cadastrar Vídeo");
  		lblUPC= new JLabel("UPC:");
  		txtUPC= new JTextField(12);
  		lblProdutor= new JLabel("Produtor:");
  		txtProdutor = new JTextField(100);
  		lblTitulo= new JLabel("Título:");
  		txtTitulo = new JTextField(100);
  		lblDataPublicacao= new JLabel("Data de publicação:");
  		txtDataPublicacao = new JFormattedTextField();
  		
  		 try {
 			txtDataPublicacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
             txtDataPublicacao.setHorizontalAlignment(JFormattedTextField.CENTER);
   		} catch (ParseException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
  	
  		lblArquivoVideo= new JLabel("Selecione o arquivo de vídeo:");
  		btnCadastrar= new JButton("Cadastrar");

  		selecionaVideo= new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Vídeo", "mp4", "avi", "mkv", "mov");
  		selecionaVideo.setFileFilter(filter);
  		selecionaVideo.setDialogTitle("Selecione um arquivo MP4");
    
  		btnCadastrar.setForeground(Color.white);
  		btnCadastrar.setBackground(roxoIndigo);
  		
  		Font fonteLabelsDesc = new Font( "Trebuchet MS", Font.PLAIN, 20);
  		lblProdutor.setFont(fonteLabelsDesc);
  		lblTitulo.setFont(fonteLabelsDesc);
  		lblUPC.setFont(fonteLabelsDesc);
  		lblDataPublicacao.setFont(fonteLabelsDesc);
  		lblArquivoVideo.setFont(fonteLabelsDesc);	
		
  		Font fonteTXT = new Font( "Trebuchet MS", Font.PLAIN, 18);;
  		txtProdutor.setFont(fonteTXT);
  		txtTitulo.setFont(fonteTXT);
  		txtDataPublicacao.setFont(fonteTXT);
  		selecionaVideo.setFont(fonteTXT);
  		selecioneVideo.setFont(fonteTXT);
  		txtUPC.setFont(fonteTXT);
  		
		Font fonteTamanho = new Font( "Trebuchet MS", Font.PLAIN, 45);
		lblCadastrarVideo.setFont(fonteTamanho);
	    
	    Font fonteTamanhoBotao = new Font( "Trebuchet MS", Font.PLAIN, 20);
	    btnCadastrar.setFont(fonteTamanhoBotao);
	    
	    lblCadastrarVideo.setBounds(870,70,800,100);
	    lblUPC.setBounds(800,165,400,30);
	    txtUPC.setBounds(800,205,465,30);
	    lblTitulo.setBounds(800,240,400,40);
	    txtTitulo.setBounds(800,280,465,30);
	    lblProdutor.setBounds(800,315,400,40);
		txtProdutor.setBounds(800,355,465,30);
		lblDataPublicacao.setBounds(800,395,400,40);
		txtDataPublicacao.setBounds(800,430,465,30);
		lblArquivoVideo.setBounds(800,470,400,40);
		selecioneVideo.setBounds(800,505,465,30);
		btnCadastrar.setBounds(915, 590, 245, 45);
	    
		btnVoltar = new JButton(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//setaPequenaRoxa.png"));
		btnVoltar.setContentAreaFilled(false); // Deixa a área de preenchimento transparente
		btnVoltar.setBorderPainted(false); // Remove a borda
		btnVoltar.setFocusPainted(false);
    	btnVoltar.setBounds(10, 650, 28,25);

		lp.add(lblCadastrarVideo, new Integer(9));
		lp.add(lblProdutor, new Integer(10));
		lp.add(txtProdutor, new Integer(11));
		lp.add(lblDataPublicacao, new Integer(12));
		lp.add(txtDataPublicacao, new Integer(13));
		lp.add(lblTitulo, new Integer(14));
		lp.add(txtTitulo, new Integer(15));
		lp.add(lblArquivoVideo, new Integer(16));
		lp.add(btnCadastrar, new Integer(17));
		lp.add(selecioneVideo, new Integer(18));
		lp.add(selecionaVideo, new Integer(19));
		lp.add(lblUPC, new Integer(20));
		lp.add(txtUPC, new Integer(21));
		lp.add(btnVoltar, new Integer(22));

		
		setLayout(new BorderLayout());
        add(lp, BorderLayout.CENTER);
        btnLivros.setBorderPainted(false);
        btnVideos.setBorderPainted(false);
        btnAssuntos.setBorderPainted(false);
        btnFlashcards.setBorderPainted(false);
        btnCronograma.setBorderPainted(false);
        btnCadastrar.setBorderPainted(false);
	}

	public void definirEventos(Olimpiada olimp, Professor prof) {
		
		txtFiltro.addKeyListener((KeyListener) new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				String tituloUPC = "%" + txtFiltro.getText() + "%";
				String numeros = tituloUPC.replaceAll("[^0-9]", "");
				boolean ehUPC= false;
				
				for (JLabel label : EspacoVideo) {
				    lp.remove(label); // Remove cada JLabel do JLayeredPane
				}
				for (JLabel label : espacoTitulo) {
				    lp.remove(label); // Remove cada JLabel do JLayeredPane
				}
		    	lp.repaint();
		    	
				if (numeros.length() == 12) {
					ehUPC=true;
			    } else {
			    	ehUPC=false;
			    }
		    	
		    	
			    if (ehUPC==true) {
			    	VideoCONTROLLER controller = new VideoCONTROLLER();
			        ArrayList<Video> lista = controller.consultarVideosPorUpc(numeros, olimp);
			        
			        int numeroResultados=lista.size();
			        JLabel[] EspacoLivroR;
			    	EspacoVideo = new JLabel[numeroResultados];
			    	int camadasEL = 30;
			    	int linhaEL = 80;
			    	int colunaEL = 200;
			    	int limite = 3;
			    	//
			    	JLabel[] espacoTituloR;
			    	espacoTitulo = new JLabel[numeroResultados];
			    	int camadas = 60;
			    	int linha = 80;
			    	int coluna = 350;
			    	
					//JLabels dos espaços para a capa;
					for(int i=0;i < numeroResultados; i++) {
						Video videoDaLista = lista.get(i);
						EspacoVideo[i] = new JLabel (videoDaLista.getTitulo());
						EspacoVideo[i].setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
						EspacoVideo[i].setHorizontalAlignment(SwingConstants.CENTER);
						EspacoVideo[i].setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
						EspacoVideo[i].setBackground(Color.WHITE);
						EspacoVideo[i].setForeground(Color.BLACK);
						if(i >= limite) {
							colunaEL = colunaEL+250;
							limite = limite + 3;
							linhaEL = 80;
						}
						EspacoVideo[i].setBounds(linhaEL,colunaEL,150,150);
						lp.add(EspacoVideo[i], new Integer(camadasEL));
						linhaEL= linhaEL+180;
						camadasEL++;
						
					}
					
					
					//JLabels dos espaços para titulos
					limite = 3;
					for(int i=0;i < numeroResultados; i++) {
						Video videoDaLista = lista.get(i);
						espacoTitulo[i] = new JLabel(videoDaLista.getUpc());
						espacoTitulo[i].setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
						espacoTitulo[i].setHorizontalAlignment(SwingConstants.CENTER);
						espacoTitulo[i].setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
						espacoTitulo[i].setBackground(Color.WHITE);
						espacoTitulo[i].setForeground(Color.BLACK);
						if(i >= limite) {
							coluna = colunaEL+150;
							limite = limite + 3;
							linha = 80;
						}
						espacoTitulo[i].setBounds(linha,coluna,150,40);
						lp.add(espacoTitulo[i], new Integer(camadas));
						linha= linha+180;
						camadas++;
					}
					
			    } else if(isInteger(tituloUPC)==false){
			    	VideoCONTROLLER controller = new VideoCONTROLLER();
			        ArrayList<Video> lista = controller.consultarVideosPorNome(tituloUPC, olimp);

			        int numeroResultados=lista.size();
			        JLabel[] EspacoLivroR;
			    	EspacoVideo = new JLabel[numeroResultados];
			    	int camadasEL = 30;
			    	int linhaEL = 80;
			    	int colunaEL = 200;
			    	int limite = 3;
			    	//
			    	JLabel[] espacoTituloR;
			    	espacoTitulo = new JLabel[numeroResultados];
			    	int camadas = 60;
			    	int linha = 80;
			    	int coluna = 350;
			    	
					//JLabels dos espaços para a capa;
					for(int i=0;i < numeroResultados; i++) {
						Video videoDaLista = lista.get(i);
						EspacoVideo[i] = new JLabel (videoDaLista.getTitulo());
						EspacoVideo[i].setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
						EspacoVideo[i].setHorizontalAlignment(SwingConstants.CENTER);
						EspacoVideo[i].setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
						EspacoVideo[i].setBackground(Color.WHITE);
						EspacoVideo[i].setForeground(Color.BLACK);
						if(i >= limite) {
							colunaEL = colunaEL+250;
							limite = limite + 3;
							linhaEL = 80;
						}
						EspacoVideo[i].setBounds(linhaEL,colunaEL,150,150);
						lp.add(EspacoVideo[i], new Integer(camadasEL));
						linhaEL= linhaEL+180;
						camadasEL++;
						
					}
					
					
					//JLabels dos espaços para titulos
					limite = 3;
					for(int i=0;i < numeroResultados; i++) {
						Video videoDaLista = lista.get(i);
						espacoTitulo[i] = new JLabel(videoDaLista.getUpc());
						espacoTitulo[i].setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
						espacoTitulo[i].setHorizontalAlignment(SwingConstants.CENTER);
						espacoTitulo[i].setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
						espacoTitulo[i].setBackground(Color.WHITE);
						espacoTitulo[i].setForeground(Color.BLACK);
						if(i >= limite) {
							coluna = colunaEL+150;
							limite = limite + 3;
							linha = 80;
						}
						espacoTitulo[i].setBounds(linha,coluna,150,40);
						lp.add(espacoTitulo[i], new Integer(camadas));
						linha= linha+180;
						camadas++;
					}
			    }
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});
		
		selecioneVideo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selecioneVideo.setText(null);
				 int returnValue = selecionaVideo.showOpenDialog(null);

	                if (returnValue == JFileChooser.APPROVE_OPTION) {
	                	  File selectedFile = selecionaVideo.getSelectedFile();
	                	  
	                	  if(selectedFile == null) {
	                		  //se nada for selecionado, continua na mesma
	                	  }else {
	                		 String fileName = selectedFile.getName();
	  	  		            JOptionPane.showMessageDialog(null, "Arquivo selecionado: " + selecionaVideo.getSelectedFile().getName());
	  	  		        selecioneVideo.setText(fileName);
	                	  }
	  		            
	                }
			}
		});
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String upc = String.valueOf(txtUPC.getText());
				String produtor= String.valueOf(txtProdutor.getText());
	            String titulo = String.valueOf(txtTitulo.getText());
	            String emailProf= prof.getEmail();
	            
	            String data = String.valueOf(txtDataPublicacao.getText());
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define o formato da data
	            LocalDate localDate = LocalDate.parse(data, formatter);
	            Date dataPublicacao = java.sql.Date.valueOf(localDate);
	            
				File selectedFile = selecionaVideo.getSelectedFile();
				if(txtUPC.getText().isEmpty()&&txtTitulo.getText().isEmpty()
                  		&&txtProdutor.getText().isEmpty()&&txtTitulo.getText().isEmpty()
                  		&&txtDataPublicacao.getText().isEmpty()&&selecioneVideo.getText().isEmpty()
                  		||selectedFile == null&&selecioneVideo.getText().equals("Selecione o arquivo de vídeo:")) {
	            	
	            	JOptionPane.showMessageDialog(null, "Não é possível cadastrar um vídeo sem os dados!");
	            	
	            }else if(txtUPC.getText().isEmpty()&&txtTitulo.getText().isEmpty()
                  		&&txtProdutor.getText().isEmpty()&&txtTitulo.getText().isEmpty()
                  		&&txtDataPublicacao.getText().isEmpty()) {
                  	
                  	JOptionPane.showMessageDialog(null, "Há campos Vazios! Não é possível cadastar o"
                  	+" livro sem todos os dados!");
		             
				}else if(selectedFile == null&&selecioneVideo.getText().isEmpty()||selecioneVideo.getText().equals("Selecione o arquivo de vídeo:")) {
	             
					JOptionPane.showMessageDialog(null, "Selecione um arquivo de vídeo para realizar o cadastro!");
	             
                }else if(!(selectedFile.getName().toLowerCase().endsWith(".mp4") ||
                	      selectedFile.getName().toLowerCase().endsWith(".avi") ||
                	      selectedFile.getName().toLowerCase().endsWith(".mkv") ||
                	      selectedFile.getName().toLowerCase().endsWith(".mov"))){
             		
             		JOptionPane.showMessageDialog(null, "O arquivo selecionado não é um vídeo."
      		            +" Não é possível cadastrar vídeo!");
             	
                }else {
			        
			        // Chame o DAO para inserir o arquivo no banco de dados
					VideoCONTROLLER controla = new VideoCONTROLLER();
					boolean VideoCadastrou = controla.cadastrar(titulo, upc, produtor, dataPublicacao, emailProf,selectedFile, olimp);
					boolean RelacionouVideo= controla.relacionarComOlimp(olimp, upc);
					boolean Historico = controla.HistoricoVideosProf( emailProf, upc, titulo);
					
					if(VideoCadastrou==false&&RelacionouVideo==false){
						
						JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o vídeo!");
						
					}else if(VideoCadastrou==true&&RelacionouVideo==true&&Historico==true) { //cadastrou
						
						JOptionPane.showMessageDialog(null, "Vídeo cadastrado com sucesso!");
			            txtProdutor.setText(null);
			            txtTitulo.setText(null);
			            txtDataPublicacao.setText(null);  
			            txtUPC.setText(null);
			      		lblArquivoVideo.setText("Selecione o arquivo de vídeo:");
						lp.repaint();
					}
                }
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
				TelaLivrosProf livro = new TelaLivrosProf(olimp, prof);
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
				//TelaAssuntosProf video = new TelaAssuntosProf(olimp, prof);
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
				TelaFlashcardsProf assuntos = new TelaFlashcardsProf(olimp, prof);
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
					TelaInicialProf tela = new TelaInicialProf(prof, true);
				     setVisible(false);
				}
			});
	}
	
	public static boolean isInteger(String input) {
	    try {
	        Integer.parseInt(input);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
		
}