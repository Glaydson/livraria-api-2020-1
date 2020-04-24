package api.controladores;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import api.entidades.Livro;
import api.servicos.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService servicoLivros;

	@GetMapping("/todos")
	public List<Livro> buscarTodos() {
		return this.servicoLivros.buscarTodos();
	}

	@GetMapping("/{id}")
	public Livro buscarPeloID(@PathVariable Long id) {
		return servicoLivros.buscarPeloID(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteLivro(@PathVariable("id") Long id) {
		servicoLivros.remover(id);
		return new ResponseEntity<>("Livro foi removido!", HttpStatus.OK);
	}

	@PostMapping("/novo")
	public ResponseEntity<Object> salvar(@RequestBody Livro livro) {
		Livro livroSalvo = servicoLivros.salvar(livro);
		URI local = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(livroSalvo.getLivroID()).toUri();
		return ResponseEntity.created(local).build();
	}

}
