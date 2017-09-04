package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.entities.Student;
import pl.coderslab.entities.StudentGroup;
import pl.coderslab.entities.StudentGroupRepo;
import pl.coderslab.repository.StudentGroupRepoRepository;
import pl.coderslab.repository.StudentGroupRepository;
import pl.coderslab.repository.StudentRepository;
import pl.coderslab.services.GithubManager;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;

import static pl.coderslab.utils.MessageHelper.addErrorAttribute;
import static pl.coderslab.utils.MessageHelper.addSuccessAttribute;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentGroupRepository studentGroupRepository;

    @Autowired
    GithubManager githubManager;


    @RequestMapping(value = "/{studentGroupId}/add", method = RequestMethod.GET)
    public String studentGroupForm(Model model, @PathVariable("studentGroupId") long studentGroupId) {
        model.addAttribute("studentGroupId", studentGroupId);
        model.addAttribute("student", new Student());
        return "student/add";
    }

    @RequestMapping(value = "/{studentGroupId}/add", method = RequestMethod.POST)
    public String processRegistration(Model model, @Valid Student student, @PathVariable("studentGroupId") long studentGroupId, BindingResult result, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            addErrorAttribute(model, "error.create");
            return "student/add";
        }
        /** @move to service */
        StudentGroup studentGroup = studentGroupRepository.findOne(studentGroupId);

        try {
            githubManager.addUserToTeam(studentGroup.getGithubTeamId(), student.getGithubLogin());
        } catch (IOException e) {
            e.printStackTrace();
        }
        studentRepository.save(student);
        addSuccessAttribute(redirectAttrs, "info.success");

        return "redirect:/group/list";
    }
}
