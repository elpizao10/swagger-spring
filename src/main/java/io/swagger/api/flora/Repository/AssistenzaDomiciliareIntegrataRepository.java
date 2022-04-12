package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.AssistenzaDomiciliareIntegrata;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssistenzaDomiciliareIntegrataRepository extends MongoRepository<AssistenzaDomiciliareIntegrata,String> {
    AssistenzaDomiciliareIntegrata save(AssistenzaDomiciliareIntegrata assistenzaDomiciliareIntegrata);
    List<AssistenzaDomiciliareIntegrata> findAll();
}
