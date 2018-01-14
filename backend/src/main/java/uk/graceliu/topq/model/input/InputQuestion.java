package uk.graceliu.topq.model.input;

import uk.graceliu.topq.model.Answer;
import uk.graceliu.topq.model.Question;
import uk.graceliu.topq.model.QuestionMeta;
import uk.graceliu.topq.model.impl.AbstractQuestionImpl;

public class InputQuestion extends AbstractQuestionImpl<InputBody, InputAnswer> {

    public InputQuestion(InputBody body, QuestionMeta meta) {
        super(body, meta);
    }

    @Override
    public boolean check(InputAnswer anser) {
        return false;
    }

    @Override
    public void validate(InputAnswer anser) {

    }
}
