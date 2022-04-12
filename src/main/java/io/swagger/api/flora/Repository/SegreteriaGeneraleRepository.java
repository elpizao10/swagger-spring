package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.SegreteriaGenerale;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface SegreteriaGeneraleRepository extends MongoRepository<SegreteriaGenerale,String> {
    SegreteriaGenerale save(SegreteriaGenerale segreteriaGenerale);

    List<SegreteriaGenerale> findAll();
}
