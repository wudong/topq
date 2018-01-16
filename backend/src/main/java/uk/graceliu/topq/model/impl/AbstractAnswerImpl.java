package uk.graceliu.topq.model.impl;

import uk.graceliu.topq.model.Answer;
import uk.graceliu.topq.model.Question;
import uk.graceliu.topq.model.User;

public class AbstractAnswerImpl implements Answer {

    public AbstractAnswerImpl() {
    }

    @Override
    public Question<?, ?> getQuestion() {
        return null;
    }

    @Override
    public User getUser() {
        return null;
    }
}
