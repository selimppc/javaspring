package demo.controller;

import demo.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @ResponseBody
    @GetMapping("/topics")
    public String getTopics() {
        return "Hello Message 11";
    }

//    @PostMapping
//    public

}
