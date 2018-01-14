package uk.graceliu.topq.model.input;

import lombok.Data;
import uk.graceliu.topq.model.QuestionBody;

import java.util.List;


public class InputBody implements QuestionBody {
    final private List<Input> inputs;
    final private String text;

    public InputBody(List<Input> inputs, String text) {
        this.inputs = inputs;
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    public List<Input> getInputs() {
        return inputs;
    }
}
