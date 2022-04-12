package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.UfficioAccertamenti;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UfficioAccertamentiRepository extends MongoRepository<UfficioAccertamenti,String> {
    UfficioAccertamenti save(UfficioAccertamenti ufficioAccertamenti);

    List<UfficioAccertamenti> findAll();
}
