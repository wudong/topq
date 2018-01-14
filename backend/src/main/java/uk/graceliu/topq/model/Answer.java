package uk.graceliu.topq.model;

import uk.graceliu.topq.model.impl.UserImpl;

public interface Answer {
    Question<?, ?> getQuestion();
    User getUser();
}
