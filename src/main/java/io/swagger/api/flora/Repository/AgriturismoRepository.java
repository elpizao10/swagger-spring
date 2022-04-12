package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.Agriturismo;
import io.swagger.api.flora.model.CaseEappartamenti;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AgriturismoRepository extends MongoRepository<Agriturismo,Long> {
    Agriturismo save(Agriturismo agriturismo);
    Optional<Agriturismo> findById(Long id);
}
