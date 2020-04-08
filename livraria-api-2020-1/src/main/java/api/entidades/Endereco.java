package api.entidades;

import lombok.Data;

@Data
public class Endereco {

	private String rua;
	private int numero;
	private String cidade;
	private String cep;

	public Endereco(String rua, int numero, String cidade, String cep) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.cep = cep;
	}

}
