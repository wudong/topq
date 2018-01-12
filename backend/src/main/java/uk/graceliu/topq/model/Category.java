package uk.graceliu.topq.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class Category {
    String name;
    String description;
    List<Category> children;
}
