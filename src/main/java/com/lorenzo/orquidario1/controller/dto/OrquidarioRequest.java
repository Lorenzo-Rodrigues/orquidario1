package com.lorenzo.orquidario1.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record OrquidarioRequest(@NotBlank String nome,
                                @NotBlank String familia,
                                          String descricao) {
}
