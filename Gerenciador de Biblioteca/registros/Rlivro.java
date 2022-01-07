package registros;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

import dados.*;

public class Rlivro {
	
	private ArrayList<Livros> rL;
	
	public Rlivro() {
		rL = new ArrayList<Livros>();
	}
	public void addLivros(Livros livros) {
		rL.add(livros);
	}
	public Livros getLivro (int indice) {
		return rL.get(indice);
	}
	public void removeLivro(Livros livros) {
		rL.remove(livros);
	}
	public void removeLivro(int indice) {
		rL.remove(indice);
	}
	public int size() {
		return rL.size();
	}
	public void emprestaLivro (Livros livros, Cliente cliente) {
		LocalDateTime now = LocalDateTime.now();
		livros.setDataEmprestimo(now);
		livros.setClienteComLivro(cliente);
	}
	public void ordenaTituloAZ() {
		Collections.sort(rL);
	}

}
