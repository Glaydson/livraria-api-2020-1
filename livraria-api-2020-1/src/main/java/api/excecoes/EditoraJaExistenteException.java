package api.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import api.entidades.Editora;

@ResponseStatus(value = HttpStatus.FOUND)
public class EditoraJaExistenteException extends RuntimeException {

	public EditoraJaExistenteException(Editora editora) {
		super("A editora " + editora.getNome() + " já existe!");
	}

}
