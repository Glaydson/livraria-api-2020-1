package api.servicos;

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
    }


}
