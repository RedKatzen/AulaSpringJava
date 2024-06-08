package br.com.ienh.springacessobanco.services;

import br.com.ienh.springacessobanco.dto.AlunoDTO;
import br.com.ienh.springacessobanco.entities.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.ienh.springacessobanco.repositories.AlunoRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    AlunoService alunoService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("alunos", alunoRepository.findAll());
        return "/aluno/listar";
    }

    public void salvar(AlunoDTO aluno){
        Aluno novoAluno = new Aluno();
        novoAluno.setNome(aluno.nome());
        novoAluno.setEndereco(aluno.endereco());
        novoAluno.setNascimento(aluno.nascimento());
        alunoRepository.save(novoAluno);
    }
}
