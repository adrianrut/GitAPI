
package pl.rutkowski.gitapi.model.branch;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class Commit {

    private String sha;
    private String url;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

}
