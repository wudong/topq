package uk.graceliu.topq.model.choice;

import lombok.Data;

@Data
public class Choice {
    boolean isCorrect;
    String text;
    int index;
}
