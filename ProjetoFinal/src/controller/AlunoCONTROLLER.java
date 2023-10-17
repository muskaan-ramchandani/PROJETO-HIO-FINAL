package controller;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import bo.AlunoBO;
import dao.AlunoDAO;
import vo.Aluno;
import vo.Professor;

public class AlunoCONTROLLER {
	
	public void cadastrar(String nomeCompleto, String nomeUsuario, String email,String senha) {
		AlunoBO bo = new AlunoBO();
		bo.cadastrar(nomeCompleto, nomeUsuario, email, senha);
	}
	
	public void adicionarOlimpiadas(Aluno aluno, String olimpiada) {
		AlunoBO bo = new AlunoBO();
		bo.adicionarOlimpiadas(aluno, olimpiada);
	}
	public ArrayList retornaOlimpiadasSelecionadas(Aluno aluno) {
		AlunoBO bo = new AlunoBO();
        return bo.retornaOlimpiadasSelecionadas(aluno);
    }
	
	public boolean consultar(String email, String senha) {
		AlunoBO bo = new AlunoBO();
		return bo.consultar(email, senha);
	}
	
	public boolean atualizarSenha(Aluno aluno, String senha, String email) {
		AlunoBO bo = new AlunoBO();
		return bo.atualizarSenha(aluno, senha, email);
	}

	
	public boolean atualizar(Aluno aluno, String nomeCompleto, String nomeUsuario, String senha, String email) {
		AlunoBO bo = new AlunoBO();
		return bo.atualizar(aluno, nomeCompleto, nomeUsuario, senha, email);
	}
	 
	 public boolean remover(String email, String senha) {
		 AlunoBO bo = new AlunoBO();
		 return bo.remover(email, senha);
	 }
	 
	 public static Aluno obterAlunoExistente(String email) {
			AlunoBO bo = new AlunoBO();
			return bo.obterAlunoExistente(email);
	}
}
