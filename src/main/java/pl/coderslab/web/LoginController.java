package pl.coderslab.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.entities.Person;
import pl.coderslab.services.PersonService;


@Controller
public class LoginController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "admin/login";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);

        return "admin/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewPerson(@Valid Person person, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Person personExists = personService.findPersonByEmail(person.getEmail());
        if (personExists != null) {
            bindingResult
                    .rejectValue("email", "error.person",
                            "There is already a person registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin/registration");
        } else {
            personService.savePerson(person);
            modelAndView.addObject("successMessage", "person has been registered successfully");
            modelAndView.addObject("person", new Person());
            modelAndView.setViewName("admin/registration");

        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Person person = personService.findPersonByEmail(auth.getName());
        modelAndView.addObject("personName", "Welcome " + person.getFirstName() + " " + person.getLastName() + " (" + person.getEmail() + ")");
        modelAndView.addObject("adminMessage", "Content Available Only for persons with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }


}