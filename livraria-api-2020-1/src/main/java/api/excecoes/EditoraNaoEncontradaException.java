package api.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EditoraNaoEncontradaException extends RuntimeException {

	public EditoraNaoEncontradaException(Long idEditora) {
		super("Editora com o id " + idEditora + " não encontrada.");
	}

}
