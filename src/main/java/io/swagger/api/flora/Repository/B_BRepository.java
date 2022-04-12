package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.B_B;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface B_BRepository extends MongoRepository<B_B,Long> {
    B_B save(B_B b_b);
    List<B_B> findAll();
    Optional<B_B> findById(Long id);
}
