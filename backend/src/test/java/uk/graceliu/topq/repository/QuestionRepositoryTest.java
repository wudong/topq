package uk.graceliu.topq.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.web.context.WebApplicationContext;
import uk.graceliu.topq.TopqApplication;
import uk.graceliu.topq.config.EmbeddedMongoConfig;
import uk.graceliu.topq.model.Question;
import uk.graceliu.topq.model.choice.Choice;
import uk.graceliu.topq.model.choice.ChoiceBody;
import uk.graceliu.topq.model.choice.ChoiceQuestion;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EmbeddedMongoConfig.class, TopqApplication.class})
@WebAppConfiguration
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository repository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc =  webAppContextSetup(webApplicationContext).build();
        //clean the store.
        this.repository.deleteAll();
    }

    public static ChoiceQuestion createTestQuestionInstance() {
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

        ChoiceBody choiceBody = new ChoiceBody();
        choiceBody.setChoices(Arrays.asList(choice1, choice2));

        choiceQuestion.setBody(choiceBody);
        return choiceQuestion;
    }

    @Test
    public void testStoreRetrieveChoiceQuestion(){
        ChoiceQuestion choiceQuestion = createTestQuestionInstance();

        ChoiceQuestion save = repository.save(choiceQuestion);
        String id = save.getId();
        assertNotNull(id);

        Optional<Question> byId = repository.findById(id);
        assertTrue(byId.isPresent());

        Question question = byId.get();
        assertTrue(question instanceof ChoiceQuestion);

        ChoiceQuestion cq = (ChoiceQuestion) question;
        assertEquals("Some Question Text", cq.getText());
    }


    @Test
    public void testRestGetById() throws Exception {
        this.mockMvc.perform(get("/api/questions/someId"))
                .andExpect(status().is4xxClientError());

        ChoiceQuestion testQuestionInstance = createTestQuestionInstance();
        ChoiceQuestion save = repository.save(testQuestionInstance);
        String createdId = save.getId();

        this.mockMvc.perform(get("/api/questions/" + createdId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text", is("Some Question Text")));
    }

}