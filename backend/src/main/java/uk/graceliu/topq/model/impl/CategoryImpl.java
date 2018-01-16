package uk.graceliu.topq.model.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import uk.graceliu.topq.model.Category;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Tag")
@TypeAlias("category")
public class CategoryImpl extends TagImpl implements Category {
    private List<Category> children = new ArrayList<>();

    public CategoryImpl(String name, String description, List<Category> children) {
        super(name, description);
        children.addAll(children);
    }

    @Override
    public List<Category> getChildern(){
        return this.children;
    }
}
