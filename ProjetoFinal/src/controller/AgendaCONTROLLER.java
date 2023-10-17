package controller;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import bo.AgendaBO;
import vo.Agenda;

public class AgendaCONTROLLER {
	public void iniciarAgenda(LocalDate dataSemana, String diaSemana, String mes, String emailAluno) {
		AgendaBO bo = new AgendaBO();
		bo.iniciarAgenda(dataSemana, diaSemana, mes, emailAluno);
	}
	
	public boolean adicionarAtividade(String atividade, LocalDate dataSemana,String diaSemana,String mes, String emailAluno) {
		AgendaBO bo = new AgendaBO();
		return bo.adicionarAtividade(atividade, dataSemana,diaSemana, mes, emailAluno);
	}
	
	public ArrayList<String> retornaAtividadesDeUmaData(LocalDate dataSemana, String emailAluno){
		AgendaBO bo = new AgendaBO();
		return bo.retornaAtividadesDeUmaData(dataSemana, emailAluno);
	}
	
	public boolean atualizarSemana(String emailAluno, LocalDate dataSemana, String diaSemana, String mes) {
		AgendaBO bo = new AgendaBO();
		return bo.atualizarSemana(emailAluno, dataSemana, diaSemana, mes);
	}
	public boolean deletarAgenda(String emailAluno) {
		AgendaBO bo = new AgendaBO();
		return bo.deletarAgenda(emailAluno);
	}
	
	public ArrayList<Agenda> retornaAgendaExistente(String emailAluno) {
		AgendaBO bo = new AgendaBO();
		return bo.retornaAgendaExistente(emailAluno);
	}
	
	public boolean deletarAtividade(String atividade, LocalDate data, String emailAluno) {
		AgendaBO bo = new AgendaBO();
		return bo.deletarAtividade(atividade, data, emailAluno);
	}
	
	public boolean editarAtividade(String atividadeAtual, LocalDate data, String emailAluno, String novaAtividade) {
		AgendaBO bo = new AgendaBO();
		return bo.editarAtividade(atividadeAtual, data, emailAluno, novaAtividade);
	}
}
