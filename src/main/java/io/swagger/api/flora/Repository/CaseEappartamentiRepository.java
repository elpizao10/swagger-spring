package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.CaseEappartamenti;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CaseEappartamentiRepository extends MongoRepository<CaseEappartamenti,Long> {
    CaseEappartamenti save(CaseEappartamenti caseEappartamenti);

    Optional<CaseEappartamenti> findById(Long id);

}
