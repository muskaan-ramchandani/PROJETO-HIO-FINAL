package vo;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Aluno {
	private String nomeCompleto;
	private String nomeUsuario;
	private String email;
	private String senha;
	private ArrayList<String> olimpiadasSelecionadas = new ArrayList<String>();
	
	public Aluno(String nomeCompleto, String nomeUsuario, String email, String senha) {
		setNomeCompleto(nomeCompleto);
		setNomeUsuario(nomeUsuario);
		setEmail(email);
		setSenha(senha);
	}

	public void alteraNomeCompleto(String nomeCompleto) {
		setNomeCompleto(nomeCompleto);
	}
	
	public void alteraNomeUsuario(String nomeUsuario) {
		setNomeUsuario(nomeUsuario);
	}
	
	public void alteraEmail(String email) {
		setEmail(email);
	}
	
	public void alteraSenha(String senha) {
		setSenha(senha);
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
	public void setOlimpiadasSelecionadas(String olimpiada) {
		olimpiadasSelecionadas.add(olimpiada);
	}
	public ArrayList getOlimpiadasSelecionadas() {
		return olimpiadasSelecionadas;
	}
	
}
