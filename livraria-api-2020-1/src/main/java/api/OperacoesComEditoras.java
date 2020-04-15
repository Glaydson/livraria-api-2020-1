package api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import api.entidades.Autor;
import api.entidades.Cliente;
import api.entidades.Editora;
import api.entidades.Endereco;
import api.entidades.Livro;
import api.servicos.AutorService;
import api.servicos.ClienteService;
import api.servicos.EditoraService;
import api.servicos.LivroService;

@SpringBootApplication
public class OperacoesComEditoras implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Autowired
	private EditoraService servicoEditoras;
	
	@Autowired
	private AutorService servicoAutores;
	
	@Autowired
	private ClienteService servicoClientes;

	public static void main(String[] args) {
		SpringApplication.run(OperacoesComEditoras.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Listar todas as editoras
		List<Editora> editoras = servicoEditoras.buscarTodos();
		editoras.forEach(System.out::println);
		
		// Alterar a cidade da Editora Bookman
		Editora bookman = servicoEditoras.buscarPeloNome("Bookman");
		bookman.setCidade("Porto Alegre");
		servicoEditoras.salvar(bookman);
		System.out.println(bookman);

		// Remover a editora Pearson
		Editora pearson = servicoEditoras.buscarPeloNome("Pearson");
		servicoEditoras.remover(pearson);
		
		//Buscar editoras com sede no rio de janeiro
		System.out.println("**** EDITORAS DO RIO DE JANEIRO ****");
		List<Editora> editorasRio = servicoEditoras.buscarPelaSede("Rio de Janeiro");
		editorasRio.forEach(System.out::println);
		
		// Todos os livros da editora bookman
		System.out.println("**** LIVROS DA EDITORA BOOKMAN ****");
		List<Livro> livrosBookman = servicoLivros.buscarPelaEditora("Bookman");
		livrosBookman.forEach(System.out::println);

		
	}

}
