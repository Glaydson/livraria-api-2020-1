package api.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LivroNaoEncontradoException extends RuntimeException {
	
	
	public LivroNaoEncontradoException(Long id) {
		super("Livro com o id " + id + " não encontrado.");
	}

}
