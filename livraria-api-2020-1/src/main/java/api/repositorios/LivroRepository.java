package api.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import api.entidades.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	// PESQUISAS COM CAMPOS STRING
		public Livro findByTitulo(String titulo);

		public List<Livro> findByTituloLike(String titulo);

		public List<Livro> findByTituloContaining(String titulo);

		public List<Livro> findByTituloStartingWith(String titulo);

		public List<Livro> findByTituloEndingWith(String titulo);

		public List<Livro> findByTituloIgnoreCase(String titulo);

		// PESQUISAS COM CAMPOS NUMÉRICOS - OPERADORES RELACIONAIS
		public List<Livro> findByNumeroPaginasEquals(int numeroPaginas);

		public List<Livro> findByNumeroPaginasGreaterThan(int numeroPaginas);

		public List<Livro> findByNumeroPaginasBetween(int min, int max);

		// PESQUISAS COM OPERADORES LÓGICOS
		public List<Livro> findByTituloContainingOrTituloContaining(String titulo1,
				String titulo2);

		public List<Livro> findByTituloNot(String titulo);

		public List<Livro> findByTituloContainingAndNumeroPaginasGreaterThan(
				String titulo, int numeroPaginas);

		// PESQUISAS COM DATAS
		public List<Livro> findByDataPublicacaoAfter(LocalDate data);

		public List<Livro> findByDataPublicacaoBefore(LocalDate data);

		public List<Livro> findByDataPublicacaoBetween(LocalDate data1,
				LocalDate data2);

		// ORDENAÇÃO
		public List<Livro> findByTituloContainingOrderByTituloAsc(String titulo);

		public List<Livro> findByTituloContainingOrderByTituloDesc(String titulo);
		
		// CONSULTAS ENVOLVENDO OUTRA TABELA
		public List<Livro> findByAutoresNome(String nome);
		
		public List<Livro> findByAutoresPais(String pais);

		
}
