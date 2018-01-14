package uk.graceliu.topq.model.impl;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class CategoryImpl {
    String name;
    String description;
    List<CategoryImpl> children;
}
