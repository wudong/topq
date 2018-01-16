package uk.graceliu.topq.model.choice;

import lombok.Data;
import lombok.ToString;
import uk.graceliu.topq.model.QuestionBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class ChoiceBody implements QuestionBody {

    final private List<Choice> choices;
    final private String text;
    private static ChoiceBody instance;

    public ChoiceBody(String text, List<Choice> choices) {
        this.choices = choices;
        this.text = text;
    }

    public static ChoiceBody getInstance(String text,
                                         Choice... choices) {
        return new ChoiceBody(text, Arrays.asList(choices));
    }

    public List<Choice> getChoices() {
        return choices;
    }

    @Override
    public String getText() {
        return this.text;
    }
}
