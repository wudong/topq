package uk.graceliu.topq.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.graceliu.topq.model.impl.UserImpl;

public interface UserRepository extends MongoRepository<UserImpl, String> {
}
