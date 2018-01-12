package uk.graceliu.topq.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Question")
public abstract class Question<B extends QuestionBody, A extends Answer> {

    @Id
    private String id;

    private String text;

    private int difficulity;

    private B body;

    private List<Tag> tags;

    private Category category;

    private String hint;

    private String explaination;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

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
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    /**
     * Check if the answer is correctly answered.
     * @param anser
     * @return
     */
    public abstract boolean check(A anser);

    /**
     * Validate the answer if it is correctly selected/input.
     * For example, for SingleChoiceQuestion, validate the at least one choice is given.
     *
     * @param anser
     */
    public abstract void validate(A anser);

    public B getBody() {
        return body;
    }

    public void setBody(B body) {
        this.body = body;
    }
}
