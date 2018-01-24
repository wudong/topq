package uk.graceliu.topq.model.impl;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import uk.graceliu.topq.model.Tag;

@Data
@Document(collection = "Tag")
@TypeAlias("tag")
public class TagImpl implements Tag{
    @Id
    private String id;

    private String name;
    private String description;

    public TagImpl(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
    	return name;
    }
    public String getDescription() {
    	return getDescription();
    }
}
