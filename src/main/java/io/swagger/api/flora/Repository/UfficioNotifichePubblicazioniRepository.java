package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.UfficioNotifichePubblicazioni;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UfficioNotifichePubblicazioniRepository extends MongoRepository<UfficioNotifichePubblicazioni,String> {
    UfficioNotifichePubblicazioni save(UfficioNotifichePubblicazioni ufficioNotifichePubblicazioni);

    List<UfficioNotifichePubblicazioni> findAll();
}
