package api.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_LIVROS")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIVRO_ID")
	private Long livroID;

	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "DATA_PUBLICACAO")
	private LocalDate dataPublicacao;

	@Column(name = "NUMERO_PAGINAS")
	private int numeroPaginas;

	@Column(name = "PRECO")
	private BigDecimal preco;

	@ManyToOne()
	@JoinColumn(name = "EDITORA_ID")
	private Editora editora;

	@ManyToMany()
	@JoinTable(name = "TB_AUTORES_LIVROS")
	private List<Autor> autores;

	public Livro() {
	}

	public Livro(String titulo, LocalDate dataPublicacao, int numeroPaginas, BigDecimal preco) {
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
		this.numeroPaginas = numeroPaginas;
		this.preco = preco;
	}
	
	public Livro(String titulo, LocalDate dataPublicacao, int numeroPaginas, BigDecimal preco, Editora editora) {
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
		this.numeroPaginas = numeroPaginas;
		this.preco = preco;
		this.editora = editora;
	}

	@Override
	public String toString() {
		return "Livro [livroId=" + livroID + ", título=" + titulo + ", data de publicação=" + dataPublicacao
				+ ", número de Páginas=" + numeroPaginas + ", preço=" + preco + "]";
	}

}
