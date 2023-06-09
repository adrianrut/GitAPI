package pl.rutkowski.gitapi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.rutkowski.gitapi.model.branch.BranchRespondDto;
import pl.rutkowski.gitapi.model.user.GitHubResponseDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class GitHubService {

    private final RestTemplate restTemplate;

    public GitHubService() {
        this.restTemplate = new RestTemplate();
    }


    public List<GitHubUserDetails> getUserDetails(String username) {
        List<GitHubUserDetails> userDetails = new ArrayList<>();
        String urlGit = "https://api.github.com/users/%s/repos".formatted(username);
        GitHubResponseDto[] responseDto = restTemplate.getForObject(urlGit, GitHubResponseDto[].class);
        assert responseDto != null;
        getUserDetails(userDetails, responseDto);
        return userDetails;

    }

    private void getUserDetails(List<GitHubUserDetails> userDetails, GitHubResponseDto[] responseDto) {
        for (GitHubResponseDto gitHubResponseDto : responseDto) {
            String name = gitHubResponseDto.getOwner().getLogin();
            String repositoryName = gitHubResponseDto.getName();
            String branches = "https://api.github.com/repos/%s/%s/branches".formatted(name, repositoryName);
            BranchRespondDto[] branchRespondDto = restTemplate.getForObject(branches, BranchRespondDto[].class);
            assert branchRespondDto != null;
            getBranchDetails(userDetails, name, repositoryName, branchRespondDto);

        }
    }

    private static void getBranchDetails(List<GitHubUserDetails> userDetails, String name, String repositoryName, BranchRespondDto[] branchRespondDto) {
        for (BranchRespondDto respondDto : branchRespondDto) {
            String branchName = respondDto.getName();
            String sha = respondDto.getCommit().getSha();
            userDetails.add(new GitHubUserDetails(name, repositoryName, branchName, sha));
        }
    }

}
