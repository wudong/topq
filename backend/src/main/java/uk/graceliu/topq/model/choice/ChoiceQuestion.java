package uk.graceliu.topq.model.choice;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import uk.graceliu.topq.model.Question;
import uk.graceliu.topq.model.QuestionMeta;
import uk.graceliu.topq.model.impl.AbstractQuestionImpl;

@Document(collection = "Question")
public class ChoiceQuestion extends AbstractQuestionImpl<ChoiceBody, ChoiceAnswer>{


    public ChoiceQuestion(ChoiceBody body, QuestionMeta meta) {
        super(body, meta);
    }


    @Override
    public boolean check(ChoiceAnswer anser) {
        return false;
    }

    @Override
    public void validate(ChoiceAnswer anser) {
    }


}
