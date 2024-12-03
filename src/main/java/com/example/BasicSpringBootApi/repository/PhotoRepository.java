package com.example.BasicSpringBootApi.repository;
import com.example.BasicSpringBootApi.model.Photo;
import org.springframework.data.repository.CrudRepository;

//CrudRepository: make it possible to perfonm CRUD activity in the database
public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
