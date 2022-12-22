package demo.rabbitmq;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RabbitmqController {

    static final String topicExchangeName = "spring-boot-exchange";
    static final String queueName = "spring-boot";

    @GetMapping("/queues")
    public void queues(){
        //
    }
}
