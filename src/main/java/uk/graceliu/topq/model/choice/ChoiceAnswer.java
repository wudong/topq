package uk.graceliu.topq.model.choice;

import lombok.Data;
import uk.graceliu.topq.model.Answer;
import uk.graceliu.topq.model.Question;
import uk.graceliu.topq.model.User;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChoiceAnswer implements Answer {
    private List<Integer> selection = new ArrayList<>();

    private User user;
    private Question<ChoiceBody, ChoiceAnswer> question;

    @Override
    public Question<?, ?> getQuestion() {
        return this.question;
    }

    @Override
    public User getUser() {
        return this.user;
    }
}
