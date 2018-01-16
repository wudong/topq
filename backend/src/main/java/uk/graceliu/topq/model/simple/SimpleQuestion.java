package uk.graceliu.topq.model.simple;


import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import uk.graceliu.topq.model.QuestionMeta;
import uk.graceliu.topq.model.impl.AbstractQuestionImpl;

@Document(collection = "Question")
@TypeAlias("simpleQuestion")
public class SimpleQuestion extends AbstractQuestionImpl<SimpleBody, SimpleAnswer> {

    public SimpleQuestion(SimpleBody body, QuestionMeta meta) {
        super(body, meta);
    }

    @Override
    public boolean check(SimpleAnswer answer) {
        return true;
    }

    @Override
    public void validate(SimpleAnswer answer) {

    }
}
