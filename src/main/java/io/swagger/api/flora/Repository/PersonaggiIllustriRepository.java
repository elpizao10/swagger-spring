package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.PersonaggiIllustri;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonaggiIllustriRepository extends MongoRepository<PersonaggiIllustri,String> {
    PersonaggiIllustri save(PersonaggiIllustri personaggiIllustri);


    List<PersonaggiIllustri> findAll();
}
