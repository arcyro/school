package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.repository.PersonRepository;
import pl.coderslab.repository.StudentGroupRepository;

@Controller
@RequestMapping("/people")
public class PersonController {


    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("list", personRepository.findAll());
        return "person/list";
    }
}
