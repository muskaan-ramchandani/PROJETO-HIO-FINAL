package view;
import javax.swing.*;

import controller.AgendaCONTROLLER;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class TelaExcluirAtividade extends JFrame{
	private Container contentPane;
	private JLayeredPane lp;
	private JLabel lblDesejaConfirmar;
	private JButton btnNao;
	private JButton btnSim;
	
	private Color roxoIndigo = new Color(75,0,130);

	public TelaExcluirAtividade(String ATIVIDADE, LocalDate dataS, String email) {
		inicializarComponentes( ATIVIDADE,  dataS,  email);
		definirEventos( ATIVIDADE,  dataS,  email);
		setVisible(true);
	}

	private void inicializarComponentes(String aTIVIDADE, LocalDate dataS, String email) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(0, 0, 510, 200);
		contentPane=getContentPane();
		contentPane.setBackground(Color.white);
		
		//inicializa
		lp= new JLayeredPane();
		lblDesejaConfirmar= new JLabel("Deseja confirmar"+" a operação?");
		btnNao = new JButton("Não");
		btnSim = new JButton("Sim");
		
		//cores
		lblDesejaConfirmar.setForeground(Color.BLACK);
		btnNao.setForeground(Color.WHITE);
		btnNao.setBackground(roxoIndigo);
		btnSim.setForeground(Color.WHITE);
		btnSim.setBackground(roxoIndigo);
		
		//fontes
		lblDesejaConfirmar.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		btnNao.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnSim.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		
		//coordenadas
		lblDesejaConfirmar.setBounds(60, 30, 450, 30);
		btnNao.setBounds(145, 80, 100, 30);
		btnSim.setBounds(270, 80, 100, 30);
		
		//adiciona
		contentPane.add(lp);
		lp.add(lblDesejaConfirmar, new Integer(1));
		lp.add(btnNao, new Integer(2));
		lp.add(btnSim, new Integer(3));
		
		setLayout(new BorderLayout());
        add(lp, BorderLayout.CENTER);
        btnSim.setBorderPainted(false);
        btnNao.setBorderPainted(false);

		
	}

	private void definirEventos(String aTIVIDADE, LocalDate dataS, String email) {
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgendaCONTROLLER controla = new AgendaCONTROLLER();
				boolean foi=controla.deletarAtividade(aTIVIDADE, dataS, email);
				
				if(foi==true) {
					JOptionPane.showMessageDialog(null, "Atividade deletada com sucesso!");
					setVisible(false);
				}else if(foi==false) {
					JOptionPane.showMessageDialog(null, "Erro ao deletar atividade");

				}
			}
		});
		
		btnNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Atividade não será excluída!");
				setVisible(false);
			}
		});
		
	}

}
