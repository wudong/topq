package uk.graceliu.topq.model.impl;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import uk.graceliu.topq.model.User;


@Data
@Document(collection = "User")

public class UserImpl implements User{

    @Id
    private String id;

    private String username;
    private String password;
    private String email;

}
