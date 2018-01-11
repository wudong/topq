package uk.graceliu.topq.model.input;

import uk.graceliu.topq.model.Answer;
import uk.graceliu.topq.model.Question;

public class InputQuestion extends Question<InputBody, InputAnswer> {
    @Override
    public boolean check(InputAnswer anser) {
        return false;
    }

    @Override
    public void validate(InputAnswer anser) {

    }
}
