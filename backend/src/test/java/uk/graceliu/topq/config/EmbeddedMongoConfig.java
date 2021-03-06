package uk.graceliu.topq.config;

import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.MongoConverter;

import java.io.IOException;

@Configuration
public class EmbeddedMongoConfig {

    private static final String MONGO_DB_URL = "localhost";
    private static final String MONGO_DB_NAME = "topq";
    private static final int MONGO_DB_PORT = 37017;

    // NOTE, this is necessary, DUE to error that says
    // see issue: https://stackoverflow.com/questions/42811214/persistententity-must-not-be-null-exception-with-mongodb-and-spring-data-rest

    private MongoConverter mongoConverter;

    @Autowired
    public EmbeddedMongoConfig(MongoConverter mongoConverter) {
        this.mongoConverter = mongoConverter;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws IOException {
        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
        mongo.setBindIp(MONGO_DB_URL);
        mongo.setPort(MONGO_DB_PORT);
        MongoClient mongoClient = mongo.getObject();

        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, MONGO_DB_NAME);
        MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory, mongoConverter);

        return mongoTemplate;
    }
}
