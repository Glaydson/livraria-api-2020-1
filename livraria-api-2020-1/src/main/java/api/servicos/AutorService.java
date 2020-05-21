package api.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.entidades.Autor;
import api.repositorios.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repo;

	/* MÉTODOS CRUD */

	public Autor salvar(Autor autor) {
		System.out.println("AUTOR " + autor.getAutorID() + " SALVO!");
		return this.repo.save(autor);
	}

	public List<Autor> buscarTodos() {
		System.out.println("OBTENDO A LISTA COMPLETA DE AUTORES");
		return this.repo.findAll();
	}

	public Autor buscarPeloID(Long idAutor) {
		System.out.println("OBTENDO O AUTOR COM O ID = " + idAutor);
		Optional<Autor> autor = this.repo.findById(idAutor);
		if (!autor.isPresent())
			throw new api.excecoes.AutorNaoEncontradoException(idAutor);
		return autor.get();
	}

	public List<Autor> buscarPelosIDs(ArrayList<Long> idsAutores) {
		System.out.println("OBTENDO OS AUTORES COM OS IDS " + idsAutores.toString());
		return this.repo.findAllById(idsAutores);
	}

	public void remover(Long idAutor) {
		this.repo.deleteById(idAutor);
		System.out.println("REMOVIDO O AUTOR COM ID = " + idAutor);
	}

	public void remover(Autor autor) {
		Autor autorBD = this.buscarPeloID(autor.getAutorID());
		if (autor.getLivros().isEmpty()) {
			this.repo.delete(autor);
			System.out.printf("Autor %s removido!%n", autor.getNome());
		} else {
			throw new api.excecoes.AutorComLivrosException(autor.getNome());
		}
	}

}
