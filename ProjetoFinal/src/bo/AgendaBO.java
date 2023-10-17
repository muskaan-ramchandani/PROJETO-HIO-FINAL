package bo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import conexaoBD.Conexao;
import dao.AgendaDAO;
import vo.Agenda;
	
public class AgendaBO {
	
	public void iniciarAgenda(LocalDate dataSemana, String diaSemana, String mes, String emailAluno) {
		AgendaDAO dao = new AgendaDAO();
		dao.iniciarAgenda(dataSemana, diaSemana, mes, emailAluno);
	}
	
	public boolean adicionarAtividade(String atividade, LocalDate dataSemana, String diaSemana, String mes, String emailAluno) {
		AgendaDAO dao = new AgendaDAO();
		return dao.adicionarAtividade(atividade, dataSemana, diaSemana, mes, emailAluno);
	}
	
	public ArrayList<String> retornaAtividadesDeUmaData(LocalDate dataSemana, String emailAluno){
		AgendaDAO dao = new AgendaDAO();
		return dao.retornaAtividadesDeUmaData(dataSemana, emailAluno);
	}
	
	public boolean atualizarSemana(String emailAluno, LocalDate dataSemana, String diaSemana, String mes) {
		AgendaDAO dao = new AgendaDAO();
		return dao.atualizarSemana(emailAluno, dataSemana, diaSemana, mes);
	}
	
	public boolean deletarAgenda(String emailAluno) {
		AgendaDAO dao = new AgendaDAO();
		return dao.deletarAgenda(emailAluno);
	}
	
	public ArrayList<Agenda> retornaAgendaExistente(String emailAluno) {
		AgendaDAO dao = new AgendaDAO();
		return dao.retornaAgendaExistente(emailAluno);
	}
	
	public boolean deletarAtividade(String atividade, LocalDate data, String emailAluno) {
		AgendaDAO dao = new AgendaDAO();
		return dao.deletarAtividade(atividade, data, emailAluno);
	}
	
	public boolean editarAtividade(String atividadeAtual, LocalDate data, String emailAluno, String novaAtividade) {
		AgendaDAO dao = new AgendaDAO();
		return dao.editarAtividade(atividadeAtual, data, emailAluno, novaAtividade);
	}
}
