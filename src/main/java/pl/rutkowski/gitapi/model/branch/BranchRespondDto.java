
package pl.rutkowski.gitapi.model.branch;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class BranchRespondDto {

    private String name;
    private Commit commit;
    private Boolean _protected;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

}
