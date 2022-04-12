package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.AssessoreBerlen;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssessoreBerlenRepository extends MongoRepository<AssessoreBerlen,String> {
    AssessoreBerlen save(AssessoreBerlen assessoreBerlen);
    List<AssessoreBerlen> findAll();
}
