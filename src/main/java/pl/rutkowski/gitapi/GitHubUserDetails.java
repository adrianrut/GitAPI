package pl.rutkowski.gitapi;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GitHubUserDetails {
    private String name;
    private String repositoryName;
    private String branchName;
    private String sha;
}
