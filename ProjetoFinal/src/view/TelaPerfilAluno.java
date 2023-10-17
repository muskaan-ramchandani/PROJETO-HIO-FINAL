package view;
import vo.Aluno;
import controller.AlunoCONTROLLER;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaPerfilAluno extends JFrame{
	private Container contentPane;
	private JLayeredPane lp;
	private JLabel lblLogo;
	private JLabel lblIconePerfil;
	private JLabel lblSeta;
	private JLabel lblDuvida;
	private JLabel lblComp;
	private JLabel lblPorta;
	private JLabel lblEngrenagem;
	private JLabel lblUser;
	private JButton btnPincel;
	private JButton btnMeusDados;
	private JButton btnComoFunciona;
	private JButton btnSuporte;
	private JButton btnSair;
	private JButton btnVoltar;
	private JMenuBar barra;
	private JLabel lblPerfilAluno;
	
	public TelaPerfilAluno (Aluno aluno){
		inicializarComponentes(aluno);
	    definirEventos(aluno);
	}

	private void inicializarComponentes(Aluno aluno) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height-40);
		contentPane=getContentPane();
        contentPane.setBackground(Color.white);
		
		//inicializar componentes
		contentPane =  new Container();
		lp  = new JLayeredPane ();
		barra=new JMenuBar();
		
		lblPerfilAluno= new JLabel("Perfil do Aluno");
		btnMeusDados  = new JButton("Meus dados");
		btnComoFunciona  = new JButton ("Como funciona");
		btnSuporte  = new JButton ("Suporte");
		btnSair  = new JButton ("Sair");
		btnVoltar  = new JButton("Voltar");
		lblUser  = new JLabel (aluno.getNomeUsuario());
		
		lblLogo  = new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//bonequinhoSFMEDIO.png"));
		
		lblIconePerfil = new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//iconePerfilRoxo.png"));
		
		
		lblDuvida  = new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//pessoaduvidaPequena.png"));
		
		lblComp  = new JLabel (new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//computadorPequeno.png"));
		
		lblPorta  = new JLabel (new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//portaSaidaPequena.png"));
		
		lblEngrenagem  = new JLabel (new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//engrenagemPequena.png"));
				
		
		lblSeta  = new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//setaVoltarPequena.png"));
		
		btnPincel = new JButton(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//lapisPequeno.png"));
		btnPincel.setContentAreaFilled(false); // Deixa a área de preenchimento transparente
        btnPincel.setBorderPainted(false); // Remove a borda
        btnPincel.setFocusPainted(false);
		
		//cores
		Color roxoEscuro= new Color(75, 0, 130);
		
		barra.setBackground(roxoEscuro);
		lblPerfilAluno.setForeground(Color.WHITE);
		lblUser.setForeground(Color.black);
		btnMeusDados.setForeground(Color.WHITE);
		btnMeusDados.setBackground(roxoEscuro);
		btnComoFunciona.setForeground(Color.white);
		btnComoFunciona.setBackground(roxoEscuro);
		btnSuporte.setForeground(Color.WHITE);
		btnSair.setForeground(Color.WHITE);
		btnSuporte.setBackground(roxoEscuro);
		btnSair.setBackground(roxoEscuro);
		btnVoltar.setBackground(roxoEscuro);
		btnVoltar.setForeground(Color.WHITE);
		
		
		//formatações de texto
		lblPerfilAluno.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblUser.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		
		Font fonteBotoes = new Font("Trebuchet MS", Font.BOLD, 35);
		btnComoFunciona.setFont(fonteBotoes);
		btnMeusDados.setFont(fonteBotoes);
		btnSuporte.setFont(fonteBotoes);
		btnSair.setFont(fonteBotoes);
		
		btnVoltar.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		
		//coordenadas
        lp.setBounds(0, 0, screenSize.width, screenSize.height-40);
        barra.setBounds(0,0,screenSize.width, 50);
        lblLogo.setBounds(10,5,44, 35);
        lblPerfilAluno.setBounds(80, 15, 150, 20);
        lblIconePerfil.setBounds(100, 200, 298, 300);
        lblUser.setBounds(205, 160, 200, 30);
        btnPincel.setBounds(285, 165,20,20);
        btnMeusDados.setBounds(700, 200, 550, 50);
        lblEngrenagem.setBounds(710, 205, 40, 40);
        btnComoFunciona.setBounds(700, 280, 550, 50);
        lblDuvida.setBounds( 710, 285,32, 40);
        btnSuporte.setBounds(700, 360, 550, 50);
        lblComp.setBounds(710, 365, 49, 40);
		btnSair.setBounds(700, 440, 550, 50);
		lblPorta.setBounds(715, 445, 35, 40);
		btnVoltar.setBounds(0, 650, 150, 35);
		lblSeta.setBounds(10, 655, 28, 25);
		
		//adiciona
		contentPane.add(lp);
		
		lp.add(barra, new Integer(1));
		lp.add(lblLogo, new Integer(2));
		lp.add(lblPerfilAluno, new Integer(3));
		lp.add(lblIconePerfil, new Integer(4));
		lp.add(lblUser, new Integer(5));
		lp.add(btnComoFunciona, new Integer(6));
		lp.add(btnMeusDados, new Integer(7));
		lp.add(btnSuporte, new Integer(8));
		lp.add(btnSair, new Integer(9));
		lp.add(btnVoltar, new Integer(10));
		lp.add(btnPincel, new Integer(11));
		lp.add(lblEngrenagem, new Integer(12));
		lp.add(lblDuvida, new Integer(13));
		lp.add(lblComp, new Integer(14));
		lp.add(lblPorta, new Integer(15));
		lp.add(lblSeta, new Integer(16));
		
		setLayout(new BorderLayout());
        add(lp, BorderLayout.CENTER);
        btnComoFunciona.setBorderPainted(false);
        btnMeusDados.setBorderPainted(false);
        btnSuporte.setBorderPainted(false);
        btnSair.setBorderPainted(false);
        btnVoltar.setBorderPainted(false);
		
		setVisible(true);
	}
	
	private void definirEventos(Aluno aluno) {
		btnPincel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = aluno.getEmail();
				TelaAlteraUserAluno tela = new TelaAlteraUserAluno(aluno, email);
		        tela.setLocationRelativeTo(null);

			}
		});
		
		btnMeusDados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = aluno.getEmail();
				TelaAlteraDadosAluno tela = new TelaAlteraDadosAluno(aluno, email);
		        tela.setLocationRelativeTo(null);
			}
		});
		
		btnComoFunciona.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnSuporte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = aluno.getEmail();
				TelaDeletaContaAluno tela = new TelaDeletaContaAluno(aluno, email);
		        tela.setLocationRelativeTo(null);
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