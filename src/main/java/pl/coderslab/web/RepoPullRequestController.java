package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entities.RepoPullRequest;
import pl.coderslab.entities.StudentGroupRepo;
import pl.coderslab.repository.RepoPullRequestRepository;
import pl.coderslab.repository.StudentGroupRepoRepository;
import pl.coderslab.services.GithubManager;
import pl.coderslab.services.TestService;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping("/repo-pull-request")
public class RepoPullRequestController {


    @Autowired
    RepoPullRequestRepository repoPullRequestRepository;

    @Autowired
    StudentGroupRepoRepository studentGroupRepoRepository;

    @Autowired
    GithubManager githubManager;

    @Autowired
    TestService testService;

    @RequestMapping("/{studentGroupRepoId}/list")
    public String list(Model model, @PathVariable("studentGroupRepoId") long studentGroupRepoId) {
        model.addAttribute("list", repoPullRequestRepository.findAllByStudentGroupRepoId(studentGroupRepoId));
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

    public String share(Model model, @PathVariable("studentGroupRepoId") long studentGroupRepoId, HttpServletRequest request) {
        // download repo and create branch
        StudentGroupRepo studentGroupRepo = studentGroupRepoRepository.findOne(studentGroupRepoId);
        try {
            githubManager.cloneAndCreateBranches(studentGroupRepo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:" + request.getHeader("Referer");
    }


    /**
     * @todo remove hardkoded info about exam files
     * @param model
     * @param pullRequestId
     * @param request
     * @return
     */
    @RequestMapping("/{pullRequestId}/check")
    public String check(Model model, @PathVariable("pullRequestId") long pullRequestId, HttpServletRequest request) {
        // download repo and create branch
        RepoPullRequest repoPullRequest = repoPullRequestRepository.findOne(pullRequestId);

        /** get exercises from database */
        List<String> examFiles = Arrays.asList("Main1", "Main2", "Main3", "Main4", "Main5", "Main6", "Main7");

        Map<String, Boolean> resultsMap = new HashMap<>();
        boolean result = false;
        for (String examFile : examFiles) {
            try {
                result = testService.runTest("WAR_JEE_S_04_JEE_Podstawy", examFile, "exam", "pl.coderslab.testrepos.java.exam1");
                System.out.println(result);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            resultsMap.put(examFile, result);
        }
        model.addAttribute("results", resultsMap);
        return "repoPullRequest/check";
    }

}
