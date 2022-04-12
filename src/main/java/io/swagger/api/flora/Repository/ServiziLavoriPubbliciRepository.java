package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.ServiziLavoriPubblici;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServiziLavoriPubbliciRepository extends MongoRepository<ServiziLavoriPubblici,String> {
    ServiziLavoriPubblici save(ServiziLavoriPubblici serviziLavoriPubblici);

    List<ServiziLavoriPubblici> findAll();
}
