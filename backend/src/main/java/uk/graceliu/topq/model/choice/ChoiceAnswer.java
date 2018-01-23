package uk.graceliu.topq.model.choice;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import uk.graceliu.topq.model.impl.AbstractAnswerImpl;

@Data
@Document(collection = "Answer")
@AllArgsConstructor
@TypeAlias("choiceAnswer")
public class ChoiceAnswer extends AbstractAnswerImpl {
    private Set<Integer> selection = new HashSet<>();
}
