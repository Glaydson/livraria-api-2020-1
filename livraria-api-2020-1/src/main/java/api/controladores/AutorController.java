package api.controladores;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import api.entidades.Autor;
import api.excecoes.AutorNaoEncontradoException;
import api.servicos.AutorService;




@RestController
@RequestMapping("/autores")
@CrossOrigin(origins="http://localhost:8080")
public class AutorController {

	@Autowired
	private AutorService servicoAutores;

	@GetMapping("/todos")
	public List<Autor> buscarTodos() {
		return this.servicoAutores.buscarTodos();
	}

	@GetMapping("/{id}")
	public Autor buscarPeloID(@PathVariable Long id) {
		return servicoAutores.buscarPeloID(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAutor(@PathVariable("id") Long id) {
		servicoAutores.remover(id);
		return new ResponseEntity<>("Autor foi removido!", HttpStatus.OK);
	}

	@PostMapping("/novo")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Autor autor) {
		Autor autorSalvo = servicoAutores.salvar(autor);
		URI local = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(autorSalvo.getAutorID()).toUri();
		return ResponseEntity.created(local).build();
	}

	@PutMapping("/atualiza/{id}")
	public ResponseEntity<Object> atualizaAutor(@RequestBody Autor autor, @PathVariable long id) {
		try {
			Autor autorBD = servicoAutores.buscarPeloID(id);
		} catch (AutorNaoEncontradoException anee) {
			return ResponseEntity.notFound().build();
		}
		autor.setAutorID(id);
		servicoAutores.salvar(autor);
		return ResponseEntity.noContent().build();
	}

}
