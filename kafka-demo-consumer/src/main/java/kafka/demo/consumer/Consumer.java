package kafka.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import kafka.demo.common.message.Message;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Consumer 
{

	
	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.consumer.group.id}")
    public void receiveMessage(Message message) {
    	log.debug("Received Message: {}", message.toString());
    }
}
