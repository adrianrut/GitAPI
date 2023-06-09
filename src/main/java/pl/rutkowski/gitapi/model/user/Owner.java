
package pl.rutkowski.gitapi.model.user;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class Owner {

    private String login;
    private Integer id;
    private String nodeId;
    private String avatarUrl;
    private String gravatarId;
    private String url;
    private String htmlUrl;
    private String followersUrl;
    private String followingUrl;
    private String gistsUrl;
    private String starredUrl;
    private String subscriptionsUrl;
    private String organizationsUrl;
    private String reposUrl;
    private String eventsUrl;
    private String receivedEventsUrl;
    private String type;
    private Boolean siteAdmin;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();


}
