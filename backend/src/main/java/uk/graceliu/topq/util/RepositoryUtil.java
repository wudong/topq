package uk.graceliu.topq.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import uk.graceliu.topq.repository.QuestionRepository;

/**
 * Some util commands help to maintain the database.
 */
@SpringBootApplication
@EnableMongoRepositories(basePackages = {"uk.graceliu.topq.repository"})
public class RepositoryUtil {

    private final Logger logger = LoggerFactory.getLogger(RepositoryUtil.class);

    private QuestionRepository questionRepository;
    private Environment env;

    public RepositoryUtil(QuestionRepository questionRepository,
                          Environment env) {
        this.questionRepository = questionRepository;
        this.env = env;
    }

    public static void main(String[] args) {
        //bootstraping a non-web spring boot application.
        //https://stackoverflow.com/questions/29800584/how-to-prevent-spring-boot-autoconfiguration-for-spring-web
        new SpringApplicationBuilder(RepositoryUtil.class)
        .web(WebApplicationType.NONE)
        .run(args);
    }

    public void run() {
        //running the command line runner.
        logger.debug("Starting Repository Util");
        generateSampleContent();
    }

    public void generateSampleContent(){
        logger.info("Generating Sample Content in Database.");
        questionRepository.deleteAll();
        questionRepository.save(SampleQuestions.sampleChoiceQuestion1());
        logger.info("Done!");
    }

    public void loadSampleContentFromFile() {
        String questionFile = this.env.getProperty("topq.loadfile.question");
        String anserFile = this.env.getProperty("topq.loadfile.answer");
        String userFile = this.env.getProperty("topq.loadfile.user");

        //TODO,

    }

    @Bean
    public CommandLineRunner runner() {
      return (String... args)->this.run();
    }

}
