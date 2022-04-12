package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.SportelloUnicoAttivitaProduttive;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SportelloUnicoAttivitaProduttiveRepository extends MongoRepository<SportelloUnicoAttivitaProduttive,String> {
    SportelloUnicoAttivitaProduttive save(SportelloUnicoAttivitaProduttive sportelloUnicoAttivitaProduttive);

    List<SportelloUnicoAttivitaProduttive> findAll();
}
