package org.example.service;

import org.example.Exceptions.ResourceNotFoundException;
import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());
    @Autowired
    private PersonRepository personRepository;

    public Person findById(Long id){

        logger.info("Finding one person!");
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for these id!"));
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person createPerson(Person person){
        logger.info("Creating person...");
        return personRepository.save(person);
    }

    public Person updatePerson(Person person){
        logger.info("Updating person...");

        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for these id!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());

        return personRepository.save(person);
    }

    public void deletePerson(Long id){

        logger.info("Deleting person...");
        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for these id!"));
        personRepository.delete(entity);

    }


}
