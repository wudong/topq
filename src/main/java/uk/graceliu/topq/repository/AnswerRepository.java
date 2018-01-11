package uk.graceliu.topq.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.graceliu.topq.model.Answer;

public interface AnswerRepository extends MongoRepository<Answer, String> {
}
