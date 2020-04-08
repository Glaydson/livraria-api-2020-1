package api.servicos;

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

}
