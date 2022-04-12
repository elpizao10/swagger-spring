package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.AttivitaProduttive;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AttivitaProduttiveRepository extends MongoRepository<AttivitaProduttive, String> {
    AttivitaProduttive save(AttivitaProduttive attivitaProduttive);
    List<AttivitaProduttive> findAll();
}
