package uk.graceliu.topq.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uk.graceliu.topq.model.Question;

public interface QuestionRepository extends MongoRepository<Question, String> {
}
