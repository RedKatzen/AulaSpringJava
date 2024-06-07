package br.com.ienh.springacessobanco.controllers;

import br.com.ienh.springacessobanco.dto.AlunoDTO;
import br.com.ienh.springacessobanco.entities.Aluno;
import br.com.ienh.springacessobanco.repositories.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("alunos", alunoRepository.findAll());
        return "/aluno/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("aluno") AlunoDTO aluno){
        return "/aluno/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("aluno") AlunoDTO aluno, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/aluno/novoForm";
        }
        Aluno novoAluno = new Aluno();
        novoAluno.setNome(aluno.nome());
        novoAluno.setEndereco(aluno.endereco());
        novoAluno.setNascimento(aluno.nascimento());
        alunoRepository.save(novoAluno);
        return "redirect:/aluno/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        alunoRepository.findById(id).ifPresent(aluno -> model.addAttribute("aluno", aluno));
        return "/aluno/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(int id, String nome, String endereco, String nascimento){
        alunoRepository.findById(id).ifPresent(aluno -> {
            aluno.setNome(nome);
            aluno.setEndereco(endereco);
            aluno.setNascimento(LocalDate.parse(nascimento));
            alunoRepository.save(aluno);
        });
        return "redirect:/aluno/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        alunoRepository.deleteById(id);
        return "redirect:/aluno/listar";
    }

}
