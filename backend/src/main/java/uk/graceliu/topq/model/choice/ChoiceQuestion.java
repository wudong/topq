package uk.graceliu.topq.model.choice;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ValidationException;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import uk.graceliu.topq.model.QuestionMeta;
import uk.graceliu.topq.model.impl.AbstractQuestionImpl;

@Document(collection = "Question")
@TypeAlias("choiceQuestion")
public class ChoiceQuestion extends AbstractQuestionImpl<ChoiceBody, ChoiceAnswer> {

	@Builder
	public ChoiceQuestion(ChoiceBody body, QuestionMeta meta) {
		super(body, meta);
	}

	@Override
	public boolean check(ChoiceAnswer answer) {
		final Set<Integer> selected = answer.getSelection();
		Set<Integer> correctAnswers = getBody().getChoices().stream().filter(c -> c.isCorrect()).map(c -> (Integer)c.getIndex())
				.collect(Collectors.toSet());

		return correctAnswers.equals(selected);
	}

	@Override
	public void validate(ChoiceAnswer answer) {
		if (answer.getSelection().size() == 0 || answer.getSelection().size() > this.getBody().getChoices().size()) {
			throw new ValidationException("Selection is too small or too large!");
		}
	}

}
