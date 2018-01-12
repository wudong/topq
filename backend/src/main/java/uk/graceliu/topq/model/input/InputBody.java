package uk.graceliu.topq.model.input;

import lombok.Data;
import uk.graceliu.topq.model.QuestionBody;

import java.util.List;

@Data
public class InputBody implements QuestionBody {
    public List<Input> inputs;
}
