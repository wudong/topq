package uk.graceliu.topq.model.simple;

import uk.graceliu.topq.model.QuestionBody;

public class SimpleBody implements QuestionBody {

    private String body;

    public SimpleBody(String body) {
        this.body = body;
    }

    @Override
    public String getText() {
        return this.body;
    }
}
