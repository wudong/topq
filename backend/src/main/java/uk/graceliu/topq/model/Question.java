package uk.graceliu.topq.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public interface Question<B extends QuestionBody, A extends Answer> {


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

    public B getBody();


    QuestionMeta getMeta();

    public String getId();

}
