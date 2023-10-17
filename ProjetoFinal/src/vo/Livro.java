package vo;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.InputStream;
import java.util.Date;

public class Livro {
	private String isbn;
	private String titulo;
	private String editora;
	private String autor;
	private Date dataPublicacao;
	private String emailProf;
	private File arquivoPDF;
	
	public Livro(String isbn, String titulo, String editora, String autor, Date dataPublicacao, String emailProf, File arquivoPDF) {
		setIsbn(isbn);
		setTitulo(titulo);
		setEditora(editora);
		setAutor(autor);
		setDataPublicacao(dataPublicacao);
		setEmailProf(emailProf);
		setArquivoPDF(arquivoPDF);
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public String getEmailProf() {
		return emailProf;
	}
	public void setEmailProf(String emailProf) {
		this.emailProf = emailProf;
	}

	public File getArquivoPDF() {
		return arquivoPDF;
	}

	public void setArquivoPDF(File arquivoPDF) {
		this.arquivoPDF = arquivoPDF;
	}
	
}



/*isbn VARCHAR(13),
    titulo VARCHAR(100) NOT NULL,
    editora VARCHAR(60) NOT NULL,
    autor VARCHAR(200) NOT NULL,
    dataPublicacao DATE NOT NULL,
    emailProf VARCHAR(100) NOT NULL,*/