package api.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AutorComLivrosException extends RuntimeException {

	public AutorComLivrosException(String nomeAutor) {
		super("O autor " + nomeAutor + " não pode ser excluído porque possui livros associados!");
	}

}
