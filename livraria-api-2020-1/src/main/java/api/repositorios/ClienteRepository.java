package api.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import api.entidades.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
