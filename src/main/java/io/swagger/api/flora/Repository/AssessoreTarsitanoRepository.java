package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.AssessoreTarsitano;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssessoreTarsitanoRepository extends MongoRepository<AssessoreTarsitano,String> {
    AssessoreTarsitano save(AssessoreTarsitano assessoreTarsitano);
    List<AssessoreTarsitano> findAll();
}
