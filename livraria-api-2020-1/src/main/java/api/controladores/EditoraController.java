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

import api.entidades.Editora;
import api.excecoes.EditoraNaoEncontradaException;
import api.servicos.EditoraService;

@RestController
@RequestMapping("/editoras")
@CrossOrigin(origins = "http://localhost:8080")
public class EditoraController {
	
	@Autowired
	private EditoraService servicoEditoras;
	
	@GetMapping("/todos")
	public List<Editora> buscarTodas() {
		return this.servicoEditoras.buscarTodos();
		
	}
	
	@GetMapping("/{id}")
	public Editora buscarPeloID(@PathVariable Long id) {
		return servicoEditoras.buscarPeloID(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEditora(@PathVariable("id") Long id) {
		servicoEditoras.remover(id);
		return new ResponseEntity<>("Editora foi removida!", HttpStatus.OK);
	}
	
	@PostMapping("/novo")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Editora editora) {
		Editora editoraSalva = servicoEditoras.salvar(editora);
		URI local = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(editoraSalva.getEditoraID()).toUri();
		return ResponseEntity.created(local).build();
	}

	@PutMapping("/atualiza/{id}")
	public ResponseEntity<Object> atualizaEditora(@RequestBody Editora editora, @PathVariable long id) {
		try {
			Editora editoraBD = servicoEditoras.buscarPeloID(id);
		} catch (EditoraNaoEncontradaException enee) {
			return ResponseEntity.notFound().build();
		}
		editora.setEditoraID(id);
		servicoEditoras.alterar(editora);
		return ResponseEntity.noContent().build();
	}
}
