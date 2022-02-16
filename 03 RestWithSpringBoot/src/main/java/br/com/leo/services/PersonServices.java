package br.com.leo.services;

import br.com.leo.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    public Person findById(String id){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leonardo");
        person.setLastName("Freitas");
        person.setAddress("João Pessoa - PB - Brasil");
        person.setGender("Male");
        return person;

    }
}
