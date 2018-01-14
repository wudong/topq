package uk.graceliu.topq.model.choice;

import lombok.Data;
import lombok.ToString;
import uk.graceliu.topq.model.QuestionBody;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChoiceBody implements QuestionBody {

    final private List<Choice> choices;
    final private String text;

    public ChoiceBody(List<Choice> choices, String text) {
        this.choices = choices;
        this.text = text;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    @Override
    public String getText() {
        return this.text;
    }
}
