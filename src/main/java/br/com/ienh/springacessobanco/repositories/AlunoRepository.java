package br.com.ienh.springacessobanco.repositories;

import br.com.ienh.springacessobanco.entities.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer>{

    public Aluno findByCpf(String cpf);

}
