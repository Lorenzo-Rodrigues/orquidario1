package com.lorenzo.orquidario1.controller;

import com.lorenzo.orquidario1.controller.dto.OrquidarioRequest;
import com.lorenzo.orquidario1.entity.OrquidarioEntity;
import com.lorenzo.orquidario1.service.OrquidarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class OrquidarioController {
    private final OrquidarioService orquidarioService;

    public OrquidarioController(OrquidarioService orquidarioService) {
        this.orquidarioService = orquidarioService;
    }

    @PostMapping(value = "/orquidario", consumes = {"multipart/form-data"})
    public ResponseEntity<OrquidarioEntity> cadastrar(@RequestPart("orquidarioRequest") OrquidarioRequest orquidarioRequest,
                                                      @RequestPart("foto") MultipartFile imagem) {

        return ResponseEntity.ok(orquidarioService.cadastrarPlanta(orquidarioRequest, imagem));
    }
}
