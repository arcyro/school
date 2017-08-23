package pl.coderslab.services;

import org.eclipse.egit.github.core.PullRequest;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.Team;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.PullRequestService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entities.RepoPullRequest;
import pl.coderslab.entities.StudentGroupRepo;
import pl.coderslab.repository.RepoPullRequestRepository;
import pl.coderslab.utils.RunBuild;

import java.io.IOException;
import java.util.List;

@Component
public class GithubManager {

    @Autowired
    RepoPullRequestRepository repoPullRequestRepository;

    /**
     * move to properties file
     */
    static final String GITHUB_ORGANIZATION = "arcyroorg";
    static final String GITHUB_USER = "arcyro";
    static final String GITHUB_PASSWORD = "1234qwer";
    static final String GITHUB_PULL_REQUEST_STATE = "open";
    static final String GITHUB_TEAM_PERMISSION = "pull";

    private GitHubClient client;
    TeamService teamService;

    @Autowired
    public GithubManager() {
        client = new GitHubClient();
        client.setCredentials(GITHUB_USER, GITHUB_PASSWORD);
        teamService = new TeamService(client);

    }

    /**
     * Create team
     *
     * @param teamName
     * @throws IOException
     */
    public Team createTeam(String teamName) throws IOException {
        return teamService.createTeam(GITHUB_ORGANIZATION, new Team().setName(teamName).setPermission(GITHUB_TEAM_PERMISSION));
    }

    public void addUserToTeam(int gitHubId, String userName) throws IOException {
        teamService.addMember(gitHubId, userName);
    }

    public void addRepoToTeam(int gitGubTeamId, String repoName) {

    }


    /**
     * Create repository for team, and copy content from main CodersLab repo
     *
     * @param mainRepoUrl
     * @param newRepoName
     * @return
     * @throws IOException
     */
    public Repository createAndCopyRepository(String mainRepoUrl, String newRepoName) throws IOException {
        String reposHomeDirectory = System.getProperty("user.home");
        RepositoryService service = new RepositoryService(client);

        Repository repo = service.createRepository(GITHUB_ORGANIZATION, new Repository().setName(newRepoName));
        String commandClone = "git clone " + mainRepoUrl + " temp_repo;";
        RunBuild.runCommand(reposHomeDirectory, commandClone);
        RunBuild.runCommand(reposHomeDirectory, "cd temp_repo; rm -rf .git; git init;");
        String commandNewRepo = "cd temp_repo; git remote add origin " + repo.getSshUrl();
        RunBuild.runCommand(reposHomeDirectory, commandNewRepo);
        RunBuild.runCommand(reposHomeDirectory, "cd temp_repo; git add .; git commit -m \"repo import\"; git push --set-upstream origin master; cd ../; rm -rf temp_repo;");

        return repo;
    }

    /**
     * @param studentGroupRepo
     * @throws IOException
     * @todo remove  repoPullRequestRepository - change logic
     */
    public void cloneAndCreateBranches(StudentGroupRepo studentGroupRepo) throws IOException {
//        String reposHomeDirectory = System.getProperty("user.home");
//        RepositoryService service = new RepositoryService(client);
//        Repository repo = service.getRepository(GITHUB_ORGANIZATION, studentGroupRepo.getName());
//
//        PullRequestService pullRequestService = new PullRequestService(client);
//        List<PullRequest> pullRequests = pullRequestService.getPullRequests(repo, GITHUB_PULL_REQUEST_STATE);
//        //remove folder if exist
//        /** @todo what should happened  */
////        RunBuild.runCommand(reposHomeDirectory, "rm -rf "+studentGroupRepo.getName());
////        String commandClone = "git clone " + repo.getSshUrl();
////        RunBuild.runCommand(reposHomeDirectory, commandClone);
//
//        for (PullRequest pullRequest : pullRequests) {
////            RunBuild.runCommand(System.getProperty("user.home"), " cd " + repo.getName() + "; git fetch origin pull/" + pullRequest.getNumber() + "/head:" + pullRequest.getNumber());
//
////            repoPullRequest.setStudentGroupRepo(studentGroupRepo);
////            repoPullRequest.setSshUrl(pullRequest.getUrl());
//            /**
//             * @todo add set Student
//             */
//
//        }
        RepoPullRequest repoPullRequest = new RepoPullRequest();
        repoPullRequest.setSshUrl("asd");
        System.out.println(repoPullRequest);
        System.out.println(repoPullRequestRepository);
//        repoPullRequest.setStudentGroupRepo(studentGroupRepo);
//        repoPullRequestRepository.save(repoPullRequest);
    }
}
