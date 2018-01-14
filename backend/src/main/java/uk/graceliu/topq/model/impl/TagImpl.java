package uk.graceliu.topq.model.impl;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class TagImpl {
    String name;
    String description;
}
