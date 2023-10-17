package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import vo.Aluno;
import controller.AlunoCONTROLLER;

public class TelaAlteraDadosAluno extends JFrame{
	private Container contentPane;
	private JLayeredPane lp;
	private JLabel lblAlterarDados;
	private JLabel lblNomeCompleto;
	private JLabel lblNomeUser;
	private JLabel lblEmail;
	private JLabel lblRepitaSenha;
	private JPasswordField pfRepeteSenha;
	private JLabel lblAlteraSenha;
	private JPasswordField pfAlteraSenha;
	private JLabel lblAlteraNomeCompleto;
	private JTextField txtAlteraNomeCompleto; 
	private JButton btnAlterarNome;
	private JButton btnAlterarSenha;
	
	public TelaAlteraDadosAluno(Aluno aluno, String email) {
		inicializarComponentes(aluno);
		definirEventos(aluno, email);
	}

	private void inicializarComponentes(Aluno aluno) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(0, 0, 550, 585);
        contentPane=getContentPane();
        contentPane.setBackground(Color.WHITE);
        setLayout(null);
        
        //inicializa
        lp= new JLayeredPane();
        lblAlterarDados= new JLabel("Alterar meus dados");
        lblRepitaSenha = new JLabel("Digite sua senha atual:");
        pfRepeteSenha = new JPasswordField(10);
        lblNomeCompleto= new JLabel("Nome completo: "+aluno.getNomeCompleto());
    	lblNomeUser= new JLabel("Nome de usuário: "+aluno.getNomeUsuario());
    	lblEmail = new JLabel("Email: "+aluno.getEmail());
    	lblAlteraSenha= new JLabel("Digite sua nova senha:");
     	pfAlteraSenha = new JPasswordField(10);
     	lblAlteraNomeCompleto= new JLabel("Digite seu nome completo:");
     	txtAlteraNomeCompleto= new JTextField(200);
        btnAlterarSenha = new JButton("Alterar senha");
        btnAlterarNome = new JButton("Alterar nome");
       
        
        //cores
    	Color roxoEscuro=new Color(75,0,130); 

    	lblAlterarDados.setForeground(roxoEscuro);
        lblRepitaSenha.setForeground(Color.BLACK);
        pfRepeteSenha.setForeground(Color.BLACK);
        lblNomeCompleto.setForeground(Color.BLACK);
        lblNomeUser.setForeground(Color.BLACK);
        lblEmail.setForeground(Color.BLACK);
        lblAlteraSenha.setForeground(Color.BLACK);
        pfAlteraSenha.setForeground(Color.BLACK);
        lblAlteraNomeCompleto.setForeground(Color.BLACK);
        txtAlteraNomeCompleto.setForeground(Color.BLACK);
        btnAlterarNome.setForeground(Color.WHITE);
        btnAlterarNome.setBackground(roxoEscuro);
        btnAlterarSenha.setForeground(Color.WHITE);
        btnAlterarSenha.setBackground(roxoEscuro);
        
        //formatação
        Font fonteInfo = new Font("Trebuchet MS", Font.PLAIN, 18);
        lblNomeCompleto.setFont(fonteInfo);
        lblNomeUser.setFont(fonteInfo);
        lblEmail.setFont(fonteInfo);
        
        Font fonteLabelsInsira = new Font( "Trebuchet MS", Font.PLAIN, 20);
        lblAlteraSenha.setFont(fonteLabelsInsira);
        lblRepitaSenha.setFont(fonteLabelsInsira);
        lblAlteraNomeCompleto.setFont(fonteLabelsInsira);
        
        Font fonteTXT = new Font( "Trebuchet MS", Font.PLAIN, 20);
        pfRepeteSenha.setFont(fonteTXT);
        pfAlteraSenha.setFont(fonteTXT);
        txtAlteraNomeCompleto.setFont(fonteTXT);
        
        Font fonteTitle = new Font( "Trebuchet MS", Font.PLAIN, 30);
        lblAlterarDados.setFont(fonteTitle);
        
        Font fonteBotao = new Font( "Trebuchet MS", Font.PLAIN, 25);
        btnAlterarSenha.setFont(fonteBotao);
        btnAlterarNome.setFont(fonteBotao);
        
        
        //coordenadas
        lp.setBounds(0, 0, 550, 585);
        lblAlterarDados.setBounds(127, 20, 300, 31);
        lblNomeCompleto.setBounds(40,85, 400,18);
        lblNomeUser.setBounds(40, 120, 400, 18);
        lblEmail.setBounds(40, 155, 400, 20);
        lblRepitaSenha.setBounds(40, 220, 300, 20);
        pfRepeteSenha.setBounds(40, 245, 450, 23);
        lblAlteraSenha.setBounds(40, 285, 250, 20);
        pfAlteraSenha.setBounds(40, 310, 450, 23);
        btnAlterarSenha.setBounds(130, 350, 250, 35);
     
        lblAlteraNomeCompleto.setBounds(40, 410, 250, 20);//40 dif
        txtAlteraNomeCompleto.setBounds(40, 435, 450, 23);//25 dif
        btnAlterarNome.setBounds(130, 475, 250, 35);//45 dif

        
        
        //adiciona
        contentPane.add(lp);
        lp.add(lblAlterarDados, new Integer(1));
        lp.add(lblNomeCompleto, new Integer(2));
        lp.add(lblNomeUser, new Integer(3));
        lp.add(lblEmail, new Integer(4));
        lp.add(lblRepitaSenha, new Integer(5));
        lp.add(pfRepeteSenha, new Integer(6));
        lp.add(lblAlteraSenha, new Integer(7));
        lp.add(pfAlteraSenha, new Integer(8));
        lp.add(lblAlteraNomeCompleto, new Integer(9));
        lp.add(txtAlteraNomeCompleto, new Integer(10));
        lp.add(btnAlterarNome, new Integer(11));
        lp.add(btnAlterarSenha, new Integer(12));
        
		setVisible(true);
	}

	private void definirEventos(Aluno aluno, String email) {
		btnAlterarNome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String senha = String.valueOf(pfRepeteSenha.getPassword());
				String novoNomeCompleto = txtAlteraNomeCompleto.getText();
				
				if(senha.equals(aluno.getSenha())) {
					AlunoCONTROLLER controla = new AlunoCONTROLLER();
					
					if(controla.atualizar(aluno, novoNomeCompleto, aluno.getNomeUsuario(),
							aluno.getSenha(), email)==false) {
						JOptionPane.showMessageDialog(null, "Não foi possível executar a ação!");
						setVisible(false);
						
					}else {
						controla.atualizar(aluno, novoNomeCompleto, aluno.getNomeUsuario(),
								aluno.getSenha(), email);//novo nome completo
							aluno.setNomeCompleto(novoNomeCompleto);
							JOptionPane.showMessageDialog(null, "Nome completo alterado com sucesso!");
							setVisible(false);
							TelaPerfilAluno tela = new TelaPerfilAluno(aluno);
		
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Senha incorreta! Nome completo não pode ser alterado!");
					pfRepeteSenha.setText(null);
					return;
				}
				
			} 
		});
		
		btnAlterarSenha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String senha = String.valueOf(pfRepeteSenha.getPassword());
				String novaSenha = String.valueOf(pfAlteraSenha.getPassword());
				
				if(senha.equals(aluno.getSenha())) {
					AlunoCONTROLLER controla = new AlunoCONTROLLER();				
					
					if(controla.atualizarSenha(aluno, novaSenha, email)==false) {
						JOptionPane.showMessageDialog(null, "Não foi possível executar a ação!");
						setVisible(false);
						
					}else {
						controla.atualizarSenha(aluno, novaSenha, email);
							aluno.setSenha(novaSenha);
							JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
							setVisible(false);
							TelaPerfilAluno tela = new TelaPerfilAluno(aluno);
		
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Senha incorreta! Senha não pode ser alterada!");
					pfRepeteSenha.setText(null);
					return;
				}

				
			}
		});

	}
}
