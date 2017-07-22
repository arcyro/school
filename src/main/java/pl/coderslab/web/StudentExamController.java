package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.repository.StudentExamRepository;
import pl.coderslab.repository.StudentGroupExamRepository;

@Controller
@RequestMapping("/student-exam")
public class StudentExamController {


    @Autowired
    StudentExamRepository studentExamRepository;
    @Autowired
    StudentGroupExamRepository studentGroupExamRepository;

    @RequestMapping("/{examId}/list")

    public String list(Model model, @PathVariable("examId") long examId){
        model.addAttribute("groupExam", studentGroupExamRepository.findOne(examId));
        model.addAttribute("list", studentExamRepository.findAll());
        return "studentExam/list";
    }
}
