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
import vo.Livro;
import vo.Olimpiada;

public class LivroBO {

	public boolean cadastrar(String isbn, String titulo, String editora, String autor, java.util.Date dataPublicacao,
	String emailProf, File arquivoPDF, Olimpiada olimp) {
		Livro livro = new Livro(isbn, titulo, editora, autor, dataPublicacao, emailProf, arquivoPDF);
		LivroDAO dao = new LivroDAO();
		return dao.cadastrar(livro, dataPublicacao, arquivoPDF, olimp);
	} 
	
	public ArrayList retornaLivroOlimpiada(Olimpiada olimp) {
		LivroDAO dao = new LivroDAO();
        return dao.retornaLivroOlimpiada(olimp);
    }
	
	public boolean relacionarComOlimp(Olimpiada olimp, String isbn) {
		 LivroDAO dao = new LivroDAO();
		 return dao.relacionarComOlimp( olimp,  isbn);
	}
	
	public ArrayList<Livro> consultarLivrosPorNome(String tituloLivro, Olimpiada olimp) {
		 LivroDAO dao = new LivroDAO();
	     return dao.consultarLivrosPorNome(tituloLivro, olimp);
	}
	
	public ArrayList<Livro> consultarLivrosPorIsbn(String isbn, Olimpiada olimp) {
		 LivroDAO dao = new LivroDAO();
	     return dao.consultarLivrosPorIsbn(isbn, olimp);
	}
	
	public boolean HistoricoLivrosProf(String emailProf, String isbn, String titulo) {
		LivroDAO dao = new LivroDAO();
	    return dao.HistoricoLivrosProf(emailProf, isbn, titulo);
	}
	
	public ArrayList<String> exibirHistoricoLivrosProfISBN(String emailProfessor) {
		LivroDAO dao= new LivroDAO();
        return dao.exibirHistoricoLivrosProfISBN(emailProfessor);
    }
	
	public ArrayList<String> exibirHistoricoLivrosProfTITULO(String emailProfessor) {
		LivroDAO dao= new LivroDAO();
        return dao.exibirHistoricoLivrosProfTITULO(emailProfessor);
    }

}
