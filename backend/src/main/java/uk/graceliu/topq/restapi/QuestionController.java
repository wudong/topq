package uk.graceliu.topq.restapi;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uk.graceliu.topq.model.Question;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class QuestionController {



    @GetMapping("/questions/:Id")
    public Question get(@PathVariable(required = true) String id) {
        //TODO
        return null;
    }
}
