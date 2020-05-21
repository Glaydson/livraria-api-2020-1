package api.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EditoraComLivrosException extends RuntimeException {

	public EditoraComLivrosException(String nomeEditora) {
		super("A editora " + nomeEditora + " não pode ser excluída porque possui livros associados!");
	}

}
