package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.AssessoreDituri;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssessoreDituriRepository extends MongoRepository<AssessoreDituri,String> {
    AssessoreDituri save(AssessoreDituri assessoreDituri);
    List<AssessoreDituri> findAll();
}
