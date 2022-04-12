package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.ServizioProgrammazioneControllo;
import io.swagger.api.flora.model.ServizioProgrammazioneControllo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServizioProgrammazioneControlloRepository extends MongoRepository<ServizioProgrammazioneControllo,String> {
    ServizioProgrammazioneControllo save(ServizioProgrammazioneControllo servizioProgrammazioneControllo);

    List<ServizioProgrammazioneControllo> findAll();


}
