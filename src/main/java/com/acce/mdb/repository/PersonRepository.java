package com.acce.mdb.repository;

import com.acce.mdb.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    List<Person> findByFirstNameStartsWith(String name);
    //List<Person> findByAgeBetween(Integer min, Integer max);

    @Query(value = "{'age': {$gt:?0, $lt:?1}}",fields = "{addressesList: 0}" )
    List<Person> findPersonByAgeBetween(Integer min, Integer max);
}
