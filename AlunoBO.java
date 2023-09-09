package bo;
import dao.AlunoDAO;
import javax.swing.*;

import conexaoBD.Conexao;
import dao.AlunoDAO;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Aluno;

public class AlunoBO {
	public void cadastrar(String nomeCompleto, String nomeUsuario, String email,String senha) {
		Aluno aluno = new Aluno(nomeCompleto, nomeUsuario, email, senha);
		AlunoDAO dao = new AlunoDAO();
		dao.cadastrar(aluno);
	}
	
	public void adicionarOlimpiadas(Aluno aluno, String olimpiada) {
		AlunoDAO dao = new AlunoDAO();
		dao.adicionarOlimpiadas(aluno, olimpiada);
	}
	
	public ArrayList retornaOlimpiadasSelecionadas(Aluno aluno) {
		AlunoDAO dao = new AlunoDAO();
        return dao.retornaOlimpiadasSelecionadas(aluno);
    }

	
	public boolean consultar(String email, String senha) {
		AlunoDAO dao = new AlunoDAO();
		return dao.consultar(email, senha);
	}
	
	public boolean atualizarSenha(Aluno aluno, String senha, String email) {
		AlunoDAO dao = new AlunoDAO();
		return dao.atualizarSenha(aluno, senha, email);
	}

	
	public boolean atualizar(Aluno aluno, String nomeCompleto, String nomeUsuario, String senha, String email) {
		AlunoDAO dao = new AlunoDAO();

		if (dao.consultar(email, senha)==false) {
            return false; // email e senha invalidos, não pode alterar
        }else {
    	    return dao.atualizar(aluno, nomeCompleto, nomeUsuario, senha, email);
        }
	}
	
	public boolean remover(String email, String senha) {
		AlunoDAO dao = new AlunoDAO();

        if (dao.consultar(email, senha)==false) {
            return false; // email e senha invalidos, não pode apagar
        }else {
            return dao.remover(email);
        }
    }
	
	
	public static Aluno obterAlunoExistente(String email) {
		AlunoDAO dao = new AlunoDAO();
		return dao.obterAlunoExistente(email);
	}

}
