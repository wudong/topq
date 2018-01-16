package uk.graceliu.topq.model.choice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class Choice {
    private int index;
    private String text;
    private boolean isCorrect;
}
