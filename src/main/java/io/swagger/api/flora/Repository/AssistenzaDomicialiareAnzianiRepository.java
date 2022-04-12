package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.AssistenzaDomiciliareAnziani;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssistenzaDomicialiareAnzianiRepository extends MongoRepository<AssistenzaDomiciliareAnziani, String> {

    AssistenzaDomiciliareAnziani save(AssistenzaDomiciliareAnziani assistenzaDomiciliareAnziani);
    List<AssistenzaDomiciliareAnziani> findAll();
}
