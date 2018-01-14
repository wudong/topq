package uk.graceliu.topq.model.impl;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Tag")
public class TagImpl {

    @Id
    String id;

    String name;
    String description;
}
