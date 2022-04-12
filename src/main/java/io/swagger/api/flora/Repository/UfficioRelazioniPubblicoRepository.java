package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.UfficioRelazioniPubblico;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UfficioRelazioniPubblicoRepository extends MongoRepository<UfficioRelazioniPubblico,String> {
    UfficioRelazioniPubblico save(UfficioRelazioniPubblico ufficioRelazioniPubblico);

    List<UfficioRelazioniPubblico> findAll();
}
