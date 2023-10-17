package view;
import javax.swing.*;

import controller.AgendaCONTROLLER;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;

public class TelaEditarAtividade extends JFrame{
	
	private Container contentPane;
	private JLayeredPane lp;
	private JLabel lblEditar;
	private JLabel lblAtividadeNova;
	private JTextField txtAtividade;
	private JButton btnEditar;
	
	private Color roxoIndigo = new Color(75,0,130);
	AgendaCONTROLLER controla = new AgendaCONTROLLER();
		
	public TelaEditarAtividade(String ATIVIDADE, LocalDate dataS, String email) {
		inicializarComponentes(ATIVIDADE, dataS,  email);
		definirEventos(ATIVIDADE, dataS, email);
		setVisible(true);
	}

	private void inicializarComponentes(String ATIVIDADE, LocalDate dataS, String email) {
		//configura tela
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Dimension screenSize = toolkit.getScreenSize();
				setBounds(0, 0, 335, 290);
				contentPane=getContentPane();
				contentPane.setBackground(Color.white);
				
				//inicializa
				lp= new JLayeredPane();
				lblEditar= new JLabel("Editar atividade");
				lblAtividadeNova= new JLabel("Atividade nova:");
				txtAtividade= new JTextField(200);
				btnEditar= new JButton("Editar");
			
				
				//cores
				lblEditar.setForeground(roxoIndigo);
				lblAtividadeNova.setForeground(Color.BLACK);
				txtAtividade.setForeground(Color.BLACK);
				btnEditar.setForeground(Color.WHITE);
				btnEditar.setBackground(roxoIndigo);
						
				//fontes
				lblEditar.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
				lblAtividadeNova.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
				txtAtividade.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				btnEditar.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
				
				//coordenadas 		
				lblEditar.setBounds(50, 20, 300, 30);
				lblAtividadeNova.setBounds(20, 70, 180, 25);
				txtAtividade.setBounds(20, 100, 275, 100);
				btnEditar.setBounds(50, 215, 200, 30);
				
				//adiciona
				contentPane.add(lp);
				lp.add(lblEditar, new Integer(1));
				lp.add(lblAtividadeNova, new Integer(4));
				lp.add(txtAtividade, new Integer(5));
				lp.add(btnEditar, new Integer(6));
				
				setLayout(new BorderLayout());
		        add(lp, BorderLayout.CENTER);
		        btnEditar.setBorderPainted(false);
		
	}

	private void definirEventos(String ATIVIDADE, LocalDate dataS, String email) {
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String atividadeNova = String.valueOf(txtAtividade.getText());
				boolean foi=controla.editarAtividade(ATIVIDADE, dataS, email, atividadeNova);
				
				if(foi==true) {
					JOptionPane.showMessageDialog(null, "Atividade editada com sucesso!");
					setVisible(false);
				}else if(foi==false) {
					JOptionPane.showMessageDialog(null, "Erro ao editar atividade");

				}
			}
		});
		
	}
}
