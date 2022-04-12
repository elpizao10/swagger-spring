package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.SportelloArtigianato;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SportelloArtigianatoRepository extends MongoRepository<SportelloArtigianato,String> {
    SportelloArtigianato save(SportelloArtigianato sportelloArtigianato);

    List<SportelloArtigianato> findAll();
}
