package bo;
import dao.AlunoDAO;
import dao.ProfessorDAO;
import javax.swing.*;

import dao.ProfessorDAO;

import java.awt.*;

import vo.Aluno;
import vo.Professor;

public class ProfessorBO {
	public void cadastrar(String nomeCompleto, String nomeUsuario, String email, String senha) {
		
		Professor prof = new Professor(nomeCompleto, nomeUsuario, email, senha);
		ProfessorDAO dao = new ProfessorDAO();
		dao.cadastrar(prof);
	}
	
	public boolean consultar(String email, String senha) {
		ProfessorDAO dao = new ProfessorDAO();
		return dao.consultar(email, senha);
	}

	public boolean atualizar(Professor prof, String nomeCompleto, String nomeUsuario, String senha, String email) {
		ProfessorDAO dao = new ProfessorDAO();

		if (dao.consultar(email, senha)==false) {
            return false; // email e senha invalidos, não pode alterar
        }else {
    	    return dao.atualizar(prof, nomeCompleto, nomeUsuario, senha);
        }
	}
	
	public boolean atualizarSenha(Professor prof, String senha, String email) {
		ProfessorDAO dao = new ProfessorDAO();
		return dao.atualizarSenha(prof, senha, email);
	}
	
	public boolean remover(String email, String senha) {
		ProfessorDAO dao = new ProfessorDAO();

        if (dao.consultar(email, senha)==false) {
            return false; // email e senha invalidos, não pode apagar
        }else {
            return dao.remover(email);
        }
    }
	
	public static Professor obterProfExistente(String email) {
		ProfessorDAO dao = new ProfessorDAO();
		return dao.obterProfExistente(email);
	}
}
