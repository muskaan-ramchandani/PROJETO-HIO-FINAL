package view;
 
import java.awt.*;
import javax.swing.*;

/** Exibe a primeira tela a ser exibida ao acessar a aplicação (Splash Screen)*/
public class SplashScreen extends JFrame{
	private int duracao;
	
	/** @param duracao Duração em milisegundos da aparição da tela */
	public SplashScreen(int duracao) { 
		this.duracao=duracao;
		ConstroiSplash();
	}
	
	/** Constrói a Splash Screen */
	private void ConstroiSplash() {		
		JPanel content = (JPanel)getContentPane();
		setTitle("HIO - Helper in Olympics");
		Color roxoEscuro=new Color(75,0,130); //código da cor desejada
		content.setBackground(roxoEscuro);		

		//Tamanho da tela
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height-40);
		
		//Configurações básicas
		String nomeLogo = "logoHIOsf";
		JLabel lblLogo = new JLabel(new ImageIcon("C:\\Users\\maria\\Downloads\\Imagens HIO\\"+nomeLogo+".png"));
		content.add(lblLogo, BorderLayout.CENTER);
		
		//Tornar visível e espera os recursos serem carregados
        setVisible(true);
        try { 
        	Thread.sleep(duracao);
        } catch (Exception e) {}        
        setVisible(false);        
		
	}
}
