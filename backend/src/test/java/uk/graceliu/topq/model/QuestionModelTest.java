package uk.graceliu.topq.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import uk.graceliu.topq.model.choice.ChoiceQuestion;

import static uk.graceliu.topq.repository.QuestionRepositoryTest.createTestQuestionInstance;

public class QuestionModelTest {

    @Test
    public void testConvertToJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ChoiceQuestion cq = createTestQuestionInstance();
        String s = objectMapper.writeValueAsString(cq);
        System.out.println(s);
    }
}
