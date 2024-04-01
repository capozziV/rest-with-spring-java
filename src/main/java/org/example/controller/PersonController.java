package org.example.Controller;

import org.example.model.Person;
import org.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

import static org.example.validation.NumberValidation.convertToDouble;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable Long id) throws Exception{

        return personService.findById(id);

    }

    @GetMapping("")
    public List<Person> findAll() throws Exception{

        return personService.findAll();

    }

    @PostMapping("")
    public Person createPerson(@RequestBody Person person) throws Exception{
        return personService.createPerson(person);
    }

    @PutMapping("")
    public Person updatePerson(@RequestBody Person person) throws Exception{
        return personService.updatePerson(person);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable Long id) throws Exception{
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable String numberOne,
                      @PathVariable String numberTwo) throws Exception{

        return convertToDouble(numberOne) * convertToDouble(numberTwo);

    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable String numberOne,
                       @PathVariable String numberTwo) throws Exception{

        return convertToDouble(numberOne) / convertToDouble(numberTwo);

    }

    @GetMapping("/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable String numberOne,
                      @PathVariable String numberTwo) throws Exception{

        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;

    }

    @GetMapping("/square/{number}")
    public Double square(@PathVariable String number) throws Exception{

        return Math.sqrt(convertToDouble(number));

    }

}
