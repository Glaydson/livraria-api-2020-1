package api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import api.entidades.Editora;
import api.entidades.Livro;
import api.servicos.EditoraService;
import api.servicos.LivroService;

@SpringBootApplication
public class LivrariaApi20201Application implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Autowired
	private EditoraService servicoEditoras;

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApi20201Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Livro livro = new Livro("Java Como Programar", LocalDate.of(2017, 8, 20), 250, new BigDecimal("15.00"));
		this.servicoLivros.salvar(livro);

		Editora editora = new Editora("Campus", "Rio de Janeir0", 1990);
		this.servicoEditoras.salvar(editora);

		// Buscando um livro pelo seu ID
		Livro livro1 = this.servicoLivros.buscarPeloID(1L);
		System.out.println(livro1);

		// Buscando todos os livros
		List<Livro> todosLivros = this.servicoLivros.buscarTodos();
		todosLivros.forEach(System.out::println);

		// Alterando o título do livro com o ID 1
		Livro livro3 = this.servicoLivros.buscarPeloID(1L);
		System.out.println(livro3);
		livro3.setTitulo("Pro Spring");
		this.servicoLivros.salvar(livro3);
		System.out.println(livro3);

		// Removendo dois livros
		this.servicoLivros.remover(1L);
		this.servicoLivros.remover(this.servicoLivros.buscarPeloID(2L));
		
		// Buscar um livro pelo seu título
		System.out.println(this.servicoLivros.buscarPeloTitulo("Java Como Programar"));

	}

}
