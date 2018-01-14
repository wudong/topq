package uk.graceliu.topq.model.choice;

        import lombok.Data;
        import uk.graceliu.topq.model.Answer;
        import uk.graceliu.topq.model.Question;
        import uk.graceliu.topq.model.impl.UserImpl;

        import java.util.ArrayList;
        import java.util.List;

@Data
public class ChoiceAnswer implements Answer {
    private List<Integer> selection = new ArrayList<>();

    private UserImpl user;
    private Question<ChoiceBody, ChoiceAnswer> question;

    @Override
    public Question<?, ?> getQuestion() {
        return this.question;
    }

    @Override
    public UserImpl getUser() {
        return this.user;
    }
}
