package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.UfficioIciTarsu;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UfficioIciTarsuRepository extends MongoRepository<UfficioIciTarsu,String> {
    UfficioIciTarsu save(UfficioIciTarsu ufficioIciTarsu);

    List<UfficioIciTarsu> findAll();
}
