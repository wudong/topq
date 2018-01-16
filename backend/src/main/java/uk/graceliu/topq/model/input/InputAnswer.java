package uk.graceliu.topq.model.input;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import uk.graceliu.topq.model.Answer;
import uk.graceliu.topq.model.Question;
import uk.graceliu.topq.model.impl.AbstractAnswerImpl;
import uk.graceliu.topq.model.impl.UserImpl;
import uk.graceliu.topq.model.choice.ChoiceAnswer;
import uk.graceliu.topq.model.choice.ChoiceBody;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "Answer")
public class InputAnswer extends AbstractAnswerImpl {
    private List<String> inputs = new ArrayList<>();


}
