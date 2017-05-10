package ufc.br.vv.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.br.vv.model.Sala;
import ufc.br.vv.repository.SalaRespository;

@Service
public class DefaultSalaService implements SalaService {
	
	@Autowired
	private SalaRespository salarepository;
	
	@Override
	public Sala save(Sala entity) {
		// TODO Auto-generated method stub
		return salarepository.save(entity);
	}

	@Override
	public Sala getById(Serializable id) {
		// TODO Auto-generated method stub
		return salarepository.findOne((Long) id);
	}

	@Override
	public List<Sala> getAll() {
		// TODO Auto-generated method stub
		return salarepository.findAll();
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		salarepository.delete((Long) id);
		
	}
	
}
