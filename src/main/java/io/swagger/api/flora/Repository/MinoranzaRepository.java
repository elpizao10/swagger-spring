package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.Minoranza;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MinoranzaRepository extends MongoRepository<Minoranza,String> {
    Minoranza save(Minoranza minoranza);

    List<Minoranza> findAll();

    List<Minoranza> findByPartito(String partito);
}
