
package br.com.ienh.springacessobanco.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoDTO(
        Integer id,

        @Size(max= 40, min=5, message="O nome deve ter entre 5 e 40 caracteres.")
        String nome,

        @Size(max= 45, min=5, message="O endereço deve ter entre 5 e 45 caracteres.")
        String endereco,
        @NotNull(message = "Informação obrigatória.")
        @Past(message = "A data de nascimento deve ser no passado.")
        LocalDate nascimento) {}