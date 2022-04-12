package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HotelGabbianoRepository extends MongoRepository<Hotel,String> {
    Hotel save(Hotel hotelGabbiano);
    List<Hotel> findAll();
}
