package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.entities.Person;
import pl.coderslab.entities.StudentGroup;
import pl.coderslab.repository.PersonRepository;
import pl.coderslab.repository.StudentGroupRepository;

import javax.validation.Valid;

import static pl.coderslab.utils.MessageHelper.addErrorAttribute;
import static pl.coderslab.utils.MessageHelper.addSuccessAttribute;

@Controller
@RequestMapping("/person")
public class PersonController {


    @Autowired
    PersonRepository personRepository;


    @RequestMapping("/test")
    @ResponseBody
    public String testAction() {
            Person person = personRepository.findOne(1L);
        person.setFirstName("aaa");
        personRepository.save(person);
        return "test";
    }

    @RequestMapping("/list")
    public String listAction(Model model, @SortDefault("id") Pageable pageable) {
        model.addAttribute("page", personRepository.findAll(pageable));
        return "person/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String personAddFormAction(Model model) {
        model.addAttribute("person", new Person());
        return "person/add";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String personEditFormAction(Model model, @PathVariable long id) {
        model.addAttribute("person", personRepository.findOne(id));
        return "person/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String processUpdateAction(Model model, @ModelAttribute @Valid Person person, BindingResult result, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            addErrorAttribute(model, "error.create");
            return "person/edit";
        }
        personRepository.saveAndFlush(person);
        addSuccessAttribute(redirectAttrs, "info.success");

        return "redirect:/person/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddAction(Model model, @Valid Person person, BindingResult result, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            addErrorAttribute(model, "error.create");
            return "person/add";
        }
        personRepository.save(person);
        addSuccessAttribute(redirectAttrs, "info.success");

        return "redirect:/person/list";
    }
}
