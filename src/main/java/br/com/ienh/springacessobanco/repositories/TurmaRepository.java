package br.com.ienh.springacessobanco.repositories;

import br.com.ienh.springacessobanco.entities.Turma;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends CrudRepository<Turma, Integer>{

}
