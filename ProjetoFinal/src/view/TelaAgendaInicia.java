package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import java.awt.*;

import controller.AgendaCONTROLLER;
import controller.AlunoCONTROLLER;
import vo.Agenda;
import vo.Aluno;


public class TelaAgendaInicia extends JFrame{
	String mesAtual;
	private Container contentPane;
	private JLayeredPane lp;
	private JMenuBar barra;
	private JButton btnVoltar;
	private JLabel lblMinhaAgenda;
	private JButton btnIniciar;
	private JButton btnAtualizar;
	private JButton btnAdicionarAtividade;
	private JButton btnApagar;
	
    private Color roxoIndigo = new Color(75,0,130);

	AgendaCONTROLLER controla = new AgendaCONTROLLER();
	
	//itens da agenda 
	private JLabel lblMes;
	private JLabel[] lblDiaMesSem;
	private JLabel[] lblAtividades;
	
	private JButton btnExcluir;
	private JButton btnEditar;
	
	public TelaAgendaInicia(Aluno aluno) {
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
				
				btnIniciar= new JButton(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
						+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//btnIniciarAgenda.png"));
				btnIniciar.setContentAreaFilled(false); // Deixa a área de preenchimento transparente
				btnIniciar.setBorderPainted(false); // Remove a borda
				btnIniciar.setFocusPainted(false);
				
				btnAtualizar= new JButton(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
						+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//btnAtualizarAgenda.png"));
				btnAtualizar.setContentAreaFilled(false); // Deixa a área de preenchimento transparente
				btnAtualizar.setBorderPainted(false); // Remove a borda
				btnAtualizar.setFocusPainted(false);
				
				
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
		        
				//cores
				barra.setBackground(roxoIndigo);
				lblMinhaAgenda.setForeground(Color.WHITE);
				
				//fontes
				lblMinhaAgenda.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
				
				//coordenadas
			    barra.setBounds(0,0,screenSize.width, 50);
		    	btnVoltar.setBounds(10, 12, 28,25);
		    	lblMinhaAgenda.setBounds(600, 12, 150, 26);
		    	btnIniciar.setBounds(1100, 100, 41, 40);
		    	btnAtualizar.setBounds(1150, 100, 41, 40);
				btnAdicionarAtividade.setBounds(1200, 100, 41, 40);
				btnApagar.setBounds(1250, 100, 41, 40); //50 diferenca

				//CONFIGURAÇÕES AGENDA
				ArrayList<Agenda> arrayVerifica = new ArrayList<Agenda>();
				arrayVerifica =controla.retornaAgendaExistente(aluno.getEmail());
				
				if(arrayVerifica.isEmpty()) {//o usuario não criou uma agenda, primeira vez
					
					//inicia valores da agenda
					LocalDate dataAtual = LocalDate.now();
			        LocalDate dataFinalDaSemana = dataAtual.with(DayOfWeek.SUNDAY); // Encontre o próximo domingo
			        LocalDate primeiraData = dataFinalDaSemana.minusDays(6); // A primeira data é 6 dias antes da data final da semana
			        LocalDate ultimaData = dataFinalDaSemana;
			        
			        for (int i = 0; i < 7; i++) {
			        	LocalDate data=primeiraData.plusDays(i);
			        	String diaSemana = String.valueOf(data.getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("pt", "BR")));
			        	int mesAtualNumero= data.getMonthValue();
			        	String mes=null;
			        	
			        	if(mesAtualNumero==1) {
			        		mes="Janeiro";
			        	}else if(mesAtualNumero==2) {
			        		mes="Fevereiro";
			        	}else if(mesAtualNumero==3) {
			        		mes="Março";

			        	}else if(mesAtualNumero==4) {
			        		mes="Abril";

			        	}else if(mesAtualNumero==5) {
			        		mes="Maio";

			        	}else if(mesAtualNumero==6) {
			        		mes="Junho";

			        	}else if(mesAtualNumero==7) {
			        		mes="Julho";

			        	}else if(mesAtualNumero==8) {
			        		mes="Agosto";

			        	}else if(mesAtualNumero==9) {
			        		mes="Setembro";

			        	}else if(mesAtualNumero==10) {
			        		mes="Outubro";

			        	}else if(mesAtualNumero==11) {
			        		mes="Novembro";

			        	}else if(mesAtualNumero==12) {
			        		mes="Dezembro";

			        	}
			        	
			            controla.iniciarAgenda(data, diaSemana,mes, aluno.getEmail());
			        }
				}//finaliza a iniciação dos itens da agenda
				

				
				ArrayList<Agenda> verificaDatasIguais = new ArrayList<Agenda>();
				verificaDatasIguais =controla.retornaAgendaExistente(aluno.getEmail());
				
				ArrayList<Agenda> itensAtuais = new ArrayList<Agenda>();
				itensAtuais =controla.retornaAgendaExistente(aluno.getEmail());
				
				
				ArrayList<Agenda> agendaNRepete = new ArrayList<Agenda>();
				
				LocalDate dataV;
				LocalDate dataIA;
				
				for(int j=0; j<itensAtuais.size();j++) {
					Agenda IA = itensAtuais.get(j);
					dataIA = itensAtuais.get(j).getDataSemana();
					
					for(int i=0; i<verificaDatasIguais.size();i++) {
						dataV= verificaDatasIguais.get(i).getDataSemana();
					
						if(dataIA.isEqual(dataV)) {
							//datas diferentes
							agendaNRepete.add(IA);
						}
					}
				}
				
				//verifica se mes ou semana acabou
	        	boolean vSemana =verificaSeSemanaAcabou( aluno, agendaNRepete);
	        	boolean vMes=verificaSeMesAcabou( aluno, agendaNRepete);
				
	        	if(vSemana==true||vMes==true) {
	        		TelaAgendaInicia inicia = new TelaAgendaInicia(aluno);
					setVisible(false);
	        	}
				//acaba verificaçao
				
	            lblDiaMesSem = new JLabel[7];
	            mesAtual = null;
	        	int xDMS =100;
	        	int yDMS=190;
	        	int contador=0;
	        	
	        	for(Agenda agendinha :agendaNRepete) {
					LocalDate dataS=agendinha.getDataSemana();
	            	mesAtual= agendinha.getMes();
	            	
	        		int mesN=dataS.getMonthValue();
	        		int diaN= dataS.getDayOfMonth();
	        		String diaDaSemana= agendinha.getDiaSemana();
	        		

	        		lblDiaMesSem[contador]= new JLabel("<html><u><font color='" + toHexString(roxoIndigo)+
	        				"'>"+diaN+"."+mesN+"     "+diaDaSemana+"</font></u></html>");
	        		lblDiaMesSem[contador].setForeground(Color.BLACK);
	        		lblDiaMesSem[contador].setFont(new Font("Trebuchet MS", Font.BOLD, 20));
	        		lblDiaMesSem[contador].setBounds(xDMS, yDMS, 110, 23);
	        		lp.add(lblDiaMesSem[contador], new Integer(7));
	      
	        		
	        		ArrayList<String> atvd = new ArrayList<String>();
	        		atvd=controla.retornaAtividadesDeUmaData(dataS, aluno.getEmail());
	        		
	        			int yAtvD=yDMS+85;
	        			int xAtvD=xDMS;
	        			 lblAtividades = new JLabel[atvd.size()];
	        			 int indiceAtv =0;
	        			 
	        			 for(String atv: atvd) {
	        				 lblAtividades[indiceAtv] = new JLabel(atv);
	        				 lblAtividades[indiceAtv].setForeground(Color.BLACK);
	        				 lblAtividades[indiceAtv].setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	        				 lblAtividades[indiceAtv].setBounds(xDMS, yAtvD, 80, 25);
	        				 lp.add(lblAtividades[indiceAtv], new Integer(8));
	        				

	        				 
   							int XBtnEdit=xDMS+75;
   							int xBtnExc= xDMS+110;
   							int YBotoes = yAtvD;
   							
							String ATIVIDADE = lblAtividades[indiceAtv].getText();

   							lblAtividades[indiceAtv].addMouseListener(new MouseListener() {
	        						
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
	        							//ta em cima
	        							chamaBotoes(ATIVIDADE, dataS, aluno, XBtnEdit, YBotoes, xBtnExc);
	        							
	        						}
	        						@Override
	        						public void mouseExited(java.awt.event.MouseEvent e) {
	        							//saiu
	        							escondeBotoes(ATIVIDADE);
	        						}
	        			        });
   	        			 yAtvD+=60;
   	        			indiceAtv++;
	        			 }
	        			 
	        		
	        		contador+=1;
	        		xDMS+=170;
	        	}
	        	
	        	lblMes = new JLabel(mesAtual);
	            lblMes.setForeground(Color.BLACK);
	    		lblMes.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
	        	lblMes.setBounds(100, 100, 200, 50);
	        	lp.add(lblMes, new Integer(100));
	        	
		    	//
	        	
		    	//adiciona
		    	contentPane.add(lp);
		    	lp.add(barra, new Integer(1));
		    	lp.add(btnVoltar, new Integer(2));
		    	lp.add(lblMinhaAgenda, new Integer(3));
		    	lp.add(btnIniciar, new Integer(4));
		    	lp.add(btnAdicionarAtividade, new Integer(5));
		    	lp.add(btnApagar, new Integer(6));
		    	lp.add(btnAtualizar, new Integer(7));
		    	
		    	
		    	
		    	setLayout(new BorderLayout());
		        add(lp, BorderLayout.CENTER);
		        btnIniciar.setBorderPainted(false);
		        btnVoltar.setBorderPainted(false);
		        btnAdicionarAtividade.setBorderPainted(false);
		        btnApagar.setBorderPainted(false);
		        
		        
		
	}

	private void definirEventos(Aluno aluno) {
		
		btnAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaAgendaInicia inicia = new TelaAgendaInicia(aluno);
				inicia.setLocationRelativeTo(null);
				setVisible(false);
			}
			
		});
		
		btnAtualizar.addMouseListener(new MouseAdapter() {
			@Override
	            public void mouseEntered(MouseEvent e) {
	                super.mouseEntered(e);
	                btnAtualizar.setToolTipText("Adicionar atividade");
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
				TelaAdicionarAtividade adicionaAtv = new TelaAdicionarAtividade(aluno, mesAtual);
				adicionaAtv.setLocationRelativeTo(null);

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
				boolean foi=controla.deletarAgenda(aluno.getEmail());
				
				if(foi==true) {
					JOptionPane.showMessageDialog(null, "Agenda deletada com sucesso!");
					TelaAgendaInicia inicia = new TelaAgendaInicia(aluno);
					setVisible(false);
					
				}else if(foi==false) {
					JOptionPane.showMessageDialog(null, "Erro ao deletar agenda!");
				}
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
	
	public void chamaBotoes(String ATIVIDADE, LocalDate dataS, Aluno aluno, int XBtnEdit, int YBotoes, int xBtnExc) {
		btnEditar =new JButton(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//btnEditarAtividade.png"));
		btnEditar.setContentAreaFilled(false); // Deixa a área de preenchimento transparente
		btnEditar.setBorderPainted(false); // Remove a borda
		btnEditar.setFocusPainted(false);
		
		
		btnEditar.setBounds(XBtnEdit, YBotoes, 26, 25);

		lp.add(btnEditar, new Integer(10));
		
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaEditarAtividade edita = new TelaEditarAtividade(ATIVIDADE, dataS, aluno.getEmail());
				edita.setLocationRelativeTo(null);

				//controla.editarAtividade(atividadeatual, dataFinalDaSemana, emailaluno, novaatv)
			}
		});
		
		btnExcluir=new JButton(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//btnExcluirAtividade.png"));
		btnExcluir.setContentAreaFilled(false); // Deixa a área de preenchimento transparente
		btnExcluir.setBorderPainted(false); // Remove a borda
		btnExcluir.setFocusPainted(false);
		
		btnExcluir.setBounds(xBtnExc, YBotoes, 26, 25);

		lp.add(btnExcluir, new Integer(11));
	
		
		btnExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaExcluirAtividade exclui = new TelaExcluirAtividade(ATIVIDADE, dataS, aluno.getEmail());
				exclui.setLocationRelativeTo(null);

				//controla.deletarAtividade(ATIVIDADE, dataFinalDaSemana, mesAtual)
			}
		});
	}
	
	private boolean verificaSeMesAcabou(Aluno aluno,  ArrayList<Agenda> agendaNRepete) {
		ArrayList<Agenda> agendaPVerificar= agendaNRepete;
		 ArrayList<LocalDate> datas = new ArrayList<>();
			
			for(Agenda a : agendaPVerificar) {
				datas.add(a.getDataSemana());
			}
			
		int ano = datas.get(0).getYear();
		int mes = datas.get(0).getMonthValue();;

		YearMonth yearMonthObject = YearMonth.of(ano, mes);
		int diasNoMes = yearMonthObject.lengthOfMonth();
		LocalDate dataAtual = LocalDate.now();
 
	       if (dataAtual.getDayOfMonth() == diasNoMes) {
	    	   //mes acabou
	   			controla.deletarAgenda(aluno.getEmail());
	        	iniciaAgendaNovamente(aluno);
	        	return true;
	       } else {
	    	   //mes nao acabou
	    	   return false;
	       }
	}
	
	private boolean verificaSeSemanaAcabou(Aluno aluno, ArrayList<Agenda> agendaNRepete) {
		ArrayList<Agenda> agendaPVerificar= agendaNRepete;
		 ArrayList<LocalDate> datas = new ArrayList<>();
			
			for(Agenda a : agendaPVerificar) {
				datas.add(a.getDataSemana());
			}
			
        LocalDate ultimaData = Collections.max(datas);
		LocalDate dataAtual = LocalDate.now();

        if (dataAtual.isEqual(ultimaData.plusDays(1))) {
            //A semana acabou
    		controla.deletarAgenda(aluno.getEmail());
        	iniciaAgendaNovamente(aluno);
        	return true;
        } else {
            //A semana ainda não acabou
        	return false;
        }
	}
	
	private void iniciaAgendaNovamente(Aluno aluno) {
				
		 	LocalDate dataAtual = LocalDate.now();
	        LocalDate dataFinalDaSemana = dataAtual.with(DayOfWeek.SUNDAY); // Encontre o próximo domingo
	        LocalDate primeiraData = dataFinalDaSemana.minusDays(6); // A primeira data é 6 dias antes da data final da semana
	        LocalDate ultimaData = dataFinalDaSemana;
	        
	        for (int i = 0; i < 7; i++) {
	        	LocalDate data=primeiraData.plusDays(i);
	        	String diaSemana = String.valueOf(data.getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("pt", "BR")));
	        	int mesAtualNumero= data.getMonthValue();
	        	String mes=null;
	        	
	        	if(mesAtualNumero==1) {
	        		mes="Janeiro";
	        	}else if(mesAtualNumero==2) {
	        		mes="Fevereiro";
	        	}else if(mesAtualNumero==3) {
	        		mes="Março";

	        	}else if(mesAtualNumero==4) {
	        		mes="Abril";

	        	}else if(mesAtualNumero==5) {
	        		mes="Maio";

	        	}else if(mesAtualNumero==6) {
	        		mes="Junho";

	        	}else if(mesAtualNumero==7) {
	        		mes="Julho";

	        	}else if(mesAtualNumero==8) {
	        		mes="Agosto";

	        	}else if(mesAtualNumero==9) {
	        		mes="Setembro";

	        	}else if(mesAtualNumero==10) {
	        		mes="Outubro";

	        	}else if(mesAtualNumero==11) {
	        		mes="Novembro";

	        	}else if(mesAtualNumero==12) {
	        		mes="Dezembro";

	        	}
	        	controla.deletarAgenda(aluno.getEmail());
	            controla.atualizarSemana(aluno.getEmail(), data, diaSemana, mes);

	        }
		//finaliza a iniciação dos itens da agenda
	}
	
	private void escondeBotoes(String ATIVIDADE) {
		Component[] components = lp.getComponents();

		for (Component component : components) {
		    if (component instanceof JButton) { 
		        JButton button = (JButton) component; 
		        String texto = button.getText(); 
		        if (texto != null && texto.equals(ATIVIDADE)) {
		            component.setVisible(false);
		        }
		    }
		}
		
	}
}
