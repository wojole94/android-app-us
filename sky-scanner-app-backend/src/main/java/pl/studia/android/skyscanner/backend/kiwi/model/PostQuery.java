package pl.studia.android.skyscanner.backend.kiwi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostQuery {

    @JsonProperty("requests")
    List<PostAttr> requests;

    public PostQuery() {
        requests = new ArrayList<>();
    }

    public PostQuery(List<PostAttr> postAttrList) {
        this.requests = postAttrList;
    }

    public void addToPostQuery(PostAttr postAttr) {
        if (requests == null) {
            requests = new ArrayList<>();
        }
        requests.add(postAttr);
    }
}
