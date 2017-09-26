package pl.coderslab.services;

import pl.coderslab.entities.Person;


public interface PersonService {
    public Person findPersonByEmail(String email);
    public void savePerson(Person user);
}
