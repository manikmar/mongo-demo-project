package com.acce.mdb.controller;

import com.acce.mdb.collection.Person;
import com.acce.mdb.config.SpringFoxConfig;
import com.acce.mdb.service.PersonService;
import io.swagger.annotations.Api;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping (value = "/load_person")
    public String save(@RequestBody Person person){
        return personService.save(person);
    }


    @GetMapping (value = "/get_persons")
    public List<Person> getPersons() {
        List<Person> personsList = new ArrayList<>();
        return personService.getPersonList();
    }


    @GetMapping (value = "/get_person_Start_With")
    public List<Person> getPersonStartWith(@RequestParam("name") String name){
        return personService.findByFirstNameStartsWith(name);
    }

    //@DeleteMapping("/{id}")
    @DeleteMapping (value = "/delete_persons")//, method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        personService.delete(id);
    }

    //@GetMapping
    @GetMapping (value = "/get_person_by_age")
    public List<Person> getPersonByAge(@RequestParam Integer min, @RequestParam Integer max){
        return personService.getPersonByAge(min, max);
    }

    @GetMapping (value = "/search_person")
    public Page<Person> searchPerson(@RequestParam(required = false)String name,
                                     @RequestParam(required = false)Integer minAge,
                                     @RequestParam(required = false)Integer maxAge,
                                     @RequestParam(required = false)String city,
                                     @RequestParam(defaultValue = "0") Integer page,
                                     @RequestParam(defaultValue = "5") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return personService.search(name, minAge, maxAge, city, pageable);
    }

}
