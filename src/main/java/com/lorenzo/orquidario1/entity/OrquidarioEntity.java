package com.lorenzo.orquidario1.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orquidario")
@Getter
@Setter
public class OrquidarioEntity {
    @Id
    private String id;
    private String nome;
    private String familia;
    private String descricao;
    private String urlImagem;

    public OrquidarioEntity() {
    }

    public OrquidarioEntity(String nome, String familia, String descricao, String urlImagem) {
        this.nome = nome;
        this.familia = familia;
        this.descricao = descricao;
        this.urlImagem = urlImagem;
    }
}
