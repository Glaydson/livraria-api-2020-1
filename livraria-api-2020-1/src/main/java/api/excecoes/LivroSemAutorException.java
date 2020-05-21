package api.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LivroSemAutorException extends RuntimeException {

	public LivroSemAutorException(String titulo) {
		super("O livro " + titulo + " precisa ter pelo menos um autor");
	}

}
