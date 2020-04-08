package api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import api.entidades.Editora;
import api.entidades.Livro;
import api.servicos.EditoraService;
import api.servicos.LivroService;

//@SpringBootApplication
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

		System.out.println("GRAVANDO UM LIVRO E UMA EDITORA");
		Livro livro = new Livro("Java Como Programar", LocalDate.of(2017, 8, 20), 250, new BigDecimal("15.00"));
		this.servicoLivros.salvar(livro);
		Editora editora = new Editora("Campus", "Rio de Janeiro", 1970);
		this.servicoEditoras.salvar(editora);
		System.out.println();

		// Buscando um livro pelo seu ID
		System.out.println("BUSCANDO UM LIVRO PELO SEU ID");
		Livro livro1 = this.servicoLivros.buscarPeloID(1L);
		System.out.println(livro1);
		System.out.println();

		// Buscando vários livros pelos seus IDs (1, 3 e 5)
		System.out.println("BUSCANDO VÁRIOS LIVROS PELOS SEUS IDS");
		List<Livro> livros2 = this.servicoLivros.buscarPelosIDs(new ArrayList<Long>() {
			{
				add(1L);
				add(3L);
				add(5L);
			}
		});
		livros2.forEach(System.out::println);
		System.out.println();

		// Alterando o título do livro com o ID 1
		System.out.println("ALTERANDO O TÍTULO DE UM LIVRO");
		Livro livro3 = this.servicoLivros.buscarPeloID(1L);
		System.out.println(livro3);
		livro3.setTitulo("Pro Spring");
		this.servicoLivros.salvar(livro3);
		System.out.println(livro3);
		System.out.println();

		// Removendo dois livros
		System.out.println("REMOVENDO DOIS LIVROS");
		this.servicoLivros.remover(1L);
		this.servicoLivros.remover(this.servicoLivros.buscarPeloID(2L));
		System.out.println();

		System.out.println("PESQUISANDO LIVROS PELO SEU TÍTULO");
		Livro livro5 = this.servicoLivros.buscarPeloTitulo("Guerra e Paz");
		System.out.println(livro5);
		System.out.println();

		System.out.println("BUSCANDO LIVROS PELO TÍTULO COM LIKE");
		List<Livro> livros6 = this.servicoLivros.buscarPeloTituloLike("%de%");
		livros6.forEach(System.out::println);
		System.out.println();

		System.out.println("BUSCANDO LIVROS PELO TÍTULO COM CONTAINS");
		this.servicoLivros.buscarPeloTituloContendo("de").forEach(System.out::println);
		System.out.println();

		System.out.println("BUSCANDO LIVROS COM TITULO INICIANDO EM UMA STRING");
		this.servicoLivros.buscarPeloTituloComecandoCom("Um").forEach(System.out::println);
		System.out.println();

		System.out.println("BUSCANDO LIVROS COM TÍTULO TERMINANDO EM UMA STRING");
		for (Livro l : this.servicoLivros.buscarPeloTituloTerminandoCom("Paz")) {
			System.out.println(l);
		}
		System.out.println();

		System.out.println("BUSCANDO LIVROS PELO TÍTULO, IGNORANDO A CAPITALIZAÇÃO");
		this.servicoLivros.buscarPeloTituloIgnorandoCaixa("GUERRA E PAZ").forEach(System.out::println);
		System.out.println();

		System.out.println("BUSCANDO LIVROS PELO NÚMERO DE PÁGINAS");
		this.servicoLivros.buscarPeloNumeroDePaginas(300).forEach(System.out::println);
		System.out.println();

		System.out.println("BUSCANDO LIVROS COM GREATER THAN, NÚMERO DE PÁGINAS MAIOR QUE");
		this.servicoLivros.buscarPeloNumeroDePaginasMaiorQue(300).forEach(System.out::println);
		System.out.println();

		System.out.println("BUSCANDO LIVROS COM BETWEEN. NÚMERO DE PÁGINAS ENTRE");
		this.servicoLivros.buscarPeloNumeroDePaginasIntervalo(170, 300).forEach(System.out::println);
		System.out.println();

		System.out.println("BUSCANDO LIVROS USANDO CONTAINING OR. TITULO CONTEM UMA OU OUTRA STRING");
		this.servicoLivros.buscarPeloTituloContendoOu("de", "um").forEach(System.out::println);
		System.out.println();

		System.out.println("BUSCANDO LIVROS USANDO NOT. TITULO NÃO CONTÉM A STRING PASSADA");
		this.servicoLivros.buscarPeloTituloDiferenteDe("Guerra e Paz").forEach(System.out::println);
		System.out.println();

		System.out.println("BUSCANDO LIVROS PELO TITULO E NÚMERO DE PÁGINAS");
		this.servicoLivros.buscarPeloTituloContendoENumeroPaginasMaior("de", 200).forEach(System.out::println);
		System.out.println();

		/**
		 * Listar os livros publicados depois de 01/01/1995? 
		 * Listar os livros publicados antes de 31/12/1972? 
		 * Listar os livros publicados entre 01/01/1943 e 15/11/1955?
		 */
		System.out.println("BUSCANDO LIVROS PUBLICADOS APÓS 1/1/1995");
		this.servicoLivros.buscarDataPublicacaoDepoisDe(LocalDate.of(1995, 1, 1)).forEach(System.out::println);
		System.out.println();

		System.out.println("BUSCANDO LIVROS PUBLICADOS ANTES DE 31/12/1972");
		this.servicoLivros.buscarDataPublicacaoAntesDe(LocalDate.of(1972, 12, 31)).forEach(System.out::println);
		System.out.println();

		System.out.println("BUSCANDO LIVROS PUBLICADOS ENTRE 1/1/1943 E 15/11/1955");
		this.servicoLivros.buscarDataPublicacaoEntre(LocalDate.of(1943, 1, 1), LocalDate.of(1955, 11, 15))
				.forEach(System.out::println);
		System.out.println();

		System.out.println("BUSCANDO LIVROS PELO TÍTULO CONTENDO EM ORDEM CRESCENTE");
		this.servicoLivros.buscarLivrosPeloTituloContendoOrdemCrescente("de").forEach(System.out::println);
		System.out.println();

	}

}
