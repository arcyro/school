package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.repository.ExamRepository;
import pl.coderslab.repository.StudentGroupRepository;

@Controller
@RequestMapping("/group")
public class StudentGroupController {


    @Autowired
    StudentGroupRepository studentGroupRepository;

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("list", studentGroupRepository.findAll());
        return "studentGroup/list";
    }
}
