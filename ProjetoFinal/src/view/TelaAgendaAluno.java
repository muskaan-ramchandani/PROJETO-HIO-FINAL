package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;
import java.time.*;

import vo.Agenda;
import vo.Aluno;
import controller.AgendaCONTROLLER;
import controller.AlunoCONTROLLER;
import view.TelasGuiOlimpiadasProf.TelaLivrosProf;

//implementar dao dde agenda


//por meio dessa classe deve ser possivel que o aluno edite/adicione/exclua eventos da sua agenda e visualize eles
//deve ser implementada uma função para que a semana seja atualizada
//ideia 1: atualiza automaticamnete
//ideia 2: botao de atualizar semana

public class TelaAgendaAluno extends JFrame{

	private Container contentPane;
	private JLayeredPane lp;
	private JMenuBar barra;
	private JButton btnVoltar;
	private JLabel lblMinhaAgenda;
	private JButton btnAtualizar;
	private JButton btnIniciar;
	private JButton btnAdicionarAtividade;
	private JButton btnApagar;
	private JLabel lblInicieSuaAgenda;
	
    private Color roxoIndigo = new Color(75,0,130);

	AgendaCONTROLLER controla = new AgendaCONTROLLER();
	
	public TelaAgendaAluno(Aluno aluno) {
		inicializarComponentes(aluno);
		definirEventos(aluno);
		setVisible(true);
	}

	private void inicializarComponentes(Aluno aluno) {
		//configura tela
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height-40);
		contentPane=getContentPane();
        contentPane.setBackground(Color.white);
        
		//inicializa
		lp=new JLayeredPane();
		barra =new JMenuBar();
		
		btnVoltar = new JButton(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//setaVoltarPequena.png"));
		btnVoltar.setContentAreaFilled(false); // Deixa a área de preenchimento transparente
		btnVoltar.setBorderPainted(false); // Remove a borda
		btnVoltar.setFocusPainted(false);
		
		btnAtualizar= new JButton(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//btnAtualizarAgenda.png"));
		btnAtualizar.setContentAreaFilled(false); // Deixa a área de preenchimento transparente
		btnAtualizar.setBorderPainted(false); // Remove a borda
		btnAtualizar.setFocusPainted(false);
		
		btnIniciar= new JButton(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//btnIniciarAgenda.png"));
		btnIniciar.setContentAreaFilled(false); // Deixa a área de preenchimento transparente
		btnIniciar.setBorderPainted(false); // Remove a borda
		btnIniciar.setFocusPainted(false);
		
		btnAdicionarAtividade= new JButton(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//btnAdicionarAtv.png"));
		btnAdicionarAtividade.setContentAreaFilled(false); // Deixa a área de preenchimento transparente
		btnAdicionarAtividade.setBorderPainted(false); // Remove a borda
		btnAdicionarAtividade.setFocusPainted(false);
		
		
		btnApagar= new JButton(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//btnDeletardadosAgenda.png"));
		btnApagar.setContentAreaFilled(false); // Deixa a área de preenchimento transparente
		btnApagar.setBorderPainted(false); // Remove a borda
		btnApagar.setFocusPainted(false);
		
		
		lblMinhaAgenda= new JLabel("Minha Agenda");
		lblInicieSuaAgenda = new JLabel("Inicie sua agenda no botão de iniciar");
        
		//cores
		barra.setBackground(roxoIndigo);
		lblMinhaAgenda.setForeground(Color.WHITE);
		lblInicieSuaAgenda.setForeground(Color.BLACK);
		
		//fontes
		lblMinhaAgenda.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblInicieSuaAgenda.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		
		//coordenadas
	    barra.setBounds(0,0,screenSize.width, 50);
    	btnVoltar.setBounds(10, 12, 28,25);
    	lblMinhaAgenda.setBounds(600, 12, 150, 26);
    	lblInicieSuaAgenda.setBounds(450, 350, 700, 40);
    	btnIniciar.setBounds(1100, 100, 41, 40);
    	btnAtualizar.setBounds(1150, 100, 41, 40);
		btnAdicionarAtividade.setBounds(1200, 100, 41, 40);
		btnApagar.setBounds(1250, 100, 41, 40); //50 diferenca

    	//adiciona
    	contentPane.add(lp);
    	lp.add(barra, new Integer(1));
    	lp.add(btnVoltar, new Integer(2));
    	lp.add(lblMinhaAgenda, new Integer(3));
    	lp.add(lblInicieSuaAgenda, new Integer(5));
    	lp.add(btnIniciar, new Integer(6));
    	lp.add(btnAdicionarAtividade, new Integer(7));
    	lp.add(btnApagar, new Integer(8));
    	lp.add(btnAtualizar, new Integer(9));
    	
    	setLayout(new BorderLayout());
        add(lp, BorderLayout.CENTER);
        btnIniciar.setBorderPainted(false);
        btnVoltar.setBorderPainted(false);
        btnAdicionarAtividade.setBorderPainted(false);
        btnApagar.setBorderPainted(false);

		
	}

	private void definirEventos(Aluno aluno) {

		btnIniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaAgendaInicia inicia = new TelaAgendaInicia(aluno);
				setVisible(false);
			}
		});
		
		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
	            public void mouseEntered(MouseEvent e) {
	                super.mouseEntered(e);
	                btnIniciar.setToolTipText("Iniciar agenda");
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                super.mouseExited(e);
	                btnIniciar.setToolTipText(" ");
	            }
	        });
		
		btnAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Só é possível atualizar uma agenda se"
						+ "\na agenda for iniciada!");
			}
			
		});
		btnAtualizar.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnAtualizar.setToolTipText("Atualizar agenda");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnAtualizar.setToolTipText(" ");
            }
        });
		
		
		btnAdicionarAtividade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Só é possível adicionar uma atividade se"
						+ "\na agenda for iniciada!");
			}
			
		});
		
		btnAdicionarAtividade.addMouseListener(new MouseAdapter() {
			@Override
	            public void mouseEntered(MouseEvent e) {
	                super.mouseEntered(e);
	                btnAdicionarAtividade.setToolTipText("Adicionar atividade");
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                super.mouseExited(e);
	                btnAdicionarAtividade.setToolTipText(" ");
	            }
	        });
		
		btnApagar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Só é possível apagar uma agenda se"
						+ "\na agenda for iniciada!");
			}
			
		});
		
		btnApagar.addMouseListener(new MouseAdapter() {
			@Override
	            public void mouseEntered(MouseEvent e) {
	                super.mouseEntered(e);
	                btnApagar.setToolTipText("Apagar agenda");
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                super.mouseExited(e);
	                btnApagar.setToolTipText(" "); 
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
	
	private static String toHexString(Color cor) {
        return String.format("#%02x%02x%02x", cor.getRed(), cor.getGreen(), cor.getBlue());
    }
}