package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.UfficioImpegni;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UfficioImpegniRepository extends MongoRepository<UfficioImpegni,String> {
    UfficioImpegni save(UfficioImpegni ufficioImpegni);

    List<UfficioImpegni> findAll();
}
