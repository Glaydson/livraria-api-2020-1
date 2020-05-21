package api.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AutorNaoEncontradoException extends RuntimeException {

	public AutorNaoEncontradoException(Long idAutor) {
		super("Autor com o id " + idAutor + " não encontrado.");
	}

}
