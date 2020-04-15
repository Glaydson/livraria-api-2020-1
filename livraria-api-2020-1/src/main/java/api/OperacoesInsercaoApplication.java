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

//@SpringBootApplication
public class OperacoesInsercaoApplication implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Autowired
	private EditoraService servicoEditoras;
	
	@Autowired
	private AutorService servicoAutores;
	
	@Autowired
	private ClienteService servicoClientes;

	public static void main(String[] args) {
		SpringApplication.run(OperacoesInsercaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Incluindo uma nova editora
		Editora e = new Editora("Érica", "Rio de Janeiro", 1937);

		// Incluindo um novo livro. É preciso dizer qual é a editora
		Livro l = new Livro("Java em 30 dias", LocalDate.now(), 250, new BigDecimal("15.00"), e);


		// Incluindo um novo autor
		Autor antonio = new Autor("Antonio José", "Brasil");
		List<Autor> autores = new ArrayList<>();
		autores.add(antonio);
		
		l.setAutores(autores);
		

		// SALVANDO AS ENTIDADES - OBSERVE A ORDEM
		this.servicoEditoras.salvar(e);
		this.servicoAutores.salvar(antonio);
		this.servicoLivros.salvar(l);
		
		// INSERINDO UM NOVO LIVRO COM EDITORA E AUTOR JÁ EXISTENTES
		
		// Cria um novo livro, editora Campus
		Livro livro2 = new Livro("Java em 90 dias", LocalDate.of(2015, 3, 30), 300, new BigDecimal("50.00"),
		servicoEditoras.buscarPeloNome("Campus"));

		// Busca um autor pelo seu ID
		Autor orsonwelles = servicoAutores.buscarPeloID(1L);

		List<Autor> autoreslivro2 = new ArrayList<>();
		autores.add(orsonwelles);
		
		livro2.setAutores(autoreslivro2);

		// Salva as alterações no livro
		this.servicoLivros.salvar(livro2);
		
		
		// OPERAÇÕES USANDO MONGODB
		// INSERINDO ALGUNS CLIENTES
		servicoClientes.removerTodos();
		Endereco end1 = new Endereco("Rua 1", 34, "Fortaleza", "60.000-300");
		Endereco end2 = new Endereco("Rua 2", 100, "Manaus", "92.000-300");
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(end1);
		enderecos.add(end2);
		Cliente cli1 = new Cliente("Ana Paula", "anapaula@hotmail.com", LocalDate.of(2000, 6, 20), enderecos);
		Cliente cli2 = new Cliente("João Paulo", "joaopaulo@hotmail.com", LocalDate.of(1998, 4, 2), enderecos);
		servicoClientes.salvar(cli1);
		servicoClientes.salvar(cli2);

		
	}

}
