package demo.rabbitmq;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender{

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    // constructor
    public Sender(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(QueueConfig.TOPIC_EXCHANGE_NAME, "foo.bar.baz", Arrays.toString(args));
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}
