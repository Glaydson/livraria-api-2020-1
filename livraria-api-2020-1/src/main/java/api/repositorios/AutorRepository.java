package api.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import api.entidades.Autor;
import api.entidades.Livro;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	
	// Todos os autores de um dado livro
	List<Autor> findByLivrosTitulo(String tituloLivro);

}
