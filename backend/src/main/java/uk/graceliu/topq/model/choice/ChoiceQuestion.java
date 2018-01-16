package uk.graceliu.topq.model.choice;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import uk.graceliu.topq.model.Question;
import uk.graceliu.topq.model.QuestionMeta;
import uk.graceliu.topq.model.impl.AbstractQuestionImpl;

import javax.validation.ValidationException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Document(collection = "Question")
@TypeAlias("choiceQuestion")
public class ChoiceQuestion extends AbstractQuestionImpl<ChoiceBody, ChoiceAnswer>{

    @Builder
    public ChoiceQuestion(ChoiceBody body, QuestionMeta meta) {
        super(body, meta);
    }

    @Override
    public boolean check(ChoiceAnswer answer) {
        final Set<Integer> selected = answer.getSelection();
        Set<Integer> correctAnswers = this.getBody().getChoices().stream()
                .filter(c -> c.isCorrect()).map(c->c.getIndex()).collect(Collectors.toSet());
        return correctAnswers.equals(selected);
    }

    @Override
    public void validate(ChoiceAnswer answer) {
        if (answer.getSelection().size()==0 || answer.getSelection().size()
                > this.getBody().getChoices().size()){
            throw new ValidationException("Selection is too small or too large!");
        }
    }

}
