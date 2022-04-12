package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.ServizioDomiciliareEducativa;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServizioDomiciliareEducativaRepository extends MongoRepository<ServizioDomiciliareEducativa,String> {
    ServizioDomiciliareEducativa save(ServizioDomiciliareEducativa servizioDomiciliareEducativa);

    List<ServizioDomiciliareEducativa> findAll();
}
