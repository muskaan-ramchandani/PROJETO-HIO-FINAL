package bo;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import conexaoBD.Conexao;
import vo.Flashcard;
import vo.Olimpiada;
import dao.FlashcardDAO;
import java.io.File;

public class FlashcardBO {

		public boolean cadastrar(Flashcard flash) {
			FlashcardDAO dao = new FlashcardDAO();
			File outputFile = null;
				try {
		            outputFile = File.createTempFile("tempImage", ".png");
		
		            ImageIO.write(flash.getImagem(), "png", outputFile);
		            
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return dao.cadastrar(flash, outputFile);
		}
		
		public boolean relacionarComOlimp(Olimpiada olimp, String titulo) {
			FlashcardDAO dao = new FlashcardDAO();
			return dao.relacionarComOlimp(olimp, titulo);
		}
		
		public ArrayList retornaFlashOlimpiada(Olimpiada olimp) {
			FlashcardDAO dao = new FlashcardDAO();
	        return dao.retornaFlashOlimpiada(olimp);
	    }
		
		public ArrayList<Flashcard> consultarFlashcardsPorTitulo(String tituloFlash, Olimpiada olimp) {
			FlashcardDAO dao = new FlashcardDAO();
		    return dao.consultarFlashcardsPorTitulo(tituloFlash, olimp);
		}
		
		public Flashcard obterFlashExistente(String titulo) {
			FlashcardDAO dao = new FlashcardDAO();
	        return dao.obterFlashExistente(titulo);
	    }
}