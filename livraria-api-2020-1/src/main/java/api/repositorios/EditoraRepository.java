package api.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import api.entidades.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
	
	public Editora findByNome(String nome);
	
	public List<Editora> findByCidade(String cidade);
	
	public List<Editora> findByNomeStartingWithOrNomeStartingWith(String nome1, String nome2);
	
	public List<Editora> findByCidadeAndCidade(String cidade1, String cidade2);


}
