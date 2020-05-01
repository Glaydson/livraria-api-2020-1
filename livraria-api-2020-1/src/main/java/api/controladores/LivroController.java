package api.controladores;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import api.entidades.Livro;
import api.excecoes.LivroNaoEncontradoException;
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
	public ResponseEntity<Object> salvar(@Valid @RequestBody Livro livro) {
		Livro livroSalvo = servicoLivros.salvar(livro);
		URI local = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(livroSalvo.getLivroID()).toUri();
		return ResponseEntity.created(local).build();
	}

	@PutMapping("/atualiza/{id}")
	public ResponseEntity<Object> atualizaLivro(@RequestBody Livro livro, @PathVariable long id) {
		try {
			Livro livroBD = servicoLivros.buscarPeloID(id);
		} catch (LivroNaoEncontradoException lnee) {
			return ResponseEntity.notFound().build();
		}
		livro.setLivroID(id);
		servicoLivros.salvar(livro);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/numeroPaginas/maior")
	public List<Livro> buscarPeloNumeroPaginasMaior(@RequestParam int numeroPaginas) {
		return this.servicoLivros.buscarPeloNumeroDePaginasMaiorQue(numeroPaginas);
	}
	
	@GetMapping("/numeroPaginas/entre/{min}/{max}")
	public List<Livro> buscarPeloNumeroPaginasIntervalo(@PathVariable int min, @PathVariable int max) {
		return this.servicoLivros.buscarPeloNumeroDePaginasIntervalo(min, max);
	}

	@GetMapping("/dataPublicacaoEntre")
	public List<Livro> buscarPorDataPublicacaoEntre(
		@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataInicial,
		@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataFinal) {
	     return this.servicoLivros.buscarDataPublicacaoEntre(dataInicial, dataFinal);
	}


}
