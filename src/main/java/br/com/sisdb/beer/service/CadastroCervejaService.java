package br.com.sisdb.beer.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import br.com.sisdb.beer.model.Cerveja;
import br.com.sisdb.beer.repository.CervejaRepository;



@Service
public class CadastroCervejaService {

	@Autowired
	private CervejaRepository cervejas;
	
	@Transactional
	public void salvar(Cerveja cerveja) {
		cervejas.save(cerveja);
	}
	
	
}
