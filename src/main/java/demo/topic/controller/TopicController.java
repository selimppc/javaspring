package demo.topic.controller;

import demo.topic.entity.Topic;
import demo.topic.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @ResponseBody
    @GetMapping("/topics")
    public List<Topic> getTopics() {
        return topicService.getAllTopics();
    }

    @ResponseBody
    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    @PostMapping("/topics")
    public ResponseEntity<?> addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
        return new ResponseEntity<>(topic, HttpStatus.CREATED);
    }

    @PutMapping("/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(id, topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopics(@PathVariable String id){
        topicService.deleteTopic(id);
    }

}
