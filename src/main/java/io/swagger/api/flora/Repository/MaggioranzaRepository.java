package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.Maggioranza;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MaggioranzaRepository extends MongoRepository<Maggioranza,String> {
    Maggioranza save(Maggioranza maggioranza);

    List<Maggioranza> findAll();

    List<Maggioranza> findByPartito(String partito);

}
