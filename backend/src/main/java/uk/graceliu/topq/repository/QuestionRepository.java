package uk.graceliu.topq.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.graceliu.topq.model.Question;

public interface QuestionRepository extends MongoRepository<Question, String> {

}
