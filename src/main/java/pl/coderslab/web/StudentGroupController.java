package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.entities.City;
import pl.coderslab.entities.StudentGroup;
import pl.coderslab.repository.CityRepository;
import pl.coderslab.repository.ExamRepository;
import pl.coderslab.repository.StudentGroupRepository;

import static pl.coderslab.utils.MessageHelper.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/group")
public class StudentGroupController {


    @Autowired
    StudentGroupRepository studentGroupRepository;
    @Autowired
    CityRepository cityRepository;

    @RequestMapping("/list")
    public String list(Model model, @SortDefault("id") Pageable pageable) {
        model.addAttribute("page", studentGroupRepository.findAll(pageable));
        return "studentGroup/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String studentGroupForm(Model model) {
        model.addAttribute("studentGroup", new StudentGroup());
        return "studentGroup/add";
    }

    @ModelAttribute("cities")
    public List<City> getCities() {
        return cityRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processRegistration(Model model, @Valid StudentGroup studentGroup, BindingResult result, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            addErrorAttribute(model, "error.create");
            return "studentGroup/add";
        }
        studentGroupRepository.save(studentGroup);
        addSuccessAttribute(redirectAttrs, "info.success");

        return "redirect:/group/list";
    }
}
