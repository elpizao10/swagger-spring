package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.CentroFamiglia;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CentroFamigliaRepository extends MongoRepository<CentroFamiglia,String> {
    CentroFamiglia save(CentroFamiglia centroFamiglia);
    List<CentroFamiglia> findAll();
}
