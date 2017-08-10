package org.superbiz.moviefun;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pivotal on 8/10/17.
 */
@RestController
public class RabbitMessageController {

    private final RabbitTemplate rabbitTemplate;
    private final String queue;

    public RabbitMessageController(ConnectionFactory connectionFactory, @Value("${rabbitmq.queue}") String queue) {
        this.rabbitTemplate = new RabbitTemplate(connectionFactory);
        this.queue = queue;
    }

    @PostMapping("/rabbit")
    public Map<String, String> publishMessage() {
        rabbitTemplate.convertAndSend(queue, "This text message will trigger the consumer");

        Map<String, String> response = new HashMap<>();
        response.put("response", "This is an unrelated JSON response");
        return response;
    }
}
