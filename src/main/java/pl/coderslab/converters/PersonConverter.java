package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.Person;
import pl.coderslab.repository.PersonRepository;

/**
 * Created by dell on 17.08.17.
 */
@Component
public class PersonConverter implements Converter<String, Person> {
    @Autowired
    PersonRepository personRepository;

    @Override
    public Person convert(String s) {
        return personRepository.findOne(Long.parseLong(s));
    }
}
