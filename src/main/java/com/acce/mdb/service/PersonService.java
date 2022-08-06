package com.acce.mdb.service;

import com.acce.mdb.collection.Person;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    String save(Person person);

    List<Person> getPersonList();

    List<Person> findByFirstNameStartsWith(String name);

    void delete(String id);

    List<Person> getPersonByAge(Integer min, Integer max);

    Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable);

}
