package vo;
import javax.swing.*;
import java.util.*;
import java.time.*;

public class Agenda {

	private LocalDate dataSemana;
	private String diaSemana;
	private String mes;
	private String atividade;
	private String emailAluno;
	
	public Agenda(LocalDate dataSemana, String diaSemana, String mes, String atividade, String emailAluno) {
		setDataSemana(dataSemana);
		setDiaSemana(diaSemana);
		setMes(mes);
		setAtividade(atividade);
		setEmailAluno(emailAluno);
	}

	public LocalDate getDataSemana() {
		return dataSemana;
	}

	public void setDataSemana(LocalDate dataSemana2) {
		this.dataSemana = dataSemana2;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public String getEmailAluno() {
		return emailAluno;
	}

	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}
	
	
}
/*id INT AUTO_INCREMENT NOT NULL,
	dataSemana DATE NOT NUll,
    diaSemana VARCHAR(14) NOT NULL,
    atividade VARCHAR(200),
    emailAluno VARCHAR(100) NOT NULL,*/