package ufc.br.vv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Sala {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer capacidade;
	private Integer numero;
	
	public Sala(Integer capacidade, Integer numero){
		this.capacidade = capacidade;
		this.numero  = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	

}
