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
import dao.LivroDAO;
import bo.LivroBO;
import bo.VideoBO;
import vo.Livro;
import vo.Olimpiada;

public class LivroCONTROLLER {

	public boolean cadastrar(String isbn, String titulo, String editora, String autor, java.util.Date dataPublicacao,
	String emailProf, File arquivoStream, Olimpiada olimp) {
		LivroBO bo = new LivroBO();
		return bo.cadastrar(isbn, titulo, editora, autor, dataPublicacao, emailProf, arquivoStream, olimp);
	}
	
	public boolean relacionarComOlimp(Olimpiada olimp, String isbn) {
		 LivroBO bo = new LivroBO();
		 return bo.relacionarComOlimp( olimp,  isbn);
	}
	
	public ArrayList retornaLivroOlimpiada(Olimpiada olimp) {
		LivroBO bo = new LivroBO();
        return bo.retornaLivroOlimpiada(olimp);
    }
	
	public ArrayList<Livro> consultarLivrosPorNome(String tituloLivro, Olimpiada olimp) {
		 LivroBO bo = new LivroBO();
	     return bo.consultarLivrosPorNome(tituloLivro, olimp);
	}
	
	public ArrayList<Livro> consultarLivrosPorIsbn(String isbn, Olimpiada olimp) {
		 LivroBO bo = new LivroBO();
	     return bo.consultarLivrosPorIsbn(isbn, olimp);
	}
	
	public boolean HistoricoLivrosProf(String emailProf, String isbn, String titulo) {
		LivroBO bo = new LivroBO();
	    return bo.HistoricoLivrosProf(emailProf, isbn, titulo);
	}
	public ArrayList<String> exibirHistoricoLivrosProfISBN(String emailProfessor) {
		LivroBO bo = new LivroBO();
        return bo.exibirHistoricoLivrosProfISBN(emailProfessor);
    }
	
	public ArrayList<String> exibirHistoricoLivrosProfTITULO(String emailProfessor) {
		LivroBO bo = new LivroBO();
        return bo.exibirHistoricoLivrosProfTITULO(emailProfessor);
    }
}
