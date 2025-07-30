package com.lorenzo.orquidario1.mapper;

import com.lorenzo.orquidario1.controller.dto.OrquidarioRequest;
import com.lorenzo.orquidario1.entity.OrquidarioEntity;

public class MapperOrquidario {

    public static OrquidarioEntity toEntity (OrquidarioRequest request, String urlImagem){
        OrquidarioEntity entity = new OrquidarioEntity();
        entity.setNome(request.nome());
        entity.setFamilia(request.familia());
        entity.setDescricao(request.descricao());
        entity.setUrlImagem(urlImagem);

        return entity;
    }
}
