package api.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.entidades.Editora;
import api.excecoes.EditoraComLivrosException;
import api.excecoes.EditoraJaExistenteException;
import api.excecoes.EditoraNaoEncontradaException;
import api.repositorios.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repo;

	public Editora salvar(Editora editora) {
		// Verificar se a editora já existe, pelo seu nome
		Editora editoraBD = this.buscarPeloNome(editora.getNome());
		if (editoraBD != null)
			throw new EditoraJaExistenteException(editora);

		return this.repo.save(editora);
		// System.out.println("Editora " + editora.getNome() + " gravada.");
	}

	// Método específico para alteração, para evitar o lançamento de exceção
	// EditoraJaExistente
	public Editora alterar(Editora e) {
		System.out.printf("Editora %s alterada!%n", e.getNome());
		return this.repo.save(e);
	}

	public Editora buscarPeloID(Long id) {
		Optional<Editora> editora = this.repo.findById(id);
		if (!editora.isPresent()) {
			throw new EditoraNaoEncontradaException(id);
		}
		return this.repo.findById(id).get();
	}

	public List<Editora> buscarTodos() {
		System.out.println("OBTENDO A LISTA COMPLETA DE EDITORAS");
		return this.repo.findAll();
	}

	public Editora buscarPeloNome(String nome) {
		return this.repo.findByNome(nome);
	}

	public void remover(Editora e) {
		Editora editoraBD = this.buscarPeloID(e.getEditoraID());
		if (e.getLivros().isEmpty()) {
			this.repo.delete(e);
			System.out.printf("Editora %s removida!%n", e.getNome());
		} else {
			throw new EditoraComLivrosException(e.getNome());
		}
	}

	public void remover(Long idEditora) {
		Editora editoraBD = this.buscarPeloID(idEditora);
		this.remover(editoraBD);

	}

	public List<Editora> buscarNomeIniciandoPor(String nome1, String nome2) {
		return this.repo.findByNomeStartingWithOrNomeStartingWith(nome1, nome2);
	}

	public List<Editora> buscarPelaSede(String cidade) {
		return this.repo.findByCidade(cidade);
	}

}
