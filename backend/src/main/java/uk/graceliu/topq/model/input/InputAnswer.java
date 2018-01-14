package uk.graceliu.topq.model.input;


import lombok.Data;
import uk.graceliu.topq.model.Answer;
import uk.graceliu.topq.model.Question;
import uk.graceliu.topq.model.impl.UserImpl;
import uk.graceliu.topq.model.choice.ChoiceAnswer;
import uk.graceliu.topq.model.choice.ChoiceBody;

import java.util.ArrayList;
import java.util.List;

@Data
public class InputAnswer implements Answer {
    private List<String> inputs = new ArrayList<>();

    private Question<ChoiceBody, ChoiceAnswer> question;
    private UserImpl user;

    @Override
    public Question<?, ?> getQuestion() {
        return this.question;
    }

    @Override
    public UserImpl getUser() {
        return this.user;
    }
}
