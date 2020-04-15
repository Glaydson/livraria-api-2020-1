package api.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.entidades.Editora;
import api.repositorios.EditoraRepository;

@Service
public class EditoraService {
	
	@Autowired
    private EditoraRepository repo;

    public void salvar(Editora editora) {
        this.repo.save(editora);
        System.out.println("Editora " + editora.getNome() + " gravada.");
    }

    public Editora buscarPeloNome(String nome) {
    	return this.repo.findByNome(nome);
    }
    
    public List<Editora> buscarTodos() {
    	return this.repo.findAll();
    }
    
    public void remover(Editora editora) {
    	this.repo.delete(editora);
    }
    
    public void remover(Long idEditora) {
    	this.repo.deleteById(idEditora);
    }
    
    public List<Editora> buscarPelaSede(String cidade) {
    	return this.repo.findByCidade(cidade);
    }

}
