package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.AssessoreSalamida;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssessoreSalamidaRepository extends MongoRepository<AssessoreSalamida,String> {
    AssessoreSalamida save(AssessoreSalamida assessoreSalamida);
    List<AssessoreSalamida> findAll();
}
