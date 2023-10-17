package controller;

import java.io.File;
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
import dao.VideoDAO;
import bo.LivroBO;
import bo.VideoBO;
import vo.Video;
import vo.Livro;
import vo.Olimpiada;

public class VideoCONTROLLER {
	
	public boolean cadastrar(String titulo, String upc, String produtor, java.util.Date dataPublicacao, String emailProf,
		File arquivoVideo, Olimpiada olimp) {
		VideoBO bo = new VideoBO();
		return bo.cadastrar(titulo,upc, produtor, dataPublicacao, emailProf, arquivoVideo, olimp);
	}
	
	public boolean relacionarComOlimp(Olimpiada olimp, String upc) {
		 VideoBO bo = new VideoBO();
		 return bo.relacionarComOlimp( olimp,  upc);
	}
	
	public ArrayList retornaVideoOlimpiada(Olimpiada olimp) {
		VideoBO bo = new VideoBO();
        return bo.retornaVideoOlimpiada(olimp);
    }
	
	public ArrayList<Video> consultarVideosPorNome(String tituloVideo, Olimpiada olimp) {
		VideoBO bo = new VideoBO();
	     return bo.consultarVideosPorNome(tituloVideo, olimp);
	}
	
	public ArrayList<Video> consultarVideosPorUpc(String upc, Olimpiada olimp) {
		VideoBO bo = new VideoBO();
	     return bo.consultarVideosPorUpc(upc, olimp);
	}
	
	public boolean HistoricoVideosProf(String emailProf, String upc, String titulo) {
		VideoBO bo = new VideoBO();
	    return bo.HistoricoVideosProf(emailProf, upc, titulo);
	}
	public ArrayList<String> exibirHistoricoVideosProfUPC(String emailProfessor) {
		VideoBO bo = new VideoBO();
        return bo.exibirHistoricoVideosProfUPC(emailProfessor);
    }
	
	public ArrayList<String> exibirHistoricoVideosProfTITULO(String emailProfessor) {
		VideoBO bo = new VideoBO();
        return bo.exibirHistoricoVideosProfTITULO(emailProfessor);
    }
}
