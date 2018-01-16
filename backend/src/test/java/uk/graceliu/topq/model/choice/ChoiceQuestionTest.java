package uk.graceliu.topq.model.choice;

import org.junit.Test;
import uk.graceliu.topq.util.SampleQuestions;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.*;

public class ChoiceQuestionTest {

    @Test
    public void testCorrectness() {
        ChoiceQuestion choiceQuestion = SampleQuestions.sampleChoiceQuestion1();
        ChoiceAnswer choiceAnswer = new ChoiceAnswer(new HashSet<>(Arrays.asList(1)));

        boolean check = choiceQuestion.check(choiceAnswer);
        assertThat(check).isFalse();

        ChoiceAnswer choiceAnswer2 = new ChoiceAnswer(new HashSet<>(Arrays.asList(3)));

        boolean check2 = choiceQuestion.check(choiceAnswer2);
        assertThat(check2).isTrue();

        ChoiceAnswer choiceAnswer3 = new ChoiceAnswer(new HashSet<>(Arrays.asList(1,3)));

        boolean check3 = choiceQuestion.check(choiceAnswer3);
        assertThat(check3).isFalse();
    }

}