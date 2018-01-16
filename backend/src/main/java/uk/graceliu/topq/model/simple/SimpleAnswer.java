package uk.graceliu.topq.model.simple;

import org.springframework.data.mongodb.core.mapping.Document;
import uk.graceliu.topq.model.impl.AbstractAnswerImpl;

@Document(collection = "Answer")
public class SimpleAnswer extends AbstractAnswerImpl{

}
