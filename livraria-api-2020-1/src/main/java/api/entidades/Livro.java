package api.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_LIVROS")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIVRO_ID")
	private Long livroID;

	@Column(name = "TITULO", nullable = false)
	@NotNull
	@Size(min=2, message="O título precisa ter pelo menos 2 caracteres")
	@Size(max=50, message="O título só pode ter no máximo 50 caracteres")
	private String titulo;

	@Column(name = "DATA_PUBLICACAO")
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate dataPublicacao;

	@Column(name = "NUMERO_PAGINAS")
	@Min(value = 50, message="Um livro deve ter pelo menos 50 páginas")
	private int numeroPaginas;

	@Column(name = "PRECO")
	private BigDecimal preco;

	@ManyToOne()
	@JoinColumn(name = "EDITORA_ID")
	@JsonIgnoreProperties("livros")
	private Editora editora;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "TB_AUTORES_LIVROS")
	@JsonIgnoreProperties("livros")
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
