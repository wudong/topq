package uk.graceliu.topq.model.choice;

import lombok.Data;
import uk.graceliu.topq.model.Question;

@Data
public class ChoiceQuestion extends Question<ChoiceBody, ChoiceAnswer>{

    @Override
    public boolean check(ChoiceAnswer anser) {
        return false;
    }

    @Override
    public void validate(ChoiceAnswer anser) {

    }
}
