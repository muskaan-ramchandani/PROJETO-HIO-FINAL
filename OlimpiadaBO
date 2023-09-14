package bo;

import dao.OlimpiadaDAO;
import vo.Olimpiada;

public class OlimpiadaBO {

	public boolean consultar(String nome) {
		OlimpiadaDAO dao = new OlimpiadaDAO();
		return dao.consultar(nome);
	}
	
	public static Olimpiada obterOlimpiadaExistente(String nome) {
		OlimpiadaDAO dao = new OlimpiadaDAO();
		return dao.obterOlimpiadaExistente(nome);
	}
}
