package api.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.entidades.Cliente;
import api.repositorios.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public void salvar(Cliente c) {
		this.repo.save(c);
		System.out.println("Cliente gravado.");
	}
	
	public void removerTodos() {
		System.out.println("Removendo todos os clientes.");
		this.repo.deleteAll();
	}
}
