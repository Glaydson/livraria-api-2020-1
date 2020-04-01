package api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import api.entidades.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	Livro findByTitulo(String titulo);

}
