package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.CondonoEdilizio;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CondonoEdilizioRepository extends MongoRepository<CondonoEdilizio,String> {
    CondonoEdilizio save(CondonoEdilizio condonoEdilizio);
    List<CondonoEdilizio> findAll();
}
