package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entities.StudentGroupExam;
import pl.coderslab.repository.StudentGroupExamRepository;
import pl.coderslab.repository.StudentGroupRepository;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/group-exam")
public class StudentGroupExamController {


    @Autowired
    StudentGroupExamRepository studentGroupExamRepository;

    @RequestMapping("/{groupId}/list")
    public String list(Model model, @PathVariable("groupId") long groupId){
        model.addAttribute("list", studentGroupExamRepository.findAllByStudentGroupId(groupId));
        return "studentGroupExam/list";
    }
}
