package uk.graceliu.topq.model.impl;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Value
@Document(collection = "Tag")
public class CategoryImpl extends TagImpl {
    List<CategoryImpl> children;
}
