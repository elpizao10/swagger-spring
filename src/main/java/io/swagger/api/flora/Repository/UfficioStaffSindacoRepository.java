package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.UfficioStaffSindaco;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UfficioStaffSindacoRepository extends MongoRepository<UfficioStaffSindaco,String> {
    UfficioStaffSindaco save(UfficioStaffSindaco ufficioStaffSindaco);

    List<UfficioStaffSindaco> findAll();
}
