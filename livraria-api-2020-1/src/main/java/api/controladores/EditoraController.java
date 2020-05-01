package api.controladores;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import api.entidades.Editora;
import api.servicos.EditoraService;

@RestController
@RequestMapping("/editoras")
public class EditoraController {
	
	@Autowired
	private EditoraService servicoEditoras;
	
	@GetMapping("/todos")
	public List<Editora> buscarTodas() {
		return this.servicoEditoras.buscarTodos();
	}
	
	@PostMapping("/novo")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Editora editora) {
		Editora editoraSalva = servicoEditoras.salvar(editora);
		URI local = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(editoraSalva.getEditoraID()).toUri();
		return ResponseEntity.created(local).build();
	}

}
