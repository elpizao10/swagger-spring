package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.Municipia;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MunicipiaRepository extends MongoRepository<Municipia,String> {
    Municipia save(Municipia municipia);
    List<Municipia> findAll();
}
