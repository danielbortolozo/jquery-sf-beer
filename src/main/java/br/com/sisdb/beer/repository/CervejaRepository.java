package br.com.sisdb.beer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sisdb.beer.model.Cerveja;



@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Long> {

	
}
