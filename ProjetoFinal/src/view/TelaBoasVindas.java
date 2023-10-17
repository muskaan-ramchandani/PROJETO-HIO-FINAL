package view;
//package  
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.AlunoCONTROLLER;
import controller.ProfessorCONTROLLER;
import dao.AlunoDAO;
import vo.Aluno;
import vo.Professor;

public class TelaBoasVindas extends JFrame{
	private JLayeredPane lp;
	private JLabel lblBemVindo;
	private JLabel lblFacaLogin;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblSenha;
    private JPasswordField pfSenha;   
    private JLabel lblTipoUser;
    private JRadioButton rbAluno;
    private JRadioButton rbProfessor;
    private ButtonGroup buttonGroup;
	private JLabel lblMedalha;
	private JLabel lblLogo;
	private JLabel lblHIO;
	private JButton btnSobreNos;
	private JButton btnLogin;
	private JButton btnCadastreSe;
	private JPanel panelRoxo;
	private JLabel lblAplicacao;
	private JLabel lblEsteja;
	
	
    private Container contentPane;
	
	public TelaBoasVindas() {
		SplashScreen splashHIO = new SplashScreen(3000);
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
        //configuração da janela
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height-40);
        contentPane=getContentPane();
        contentPane.setBackground(Color.white);
        setLayout(null);
        
        
        //instancia componentes
        lp=new JLayeredPane();
        lblBemVindo = new JLabel("Bem vindo(a)");
        lblFacaLogin = new JLabel ("Faça login com sua conta");
        lblEmail = new JLabel ("Email:");
        txtEmail = new JTextField(254);
        lblSenha = new JLabel("Senha:");
        pfSenha = new JPasswordField (10);
        btnSobreNos = new JButton("Sobre nós");
        btnLogin = new JButton("Login");
        btnCadastreSe = new JButton("Cadastro");
        lblTipoUser= new JLabel("Tipo de usuário:");
        lblHIO = new JLabel("HIO");
        rbAluno = new JRadioButton("Aluno");
        rbProfessor = new JRadioButton("Professor");
        buttonGroup = new ButtonGroup();
        lblAplicacao = new JLabel("Aplicação de estudos para olimpíadas");
        lblEsteja = new JLabel("Esteja preparado para vencer!");
        panelRoxo= new JPanel();
    	Color roxoEscuro=new Color(75,0,130); //código da cor desejada

        lblMedalha = new JLabel(new ImageIcon("C:\\Users\\maria\\Downloads\\Imagens HIO\\medalha.png"));
        lblLogo = new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//bonequinhoSFCortado.png"));
		
	    //Configurações de fonte/cor
        panelRoxo.setBackground(roxoEscuro);
        btnSobreNos.setForeground(Color.WHITE);
        btnSobreNos.setBackground(roxoEscuro);
	    btnLogin.setBackground(Color.WHITE);
	    btnCadastreSe.setBackground(roxoEscuro);
	    btnLogin.setBackground(Color.white);
	    btnLogin.setForeground(roxoEscuro);
	    btnCadastreSe.setForeground(Color.white);
	    txtEmail.setBackground(new Color(57,0,103));
	    pfSenha.setBackground(new Color(57,0,103));
	    txtEmail.setForeground(Color.WHITE);
	    pfSenha.setForeground(Color.white);
	    lblEmail.setForeground(Color.WHITE);
	    lblSenha.setForeground(Color.WHITE);
	    lblTipoUser.setForeground(Color.WHITE);
	    rbAluno.setForeground(Color.WHITE);
	    rbProfessor.setForeground(Color.white);
	    rbAluno.setBackground(roxoEscuro);
	    rbProfessor.setBackground(roxoEscuro);
	    lblHIO.setForeground(roxoEscuro);
	    lblAplicacao.setForeground(new Color(153, 50, 204));
	    lblEsteja.setForeground(Color.BLACK);
	    lblBemVindo.setForeground(Color.WHITE);
	    lblFacaLogin.setForeground(Color.WHITE);
	    
	    Color escuro = new Color(57,0,103);
        txtEmail.setBorder(BorderFactory.createLineBorder(escuro, 1)); // Cria uma borda de 2 pixels de largura em preto
        pfSenha.setBorder(BorderFactory.createLineBorder(escuro, 1)); // Cria uma borda de 2 pixels de largura em preto

	    
	    Font fonteTamanhoBV = new Font( "Trebuchet MS", Font.PLAIN, 45);
        lblBemVindo.setFont(fonteTamanhoBV);
        
	    Font fonteTamanhoES = new Font( "Trebuchet MS", Font.PLAIN, 25);
	    lblEmail.setFont(fonteTamanhoES);
	    lblSenha.setFont(fonteTamanhoES);
	    lblTipoUser.setFont(fonteTamanhoES);


	    Font fonteTamanhoTP = new Font( "Trebuchet MS", Font.PLAIN, 20);
	    txtEmail.setFont(fonteTamanhoTP);
	    pfSenha.setFont(fonteTamanhoTP);
	    rbAluno.setFont(fonteTamanhoTP);
	    rbProfessor.setFont(fonteTamanhoTP);
	    
	    Font fonteTamanhoBotao = new Font( "Trebuchet MS", Font.PLAIN, 22);
	    btnLogin.setFont(fonteTamanhoBotao);
	    
	    btnCadastreSe.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
	    
	    btnSobreNos.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
	    
	    lblHIO.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
	    
	    lblAplicacao.setFont(new Font( "Trebuchet MS", Font.PLAIN, 25));
	    lblEsteja.setFont(new Font( "Trebuchet MS", Font.PLAIN, 23));
	    
        lblFacaLogin.setFont(new Font( "Trebuchet MS", Font.PLAIN, 20));

	    
        //Posições na tela
	    lp.setBounds(0, 0, screenSize.width, screenSize.height-40);
	    panelRoxo.setBounds(screenSize.width-600, 0,600, screenSize.height-40 );
	    
	    lblHIO.setBounds(15, 10, 50, 20);
        lblMedalha.setBounds(110, 40, 512, 512);
        lblAplicacao.setBounds(150,550,450,25);
	    lblEsteja.setBounds(200,580, 350,23);
	    btnSobreNos.setBounds(1223, 10, 123, 20);
	    btnCadastreSe.setBounds(1115,10,120,20);
	    lblLogo.setBounds(992, 40, 126, 100);
	    lblBemVindo.setBounds(930, 150, 450, 45);
	    lblFacaLogin.setBounds(945, 200, 450, 20);
	    lblEmail.setBounds(830, 265, 100, 25);
	    txtEmail.setBounds(830, 295, 453, 35);
	    lblSenha.setBounds(830, 370, 100, 25);
	    pfSenha.setBounds(830, 400, 453, 35);
	    lblTipoUser.setBounds(830, 475, 200, 25);
	    rbAluno.setBounds(830, 505, 100, 30);
	    rbProfessor.setBounds(1000, 505, 150, 30);
	    btnLogin.setBounds(1000, 590, 100, 35);
      
        
        //Adiciona componentes
	    buttonGroup.add(rbAluno);
        buttonGroup.add(rbProfessor);
        
        contentPane.add(lp);
        
        lp.add(panelRoxo, new Integer(1));
        lp.add(lblHIO, new Integer(2));
        lp.add(lblMedalha, new Integer(3));
        lp.add(lblAplicacao, new Integer(4));
        lp.add(lblEsteja, new Integer(5));
        lp.add(btnSobreNos, new Integer(6));
        lp.add(btnCadastreSe, new Integer(7));
        lp.add(lblLogo, new Integer(8));
        lp.add(lblBemVindo, new Integer(9));
        lp.add(lblFacaLogin, new Integer(10));
        lp.add(lblEmail, new Integer(11));
        lp.add(txtEmail, new Integer(12));
        lp.add(lblSenha, new Integer(13));
        lp.add(pfSenha, new Integer(14));
        lp.add(lblTipoUser, new Integer(15));
        lp.add(rbAluno, new Integer(16));
        lp.add(rbProfessor, new Integer(17));
        lp.add(btnLogin, new Integer(18));
        
        setLayout(new BorderLayout());
        add(lp, BorderLayout.CENTER);
        btnSobreNos.setBorderPainted(false);
        btnCadastreSe.setBorderPainted(false);
        btnLogin.setBorderPainted(false);
        
        setVisible(true);
	}
	
	private void definirEventos() {
		 btnSobreNos.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	TelaSobreNos telaSB= new TelaSobreNos();
				     setVisible(false);
	            }
	        });
		 
		 btnLogin.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 
				 boolean retorna=false;
				 
				 do{
					 if(rbAluno.isSelected()==true){

						 String email= txtEmail.getText();
						 String senha = String.valueOf(pfSenha.getPassword());						 
						 
						 AlunoCONTROLLER controla = new AlunoCONTROLLER();
						 boolean resposta=controla.consultar(email, senha);
						 
						 if(resposta==true) {
							 JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
							 
						      Aluno aluno = controla.obterAlunoExistente(email);
							 TelaInicialAluno telaInicialA = new TelaInicialAluno(aluno, true);
						     setVisible(false);
						 }else {
							 JOptionPane.showMessageDialog(null, "Login não realizado, por favor, tente novamente!");
						 }
						 retorna=true;
						 
					 }else if(rbProfessor.isSelected()==true){

						 String email= txtEmail.getText();
						 String senha = String.valueOf(pfSenha.getPassword());						 
						 
						 ProfessorCONTROLLER controla = new ProfessorCONTROLLER();
						 boolean resposta=controla.consultar(email, senha);
						 
						 if(resposta==true) {
							 JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
						       Professor prof = controla.obterProfExistente(email);
						       TelaInicialProf telaInicialP = new TelaInicialProf(prof, true);
						       setVisible(false);
						 }else {
							 JOptionPane.showMessageDialog(null, "Login não realizado, por favor, tente novamente!");
						 }
						 retorna=true;
						 
					 }else if(rbAluno.isSelected()==false && rbProfessor.isSelected()==false){
						 JOptionPane.showMessageDialog(null, "Selecione um tipo de usuário!");
						 retorna=false;
						 return;
					 }

				}while(retorna==false);
				
			 }
		 });

		 btnCadastreSe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaAlunoProfessor telaCad1= new TelaAlunoProfessor();
				telaCad1.setVisible(true);
			     setVisible(false);
			}
			 
		 });
	       
	}
}