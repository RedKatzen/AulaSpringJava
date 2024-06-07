package br.com.ienh.springacessobanco.controllers;

import br.com.ienh.springacessobanco.dto.AlunoDTO;
import br.com.ienh.springacessobanco.dto.ContatoDTO;
import br.com.ienh.springacessobanco.entities.Aluno;
import br.com.ienh.springacessobanco.entities.Contato;
import br.com.ienh.springacessobanco.repositories.AlunoRepository;
import br.com.ienh.springacessobanco.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    ContatoRepository contatoRepository;

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("contato") ContatoDTO contato, Model model){
        Iterable<Aluno> alunos = alunoRepository.findAll();
        List<AlunoDTO> alunosDTO = new ArrayList<>();
        alunos.forEach(aluno -> alunosDTO.add(new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getEndereco(), aluno.getNascimento())));
        model.addAttribute("alunos", alunosDTO);
        return "/contato/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(ContatoDTO contato){
        Contato novoContato = new Contato();
        novoContato.setDescricao(contato.descricao());
        novoContato.setTipo(contato.tipo());
        alunoRepository.findById(contato.idAluno()).ifPresent(novoContato::setAluno);
        contatoRepository.save(novoContato);
        return "redirect:/aluno/listar";
    }

}
