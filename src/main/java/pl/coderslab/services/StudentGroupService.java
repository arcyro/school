package pl.coderslab.services;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entities.CodersLabRepo;
import pl.coderslab.entities.StudentGroup;
import pl.coderslab.entities.StudentGroupRepo;
import pl.coderslab.repository.CodersLabRepoRepository;
import pl.coderslab.repository.StudentGroupRepoRepository;
import pl.coderslab.repository.StudentGroupRepository;

import java.io.IOException;
import java.util.List;

@Component
public class StudentGroupService {


    @Autowired
    StudentGroupRepository studentGroupRepository;

    @Autowired
    GithubManager githubManager;

    @Autowired
    CodersLabRepoRepository codersLabRepoRepository;

    @Autowired
    StudentGroupRepoRepository studentGroupRepoRepository;


    /**
     * Create group and all repositories
     *
     * @param studentGroup
     */
    public void initGroup(StudentGroup studentGroup) {

        try {
            // create Team on Github
            Team team = githubManager.createTeam(studentGroup.getName());
            studentGroup.setGithubTeamId(team.getId());
            studentGroupRepository.save(studentGroup);
            // get repos
            List<CodersLabRepo> codersLabRepos = codersLabRepoRepository.findAllByActive(true);
            // create repos and copy files
            for (CodersLabRepo codersLabRepo : codersLabRepos) {
                String repoName = studentGroup.getName() + "_" + codersLabRepo.getName();
                Repository repository = githubManager.createAndCopyRepository(codersLabRepo.getSshUrl(), repoName);
                //add
                studentGroupRepoRepository.save(new StudentGroupRepo(studentGroup, codersLabRepo, repoName, repository.getSshUrl())); //get from repo
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
