package api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import api.entidades.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
