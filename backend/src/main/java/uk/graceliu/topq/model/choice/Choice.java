package uk.graceliu.topq.model.choice;

import lombok.Data;

@Data
public class Choice {
    private boolean isCorrect;
    private String text;
    private int index;
}
