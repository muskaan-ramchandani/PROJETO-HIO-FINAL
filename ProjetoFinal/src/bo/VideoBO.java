package bo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import conexaoBD.Conexao;
import dao.LivroDAO;
import dao.VideoDAO;
import vo.Video;
import vo.Livro;
import vo.Olimpiada;

public class VideoBO {

	
	public boolean cadastrar(String titulo, String upc, String produtor, java.util.Date dataPublicacao, String emailProf,
			File arquivoVideo, Olimpiada olimp) {
		Video video = new Video(titulo, upc, produtor, dataPublicacao, emailProf, arquivoVideo);
		VideoDAO dao = new VideoDAO();
		return dao.cadastrar(video, dataPublicacao, arquivoVideo, olimp);
	} 
	
	public ArrayList retornaVideoOlimpiada(Olimpiada olimp) {
		VideoDAO dao = new VideoDAO();
        return dao.retornaVideoOlimpiada(olimp);
    }
	
	public boolean relacionarComOlimp(Olimpiada olimp, String upc) {
		 VideoDAO dao = new VideoDAO();
		 return dao.relacionarComOlimp( olimp,  upc);
	}
	
	public ArrayList<Video> consultarVideosPorNome(String tituloVideo, Olimpiada olimp) {
		 VideoDAO dao = new VideoDAO();
	     return dao.consultarVideosPorNome(tituloVideo, olimp);
	}
	
	public ArrayList<Video> consultarVideosPorUpc(String upc, Olimpiada olimp) {
		VideoDAO dao = new VideoDAO();
	     return dao.consultarVideosPorUpc(upc, olimp);
	}
	public boolean HistoricoVideosProf(String emailProf, String upc, String titulo) {
		VideoDAO dao = new VideoDAO();
	    return dao.HistoricoVideosProf(emailProf, upc, titulo);
	}
	
	public ArrayList<String> exibirHistoricoVideosProfUPC(String emailProfessor) {
		VideoDAO dao= new VideoDAO();
        return dao.exibirHistoricoVideosProfUPC(emailProfessor);
    }
	
	public ArrayList<String> exibirHistoricoVideosProfTITULO(String emailProfessor) {
		VideoDAO dao= new VideoDAO();
        return dao.exibirHistoricoVideosProfTITULO(emailProfessor);
    }
}
