package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.repository.ExamRepository;

@Controller
@RequestMapping("/exam")
public class ExamController {


    @Autowired
    ExamRepository examRepository;

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("list", examRepository.findAll());
        return "exam/list";
    }
}
