package uk.graceliu.topq.model.impl;

import lombok.Builder;
import lombok.Data;
import uk.graceliu.topq.model.Category;
import uk.graceliu.topq.model.QuestionMeta;
import uk.graceliu.topq.model.Tag;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class QuestionMetaImpl implements QuestionMeta{

    private int difficulity;

    private List<Tag> tags;

    private Category categoryImpl;

    private String hint;

    private String explaination;

}
