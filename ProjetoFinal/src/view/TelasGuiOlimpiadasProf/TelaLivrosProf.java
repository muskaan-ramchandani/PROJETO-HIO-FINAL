package view.TelasGuiOlimpiadasProf;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.time.LocalDate;
import org.w3c.dom.events.MouseEvent;
import vo.Professor;
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

import controller.LivroCONTROLLER;
import controller.OlimpiadaCONTROLLER;
import dao.LivroDAO;
import view.TelaInicialProf;
import vo.Livro;
import vo.Olimpiada;

public class TelaLivrosProf extends JFrame{
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
	
	private JLabel lblCadastrarLivro;
	private JLabel lblIsbn;
	private JTextField txtIsbn;
	private JLabel lblTitulo;
	private JTextField txtTitulo;
	private JLabel lblEditora;
	private JTextField txtEditora;
	private JLabel lblAutor;
	private JTextField txtAutor;
	private JLabel lblDataPublicacao;
	private JFormattedTextField txtDataPublicacao;
	private JLabel lblArquivoPDF;
	private JButton selecionePDF;
	private JFileChooser selecionaPDF;
	private JButton btnCadastrar;
    private JTextField txtFiltro;
    private JLabel lblFiltro;
    private JLabel lblPesquisar;
    
    ArrayList<Livro> livrosDaOlimpiada = new ArrayList<Livro>();
	JLabel[] EspacoLivro;
	JLabel[] espacoTitulo;

    private Color roxoIndigo = new Color(75,0,130);
	
	public TelaLivrosProf(Olimpiada olimp, Professor prof) {
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
        
      //Tela dos livros configurações
        LivroCONTROLLER controla = new LivroCONTROLLER();
        livrosDaOlimpiada= controla.retornaLivroOlimpiada(olimp);
    	
    	int numeroLabels = livrosDaOlimpiada.size();
    	

    	EspacoLivro = new JLabel[numeroLabels];
    	int camadasEL = 30;
    	int linhaEL = 80;
    	int colunaEL = 200;
    	int limite = 3;
    	//
    	espacoTitulo = new JLabel[numeroLabels];
    	int camadas = 60;
    	int linha = 80;
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
		selecionePDF= new JButton("Clique e escolha um arquivo pdf");
		txtFiltro = new JTextField(300);
		lblFiltro= new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//funilPequeno.png"));
	    lblPesquisar= new JLabel("Procurar por título");
		
		//cores		
		barra.setBackground(roxoIndigo);
		lblNomeOlimp.setBackground(roxoIndigo);
		lblNomeOlimp.setForeground(Color.WHITE);
		btnVideos.setBackground(roxoIndigo);
		btnVideos.setForeground(Color.WHITE);
		btnAssuntos.setBackground(roxoIndigo);
		btnAssuntos.setForeground(Color.WHITE);
		btnFlashcards.setBackground(roxoIndigo);
		btnFlashcards.setForeground(Color.WHITE);
		btnCronograma.setBackground(roxoIndigo);
		btnCronograma.setForeground(Color.WHITE);
		selecionePDF.setBackground(Color.white);
		selecionePDF.setForeground(Color.black);
		Color roxoVioleta = new Color(148,0,211);
		btnLivros.setBackground(roxoVioleta);
		btnLivros.setForeground(Color.WHITE);
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
		lblPesquisar.setBounds(108, 110, 490, 35);
	    
		if(numeroLabels==0) {
			JLabel lblNaoTem = new JLabel("<html>Não há livros cadastrados<br>      nesta olimpíada<html>");
			lblNaoTem.setForeground(Color.BLACK);
			lblNaoTem.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
			lblNaoTem.setBounds(100, 350, 1000, 70);
			lp.add(lblNaoTem, new Integer(30));
		}else {
	    	
			//JLabels dos espaços para a capa;
			for(int i=0;i < numeroLabels; i++) {
				Livro livroDaLista = livrosDaOlimpiada.get(i);
				EspacoLivro[i] = new JLabel (livroDaLista.getTitulo());
				EspacoLivro[i].setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
				EspacoLivro[i].setHorizontalAlignment(SwingConstants.CENTER);
				EspacoLivro[i].setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
				EspacoLivro[i].setBackground(Color.WHITE);
				EspacoLivro[i].setForeground(Color.BLACK);
				if(i >= limite) {
					colunaEL = colunaEL+250;
					limite = limite + 3;
					linhaEL = 80;
				}
				EspacoLivro[i].setBounds(linhaEL,colunaEL,150,150);
				lp.add(EspacoLivro[i], new Integer(camadasEL));
				linhaEL= linhaEL+180;
				camadasEL++;
				
			}
			
			
			//JLabels dos espaços para titulos
			limite = 3;
			for(int i=0;i < numeroLabels; i++) {
				Livro livroDaLista = livrosDaOlimpiada.get(i);
				espacoTitulo[i] = new JLabel(livroDaLista.getIsbn());
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
		lp.add(btnVoltar, new Integer(27));
		
		
		 // Primeira área (sem JScrollPane) CADASTRO
  		lblCadastrarLivro = new JLabel("Cadastrar Livro");
  		lblIsbn= new JLabel("Isbn:");
  		txtIsbn = new JTextField(13);
  		lblTitulo= new JLabel("Título:");
  		txtTitulo = new JTextField(100);
  		lblEditora= new JLabel("Editora:");
  		txtEditora = new JTextField(60);
  		lblAutor= new JLabel("Autor:");
  		txtAutor = new JTextField(200);
  		lblDataPublicacao= new JLabel("Data de publicação:");
  		txtDataPublicacao = new JFormattedTextField();
  		
  		 try {
 			txtDataPublicacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
             txtDataPublicacao.setHorizontalAlignment(JFormattedTextField.CENTER);
   		} catch (ParseException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
  	
  		lblArquivoPDF= new JLabel("Selecione o arquivo pdf:");
  		btnCadastrar= new JButton("Cadastrar");

  		selecionaPDF= new JFileChooser();
  		FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files", "pdf");
  		selecionaPDF.setFileFilter(filter);
  		selecionaPDF.setDialogTitle("Selecione um arquivo PDF");
    
  		btnCadastrar.setForeground(Color.white);
  		btnCadastrar.setBackground(roxoIndigo);
  		
  		Font fonteLabelsDesc = new Font( "Trebuchet MS", Font.PLAIN, 20);
  		lblIsbn.setFont(fonteLabelsDesc);
  		lblTitulo.setFont(fonteLabelsDesc);
  		lblEditora.setFont(fonteLabelsDesc);
  		lblAutor.setFont(fonteLabelsDesc);
  		lblDataPublicacao.setFont(fonteLabelsDesc);
  		lblArquivoPDF.setFont(fonteLabelsDesc);	
		
  		Font fonteTXT = new Font( "Trebuchet MS", Font.PLAIN, 18);;
  		txtIsbn.setFont(fonteTXT);
  		txtTitulo.setFont(fonteTXT);
  		txtEditora.setFont(fonteTXT);
  		txtAutor.setFont(fonteTXT);
  		txtDataPublicacao.setFont(fonteTXT);
  		selecionaPDF.setFont(fonteTXT);
  		selecionePDF.setFont(fonteTXT);
  		
		Font fonteTamanho = new Font( "Trebuchet MS", Font.PLAIN, 45);
		lblCadastrarLivro.setFont(fonteTamanho);
	    
	    Font fonteTamanhoBotao = new Font( "Trebuchet MS", Font.PLAIN, 20);
	    btnCadastrar.setFont(fonteTamanhoBotao);
	    
	    lblCadastrarLivro.setBounds(870,70,800,100);
	    lblIsbn.setBounds(800,165,200,30);
		txtIsbn.setBounds(800,205,212,30); //espaço de 40
		lblDataPublicacao.setBounds(1062, 165, 200, 30);
		txtDataPublicacao.setBounds(1062, 205, 200, 30);
		lblTitulo.setBounds(800,240,400,40);
		txtTitulo.setBounds(800,280,465,30); //diferença de 35
		lblEditora.setBounds(800,315,400,40);
		txtEditora.setBounds(800,355,465,30);
		lblAutor.setBounds(800,395,400,40);
		txtAutor.setBounds(800,430,465,30);
		lblArquivoPDF.setBounds(800,470,400,40);
		selecionePDF.setBounds(800, 505, 465, 30);
		btnCadastrar.setBounds(915, 590, 245, 45);
	    

		lp.add(lblCadastrarLivro, new Integer(9));
		lp.add(lblIsbn, new Integer(10));
		lp.add(txtIsbn, new Integer(11));
		lp.add(lblDataPublicacao, new Integer(12));
		lp.add(txtDataPublicacao, new Integer(13));
		lp.add(lblTitulo, new Integer(14));
		lp.add(txtTitulo, new Integer(15));
		lp.add(lblEditora, new Integer(16));
		lp.add(txtEditora, new Integer(17));
		lp.add(lblAutor, new Integer(18));
		lp.add(txtAutor, new Integer(19));
		lp.add(lblArquivoPDF, new Integer(20));
		lp.add(btnCadastrar, new Integer(22));
		lp.add(selecionePDF, new Integer(23));
		lp.add(selecionaPDF, new Integer(21));

		
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
				String tituloIsbn = "%" + txtFiltro.getText() + "%";
				String numeros = tituloIsbn.replaceAll("[^0-9]", "");
				boolean ehIsbn= false;
				
				for (JLabel label : EspacoLivro) {
				    lp.remove(label); // Remove cada JLabel do JLayeredPane
				}
				for (JLabel label : espacoTitulo) {
				    lp.remove(label); // Remove cada JLabel do JLayeredPane
				}
		    	lp.repaint();
		    	
				if (numeros.length() == 13) {
					ehIsbn=true;
			    } else {
			    	ehIsbn=false;
			    }
		    	
		    	
			    if (ehIsbn==true) {
			        LivroCONTROLLER controller = new LivroCONTROLLER();
			        ArrayList<Livro> lista = controller.consultarLivrosPorIsbn(numeros, olimp);
			        
			        int numeroResultados=lista.size();
			        JLabel[] EspacoLivroR;
			    	EspacoLivro = new JLabel[numeroResultados];
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
						Livro livroDaLista = lista.get(i);
						EspacoLivro[i] = new JLabel (livroDaLista.getTitulo());
						EspacoLivro[i].setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
						EspacoLivro[i].setHorizontalAlignment(SwingConstants.CENTER);
						EspacoLivro[i].setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
						EspacoLivro[i].setBackground(Color.WHITE);
						EspacoLivro[i].setForeground(Color.BLACK);
						if(i >= limite) {
							colunaEL = colunaEL+250;
							limite = limite + 3;
							linhaEL = 80;
						}
						EspacoLivro[i].setBounds(linhaEL,colunaEL,150,150);
						lp.add(EspacoLivro[i], new Integer(camadasEL));
						linhaEL= linhaEL+180;
						camadasEL++;
						
					}
					
					
					//JLabels dos espaços para titulos
					limite = 3;
					for(int i=0;i < numeroResultados; i++) {
						Livro livroDaLista = lista.get(i);
						espacoTitulo[i] = new JLabel(livroDaLista.getIsbn());
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
					
			    } else if(isInteger(tituloIsbn)==false){
			        LivroCONTROLLER controller = new LivroCONTROLLER();
			        ArrayList<Livro> lista = controller.consultarLivrosPorNome(tituloIsbn, olimp);

			        int numeroResultados=lista.size();
			        JLabel[] EspacoLivroR;
			    	EspacoLivro = new JLabel[numeroResultados];
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
						Livro livroDaLista = lista.get(i);
						EspacoLivro[i] = new JLabel (livroDaLista.getTitulo());
						EspacoLivro[i].setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
						EspacoLivro[i].setHorizontalAlignment(SwingConstants.CENTER);
						EspacoLivro[i].setBorder(javax.swing.BorderFactory.createLineBorder(new Color(75,0,130), 3));
						EspacoLivro[i].setBackground(Color.WHITE);
						EspacoLivro[i].setForeground(Color.BLACK);
						if(i >= limite) {
							colunaEL = colunaEL+250;
							limite = limite + 3;
							linhaEL = 80;
						}
						EspacoLivro[i].setBounds(linhaEL,colunaEL,150,150);
						lp.add(EspacoLivro[i], new Integer(camadasEL));
						linhaEL= linhaEL+180;
						camadasEL++;
						
					}
					
					
					//JLabels dos espaços para titulos
					limite = 3;
					for(int i=0;i < numeroResultados; i++) {
						Livro livroDaLista = lista.get(i);
						espacoTitulo[i] = new JLabel(livroDaLista.getIsbn());
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

		selecionePDF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selecionePDF.setText(null);
				 int returnValue = selecionaPDF.showOpenDialog(null);

	                if (returnValue == JFileChooser.APPROVE_OPTION) {
	                	  File selectedFile = selecionaPDF.getSelectedFile();
	                	  
	                	  if(selectedFile == null) {
	                		  //se nada for selecionado, continua na mesma
	                	  }else {
	                		 String fileName = selectedFile.getName();
	  	  		            JOptionPane.showMessageDialog(null, "Arquivo selecionado: " + selecionaPDF.getSelectedFile().getName());
	  	    				selecionePDF.setText(fileName);
	                	  }
	  		            
	                }
			}
		});
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String isbn= String.valueOf(txtIsbn.getText());
	            String titulo = String.valueOf(txtTitulo.getText());
	            String editora= String.valueOf(txtEditora.getText());
	            String autor = String.valueOf(txtAutor.getText());
	            String emailProf= prof.getEmail();
	            
	            String data = String.valueOf(txtDataPublicacao.getText());
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define o formato da data
	            LocalDate localDate = LocalDate.parse(data, formatter);
	            Date dataPublicacao = java.sql.Date.valueOf(localDate);	
	            
				File selectedFile = selecionaPDF.getSelectedFile();
				
	            
	            if(txtIsbn.getText().isEmpty()&&txtTitulo.getText().isEmpty()
                  		&&txtEditora.getText().isEmpty()&&txtAutor.getText().isEmpty()
                  		&&txtDataPublicacao.getText().isEmpty()&&selecionePDF.getText().isEmpty()
                  		||selectedFile == null&&selecionePDF.getText().equals("Selecione um arquivo PDF")) {
	            	
	            	JOptionPane.showMessageDialog(null, "Não é possível cadastrar um livro sem os dados!");
	            	
	            }else if(txtIsbn.getText().isEmpty()||txtTitulo.getText().isEmpty()
                  		||txtEditora.getText().isEmpty()||txtAutor.getText().isEmpty()
                  		||txtDataPublicacao.getText().isEmpty()) {
                  	
                  	JOptionPane.showMessageDialog(null, "Há campos Vazios! Não é possível cadastar o"
                  	+" livro sem todos os dados!");
		             
				}else if(selectedFile == null&&selecionePDF.getText().isEmpty()||selecionePDF.getText().equals("Selecione um arquivo PDF")) {
	             
					JOptionPane.showMessageDialog(null, "Selecione um arquivo pdf para que o livro seja cadastrado!");
	             
                }else if(!selectedFile.getName().toLowerCase().endsWith(".pdf")){
                 		
                 		JOptionPane.showMessageDialog(null, "O arquivo selecionado não é um PDF."
          		            +" Não é possível cadastrar livro!");
                }else {
			        
			        // Chame o DAO para inserir o arquivo no banco de dados
					LivroCONTROLLER controla = new LivroCONTROLLER();
					boolean LivroCadastrou = controla.cadastrar(isbn, titulo, editora, autor, dataPublicacao, emailProf, selectedFile, olimp);
					boolean RelacionouLivro= controla.relacionarComOlimp(olimp, isbn);
					boolean Historico = controla.HistoricoLivrosProf(emailProf, isbn, titulo);
					
					if(LivroCadastrou==false&&RelacionouLivro==false){
						
						JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o livro!");
						
					}else if(LivroCadastrou==true&&RelacionouLivro==true&&Historico==true) { //cadastrou
						
						JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
						txtIsbn.setText(null);
						txtTitulo.setText(null);
						txtEditora.setText(null);
						txtAutor.setText(null);
						txtDataPublicacao.setText(null);   
						lblArquivoPDF.setText("Selecione um arquivo PDF");
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
				TelaVideosProf video = new TelaVideosProf(olimp, prof);
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