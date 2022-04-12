package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.ServizioAnagrafe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServizioAnagrafeRepository extends MongoRepository<ServizioAnagrafe,String> {
    ServizioAnagrafe save(ServizioAnagrafe servizioAnagrafe);

    List<ServizioAnagrafe> findAll();
}
