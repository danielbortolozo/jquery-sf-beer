package br.com.sisdb.beer.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sisdb.beer.model.Estilo;
import br.com.sisdb.beer.repository.EstiloRepository;
import br.com.sisdb.beer.service.exception.NomeEstiloJaCadastradoException;

@Service
public class EstiloService {
	
	@Autowired
	private EstiloRepository repository;
	
	@Transactional
	public Estilo salvar(Estilo estilo) {		
		
		Optional<Estilo> estiloOptional = repository.findByNomeIgnoreCase(estilo.getNome());
		if (estiloOptional.isPresent()) {
			throw new NomeEstiloJaCadastradoException("Nome do estilo já cadastrado");
		}
		return repository.saveAndFlush(estilo);
	}
	
	

}
