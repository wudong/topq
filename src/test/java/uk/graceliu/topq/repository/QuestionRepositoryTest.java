package uk.graceliu.topq.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.graceliu.topq.model.Question;
import uk.graceliu.topq.model.choice.Choice;
import uk.graceliu.topq.model.choice.ChoiceBody;
import uk.graceliu.topq.model.choice.ChoiceQuestion;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository repository;

    @Test
    public void testStoreRetrieveChoiceQuestion(){
        ChoiceQuestion choiceQuestion = new ChoiceQuestion();
        choiceQuestion.setText("Some Question Text");

        Choice choice1 = new Choice();
        choice1.setCorrect(true);
        choice1.setIndex(1);
        choice1.setText("What's going on?");

        Choice choice2 = new Choice();

        choice2.setCorrect(false);
        choice2.setIndex(2);
        choice2.setText("Nothing is wrong");

        ChoiceBody choiceBody = new ChoiceBody(choice1, choice2);

        choiceQuestion.setBody(choiceBody);
        ChoiceQuestion save = repository.save(choiceQuestion);
        String id = save.getId();
        assertNotNull(id);

        Optional<Question> byId = repository.findById(id);
        assertTrue(byId.isPresent());

        Question question = byId.get();
        assertTrue(question instanceof ChoiceQuestion);

        ChoiceQuestion cq = (ChoiceQuestion) question;
        assertEquals("Some Question Text", cq.getText());

        repository.deleteById(id);
    }


}