package pl.waw.great.alledrogo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Builder
@Document("user")
public class User {

    //@FIXME remove after authorization created
    public static final String DEFAULT_USER_ID =  "1";

    private String id;
    private String login;
    private String password;

    public class DEFAULT_USER_I {
    }
}
