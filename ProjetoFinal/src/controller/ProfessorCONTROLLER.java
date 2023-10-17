package controller;
import javax.swing.*;
import java.awt.*;

import bo.AlunoBO;
import bo.ProfessorBO;
import vo.Aluno;
import vo.Professor;

public class ProfessorCONTROLLER {
	
	public void cadastrar(String nomeCompleto, String nomeUsuario, String email, String senha) {
		ProfessorBO bo = new ProfessorBO();
		bo.cadastrar(nomeCompleto, nomeUsuario, email, senha);
	}
	
	public boolean consultar(String email, String senha) {
		ProfessorBO bo = new ProfessorBO();
		return bo.consultar(email, senha);
	}

	public boolean atualizar(Professor prof, String nomeCompleto, String nomeUsuario, String senha, String email) {
		ProfessorBO bo = new ProfessorBO();
		return bo.atualizar(prof, nomeCompleto, nomeUsuario, senha, email);
	}
	
	public boolean atualizarSenha(Professor prof, String senha, String email) {
		ProfessorBO bo = new ProfessorBO();
		return bo.atualizarSenha(prof, senha, email);
	}
	
	public boolean remover(String email, String senha) {
		ProfessorBO bo = new ProfessorBO();
		return bo.remover(email, senha);
	 }
	
	public static Professor obterProfExistente(String email) {
		ProfessorBO bo = new ProfessorBO();
		return bo.obterProfExistente(email);
	}
}
