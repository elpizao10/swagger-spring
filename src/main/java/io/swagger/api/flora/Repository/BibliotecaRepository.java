package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.Biblioteca;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;


public interface BibliotecaRepository extends MongoRepository<Biblioteca,String> {
    Biblioteca save(Biblioteca biblioteca);

    List<Biblioteca> findAll(); //Importante da ricordare //da fare per tutti ESEMPIO

}
