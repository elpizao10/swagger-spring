package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.PoliziaAmministrativa;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PoliziaAmministrativaRepository  extends MongoRepository<PoliziaAmministrativa,String> {
    PoliziaAmministrativa save(PoliziaAmministrativa poliziaAmministrativa);
    List<PoliziaAmministrativa> findAll();
}
