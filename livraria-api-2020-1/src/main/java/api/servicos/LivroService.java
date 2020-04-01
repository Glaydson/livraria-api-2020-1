package api.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.entidades.Livro;
import api.repositorios.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
    private LivroRepository repo;

    public void salvar(Livro livro) {
        this.repo.save(livro);
        System.out.println("Livro " + livro.getTitulo() + " gravado.");
    }

    public Livro buscarPeloID(long idLivro) {
        return this.repo.findById(idLivro).get();
    }

    public List<Livro> buscarTodos() {
    	return this.repo.findAll();
    }
    
    public void remover(Long idLivro) {
    	this.repo.deleteById(idLivro);
        System.out.println("Livro " + idLivro + " removido.");
    }
    
    public void remover(Livro livro) {
    	this.repo.delete(livro);
        System.out.println("Livro " + livro.getTitulo() + " removido.");

    }
    
    public Livro buscarPeloTitulo(String titulo) {
        return this.repo.findByTitulo(titulo);
    }


}
