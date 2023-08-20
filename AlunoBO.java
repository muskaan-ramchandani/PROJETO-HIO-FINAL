package bo;
import dao.AlunoDAO;
import javax.swing.*;

import dao.AlunoDAO;

import java.awt.*;
import vo.Aluno;

public class AlunoBO {
	public void cadastrar(String nomeCompleto, String nomeUsuario, String email,String senha) {
		Aluno aluno = new Aluno(nomeCompleto, nomeUsuario, email, senha);
		AlunoDAO dao = new AlunoDAO();
		dao.cadastrar(aluno);
	}
	
	public boolean consultar(String email, String senha) {
		AlunoDAO dao = new AlunoDAO();
		return dao.consultar(email, senha);
	}
	
}