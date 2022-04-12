package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.Campeggio;
import io.swagger.api.flora.model.CaseEappartamenti;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CampeggioRepository extends MongoRepository<Campeggio,Long> {
    Campeggio save(Campeggio campeggio);
    Optional<Campeggio> findById(Long id);
}
