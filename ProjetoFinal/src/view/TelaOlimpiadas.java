package view;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

import controller.AlunoCONTROLLER;
import vo.Aluno;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaOlimpiadas extends JFrame{
	AlunoCONTROLLER controla = new AlunoCONTROLLER();
	Color roxoEscuro=new Color(75,0,130);
	
	private JPanel panelBranco;
	private JLayeredPane lp;
	private Container contentPane;
	private JLabel lblPessoaLendo;
	private JLabel lblLogo;
	private JLabel lblOla;
	private JLabel lblOla2;
	private JMenuBar barra;
	private JButton btnFinalizar;
	
	private JCheckBox cbOBMEP;
	private JCheckBox cbOBC;
	private JCheckBox cbONC;
	private JCheckBox cbONHB;
	private JCheckBox cbOBQ;
	private JCheckBox cbOBB;
	private JCheckBox cbOBA;
	private JCheckBox cbOBF;
	private JCheckBox cbOBG;
	private JCheckBox cbOBI;
	private JCheckBox cbOBL;
	private JCheckBox cbOBR;
	private JCheckBox cbOLAA;
	private JCheckBox cbOMU;
	private JCheckBox cbOIMSF;
	
	public TelaOlimpiadas(Aluno aluno, boolean retorna) {
		inicializarComponentes(aluno, retorna);
		definirEventos(aluno, retorna);
	}

	private void inicializarComponentes(Aluno aluno, boolean retorna) {
		setTitle("Seleção de olimpíadas");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height-40);
        contentPane=getContentPane();
        
        UIManager.put("CheckBox.border", BorderFactory.createEmptyBorder()); 
        // Define a borda vazia para todos os checkboxes
        UIManager.put("CheckBox.foreground", roxoEscuro); // Define a cor do texto da checkbox
        UIManager.put("CheckBox.background", Color.white); // Define a cor de fundo da checkbox
        UIManager.put("CheckBox.select", Color.WHITE); // Define a cor de seleção da checkbox
        
        Border focusBorder = BorderFactory.createLineBorder(Color.BLACK, 2); // Cria uma borda de foco personalizada
        UIManager.put("CheckBox.border", focusBorder);
        UIManager.put("CheckBox.focus", roxoEscuro);//Define a cor de fundo do foco
        
                
        //inicializa
        panelBranco=new JPanel();
        lp=new JLayeredPane();
        lblOla = new JLabel("Olá, "+aluno.getNomeUsuario()+"!");
        lblOla2 = new JLabel("Selecione as olimpíadas de seu interesse:");
        barra = new JMenuBar();
        btnFinalizar= new JButton("Finalizar");

        lblPessoaLendo = new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//pessoaLendo1.png"));
        lblLogo= new JLabel(new ImageIcon("C://Users//maria//OneDrive//Área de Trabalho//"
				+"Projeto HIO//PROJETO-HIO-FINAL//PROJETO-HIO-FINAL//Imagens HIO//bonequinhoSFMEDIO.png"));
        
        
        cbOBMEP= new JCheckBox("OBMEP");
    	cbOBC= new JCheckBox("OBC");
    	cbONC= new JCheckBox("ONC");
    	cbONHB= new JCheckBox("ONHB");
    	cbOBQ= new JCheckBox("OBQ");
    	cbOBB= new JCheckBox("OBB");
    	cbOBA= new JCheckBox("OBA");
    	cbOBF= new JCheckBox("OBF");
    	cbOBG= new JCheckBox("OBG");
    	cbOBI= new JCheckBox("OBI");
    	cbOBL= new JCheckBox("OBL");
    	cbOBR= new JCheckBox("OBR");
    	cbOLAA= new JCheckBox("OLAA");
    	cbOMU= new JCheckBox("OMU");
    	cbOIMSF= new JCheckBox("IMSF");
        
        //cores e formatações
        panelBranco.setBackground(Color.white);
        barra.setBackground(roxoEscuro);
        btnFinalizar.setBackground(roxoEscuro);
        btnFinalizar.setForeground(Color.WHITE);
        
        Font fonteOLA = new Font( "Trebuchet MS", Font.PLAIN, 55);
		lblOla.setFont(fonteOLA);
		lblOla.setForeground(roxoEscuro);
		lblOla2.setFont( new Font( "Trebuchet MS", Font.PLAIN, 35));
		lblOla2.setForeground(roxoEscuro);

		Font fonteCB= new Font( "Trebuchet MS", Font.PLAIN, 25);
		cbOBMEP.setFont(fonteCB);
    	cbOBC.setFont(fonteCB);
    	cbONC.setFont(fonteCB);
    	cbONHB.setFont(fonteCB);
    	cbOBQ.setFont(fonteCB);
    	cbOBB.setFont(fonteCB);
    	cbOBA.setFont(fonteCB);
    	cbOBF.setFont(fonteCB);
    	cbOBG.setFont(fonteCB);
    	cbOBI.setFont(fonteCB);
    	cbOBL.setFont(fonteCB);
    	cbOBR.setFont(fonteCB);
    	cbOLAA.setFont(fonteCB);
    	cbOMU.setFont(fonteCB);
    	cbOIMSF.setFont(fonteCB);
    	
    	btnFinalizar.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
    	
        //coordenadas
		panelBranco.setBounds(0, 0, screenSize.width, screenSize.height-40);
        lblPessoaLendo.setBounds(217, 213, screenSize.width-50, 600);
        lblOla.setBounds(15, 30, 400, 100);
        lblOla2.setBounds(15, 80, 700, 100);
        barra.setBounds(0,0, screenSize.width, 40);
        lblLogo.setBounds(0,0,40, 40);
        cbOBMEP.setBounds(15, 200, 150, 50);
        cbOBC.setBounds(15, 250, 150, 50);
        cbONC.setBounds(15, 300, 150, 50);
     
        cbONHB.setBounds(150, 200, 150, 50);
        cbOBQ.setBounds(150, 250, 150, 50);
        cbOBB.setBounds(150, 300, 150, 50);
       
        cbOBA.setBounds(285, 200, 150, 50);
        cbOBF.setBounds(285, 250, 150, 50);
        cbOBG.setBounds(285, 300, 150, 50);

        cbOBI.setBounds(420, 200, 150, 50);
        cbOBL.setBounds(420, 250, 150, 50);
        cbOBR.setBounds(420,300,150,50);
        
        cbOLAA.setBounds(555, 200, 150, 50);
        cbOMU.setBounds(555, 250, 150, 50);
        cbOIMSF.setBounds(555, 300, 150, 50);

        btnFinalizar.setBounds(245, 400, 150, 50);
        
        
        
        if(retorna==true) {//foi pressionado botao de adicionar mais olimps 
	            ArrayList<String> olimpiadas = new ArrayList<String>();
				olimpiadas = controla.retornaOlimpiadasSelecionadas(aluno); 
				
				
				for(String nomeLista : olimpiadas) {
					if(cbOBMEP.getText().equals(nomeLista)) {
						cbOBMEP.setSelected(true);
					}
					if(cbOBC.getText().equals(nomeLista)) {
						cbOBC.setSelected(true);
					}
					if(cbONC.getText().equals(nomeLista)) {
						cbONC.setSelected(true);
					}
					if(cbONHB.getText().equals(nomeLista)) {
						cbONHB.setSelected(true);
					}
					if(cbOBQ.getText().equals(nomeLista)) {
						cbOBQ.setSelected(true);
					}
					if(cbOBB.getText().equals(nomeLista)) {
						cbOBB.setSelected(true);
					}
					if(cbOBA.getText().equals(nomeLista)) {
						cbOBA.setSelected(true);
					}
					if(cbOBF.getText().equals(nomeLista)) {
						cbOBF.setSelected(true);
					}
					if(cbOBG.getText().equals(nomeLista)) {
						cbOBG.setSelected(true);
					}
					if(cbOBI.getText().equals(nomeLista)) {
						cbOBI.setSelected(true);
					}
					if(cbOBL.getText().equals(nomeLista)) {
						cbOBL.setSelected(true);
					}
					if(cbOBR.getText().equals(nomeLista)) {
						cbOBR.setSelected(true);
					}
					if(cbOLAA.getText().equals(nomeLista)) {
						cbOLAA.setSelected(true);
					}
					if(cbOMU.getText().equals(nomeLista)) {
						cbOMU.setSelected(true);
					}
					if(cbOIMSF.getText().equals(nomeLista)) {
						cbOIMSF.setSelected(true);
					}
				}
        }
        
        //adiciona
        contentPane.add(lp);
        lp.add(panelBranco, new Integer(1));
        lp.add(lblPessoaLendo, new Integer(2));
        lp.add(lblOla, new Integer(3));
        lp.add(lblOla2, new Integer(4));
        lp.add(barra, new Integer(5));
        lp.add(lblLogo, new Integer(6));
        lp.add(cbOBMEP, new Integer(7));
        lp.add(cbOBC, new Integer(8));
        lp.add(cbONC, new Integer(9));
        lp.add(cbONHB, new Integer(10));
        lp.add(cbOBQ, new Integer(11));
        lp.add(cbOBB, new Integer(12));
        lp.add(cbOBA, new Integer(13));
        lp.add(cbOBF, new Integer(14));
        lp.add(cbOBG, new Integer(15));
        lp.add(cbOBI, new Integer(16));
        lp.add(cbOBL, new Integer(17));
        lp.add(cbOBR, new Integer(18));
        lp.add(cbOLAA, new Integer(19));
        lp.add(cbOMU, new Integer(20));
        lp.add(cbOIMSF, new Integer(21));
        lp.add(btnFinalizar, new Integer(22));
        
        
        setLayout(new BorderLayout());
        add(lp, BorderLayout.CENTER);
        
        
        setVisible(true);
	}
	
	private void definirEventos(Aluno aluno, boolean retorna) {
		
		if(retorna==true) {//foi pressionado botao de adicionar mais olimps	
			
			btnFinalizar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(cbOBMEP.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBMEP.getText());
					}
					if(cbOBC.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBC.getText());
					}
					if(cbONC.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbONC.getText());
					}
					if(cbONHB.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbONHB.getText());
					}
					if(cbOBQ.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBQ.getText());
					}
					if(cbOBB.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBB.getText());
					}
					if(cbOBA.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBA.getText());
					}
					if(cbOBF.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBF.getText());
					}
					if(cbOBG.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBG.getText());
					}
					if(cbOBI.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBI.getText());
					}
					if(cbOBL.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBL.getText());
					}
					if(cbOBR.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBR.getText());
					}
					if(cbOLAA.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOLAA.getText());
					}
					if(cbOMU.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOMU.getText());
					}
					if(cbOIMSF.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOIMSF.getText());
					}
					
					AlunoCONTROLLER controla = new AlunoCONTROLLER();
					int qntdOlimpiadas = (controla.retornaOlimpiadasSelecionadas(aluno)).size();
					if(qntdOlimpiadas>0) {
						JOptionPane.showMessageDialog(null, qntdOlimpiadas +" olimpíadas selecionadas com sucesso!");
						TelaInicialAluno tela = new TelaInicialAluno(aluno, true);
					     setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "Você deve selecionar uma olimpíada! Tente novamente!");
					}
				}
			});
			
		}else{//falso, não foi pressionado botao de adicionar mais olimps, direto do cadastro
			btnFinalizar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(cbOBMEP.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno, cbOBMEP.getText());
					}
					if(cbOBC.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBC.getText());
					}
					if(cbONC.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbONC.getText());
					}
					if(cbONHB.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbONHB.getText());
					}
					if(cbOBQ.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBQ.getText());
					}
					if(cbOBB.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBB.getText());
					}
					if(cbOBA.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBA.getText());
					}
					if(cbOBF.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBF.getText());
					}
					if(cbOBG.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBG.getText());
					}
					if(cbOBI.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBI.getText());
					}
					if(cbOBL.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBL.getText());
					}
					if(cbOBR.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOBR.getText());
					}
					if(cbOLAA.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOLAA.getText());
					}
					if(cbOMU.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOMU.getText());
					}
					if(cbOIMSF.isSelected()==true) {
						controla.adicionarOlimpiadas(aluno,cbOIMSF.getText());
					}
					
					int qntdOlimpiadas = (aluno.getOlimpiadasSelecionadas()).size();
					if(qntdOlimpiadas>0) {
						JOptionPane.showMessageDialog(null, qntdOlimpiadas +" olimpíadas selecionadas com sucesso!");
						TelaInicialAluno tela = new TelaInicialAluno(aluno, false);
					     setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "Você deve selecionar uma olimpíada! Tente novamente!");
					}
				}
			});
		}
		
		
		
		
		
	}
}