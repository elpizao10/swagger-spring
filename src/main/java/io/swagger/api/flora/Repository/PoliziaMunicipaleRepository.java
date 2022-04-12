package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.PoliziaMunicipale;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PoliziaMunicipaleRepository extends MongoRepository<PoliziaMunicipale,String> {
    PoliziaMunicipale save(PoliziaMunicipale poliziaMunicipale);
    List<PoliziaMunicipale> findAll();
}
