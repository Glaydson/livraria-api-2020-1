package api.excecoes;

public class LivroNaoEncontradoException extends RuntimeException {
	
	public LivroNaoEncontradoException(Long id) {
		super("Livro com o id " + id + " não encontrado.");
	}

}
