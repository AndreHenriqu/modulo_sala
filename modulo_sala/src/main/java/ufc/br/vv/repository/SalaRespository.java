package ufc.br.vv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ufc.br.vv.model.Sala;

public interface SalaRespository extends JpaRepository<Sala, Long>{

}
