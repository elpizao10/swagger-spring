package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.EdiliziaResidenzialePubblica;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EdiliziaResidenzialePubblicaRepository extends MongoRepository<EdiliziaResidenzialePubblica,String>{
    EdiliziaResidenzialePubblica save(EdiliziaResidenzialePubblica ediliziaResidenzialePubblica);
    List<EdiliziaResidenzialePubblica> findAll();

}
