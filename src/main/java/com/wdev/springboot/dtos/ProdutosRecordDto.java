package com.wdev.springboot.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutosRecordDto(
        @NotBlank(message = "Campo nome é obrigatório") String nome,
        @NotNull(message = "Valor deve ser preenchido") BigDecimal valor,
        String marca
){}
