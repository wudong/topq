package uk.graceliu.topq.model.choice;

import lombok.ToString;
import org.springframework.data.annotation.PersistenceConstructor;
import uk.graceliu.topq.model.QuestionBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ToString
public class ChoiceBody implements QuestionBody {
    private List<Choice> choices = new ArrayList<Choice>();

    @PersistenceConstructor
    public ChoiceBody(List<Choice> choices) {
        this.choices.addAll(choices);
    }

    public ChoiceBody(Choice... choices) {
        this.choices.addAll(Arrays.asList(choices));
    }
}
