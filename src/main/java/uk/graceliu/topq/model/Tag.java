package uk.graceliu.topq.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Tag {
    String name;
    String description;
}
