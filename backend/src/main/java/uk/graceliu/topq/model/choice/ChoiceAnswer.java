package uk.graceliu.topq.model.choice;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import uk.graceliu.topq.model.impl.AbstractAnswerImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "Answer")
@Data
@AllArgsConstructor
@TypeAlias("choiceAnswer")
public class ChoiceAnswer extends AbstractAnswerImpl {
    private Set<Integer> selection = new HashSet<>();
}
