package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import controller.AgendaCONTROLLER;
import vo.Agenda;
import vo.Aluno;

public class TelaAdicionarAtividade extends JFrame{
// boolean adicionarAtividade(String atividade, LocalDate dataSemana, String diaSemana,String mes, String emailAluno) {

	private JLayeredPane lp;
	private Container contentPane;
	private JLabel lblAdicionarAtv;
	private JLabel lblDataSemana;
	private JFormattedTextField txtDataSemana;
	private JLabel lblAtividade;
	private JTextField txtAtividade;
	private JButton btnAdicionar;
	
    private Color roxoIndigo = new Color(75,0,130);
	AgendaCONTROLLER controla = new AgendaCONTROLLER();

	
	public TelaAdicionarAtividade(Aluno aluno, String mesAtual) {
		
		this.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                TelaAgendaInicia iniciaNova = new TelaAgendaInicia(aluno);
            }
        });
		
		inicializarComponentes(aluno);
		definirEventos(aluno, mesAtual);
		setVisible(true);
	}

	private void inicializarComponentes(Aluno aluno) {
		//configura tela
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(0, 0, 335, 400);
		contentPane=getContentPane();
		contentPane.setBackground(Color.white);
		
		//inicializa
		lp= new JLayeredPane();
		lblAdicionarAtv= new JLabel("Adicionar atividade");
		lblDataSemana = new JLabel("Data da semana:");
		txtDataSemana= new JFormattedTextField();
		lblAtividade= new JLabel("Atividade:");
		txtAtividade= new JTextField(200);
		btnAdicionar= new JButton("Adicionar");
		
		try {
			txtDataSemana.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
			txtDataSemana.setHorizontalAlignment(JFormattedTextField.CENTER);
   		} catch (ParseException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
		
		//cores
		lblAdicionarAtv.setForeground(roxoIndigo);
		lblDataSemana.setForeground(Color.BLACK);
		txtDataSemana.setForeground(Color.BLACK);
		lblAtividade.setForeground(Color.BLACK);
		txtAtividade.setForeground(Color.BLACK);
		btnAdicionar.setForeground(Color.WHITE);
		btnAdicionar.setBackground(roxoIndigo);
				
		//fontes
		lblAdicionarAtv.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblDataSemana.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		txtDataSemana.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblAtividade.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		txtAtividade.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnAdicionar.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		
		//coordenadas 		setBounds(0, 0, 550, 585);
		lblAdicionarAtv.setBounds(40, 20, 300, 30);
		lblDataSemana.setBounds(20, 90, 259, 25);
		txtDataSemana.setBounds(20, 115, 275, 25);
		lblAtividade.setBounds(20, 145, 100, 25);
		txtAtividade.setBounds(20, 170, 275, 100);
		btnAdicionar.setBounds(50, 310, 200, 30);
		
		//adiciona
		contentPane.add(lp);
		lp.add(lblAdicionarAtv, new Integer(1));
		lp.add(lblDataSemana, new Integer(2));
		lp.add(txtDataSemana, new Integer(3));
		lp.add(lblAtividade, new Integer(4));
		lp.add(txtAtividade, new Integer(5));
		lp.add(btnAdicionar, new Integer(6));
		
		setLayout(new BorderLayout());
        add(lp, BorderLayout.CENTER);
        btnAdicionar.setBorderPainted(false);
	}

	private void definirEventos(Aluno aluno, String mesAtual) {
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//pegar 1 e ultima data
				ArrayList<Agenda> arrayAgenda = new ArrayList<Agenda>();
				arrayAgenda =controla.retornaAgendaExistente(aluno.getEmail());
				
		        ArrayList<LocalDate> datas = new ArrayList<>();
				
				for(Agenda a : arrayAgenda) {
					datas.add(a.getDataSemana());
				}
				
				LocalDate primeiraData = Collections.min(datas);
		        LocalDate ultimaData = Collections.max(datas);
		        
				String Atividade = String.valueOf(txtAtividade.getText());
				
				String text = txtDataSemana.getText(); 
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define o formato da data
		        LocalDate localDate= LocalDate.parse(text, formatter);
		        

	            if(txtAtividade.getText().isEmpty()||txtDataSemana.getText().isEmpty()) {
	            	
	            	JOptionPane.showMessageDialog(null, "Não é possível cadastrar uma atividade sem todos os dados!");
	            	
	            }else if(!((localDate.isAfter(primeiraData)||localDate.isEqual(primeiraData))&&
	            		(localDate.isBefore(ultimaData)||localDate.isEqual(ultimaData)))){
	            	 
	            	JOptionPane.showMessageDialog(null, "Não é possível cadastrar uma atividade nessa data!"
	            			+ "\nEscolha uma data entre "+primeiraData+" e "+ultimaData);
	                 
	            }else {
		        	String diaSemana = String.valueOf(localDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("pt", "BR")));

	            	
	            	boolean foi =controla.adicionarAtividade(Atividade, localDate,diaSemana, mesAtual,aluno.getEmail() ); 
	            	
	            	if(foi==false) {
	            		JOptionPane.showMessageDialog(null, "Erro ao adicionar atividade!");
	            	}else if(foi==true) {
	            		JOptionPane.showMessageDialog(null, "Atividade adicionada com sucesso!");
	            		setVisible(false);
	            	}
	            }
			}
		});
		
	}

	
	
}
