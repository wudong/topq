package uk.graceliu.topq.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.graceliu.topq.model.User;

public interface UserRepository extends MongoRepository<User, String> {
}
