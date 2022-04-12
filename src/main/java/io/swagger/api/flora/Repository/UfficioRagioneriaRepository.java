package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.UfficioRagioneria;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UfficioRagioneriaRepository extends MongoRepository<UfficioRagioneria,String> {
    UfficioRagioneria save(UfficioRagioneria ufficioRagioneria);

    List<UfficioRagioneria> findAll();
}
