package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.UfficioTosapCosap;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UfficioTosapCosapRepository extends MongoRepository<UfficioTosapCosap,String> {
    UfficioTosapCosap save(UfficioTosapCosap ufficioTosapCosap);

    List<UfficioTosapCosap> findAll();
}
