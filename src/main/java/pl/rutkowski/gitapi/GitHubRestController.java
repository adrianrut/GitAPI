package pl.rutkowski.gitapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitHubRestController {

    private final GitHubService gitHubService;

    public GitHubRestController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @PostMapping(value = "/user_details/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserDetails(@RequestBody User user) {
        List<GitHubUserDetails> userDetails = gitHubService.getUserDetails(user.getUsername());
        if (!userDetails.isEmpty()) {
            return ResponseEntity.ok(userDetails);
        } else {
            return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "Username not exist");
        }

    }


}

