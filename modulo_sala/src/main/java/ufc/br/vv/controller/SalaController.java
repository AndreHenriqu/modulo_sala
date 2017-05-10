package ufc.br.vv.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import ufc.br.vv.model.Sala;
import ufc.br.vv.service.SalaService;



@RestController
@RequestMapping("/sala")
public class SalaController {
	
	final static Logger logger = Logger.getLogger(SalaController.class);
	
	@Autowired
	SalaService salaservice;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Sala> addSala(@RequestBody Sala sala){
		salaservice.save(sala);
		logger.debug("Adicionado: " + sala);
		return new ResponseEntity<Sala>(sala, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateSala(@RequestBody Sala sala) {
		Sala existingSala = salaservice.getById(sala.getId());
		if (existingSala == null) {
			logger.debug("Sala de id " + sala.getId() + " não existe");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			salaservice.save(sala);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Sala> getSala(@PathVariable("id") Long id) {
		Sala sala = salaservice.getById(id);
		if (sala == null) {
			logger.debug("Sala de id " + id + " não existe");
			return new ResponseEntity<Sala>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Sala encontrada: " + sala);
		return new ResponseEntity<Sala>(sala, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Sala>> getAllEmployees() {
		List<Sala> salas = salaservice.getAll();
		if (salas.isEmpty()) {
			logger.debug("Não existems salas");
			return new ResponseEntity<List<Sala>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + salas.size() + " Employees");
		logger.debug(Arrays.toString(salas.toArray()));
		return new ResponseEntity<List<Sala>>(salas, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteSala(@PathVariable("id") Long id) {
		Sala sala = salaservice.getById(id);
		if (sala == null) {
			logger.debug("Sala de id " + id + "não existe");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			salaservice.delete(id);
			logger.debug("Sala de id " + id + " deletada");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
}
