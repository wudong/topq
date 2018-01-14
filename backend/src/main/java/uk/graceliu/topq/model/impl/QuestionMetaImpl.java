package uk.graceliu.topq.model.impl;

import uk.graceliu.topq.model.Category;
import uk.graceliu.topq.model.QuestionMeta;
import uk.graceliu.topq.model.Tag;

import java.time.Instant;
import java.util.List;

public class QuestionMetaImpl implements QuestionMeta{

    private int difficulity;

    private List<Tag> tags;

    private Category categoryImpl;

    private String hint;

    private String explaination;

    public int getDifficulity() {
        return difficulity;
    }

    public void setDifficulity(int difficulity) {
        this.difficulity = difficulity;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Category getCategory() {
        return categoryImpl;
    }

    public void setCategory(Category categoryImpl) {
        this.categoryImpl = categoryImpl;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getExplaination() {
        return explaination;
    }

    public void setExplaination(String explaination) {
        this.explaination = explaination;
    }

}
