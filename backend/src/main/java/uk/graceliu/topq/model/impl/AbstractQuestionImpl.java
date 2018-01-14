package uk.graceliu.topq.model.impl;

import uk.graceliu.topq.model.Answer;
import uk.graceliu.topq.model.Question;
import uk.graceliu.topq.model.QuestionBody;
import uk.graceliu.topq.model.QuestionMeta;

public abstract class AbstractQuestionImpl<B extends QuestionBody, A extends Answer>
        implements Question <B, A>{

    final private B body;
    final private QuestionMeta meta;

    public AbstractQuestionImpl(B body, QuestionMeta meta) {
        this.body = body;
        this.meta = meta;
    }

    @Override
    public B getBody() {
        return body;
    }

    @Override
    public QuestionMeta getMeta() {
        return meta;
    }
}
