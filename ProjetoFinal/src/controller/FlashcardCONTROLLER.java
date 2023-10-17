package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import bo.FlashcardBO;
import vo.Flashcard;
import vo.Olimpiada;

public class FlashcardCONTROLLER {
	public boolean cadastrar(String titulo, String resumo, String palavrasChave, BufferedImage imagem, String emailProf) {
		FlashcardBO bo = new FlashcardBO();
		Flashcard flash = new Flashcard(titulo, resumo, palavrasChave, imagem, emailProf);
		return bo.cadastrar(flash);
	}
	
	public boolean relacionarComOlimp(Olimpiada olimp, String titulo) {
		FlashcardBO bo = new FlashcardBO();
		return bo.relacionarComOlimp(olimp, titulo);
	}
	
	public ArrayList retornaFlashOlimpiada(Olimpiada olimp) {
		FlashcardBO bo = new FlashcardBO();
        return bo.retornaFlashOlimpiada(olimp);
    }
	
	public ArrayList<Flashcard> consultarFlashcardsPorTitulo(String tituloFlash, Olimpiada olimp) {
		FlashcardBO bo = new FlashcardBO();
	    return bo.consultarFlashcardsPorTitulo(tituloFlash, olimp);
	}
	
	public Flashcard obterFlashExistente(String titulo) {
		FlashcardBO bo = new FlashcardBO();
        return bo.obterFlashExistente(titulo);
    }
}
