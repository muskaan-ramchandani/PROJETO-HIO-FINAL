package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import vo.Aluno;
import controller.AlunoCONTROLLER;

import conexaoBD.Conexao;

import javax.swing.*;

public class TelaCadastroAluno extends JFrame {
	private JLabel lblBemVindo;
	private JLabel lblMsg;
	private Container contentPane;
	private JLayeredPane lp;
	private JPanel panelRoxo;
	private JPanel panelBranco;
	private JLabel lblFundo2;
	private JLabel lblFundo;
	private JLabel lblNomeCompleto;
	private JLabel lblNomeUsuario;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JLabel lblConfirmeSenha;
	private JLabel lblInsiraDados;
	private JTextField txtNomeCompleto;
	private JTextField txtNomeUsuario;
	private JTextField txtEmail;
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmaSenha;
	private JButton btnFinalizarCadastro;
	private JLabel lblImagem;
	
	public TelaCadastroAluno() {
		inicializarComp();
		definirEventos();
	}
	
	public void inicializarComp() {
		setLayout(null);
		setTitle("Cadastro do Aluno");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height-40);
		contentPane=getContentPane();
        contentPane.setBackground(Color.black);
        		
		lp = new JLayeredPane();
		panelRoxo = new JPanel();
		panelBranco= new JPanel();
		
		Color roxoEscuro=new Color(75,0,130);
		panelBranco.setBackground(Color.WHITE);
		panelRoxo.setBackground(roxoEscuro);
		
		
		//caixas de texto
		txtNomeCompleto = new JTextField(200);
		txtNomeUsuario = new JTextField(64);
		txtEmail = new JTextField(256);
		pfSenha = new JPasswordField(100);
		pfConfirmaSenha = new JPasswordField(100);
		
		//JLabels
		lblInsiraDados = new JLabel("Insira seus dados");
		lblNomeCompleto = new JLabel("Nome completo:");
		lblNomeUsuario = new JLabel("Nome de usuário:");
		lblEmail = new JLabel("Email:");
		lblSenha = new JLabel("Senha:");
		lblConfirmeSenha = new JLabel("Confirme sua senha:");
		lblBemVindo =new JLabel("Seja bem vindo!");
		lblMsg = new JLabel("Finalize seu cadastro e desfrute de nossa aplicação.");
		
		//Botão
		btnFinalizarCadastro = new JButton("Finalizar cadastro");	
			
		String nomeImagem ="bonequinhoSF";
		lblImagem = new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//"+nomeImagem+".png"));
		String nomeFundo = "fundoTela";
		lblFundo = new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//"+nomeFundo+".png"));
		String fundo2 = "fundo2Tela";
		lblFundo2 =new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//"+fundo2+".png"));
		
		btnFinalizarCadastro.setBackground(roxoEscuro);
		btnFinalizarCadastro.setForeground(Color.white);
		
		Font fonteLabelsDesc = new Font( "Trebuchet MS", Font.PLAIN, 20);
		lblNomeCompleto.setFont(fonteLabelsDesc);
		lblNomeUsuario.setFont(fonteLabelsDesc);
		lblEmail.setFont(fonteLabelsDesc);
		lblSenha.setFont(fonteLabelsDesc);
		lblConfirmeSenha.setFont(fonteLabelsDesc);	

		
		Font fonteTamanho = new Font( "Trebuchet MS", Font.PLAIN, 45);
		lblInsiraDados.setFont(fonteTamanho);
	    
	    Font fonteTamanhoBotao = new Font( "Trebuchet MS", Font.PLAIN, 20);
	    btnFinalizarCadastro.setFont(fonteTamanhoBotao);
	    
	    lblBemVindo.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	    lblBemVindo.setForeground(Color.WHITE);
	    
	    lblMsg.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
	    lblMsg.setForeground(Color.WHITE);
		
	    //caixas de texto e jlabels
		lblInsiraDados.setBounds(252,55,800,100);

		lblNomeCompleto.setBounds(205,150,400,30);
		txtNomeCompleto.setBounds(205,190,425,30);

		lblNomeUsuario.setBounds(205,240,400,40);
		txtNomeUsuario.setBounds(205,280,425,30);

		lblEmail.setBounds(205,330,400,40);
		txtEmail.setBounds(205,370,425,30);

		lblSenha.setBounds(205,420,400,40);
		pfSenha.setBounds(205,460,425,30);
		
		lblConfirmeSenha.setBounds(205,510,400,40);
		pfConfirmaSenha.setBounds(205,550,425,30);
		
	
        lblImagem.setBounds((screenSize.width/2)-35,50, 550,screenSize.height-45);
        lblBemVindo.setBounds((screenSize.width/2)+110,100, 450, 200);
        lblMsg.setBounds((screenSize.width/2)+70, 140, 500, 200);
		lblFundo.setBounds(0, 0, screenSize.width, screenSize.height-40);
		lblFundo2.setBounds(680,60, (screenSize.width/2)-205, screenSize.height-190);

        
		//JButton
		btnFinalizarCadastro.setBounds(285,590,245,45);
		
		//panels
		panelRoxo.setBounds(680,60, (screenSize.width/2)-205, screenSize.height-190);
		panelBranco.setBounds(155, 60, screenSize.width-520, screenSize.height-190);

		
		contentPane.add(lp);
		lp.add(lblFundo, new Integer(1));
		lp.add(panelBranco, new Integer(2));
		lp.add(panelRoxo, new Integer(3));
		lp.add(lblFundo2, new Integer(4));
		lp.add(lblImagem, new Integer(5));
		
		//caixas de text
		lp.add(txtNomeCompleto, new Integer(6));
		lp.add(txtNomeUsuario, new Integer(7));
		lp.add(txtEmail, new Integer(8));
		lp.add(pfSenha, new Integer(9));
		lp.add(pfConfirmaSenha, new Integer(10));
		
		//Jlabels
		lp.add(lblInsiraDados, new Integer(11));
		lp.add(lblNomeCompleto, new Integer(12));
		lp.add(lblNomeUsuario, new Integer(13));
		lp.add(lblEmail, new Integer(14));
		lp.add(lblSenha, new Integer(15));
		lp.add(lblConfirmeSenha, new Integer(16));
		lp.add(lblBemVindo, new Integer(18));
		lp.add(lblMsg, new Integer(19));
		
		//Jbutton
		lp.add(btnFinalizarCadastro, new Integer(17));
		
		setLayout(new BorderLayout());
        add(lp, BorderLayout.CENTER);
        
		
        setVisible(true);
	}
	
	private void definirEventos() {
		 btnFinalizarCadastro.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String senha;
					String confirma;
					boolean retorna=false;
					
					while(retorna==false){
						senha = String.valueOf(pfSenha.getPassword());
						confirma = String.valueOf(pfConfirmaSenha.getPassword());
						
							if(senha.equals(confirma)){
								String nomeCompleto = txtNomeCompleto.getText();
								String nomeUsuario = txtNomeUsuario.getText();
								String email = txtEmail.getText();
								
								AlunoCONTROLLER controla = new AlunoCONTROLLER();
								controla.cadastrar(nomeCompleto, nomeUsuario, email, senha);
								JOptionPane.showMessageDialog(null, "Cadastro finalizado com sucesso!");
								
								Aluno aluno = new Aluno(nomeCompleto, nomeUsuario, email, senha);
								TelaOlimpiadas telaOlimp=new TelaOlimpiadas(aluno, false);
							     setVisible(false);
								retorna=true;
								
							}else{
									JOptionPane.showMessageDialog(null, "Valor inserido em 'Confirma Senha' é diferente"
											+" do valor de 'Senha'! \nDigite novamente!");
									pfConfirmaSenha.setText(null);
									confirma = String.valueOf(pfConfirmaSenha.getPassword());
									retorna=false;
									return;
							}

						}					
				
				}
				 
		 });
	}
	
}