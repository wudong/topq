package uk.graceliu.topq.model;

public interface Answer {
    Question<?, ?> getQuestion();
    User getUser();
}
