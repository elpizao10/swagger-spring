package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.UfficioProtocollo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UfficioProtocolloRepository extends MongoRepository<UfficioProtocollo,String> {
    UfficioProtocollo save(UfficioProtocollo ufficioProtocollo);

    List<UfficioProtocollo> findAll();
}
