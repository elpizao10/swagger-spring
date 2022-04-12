package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.UrbanisticaEdiliziaPrivata1;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UrbanisticaEdiliziaPrivata1Repository extends MongoRepository<UrbanisticaEdiliziaPrivata1,String> {
    UrbanisticaEdiliziaPrivata1 save(UrbanisticaEdiliziaPrivata1 urbanisticaEdiliziaPrivata1);

    List<UrbanisticaEdiliziaPrivata1> findAll();
}
