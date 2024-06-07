package br.com.ienh.springacessobanco.dto;

import jakarta.validation.constraints.NotNull;

public record ContatoDTO(
        @NotNull
        String descricao,

        @NotNull
        String tipo,

        @NotNull
        Integer idAluno) {}
