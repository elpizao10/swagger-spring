package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.Affittacamere;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AffittacamereRepository extends MongoRepository<Affittacamere,Long> {
    Affittacamere save(Affittacamere affittacamere);

    Optional<Affittacamere> findById(Long id);
}
