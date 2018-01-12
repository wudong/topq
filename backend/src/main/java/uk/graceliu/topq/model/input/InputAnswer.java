package uk.graceliu.topq.model.input;


import uk.graceliu.topq.model.Answer;
import uk.graceliu.topq.model.Question;
import uk.graceliu.topq.model.User;
import uk.graceliu.topq.model.choice.ChoiceAnswer;
import uk.graceliu.topq.model.choice.ChoiceBody;

import java.util.ArrayList;
import java.util.List;

public class InputAnswer implements Answer {
    private List<String> inputs = new ArrayList<>();

    private Question<ChoiceBody, ChoiceAnswer> question;
    private User user;

    @Override
    public Question<?, ?> getQuestion() {
        return this.question;
    }

    @Override
    public User getUser() {
        return this.user;
    }
}
