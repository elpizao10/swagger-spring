package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.ServiziCimiteriali;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServiziCimiterialiRepository extends MongoRepository<ServiziCimiteriali,String> {
    ServiziCimiteriali save(ServiziCimiteriali serviziCimiteriali);

    List<ServiziCimiteriali> findAll();
}
