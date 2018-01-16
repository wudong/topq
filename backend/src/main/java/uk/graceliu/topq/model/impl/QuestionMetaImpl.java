package uk.graceliu.topq.model.impl;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import uk.graceliu.topq.model.Category;
import uk.graceliu.topq.model.QuestionMeta;
import uk.graceliu.topq.model.Tag;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@TypeAlias("meta")
public class QuestionMetaImpl implements QuestionMeta{

    private int difficulity;

    private List<Tag> tags;

    private Category category;

    private String hint;

    private String explaination;

}
