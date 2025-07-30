package com.lorenzo.orquidario1.service;

import com.lorenzo.orquidario1.controller.dto.OrquidarioRequest;
import com.lorenzo.orquidario1.entity.OrquidarioEntity;
import com.lorenzo.orquidario1.infra.OrquidarioS3;
import com.lorenzo.orquidario1.mapper.MapperOrquidario;
import com.lorenzo.orquidario1.repository.OrquidarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class OrquidarioService {
    private final OrquidarioS3 orquidarioS3;
    private final OrquidarioRepository orquidarioRepository;

    public OrquidarioService(OrquidarioS3 orquidarioS3, OrquidarioRepository orquidarioRepository) {
        this.orquidarioS3 = orquidarioS3;
        this.orquidarioRepository = orquidarioRepository;
    }

    public OrquidarioEntity cadastrarPlanta(OrquidarioRequest request, MultipartFile imagem) {
        byte[] bytes;

        try {
            bytes = imagem.getBytes();
        } catch (IOException e) {
            throw new RuntimeException("Error while trying to convert multipart file to bytes");
        }

        String nomeArquivo = String.valueOf(System.currentTimeMillis());
        String urlImagem = orquidarioS3.salvarImagemNoS3(bytes, nomeArquivo);

        OrquidarioEntity entity = MapperOrquidario.toEntity(request, urlImagem);

        return orquidarioRepository.save(entity);
    }
}
