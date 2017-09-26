package pl.coderslab.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.entities.Person;
import pl.coderslab.entities.Role;
import pl.coderslab.entities.User;
import pl.coderslab.repository.PersonRepository;
import pl.coderslab.repository.RoleRepository;
import pl.coderslab.repository.UserRepository;


@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Person findPersonByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    @Override
    public void savePerson(Person person) {
        person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
        person.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        person.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        personRepository.save(person);
    }

}