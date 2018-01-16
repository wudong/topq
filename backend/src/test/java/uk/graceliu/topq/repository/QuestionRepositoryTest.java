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
import uk.graceliu.topq.model.QuestionMeta;
import uk.graceliu.topq.model.choice.Choice;
import uk.graceliu.topq.model.choice.ChoiceBody;
import uk.graceliu.topq.model.choice.ChoiceQuestion;
import uk.graceliu.topq.model.impl.QuestionMetaImpl;

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

        Choice choice1 = new Choice(1, "12/12/1978", false);
        Choice choice2 = new Choice(2, "25/10/2012", true);
        ChoiceBody choiceBody = new ChoiceBody("When is Grace Birthday?", Arrays.asList(choice1, choice2) );
        QuestionMeta qm = QuestionMetaImpl.builder().difficulity(1).explaination("No need").build();

        ChoiceQuestion choiceQuestion = new ChoiceQuestion(choiceBody, qm);
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
        assertEquals("When is Grace Birthday?", cq.getBody().getText());
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
                .andExpect(jsonPath("$.body.text", is("When is Grace Birthday?")));
    }

}