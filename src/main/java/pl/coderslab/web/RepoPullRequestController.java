package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entities.StudentGroupRepo;
import pl.coderslab.repository.RepoPullRequestRepository;
import pl.coderslab.repository.StudentGroupRepoRepository;
import pl.coderslab.services.GithubManager;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;


@Controller
@RequestMapping("/repo-pull-request")
public class RepoPullRequestController {


    @Autowired
    RepoPullRequestRepository repoPullRequestRepository;

    @Autowired
    StudentGroupRepoRepository studentGroupRepoRepository;

    @Autowired
    GithubManager githubManager;

    @RequestMapping("/{studentGroupRepoId}/list")
    public String list(Model model, @PathVariable("studentGroupRepoId") long studentGroupRepoId) {
        model.addAttribute("list", repoPullRequestRepository.findAll());
//        model.addAttribute("list", repoPullRequestRepository.findAllByStudentGroupRepoId(studentGroupRepoId));
        model.addAttribute("studentGroupRepoId", studentGroupRepoId);
        return "repoPullRequest/list";
    }


    /**
     * @param model
     * @param studentGroupRepoId
     * @param request
     * @return
     * @todo Add Error Handler and logger
     */
    @RequestMapping("/{studentGroupRepoId}/download")
    @ResponseBody
    public String share(Model model, @PathVariable("studentGroupRepoId") long studentGroupRepoId, HttpServletRequest request) {
        // download repo and create branch
        StudentGroupRepo studentGroupRepo = studentGroupRepoRepository.findOne(studentGroupRepoId);

        try {

            githubManager.cloneAndCreateBranches(studentGroupRepo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:" ;
//        return "redirect:" + request.getHeader("Referer");
    }

}
