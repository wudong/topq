package uk.graceliu.topq.model;

import java.util.List;

public interface QuestionMeta {
    public int getDifficulity();

    public List<Tag> getTags();

    public Category getCategory();

    public String getHint();

    public String getExplaination();
}
