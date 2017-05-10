package ufc.br.vv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Sala implements java.io.Serializable {
	
	private static final long serialVersionUID = 4910225916550731446L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	private Integer capacidade;
	private Integer numero;
	
	public Sala(){}
	
	public Sala(Long id){
		this.id = id;
	}
	
	public Sala(Long id, Integer capacidade, Integer numero){
		this.id = id;
		this.capacidade = capacidade;
		this.numero  = numero;
	}
	
	public Sala(Integer capacidade, Integer numero){
		this.capacidade = capacidade;
		this.numero  = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	@Override
	public String toString() {
		return "Sala [id=" + id + ", capacidade=" + capacidade + ", numero=" + numero + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capacidade == null) ? 0 : capacidade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (capacidade == null) {
			if (other.capacidade != null)
				return false;
		} else if (!capacidade.equals(other.capacidade))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	

}
