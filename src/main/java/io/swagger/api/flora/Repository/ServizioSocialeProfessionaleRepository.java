package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.ServizioSocialeProfessionale;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServizioSocialeProfessionaleRepository extends MongoRepository<ServizioSocialeProfessionale,String> {
    ServizioSocialeProfessionale save(ServizioSocialeProfessionale servizioSocialeProfessionale);

    List<ServizioSocialeProfessionale> findAll();
}
