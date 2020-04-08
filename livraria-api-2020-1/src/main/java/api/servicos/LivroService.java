package api.servicos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.entidades.Livro;
import api.repositorios.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
    private LivroRepository repoLivros;

    public void salvar(Livro livro) {
        this.repoLivros.save(livro);
        System.out.println("Livro " + livro.getTitulo() + " gravado.");
    }

    public Livro buscarPeloID(long idLivro) {
        return this.repoLivros.findById(idLivro).get();
    }

    public List<Livro> buscarPelosIDs(ArrayList<Long> idsLivros) {
		return this.repoLivros.findAllById(idsLivros);
	}

	public List<Livro> buscarTodos() {
		return this.repoLivros.findAll();
	}

	public void remover(Long idLivro) {
		// Se o livro não for encontrado, será lançada exceção para a interface
		Livro livroBD = this.buscarPeloID(idLivro);
		this.repoLivros.deleteById(idLivro);
	}

	public void remover(Livro livro) {
		// Se o livro não for encontrado, será lançada exceção para a interface
		Livro livroBD = this.buscarPeloID(livro.getLivroID());
		this.repoLivros.delete(livro);
	}

	public Livro buscarPeloTitulo(String titulo) {
		return this.repoLivros.findByTitulo(titulo);
	}

	public List<Livro> buscarPeloTituloLike(String titulo) {
		return this.repoLivros.findByTituloLike(titulo);
	}

	public List<Livro> buscarPeloTituloContendo(String titulo) {
		return this.repoLivros.findByTituloContaining(titulo);
	}

	public List<Livro> buscarPeloTituloComecandoCom(String titulo) {
		return this.repoLivros.findByTituloStartingWith(titulo);
	}

	public List<Livro> buscarPeloTituloTerminandoCom(String titulo) {
		return this.repoLivros.findByTituloEndingWith(titulo);
	}

	public List<Livro> buscarPeloTituloIgnorandoCaixa(String titulo) {
		return this.repoLivros.findByTituloIgnoreCase(titulo);
	}

	public List<Livro> buscarPeloNumeroDePaginas(int numeroPaginas) {
		return this.repoLivros.findByNumeroPaginasEquals(numeroPaginas);
	}

	public List<Livro> buscarPeloNumeroDePaginasMaiorQue(int numeroPaginas) {
		return this.repoLivros.findByNumeroPaginasGreaterThan(numeroPaginas);
	}

	public List<Livro> buscarPeloNumeroDePaginasIntervalo(int min, int max) {
		return this.repoLivros.findByNumeroPaginasBetween(min, max);
	}

	public List<Livro> buscarPeloTituloContendoOu(String titulo1, String titulo2) {
		return this.repoLivros.findByTituloContainingOrTituloContaining(titulo1, titulo2);
	}

	public List<Livro> buscarPeloTituloDiferenteDe(String titulo) {
		return this.repoLivros.findByTituloNot(titulo);
	}

	public List<Livro> buscarPeloTituloContendoENumeroPaginasMaior(String titulo, int numeroPaginas) {
		return this.repoLivros.findByTituloContainingAndNumeroPaginasGreaterThan(titulo, numeroPaginas);
	}

	public List<Livro> buscarDataPublicacaoAntesDe(LocalDate data) {
		return this.repoLivros.findByDataPublicacaoBefore(data);
	}

	public List<Livro> buscarDataPublicacaoDepoisDe(LocalDate data) {
		return this.repoLivros.findByDataPublicacaoAfter(data);
	}

	public List<Livro> buscarDataPublicacaoEntre(LocalDate data1, LocalDate data2) {
		return this.repoLivros.findByDataPublicacaoBetween(data1, data2);
	}

	public List<Livro> buscarLivrosPeloTituloContendoOrdemCrescente(String titulo) {
		return this.repoLivros.findByTituloContainingOrderByTituloAsc(titulo);
	}

}