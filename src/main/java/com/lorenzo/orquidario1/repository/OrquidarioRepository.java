package com.lorenzo.orquidario1.repository;

import com.lorenzo.orquidario1.entity.OrquidarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrquidarioRepository extends MongoRepository<OrquidarioEntity,String> {
}
