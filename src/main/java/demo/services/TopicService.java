package demo.services;

import demo.entity.Topic;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    private Topic topic;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public void updateTopic(Topic topic, String id) {
    }

    public void removeTopic(String id){

    }
}
