package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import vo.Aluno;
import controller.AlunoCONTROLLER;

public class TelaAlteraUserAluno extends JFrame{
	private Container contentPane;
	private JLayeredPane lp;
	private JLabel lblAlterarUser;
	private JButton btnAlterar;
	private JTextField txtNomeUser;
	private JLabel lblDigiteNovoUser;
	private JPasswordField pfRepeteSenha;
	private JLabel lblRepitaSenha;
	
	public TelaAlteraUserAluno(Aluno aluno, String email) {
		inicializarComponentes(aluno);
		definirEventos(aluno, email);
	}

	private void inicializarComponentes(Aluno aluno) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(0, 0, 400, 300);
        contentPane=getContentPane();
        contentPane.setBackground(Color.WHITE);
        setLayout(null);
        
        //inicializa
        lp= new JLayeredPane();
        lblAlterarUser= new JLabel("Alterar nome de usuário");
        lblRepitaSenha = new JLabel("Digite sua senha:");
        pfRepeteSenha = new JPasswordField(10);
        lblDigiteNovoUser = new JLabel("Digite o novo nome de usuário:");
        txtNomeUser = new JTextField(10);
        btnAlterar = new JButton("Alterar");
        
        //cores
    	Color roxoEscuro=new Color(75,0,130); 

        lblAlterarUser.setForeground(roxoEscuro);
        lblRepitaSenha.setForeground(Color.BLACK);
        pfRepeteSenha.setForeground(Color.BLACK);
        lblDigiteNovoUser.setForeground(Color.BLACK);
        txtNomeUser.setForeground(Color.BLACK);
        btnAlterar.setForeground(Color.WHITE);
        btnAlterar.setBackground(roxoEscuro);
        
        //formatação
        Font fonteLabelsInsira = new Font( "Trebuchet MS", Font.PLAIN, 20);
        lblDigiteNovoUser.setFont(fonteLabelsInsira);
        lblRepitaSenha.setFont(fonteLabelsInsira);
        
        Font fonteTXT = new Font( "Trebuchet MS", Font.PLAIN, 20);
        pfRepeteSenha.setFont(fonteTXT);
        txtNomeUser.setFont(fonteTXT);
        
        Font fonteTitle = new Font( "Trebuchet MS", Font.PLAIN, 25);
        lblAlterarUser.setFont(fonteTitle);
        
        Font fonteBotao = new Font( "Trebuchet MS", Font.PLAIN, 25);
        btnAlterar.setFont(fonteBotao);
        
        
        //coordenadas
        lp.setBounds(0, 0, 400, 300);
        lblAlterarUser.setBounds(50, 20, 300, 25);
        lblRepitaSenha.setBounds(15, 85, 200, 20);
        pfRepeteSenha.setBounds(15, 110, 350, 23);
        lblDigiteNovoUser.setBounds(15, 150, 350, 20);
        txtNomeUser.setBounds(15, 175, 350, 23);
        btnAlterar.setBounds(115, 220, 150, 35);
        
        //adiciona
        contentPane.add(lp);
        lp.add(lblAlterarUser, new Integer(1));
        lp.add(lblRepitaSenha, new Integer(2));
        lp.add(pfRepeteSenha, new Integer(3));
        lp.add(lblDigiteNovoUser, new Integer(4));
        lp.add(txtNomeUser, new Integer(5));
        lp.add(btnAlterar, new Integer(6));
        
		setVisible(true);
	}

	private void definirEventos(Aluno aluno, String email) {
		btnAlterar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String senha = String.valueOf(pfRepeteSenha.getPassword());
				
				if(senha.equals(aluno.getSenha())) {
					AlunoCONTROLLER controla = new AlunoCONTROLLER();
					
					if(controla.atualizar(aluno, aluno.getNomeCompleto(), txtNomeUser.getText(),
							aluno.getSenha(), email)==false) {
						
						JOptionPane.showMessageDialog(null, "Não foi possível executar a ação!");
						setVisible(false);
						
					}else {
						controla.atualizar(aluno, aluno.getNomeCompleto(), txtNomeUser.getText(),
								aluno.getSenha(), email);
						JOptionPane.showMessageDialog(null, "Nome de usuário alterado com sucesso!");
						aluno.setNomeUsuario(txtNomeUser.getText());
						setVisible(false);
						TelaPerfilAluno tela = new TelaPerfilAluno(aluno);
					}
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Senha incorreta! Nome de usuário não pode ser alterado!");
					pfRepeteSenha.setText(null);
					return;
				}
				
				
			} 
		});

	}
}
