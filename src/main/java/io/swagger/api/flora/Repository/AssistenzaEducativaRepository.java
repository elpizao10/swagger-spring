package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.AssistenzaEducativa;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssistenzaEducativaRepository extends MongoRepository<AssistenzaEducativa,String> {
    AssistenzaEducativa save(AssistenzaEducativa assistenzaEducativa);

    List<AssistenzaEducativa> findAll();
}
